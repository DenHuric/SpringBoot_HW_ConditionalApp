FROM openjdk:17
EXPOSE 8080
COPY target/ConditionalApp-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]