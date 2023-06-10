FROM openjdk:20-oracle
CMD .\mvnw clean package
COPY target/welcomeapp-0.0.1-SNAPSHOT.jar welcomeapp-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","welcomeapp-0.0.1-SNAPSHOT.jar"]