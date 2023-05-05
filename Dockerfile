FROM adoptopenjdk:11-jre-hotspot

LABEL maintainer="prashant.hariharan@mathema.de"

ADD ./target/*.jar /app/service.jar

#Java execution
CMD ["java", "-Djdk.tls.client.protocols=TLSv1.2", "-Xmx512m", "-jar", "/app/service.jar"]
EXPOSE 8080


