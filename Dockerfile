FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/fashionrent-0.0.1.jar fashionrent-0.0.1.jar
EXPOSE 8383
CMD ["java","-jar","fashionrent-0.0.1.jar"]