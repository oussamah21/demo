FROM  openjdk:17-jdk-alpine

EXPOSE 8080
COPY /target/demo-0.1.jar app.jar

# assumes that the config will be mounted as a volume at the root of the file system, next to the jar
ENTRYPOINT ["java", "-jar","/app.jar"]
