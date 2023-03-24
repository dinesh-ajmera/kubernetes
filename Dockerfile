FROM openjdk:11-jdk
WORKDIR /app
COPY . /app
RUN ./mvn clean package
EXPOSE 8080
CMD ["java", "-jar", "/app/target/sudoku-game.jar"]
