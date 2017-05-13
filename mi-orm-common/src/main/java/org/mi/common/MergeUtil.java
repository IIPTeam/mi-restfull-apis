package org.mi.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.util.Assert;

public class MergeUtil {

	/**
	 * simple object merge, only support basic type.
	 */
	public static void simpleMerge(final Object source, final Object target) {
		if (equals(source, target)) {
			Field[] fields = getFields(source, null);
			merge(fields, source, target);
		}
	}

	public static void simpleMerge(final Object source, final Object target, final String[] ignores) {
		if (equals(source, target)) {
			Field[] fields = getFields(source, ignores);
			merge(fields, source, target);
		}
	}

	/**
	 * Object source is the same as Object target.
	 *
	 * @param source
	 * @param target
	 * @return
	 */
	private static boolean equals(final Object source, final Object target) {
		Assert.notNull(source, "Object source must not be null!");
		Assert.notNull(target, "Object rarget must not be null!");

		boolean result = source.getClass().isAssignableFrom(target.getClass())
				&& target.getClass().isAssignableFrom(source.getClass());

		return result;
	}

	/**
	 * get available field
	 *
	 * @param obj
	 * @param ignores
	 * @return
	 */
	private static Field[] getFields(final Object obj, final String[] ignores) {
		Field[] fields = obj.getClass().getDeclaredFields();
		if (ignores != null) {
			List<Field> fieldList = new ArrayList<Field>();
			List<String> ignoreList = Arrays.asList(ignores);
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					if (ignoreList.contains(field.getName()) || !isBasicType(field.get(obj))) {
						continue;
					}
					fieldList.add(field);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			fields = fieldList.toArray(new Field[] {});
		}
		return fields;
	}

	/**
	 * merge fields to Object target
	 *
	 * @param fields
	 * @param target
	 */
	private static void merge(final Field[] fields, final Object source, final Object target) {
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				setField(field.getName(), field.get(source), target);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * set field
	 *
	 * @param name
	 * @param val
	 * @param target
	 */
	private static void setField(final String name, final Object val, final Object target) {
		try {
			Field field = target.getClass().getDeclaredField(name);
			field.setAccessible(true);
			Object target_val = field.get(target);
			if (val == null || val.equals(target_val)) {
				return;
			}
			field.setAccessible(true);
			field.set(target, val);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static boolean isBasicType(final Object val) {
		boolean result = false;
		if (val != null) {
			result = (val instanceof String || val instanceof Character || val instanceof Byte || val instanceof Short
					|| val instanceof Integer || val instanceof Long || val instanceof Float || val instanceof Double
					|| val instanceof Boolean || val instanceof Date);
		}
		return result;
	}
}