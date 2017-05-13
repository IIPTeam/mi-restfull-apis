package org.mi.ot.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.mi.ot.vo.OTInfo;
import org.mi.ot.vo.OTRequest;
import org.mi.ot.vo.OTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class OTController {

	@Value("${ot-process-api-url}")
	public String otProcessAPIURL;

	@RequestMapping(value = "/submit", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public OTResponse submit(@RequestBody @Valid OTRequest otReq) {
		OTResponse otResp = new OTResponse();

		RestTemplate restTemplate = new RestTemplate();
		String url = otProcessAPIURL + "process/ot";
		try {
			checkData(otReq.getOtInfo());
			restTemplate.postForObject(url, otReq.getOtInfo(), OTInfo.class);
			otResp.setCode(200);
			otResp.setMessage("OT updated successfully");
		} catch (RestClientException e) {
			otResp.setCode(500);
			otResp.setMessage(e.getMessage());
		}

		return otResp;
	}

	@RequestMapping(value = "/update", consumes = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public OTResponse update(@RequestBody @Valid OTRequest otReq) {
		OTResponse otResp = new OTResponse();

		RestTemplate restTemplate = new RestTemplate();
		String url = otProcessAPIURL + "process/ot";
		try {
			checkData(otReq.getOtInfo());
			restTemplate.put(url, otReq.getOtInfo());
			otResp.setCode(200);
			otResp.setMessage("OT updated successfully");
		} catch (RestClientException e) {
			otResp.setCode(500);
			otResp.setMessage(e.getMessage());
		}

		return otResp;
	}
	
	public List<OTInfo> list(){
	
		return null;
	}
	
	private boolean checkData(OTInfo ot){
		boolean result = false;

		Assert.notNull(ot.getStartTime(), "startTime must not be null!");
		Assert.notNull(ot.getEndTime(), "startTime must not be null!");
		
		long intervalLong = ot.getEndTime().getTime() - ot.getStartTime().getTime();
		if(intervalLong > 0){
			BigDecimal duration = new BigDecimal(ot.getDuration());

			long minute = (int)(intervalLong % (60 * 60 * 1000)) / (60 * 1000);
			BigDecimal hour = new BigDecimal(Double.toString(intervalLong / (60 * 60 * 1000)));
			BigDecimal min = new BigDecimal(Double.toString(minute < 15 ? 0 : (minute < 45) ? 0.5 : 1));
			
			BigDecimal expect = hour.add(min);
			result = duration.subtract(expect).doubleValue() == 0.0D;
		}
		return result;
	}

}
