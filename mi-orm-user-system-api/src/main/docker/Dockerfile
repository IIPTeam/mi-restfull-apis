FROM openjdk:8-jre-alpine
VOLUME /tmp
ARG VERSION
#ADD mi-orm-user-system-api-1.0.0-SNAPSHOT.jar app.jar
ADD mi-orm-user-system-api-${VERSION:-1.0.0-SNAPSHOT}.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]