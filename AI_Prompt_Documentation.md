# AI Prompt Documentation & Workflow – Task Management System

This document is derived from:

- GEMINI.md (AI-based requirement extraction)
- Project_Implementation_Plan.md (AI-generated execution phases)

All implementation steps strictly follow these artifacts.

## Core Idea

Use AI as a looped system:

Planner → Implementer → Tester → Reviewer

Avoid one-shot code generation. Follow incremental, validated development.

---

## Tools Used

* Gemini CLI / Gemini Code Assistant
* Git (version control)
* MySQL (taskmgmtdb)
* Postman
* Swagger UI
* (Optional) Sonar, Gitleaks

---

## 1. Define the Task using AI

### Goal

Clarify the problem, inputs/outputs, constraints, and success criteria.

### Execution

Run:
gemini cli

### Prompt

Analyze the uploaded assignment and extract:

1. Problem statement
2. Entities with fields
3. API endpoints
4. Constraints (tech stack, DB, etc.)
5. Deliverables

Return structured markdown.

### Output

Save as:
GEMINI.md

---

## 2. Plan Before Coding

### Goal

Break the system into small, structured phases.

### Execution

Run:
gemini chat

### Prompt

Using GEMINI.md, create a step-by-step implementation plan.

Break into phases:

1. Project Setup
2. Entity & Repository
3. Service Layer
4. Controllers
5. Testing

For each phase, provide execution prompts.

### Output

Save as:
Project_Implementation_Plan.md

---

## 3. Use Reusable Patterns

* Architecture: Controller → Service → Repository → Entity
* Debugging Prompt: Fix this Spring Boot error and explain root cause
* Review Prompt: Review this code for production readiness
* Testing Prompt: Generate Postman collection and edge cases

---

## 4. Decompose First

### Prompt

Analyze this system and identify:

1. Dependencies between layers
2. Risks (entity mapping, JSON recursion)
3. Order of implementation

### Key Risks

* Task → User mapping (ManyToOne)
* Infinite JSON recursion
* Enum handling
* Date parsing

---

## 5. Build in Increments

### Increment 1: Project Setup

Tool used:
gemini cli

Prompt:
Initialize a Spring Boot project using Java 17+.

Include:

* Spring Web
* Spring Data JPA
* MySQL Driver
* Springdoc OpenAPI

Configure application.properties:

* database: taskmgmtdb
* Hibernate DDL auto update

Generate a standard .gitignore.

Verify:

* Application runs
* Database connects

---

### Increment 2: Entity & Repository Layer

### Execution

Tool used:
gemini cli

Prompt:
Create the domain entities and repositories:

1. Create Priority (HIGH, MEDIUM, LOW) and Status (PENDING, COMPLETED) enums
2. Create User entity (id, name, email)
3. Create Task entity (id, title, description, priority, status, dueDate)
4. Add ManyToOne mapping from Task to User
5. Create JpaRepository interfaces
6. Add derived queries for status, priority, dueDate

Verify:

* Tables created
* Relationships working

---

### Increment 3: Service Layer & Exception Handling

Tool used:
gemini cli

Prompt:
Implement service layer:

1. Create UserService and TaskService interfaces
2. Create implementations UserServiceImpl and TaskServiceImpl
3. Implement CRUD operations
4. Implement filtering (status, priority, dueDate)
5. Add global exception handler using @ControllerAdvice
6. Create ResourceNotFoundException

Verify:

* Business logic works
* Errors handled properly

---

### Increment 4: Controllers & Swagger

Tool used:
gemini cli

Prompt:
Create REST controllers:

1. UserController (/users):

   * POST, GET by id, GET all, DELETE

2. TaskController (/tasks):

   * POST, GET by id, GET all, DELETE
   * Filter by status, priority, dueDate

3. Inject services into controllers

4. Enable Swagger UI at /swagger-ui.html

Verify:

* Swagger UI loads
* APIs visible

---

### Increment 5: Testing & Deliverables

Tool used:
gemini cli

Prompt:
Generate a Postman collection (test.json):

Include:

* Create user
* Create task
* Get all
* Filter APIs
* Delete APIs

Include sample request bodies.

Verify:

* Import into Postman
* All APIs working

---

## 6. Separate WRITE vs REVIEW

### Write Phase

Used Gemini CLI to generate code.

### Review Phase

Tool used:
gemini cli

Prompt:
Review this Spring Boot code:

* Check for bugs
* Validate architecture
* Improve exception handling
* Suggest improvements

Checklist:

* Proper layering
* No circular JSON
* @Transactional used
* Clean validation

---

## 7. Testing Strategy

### Manual Testing

Use Postman (test.json)

### Swagger Testing

Access:
/swagger-ui.html

### Edge Case Testing

Prompt:
Generate edge test cases for:

* Invalid ID
* Missing fields
* Invalid enum values
* Past due dates

---

## 8. Verification Checklist

* All APIs working
* Swagger accessible
* MySQL connected
* No hardcoded secrets
* test.json included
* demo video included
* .gitignore added

---

## 9. Reusable AI Skills

Planning:
Break this project into phases

Debugging:
Fix this Spring Boot error and explain why

Review:
Review this code for production readiness

Testing:
Generate test cases for this API

---

## 10. Failure Handling

If AI gives wrong code:

Prompt:
Fix this error and explain root cause

Steps:

1. Re-prompt
2. Check logs
3. Validate manually

If build fails:

* Check dependencies
* Check DB config
* Refine prompt

---

## 11. AI Execution Evidence

* GEMINI.md generated using Gemini CLI
* Implementation plan generated using AI prompts
* Entities, services, and controllers generated incrementally
* Postman collection (test.json) generated using AI
* Errors resolved using debugging prompts

---

## Final Outcome

* Fully functional system
* AI-driven development
* Structured workflow
* Reproducible process

---

## Final Summary

This project was developed using a structured AI workflow leveraging Gemini CLI, following a planner → implementer → tester → reviewer loop. The system was built incrementally with continuous validation to ensure correctness, maintainability, and production-level quality.
