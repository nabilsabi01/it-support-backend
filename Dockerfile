FROM openjdk:17
EXPOSE 8080
ADD target/itsupport.jar itsupport.jar
ENTRYPOINT ["java", "-jar", "/itsupport.jar"]