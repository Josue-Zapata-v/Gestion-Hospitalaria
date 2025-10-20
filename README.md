# 🏥 Sistema de Gestión Hospitalaria - Módulo Pacientes

Sistema de gestión de pacientes desarrollado con **Spring Boot**, **Spring Data JPA** y **Thymeleaf**. Permite administrar información personal y médica de pacientes, asegurando que cada uno tenga un expediente completo y único.

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías](#-tecnologías)
- [Arquitectura](#-arquitectura)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Uso](#-uso)
- [Funcionalidades](#-funcionalidades)
- [Modelo de Datos](#-modelo-de-datos)
- [Autor](#-autor)

## ✨ Características

- ✅ Registro y gestión completa de pacientes
- ✅ Creación automática de historia clínica al registrar paciente
- ✅ Gestión de antecedentes médicos (alergias, enfermedades, cirugías)
- ✅ Interfaz moderna y responsiva con Bootstrap 5
- ✅ Arquitectura MVC con Spring Boot
- ✅ Validación de datos y manejo de errores
- ✅ Diseño intuitivo con tarjetas informativas

## 🛠 Tecnologías

- **Backend:** Spring Boot 3.5.6, Spring Data JPA, Hibernate
- **Frontend:** Thymeleaf, Bootstrap 5, HTML5, CSS3
- **Base de Datos:** MySQL 
- **Lenguaje:** Java 17+
- **Gestión de Dependencias:** Maven 3.6+

## 🏗 Arquitectura

El proyecto sigue el patrón **MVC (Modelo-Vista-Controlador)**:
```
┌─────────────┐      ┌──────────────┐      ┌─────────────┐
│  Controller │─────▶│   Service    │─────▶│ Repository  │
│  (HTTP)     │◀─────│  (Lógica)    │◀─────│   (DB)      │
└─────────────┘      └──────────────┘      └─────────────┘
       │
       ▼
┌─────────────┐
│    View     │
│ (Thymeleaf) │
└─────────────┘
```

## 📁 Estructura del Proyecto
```
src/
├── main/
│   ├── java/com/tecsup/
│   │   ├── controllers/          # Controladores HTTP
│   │   ├── model/
│   │   │   ├── entities/         # Entidades JPA
│   │   │   └── daos/             # Repositorios
│   │   └── services/             # Lógica de negocio
│   └── resources/
│       ├── templates/            # Vistas Thymeleaf (.html)
│       ├── static/
│       │   └── css/              # Estilos personalizados
│       └── application.properties
```

## 📦 Componentes Principales

| Componente | Paquete | Responsabilidad |
|------------|---------|-----------------|
| **Entidades** | `com.tecsup.model.entities` | Modelos de datos: `Paciente`, `HistoriaClinica`, `AntecedenteMedico` |
| **Repositorios** | `com.tecsup.model.daos` | Interfaces `JpaRepository` para persistencia |
| **Servicios** | `com.tecsup.services` | Lógica de negocio y reglas de validación |
| **Controladores** | `com.tecsup.controllers` | Manejo de peticiones HTTP y navegación |
| **Vistas** | `templates/` | Plantillas HTML renderizadas con Thymeleaf |

## 💻 Requisitos Previos

- ☕ Java Development Kit (JDK) 17 o superior
- 📦 Maven 3.6+
- 🗄️ MySQL 8.0 o superior
- 🔧 IDE recomendado: IntelliJ IDEA, Eclipse o VS Code

## 🚀 Instalación y Configuración

### 1. Clonar el repositorio
```bash
git clone https://github.com/Josue-Zapata-v/Gestion-Hospitalaria.git
cd gestion-hospitalaria
```

### 2. Configurar la base de datos

Crear la base de datos en MySQL:
```sql
CREATE DATABASE hospital_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configurar credenciales

Editar el archivo `src/main/resources/application.properties`:
```properties
# Configuración de Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA_AQUI

# Configuración del servidor
server.port=8086
```

> **Nota:** Reemplaza `TU_CONTRASEÑA_AQUI` con tu contraseña de MySQL. Si usas el usuario root sin contraseña, deja el campo vacío.

### 4. Compilar y ejecutar
```bash
# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

O ejecutar directamente desde tu IDE.

### 5. Acceder a la aplicación

Abrir en el navegador:
```
http://localhost:8086/pacientes/listar
```

## 📱 Uso

### Rutas Principales

| Ruta | Método | Descripción |
|------|--------|-------------|
| `/pacientes/listar` | GET | Lista todos los pacientes |
| `/pacientes/nuevo` | GET | Formulario de registro |
| `/pacientes/guardar` | POST | Guarda un nuevo paciente |
| `/pacientes/editar/{id}` | GET | Formulario de edición |
| `/pacientes/eliminar/{id}` | GET | Elimina un paciente |

## 🎯 Funcionalidades

### Gestión de Pacientes

- **Listar Pacientes:** Vista en formato de tarjetas con información detallada
- **Registrar Paciente:** Formulario con validaciones y creación automática de historia clínica
- **Editar Paciente:** Modificación de datos personales manteniendo integridad referencial
- **Eliminar Paciente:** Eliminación en cascada de historia y antecedentes

### Diseño de Interfaz

- 🎨 Diseño moderno con Bootstrap 5
- 📱 Totalmente responsivo (mobile-first)
- 🎯 Tarjetas informativas con dos columnas balanceadas
- 🔘 Botones de acción con iconos intuitivos
- ✨ Efectos hover y transiciones suaves

### Lógica de Negocio

- ✅ **Creación automática de Historia Clínica** al registrar paciente (relación 1:1)
- ✅ **Edición segura** sin duplicar historias clínicas
- ✅ **Validación de datos** antes de persistir
- ✅ **Manejo de errores** con mensajes informativos

## 🗃 Modelo de Datos

### Entidades y Relaciones
```
┌─────────────┐         ┌──────────────────┐         ┌────────────────────┐
│  Paciente   │1      1 │ HistoriaClinica  │1      N │ AntecedenteMedico  │
│─────────────│────────▶│──────────────────│────────▶│────────────────────│
│ id          │         │ id               │         │ id                 │
│ dni         │         │ paciente_id      │         │ historiaClinica_id │
│ nombre      │         │ fechaCreacion    │         │ tipo               │
│ apellido    │         │                  │         │ descripcion        │
│ fechaNac    │         │                  │         │ fechaRegistro      │
│ telefono    │         │                  │         │                    │
│ email       │         │                  │         │                    │
│ direccion   │         │                  │         │                    │
│ estado      │         │                  │         │                    │
└─────────────┘         └──────────────────┘         └────────────────────┘
```

### Descripción de Entidades

| Entidad | Propósito | Relación |
|---------|-----------|----------|
| **Paciente** | Datos personales del paciente (DNI, nombre, contacto, estado) | 1:1 con HistoriaClinica |
| **HistoriaClinica** | Expediente médico central, creado automáticamente | 1:1 con Paciente, 1:N con AntecedenteMedico |
| **AntecedenteMedico** | Registro de alergias, enfermedades y cirugías | N:1 con HistoriaClinica |

## 📝 Configuración Detallada

### application.properties
```properties
# Nombre de la aplicación
spring.application.name=gestion_hospitalaria

# Puerto del servidor
server.port=8086

# Configuración de Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Logs SQL formateados
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 👨‍💻 Autor

**Josué Zapata**

---

⭐ Si este proyecto te fue útil, no olvides darle una estrella en GitHub

📧 Para consultas o sugerencias, no dudes en contactar
