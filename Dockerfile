FROM openjdk:17
EXPOSE 8081
ADD target/Thrishank-Jenikins-pipeline.jar Thrishank-Jenikins-pipeline.jar
ENTRYPOINT ["java","-jar","/Thrishank-Jenikins-pipeline.jar"]