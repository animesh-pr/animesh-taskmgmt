# GEMINI.md - Task Management System

## Project Overview
A Spring Boot-based Task Management System allowing CRUD operations on Tasks and Users with filtering capabilities.

## Technical Mandates
- **Language:** Java 17+
- **Framework:** Spring Boot
- **Database:** MySQL (Database name: `taskmgmtdb`)
- **API Documentation:** Swagger UI (accessible at `/swagger-ui.html`)
- **Architecture:** Controller -> Service (Interface/Impl) -> Repository -> Entity

## Entity Specifications

### User
- `Long id` (Primary Key)
- `String name`
- `String email`

### Task
- `Long id` (Primary Key)
- `String title`
- `String description`
- `Priority priority` (Enum: HIGH, MEDIUM, LOW)
- `Status status` (Enum: PENDING, COMPLETED)
- `LocalDate dueDate`
- `User user` (Many-to-One mapping)

## API Endpoints

### TaskController
- `POST /tasks`: Create/Save task
- `GET /tasks/{id}`: Retrieve by ID
- `GET /tasks`: List all
- `DELETE /tasks/{id}`: Delete by ID
- `GET /tasks/status/{status}`: Filter by Status
- `GET /tasks/priority/{priority}`: Filter by Priority
- `GET /tasks/duedate/{duedate}`: Filter tasks due before date

### UserController
- `POST /users`: Create/Save user
- `GET /users/{id}`: Retrieve by ID
- `GET /users`: List all
- `DELETE /users/{id}`: Delete by ID

## Constraints & Requirements
- Use `JpaRepository<T, Long>` for data access.
- Implement Interface-based service layers (`TaskService`/`TaskServiceImpl`, `UserService`/`UserServiceImpl`).
- Handle invalid inputs gracefully with user-friendly prompts.
- Deliverables must include a Postman collection (`test.json`) and a `.gitignore` file.
