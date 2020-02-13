from openjdk:8-jre-slim
RUN mkdir -p /opt/order/
copy ./target/order-service-0.0.1-SNAPSHOT.jar /opt/order
WORKDIR /opt/order

EXPOSE 8085
CMD ["java" , "-jar" , "order-service-0.0.1-SNAPSHOT.jar"]
