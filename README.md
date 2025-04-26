# Biblioteca
# Sistema de Gestión de Biblioteca - Microservicios

## 📋 Descripción

Sistema distribuido para gestión de libros y autores, implementado con:
- **2 microservicios** independientes (autor, libro)
- Comunicación REST reactiva
- Base de datos MongoDB
- API Gateway con enrutamiento dinámico
- Contenerización con Docker

## 🚀 Tecnologías Principales

| Tecnología          | Uso                          |
|---------------------|------------------------------|
| Spring Boot 3       | Framework backend            |
| WebFlux             | Programación reactiva        |
| MongoDB             | Base de datos NoSQL          |
| Spring Cloud Gateway| Enrutamiento de peticiones   |
| Eureka              | Service Discovery            |
| JUnit 5             | Pruebas unitarias            |
| Docker              | Contenerización             |
| GitHub Actions      | CI/CD Pipeline               |

## ⚙️ Configuración

### Requisitos
- JDK 17
- Maven 3.8+
- Docker 20.10+
- MongoDB 5.0+

### Variables de Entorno
```bash
Ejemplo para libro-service
export SPRING_DATA_MONGODB_URI=mongodb://localhost:27017/librosdb
export EUREKA_CLIENT_SERVICE_URL_DEFAULTZONE=http://localhost:8761/eureka


🏗️ Estructura del Proyecto
biblioteca/
├── autor-service/
│ ├── src/
│ │ ├── main/java/com/biblioteca/autor/
│ │ │ ├── config/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── AutorApplication.java
│ │ └── resources/
│ │ └── application.properties
│ ├── Dockerfile
│ └── pom.xml
├── libro-service/
│ ├── src/
│ │ ├── main/java/com/biblioteca/libro/
│ │ │ ├── client/
│ │ │ ├── config/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── LibroApplication.java
│ │ └── resources/
│ │ └── application.properties
│ ├── Dockerfile
│ └── pom.xml
🛠️ Instalación
Clonar repositorio:

bash
git clone https://github.com/tu-usuario/biblioteca-microservices.git
cd biblioteca-microservices
Iniciar con Docker Compose:

bash
docker-compose up -d --build
Verificar servicios:

bash
docker ps
📚 Endpoints
API Gateway (Puerto 8082)
Método	Endpoint	Descripción
POST	/autores	Crear nuevo autor
GET	/autores	Listar todos los autores
GET	/autores/{id}	Obtener autor por ID
POST	/libros	Crear nuevo libro
GET	/libros	Listar todos los libros
GET	/libros/{id}	Obtener libro por ID
PUT	/libros/{id}/autor	Asignar autor a libro
🧪 Pruebas
Ejecutar pruebas unitarias:

bash
# En cada microservicio
mvn test
Pruebas de integración:

bash
mvn verify -Pintegration
🐳 Docker
Construir imágenes individuales:

bash
cd autor-service
docker build -t autor-service .
🔍 Monitorización
Endpoints Actuator (por servicio):

http://localhost:8080/actuator/health

http://localhost:8081/actuator/metrics

http://localhost:8082/actuator/env

🤝 Contribución
Hacer fork del proyecto

Crear rama (git checkout -b feature/foo)

Commitear cambios (git commit -am 'Add some foo')

Pushear la rama (git push origin feature/foo)

Crear Pull Request

📄 Licencia
Jeffer Pinzon

Nota: Para desarrollo local sin Docker, iniciar MongoDB manualmente y configurar las URIs en los application.properties de cada servicio.
