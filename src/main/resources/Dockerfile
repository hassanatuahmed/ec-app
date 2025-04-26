FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/ecommerceapp.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]