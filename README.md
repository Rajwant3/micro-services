# Spring Cloud Microservices with Apache Camel and Docker

## Overview

This repository hosts a collection of seven small microservices built using Spring Cloud framework, integrated with Apache Camel for message routing and Docker for containerization. These microservices demonstrate the integration of various technologies and serve as a learning resource for developers interested in understanding Spring Cloud, Apache Camel, and Docker.

## Microservices

1. **Limit Service**
2. **Api gateways**
3. **Currency Exchange Service**
4. **Currency Conversion Service**
5. **Eureka Naming Server**
6. **Spring Cloud Config Server**
7. **Restful services**
   
- ## Technologies Used

### Spring Cloud
- **API Gateway**: Acts as a single entry point for clients, providing routing, security, and more to underlying microservices.
- **Eureka Server (Service Registry)**: Allows microservices to register themselves and discover other services dynamically.
- **Config Server (Configuration Management)**: Centralized configuration management for distributed systems, allowing externalized configuration in a scalable and reliable manner.

### Apache Camel
- **Provides message routing and integration** between microservices and potentially external systems. It supports numerous protocols, data formats, and patterns to facilitate seamless communication.

### Docker
- **Enables containerization** of each microservice for independent scaling and deployment. Docker containers encapsulate applications and their dependencies, providing consistency across different environments and simplifying deployment processes.


## Prerequisites

Before running the microservices, ensure the following dependencies are installed:

- Java Development Kit (JDK)
- Maven
- Docker

## Installation

1. Clone this repository to your local machine:

    ```bash
    git clone https://github.com/your-username/your-repository.git
    ```

2. Navigate to the project directory:

    ```bash
    cd your-repository
    ```

3. Build the microservices using Maven:

    ```bash
    mvn clean install
    ```

4. Build Docker images for each microservice:

    ```bash
    docker-compose build
    ```

## Usage

1. Start the microservices using Docker Compose:

    ```bash
    docker-compose up
    ```

2. Access the microservices through their respective endpoints.

## Configuration

- Configuration files for each microservice are located in the `config` directory.
- Customize the configurations as per your requirements.

## Contributing

Contributions are welcome! If you find any issues or want to enhance the project, feel free to open a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
