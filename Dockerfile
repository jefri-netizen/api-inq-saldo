# Stage 1: Build menggunakan Maven
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Jalankan aplikasi
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Ambil file jar dari stage build di atas
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
