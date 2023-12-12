FROM openjdk:17
EXPOSE 8080
ADD target/Thrishank-JavaApplication.jar Thrishank-JavaApplication.jar
ENTRYPOINT ["java","-jar","/Thrishank-JavaApplication"]