FROM openjdk:11-jdk
RUN apt-get update && apt-get install -y maven
WORKDIR /app
COPY . /app
RUN mvn clean package
EXPOSE 8080
CMD ["java", "-jar", "/app/target/sudoku-game.jar"]
