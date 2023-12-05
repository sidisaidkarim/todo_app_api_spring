FROM ubuntu:20.04
RUN apt-get update && apt-get install openjdk-17-jdk vim curl -y

COPY . /app
WORKDIR /app

RUN ./mvnw clean package -DskipTests=true
EXPOSE 8080

CMD ["java", "-jar", "target/todoapp-0.0.1-SNAPSHOT.jar"]
