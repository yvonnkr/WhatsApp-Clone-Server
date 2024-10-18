# Whatsapp clone (fullstack project) Spring boot 3, Angular 18, Bootstrap, PostgreSQL, Keycloak (2024) (Backend)

Spring boot backend of the whatsapp clone


[Angular Frontend](https://github.com/yvonnkr/WhatsApp-Clone-Client)

### Key Features:
- 💬 Real-time messaging
- 👥 Conversations management
- 📁 File sharing (images, videos, documents)
- 🔐 Authentication and Authorization (Role management) with Keycloak (OAuth2)
- 🏢 Hexagonal architecture

## Usage
### Prerequisites
- [JDK 21](https://adoptium.net/temurin/releases/)
- [PostgreSQL](https://www.postgresql.org/download/)
- IDE ([IntelliJ](https://www.jetbrains.com/idea/download/))
- Docker ([Docker Desktop](https://docs.docker.com/engine/install/))

### Clone the repository
``git clone https://github.com/yvonnkr/WhatsApp-Clone-Server``

### Launch

#### Run keycloak
``docker-compose src/main/docker/keycloak.yml up -d``

#### Maven
``./mvnw spring-boot:run``