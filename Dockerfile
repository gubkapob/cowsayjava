# builder
FROM gradle:9.1-jdk21-ubi AS builder
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . /home/gradle/project
# build fat jar
RUN gradle --no-daemon clean bootJar

# runtime
FROM eclipse-temurin:21-jre
WORKDIR /app
# копируем собранный jar
COPY --from=builder /home/gradle/project/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]