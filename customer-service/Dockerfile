from openjdk:8-jre-slim
RUN mkdir -p /opt/customer/
copy ./target/customer-service-0.0.1-SNAPSHOT.jar /opt/customer
WORKDIR /opt/customer

EXPOSE 8086
CMD ["java" , "-jar" , "customer-service-0.0.1-SNAPSHOT.jar"]
