# AuthService 

## How to start project

1. Go to the root folder of the project and on the command line write the command: 
    ```mvn clean install```

2. Write the next command:
    ```docker-compose up --build -d```

4. Go to the browser and go to: ```http://localhost:8080/swagger-ui.html```
5. Done, you can test the application.

### `You are great!`

## About project

This project is a microservice for authorizing a user and issuing him a token.
Also, this service allows you to perform CRUD operations on users from the database.
This application contains both protected requests (for user browsing and unprotected 
requests).

When a user is created, a notification message is sent to the message queue (via RabbitMQ).

The application has swagger documentation. A screenshot of it is shown on the screen below.

![img.png](img.png)

## Technology stack
- Spring Boot 3
- Spring Security
- JWT token
- RabbitMQ
- Redis
- Docker compose
- Swagger-ui