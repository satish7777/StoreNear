from openjdk:8-jre-slim
RUN mkdir -p /opt/eureka/
copy ./target/eureka-server-0.0.1-SNAPSHOT.jar /opt/eureka
WORKDIR /opt/eureka

EXPOSE 8888
CMD ["java" , "-jar" , "eureka-server-0.0.1-SNAPSHOT.jar"]
