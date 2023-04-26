FROM amazoncorretto:19-alpine-jdk
ADD target/AuthService-0.0.1-SNAPSHOT.jar AuthService-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "AuthService-0.0.1-SNAPSHOT.jar"]