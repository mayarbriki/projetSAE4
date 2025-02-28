Educational Platform - Microservices Architecture
Overview

This project is a microservices-based educational platform designed for managing courses, exams, users, and student interactions. The architecture ensures scalability, maintainability, and flexibility, aligning with best practices in microservices design.
Features

    Course Management: Create, modify, and track courses.
    Exam Administration: Schedule, configure, and grade exams.
    User Authentication & Authorization: Secure access using JWT and role-based controls.
    Microservices Communication: Uses REST, service discovery, and circuit breaking.
    Scalable Deployment: Containerized services managed via Kubernetes/Docker.
    Security & Performance Optimization: Implements caching, logging, and monitoring.

Architecture
![image](https://github.com/user-attachments/assets/cf1c9765-4718-486b-bcf3-d48ad1071b0d)
![image](https://github.com/user-attachments/assets/ff8f323b-4e72-4f64-9791-23964ea4e250)
![image](https://github.com/user-attachments/assets/3a1c50d1-d34d-41b4-843c-8a1d9df3e8ba)
![image](https://github.com/user-attachments/assets/7e74a5c8-2d91-4516-b4e1-91c298cd3e7b)





The platform consists of multiple microservices, including:

    Core Services:
        Answer Service (Exam responses and evaluation)
        Course Service (Course creation and tracking)
        Exam Service (Exam scheduling and grading)
        User Service (User management and authentication)

    Common Services:
        Common Service (Shared utilities)
        Common Student Service (Student-related logic)
        Common Exam Service (Exam-related utilities)

    Infrastructure Services:
        API Gateway (Single entry point for requests)
        Service Discovery (Eureka) (Microservices registration and lookup)

Deployment

    Uses Docker for containerization.
    Orchestrated via Kubernetes (or Docker Swarm).
    CI/CD pipeline for automated deployments.

Tech Stack

    Spring Boot (Backend)
    MySQL (Database)
    Eureka (Service Discovery)
    JWT (Authentication)
    Redis (Caching)
    Docker/Kubernetes (Deployment)

Installation
Prerequisites

    Docker & Docker Compose
    Java 17+
    MongoDB
    Kubernetes (if using orchestration)
