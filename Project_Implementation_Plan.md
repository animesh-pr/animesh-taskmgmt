# Project Implementation Plan - Task Management System

This document outlines the strategic breakdown of the Task Management System into manageable implementation phases based on the requirements in `GEMINI.md`. You can use the execution prompts below to guide each step of the development process.

## Phase 1: Project Setup and Configuration
**Goal:** Initialize the project, configure dependencies, set up the database connection, and create standard configuration files like `.gitignore`.

**Execution Prompt:**
> Initialize a Spring Boot project using Java 17+. Include dependencies for Spring Web, Spring Data JPA, MySQL Driver, and Springdoc OpenAPI (for Swagger UI). Configure the `application.properties` (or `application.yml`) to connect to a MySQL database named `taskmgmtdb`. Set up Hibernate to automatically update the DDL. Finally, generate a standard Java/Spring Boot `.gitignore` file to ensure build artifacts and IDE files are not tracked.

## Phase 2: Entity and Repository Layer Implementation
**Goal:** Define the data model, establish relationships, and create the Data Access Layer using `JpaRepository`.

**Execution Prompt:**
> Create the domain entities and repositories for the Task Management System. 
> 1. Create `Priority` (HIGH, MEDIUM, LOW) and `Status` (PENDING, COMPLETED) enums.
> 2. Create a `User` entity with `id` (Long, PK), `name` (String), and `email` (String). 
> 3. Create a `Task` entity with `id` (Long, PK), `title` (String), `description` (String), `priority` (Enum), `status` (Enum), and `dueDate` (LocalDate). Add a Many-to-One relationship mapping from `Task` to `User`.
> 4. Create `UserRepository` and `TaskRepository` interfaces extending `JpaRepository<T, Long>`. In `TaskRepository`, add custom derived query methods to find tasks by status, priority, and due date (tasks due before a specific date).

## Phase 3: Service Layer Implementation and Exception Handling
**Goal:** Implement the business logic using an interface-based design and set up graceful error handling.

**Execution Prompt:**
> Implement the service layer for the Task Management System using interface-based design. 
> 1. Create interfaces `UserService` and `TaskService`, and their respective implementations `UserServiceImpl` and `TaskServiceImpl`.
> 2. Implement CRUD methods in `UserService` (create user, get by ID, get all, delete).
> 3. Implement methods in `TaskService` (create task, get by ID, get all, delete, filter by status, filter by priority, and filter by due date).
> 4. Create a global exception handler (using `@ControllerAdvice`) and custom exceptions (e.g., `ResourceNotFoundException`) to handle invalid inputs and missing records gracefully, returning user-friendly JSON error messages.

## Phase 4: REST Controllers and Swagger UI
**Goal:** Expose the application via RESTful APIs and ensure the API documentation is accessible.

**Execution Prompt:**
> Create the REST controllers for the Task Management System.
> 1. Create `UserController` mapped to `/users` with endpoints: `POST /users`, `GET /users/{id}`, `GET /users`, and `DELETE /users/{id}`.
> 2. Create `TaskController` mapped to `/tasks` with endpoints: `POST /tasks`, `GET /tasks/{id}`, `GET /tasks`, `DELETE /tasks/{id}`, `GET /tasks/status/{status}`, `GET /tasks/priority/{priority}`, and `GET /tasks/duedate/{duedate}`.
> 3. Inject the appropriate service interfaces into the controllers. 
> 4. Ensure that Swagger UI is accessible at `/swagger-ui.html` and add basic OpenAPI annotations to describe the endpoints if necessary.

## Phase 5: Testing and Deliverables Verification
**Goal:** Create the required Postman collection and ensure all constraints are met.

**Execution Prompt:**
> Generate a Postman collection in JSON format named `test.json` containing requests for all the Task Management System API endpoints. Include standard requests for creating users, creating tasks (assigned to a user), fetching records, filtering tasks by priority/status/dueDate, and deleting records. Ensure sample request bodies are included for the POST methods.