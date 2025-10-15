# builder
FROM gradle:jdk21-ubi AS builder
WORKDIR /home/gradle/app
COPY --chown=gradle:gradle . /home/gradle/app
# build fat jar
RUN gradle --no-daemon clean bootJar

# runtime
FROM eclipse-temurin:21-jre-noble
WORKDIR /app
# копируем собранный jar
COPY --from=builder /home/gradle/app/build/libs/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]