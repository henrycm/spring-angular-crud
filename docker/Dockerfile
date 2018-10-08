FROM ubuntu:16.04

# Install tools
RUN apt-get update && apt-get install -y openjdk-8-jdk

ADD facturacion-1.0.0.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]