# cuscatlan-product-service
The product microservice is responsible for managing product information, including retrieving products by ID and integrating with other microservices.

## Features
- Retrieve products by ID.
- Integration with the order microservice to provide product information during order creation.
- Request validation and error handling.

## Prerequisites
- Java 17
- Spring Boot 3.3.4
- Maven 3.x
- H2 Database (for local testing)

## Installation
1. Clone the repository:
   git clone https://github.com/fran090893/cuscatlan-product-service.git
2. Navigate to the project directory:
   cd productservice
3. Build the project with Maven:
   mvn clean install
4. Run the microservice:
   mvn spring-boot:run