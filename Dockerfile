# Step 1: Build Stage
FROM maven:3openjdk-18 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run Stage
FROM openjdk:18-jdk-slim
WORKDIR /app
COPY --from=build /app/target/calender-0.0.1-SNAPSHOT.war calender.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "calender.war"]
