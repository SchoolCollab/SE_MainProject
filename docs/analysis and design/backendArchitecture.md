# SportNexus Backend Project Architecture

The backend of SportNexus is built using **Spring Boot**, following a modular and layered architecture that ensures clear separation of concerns, scalability, and maintainability. The backend leverages the following main dependencies: **Spring Data JPA**, **Spring Boot Security**, **Spring Boot Validation**, **Spring Web**, **Lombok**, and the **PostgreSQL driver**.

The application uses **Supabase** as its database platform, which is based on **PostgreSQL**.

This architecture organizes the backend into three main modules that communicate in a one-way dependency flow: **Controller → Service → Model**.

***

## Explanation of Main Components

Below are the meanings of each term in this architecture:

* **Controller Layer** 🌐  
    This layer contains the application's **REST controllers** (annotated with `@RestController`). It handles incoming HTTP requests, maps them to service methods, and returns responses to the client. The controller is responsible for request validation and error handling, delegating business logic to the service layer.

* **Service Layer (or DAO)** ⚙️  
    This layer contains the **service classes** that implement the business logic of the application. Services interact with the model layer (repositories and entities) to perform CRUD operations and other business processes. The service layer ensures that the controller remains thin and focused on handling HTTP requests.

* **Model Layer** 🗄️  
    This layer consists of the **entity classes** (annotated with `@Entity`) that map to database tables, and the **repository interfaces** (extending `JpaRepository`) that provide data access methods. The model layer is responsible for representing and managing the application's data.

* **Security** 🔒  
    The backend uses **Spring Boot Security** to handle authentication and authorization. User credentials and roles are managed securely, and endpoints are protected according to the application's requirements.

* **Validation** ✅  
    **Spring Boot Validation** is used to ensure that incoming data (such as request bodies) meets defined constraints before being processed by the service layer.

* **Database** 🛢️  
    The application connects to a **Supabase** PostgreSQL database. All data persistence is managed through Spring Data JPA repositories, which abstract away the underlying SQL queries.

***

## Dependency Flow

The dependency flow in this architecture is strictly one-way:

**Controller → Service → Model (Entity/Repository) → Database**

This ensures that each layer has a single responsibility and can be tested or modified independently.

***

## Summary Table

| Layer         | Main Responsibility                | Technologies/Annotations             |
| ------------- | ---------------------------------- | ------------------------------------ |
| Controller    | Handle HTTP requests and responses | `@RestController`, `@RequestMapping` |
| Service (DAO) | Business logic, data processing    | `@Service`, `@Transactional`         |
| Model         | Data representation and access     | `@Entity`, `@Repository`, JPA        |
| Security      | Authentication and authorization   | Spring Security                      |
| Validation    | Input validation                   | Spring Validation (`@Valid`)         |
| Database      | Data storage and retrieval         | Supabase PostgreSQL,                 |