from openjdk:8-jre-slim
RUN mkdir -p /opt/apiservice/
copy ./target/api-service-0.0.1-SNAPSHOT.jar /opt/apiservice
WORKDIR /opt/apiservice

EXPOSE 9090
CMD ["java" , "-jar" , "api-service-0.0.1-SNAPSHOT.jar"]
