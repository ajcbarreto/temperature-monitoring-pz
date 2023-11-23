# Quarkus Temperature Monitoring Project

This project is a Quarkus-based application for monitoring temperature data in two distinct cities. It consists of two microservices: a producer that collects and sends temperature data to Kafka, and a consumer that consumes the data and stores it in PostgreSQL.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java 17 or higher
- Maven
- Docker and Docker Compose

## Running the Application

1. Clone the repository:
    ```
    git clone https://github.com/ajcbarreto/temperature-monitoring-pz.git
    ```

2. Start the Docker containers for Kafka and PostgreSQL:
    ```
    docker-compose up -d
    ```

3. Navigate to the project directory:
    ```
    cd quarkus-temperature-monitoring
    ```

4. Build the application:
    ```
    ./mvnw clean install
    ```

5. Run the Quarkus application:
    ```
    ./mvnw quarkus:dev
    ```