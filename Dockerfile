FROM openjdk:17
EXPOSE 8080
ADD target/Thrishank-dockertest.jar Thrishank-dockertest.jar
ENTRYPOINT ["java","-jar","/Thrishank-dockertest"]