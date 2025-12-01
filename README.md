# 📘 MS_SECURITY – API Documentation

Sistema de seguridad y gestión de módulos del e-commerce **Sak Global**, desarrollado en **Java Spring Boot**, con servicios para autenticación, autorización, productos, categorías, carrito de compras, órdenes, pagos y configuración del sistema.

Este README documenta los endpoints expuestos por los controladores del módulo **ms_security**.

El backend de **Sak Global** es una API desarrollada en **Java con Spring Boot**, con persistencia en **MySQL** y manejo centralizado de errores mediante el módulo `GuardianShopErrorControl`.

---

## 📂 Estructura de Controladores Documentados

Este documento cubre los siguientes controladores:

- AuthController  
- CartController  
- CategoryController  
- OrderItemController  
- ParametersController  
- PayPalController  
- PermissionController  
- RoleController  

---

## 🚀 Tecnologías

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Security  
- JPA / Hibernate  
- Lombok  
- Swagger OpenAPI  
- PayPal SDK  

---

# 📁 Endpoints Documentados

---

# 1️⃣ AUTH CONTROLLER

### **Base Path:** `/auth`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/login` | Iniciar sesión y obtener token JWT |
| POST | `/validate-token` | Validar token de autenticación |
| POST | `/create-user` | Registrar un nuevo usuario |
| POST | `/update-user` | Actualizar información de usuario |
| POST | `/delete-user` | Eliminar usuario |
| POST | `/find/id` | Buscar usuario por ID |
| POST | `/find/all` | Listar usuarios |

---

# 2️⃣ CART CONTROLLER

### **Base Path:** `/cart`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/list/id` | Buscar carrito por ID |
| POST | `/list/all` | Listar todos los carritos |
| POST | `/addRecord` | Crear carrito |
| POST | `/updateRecord` | Actualizar carrito |
| POST | `/delete` | Eliminar carrito |
| POST | `/validate/user` | Validar si un usuario ya tiene carrito |
| POST | `/list/user` | Buscar carrito por ID de usuario |

---

# 3️⃣ CATEGORY CONTROLLER

### **Base Path:** `/category`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/list/id` | Buscar categoría por ID |
| POST | `/list/all` | Listar categorías |
| POST | `/addRecord` | Crear categoría |
| POST | `/updateRecord` | Actualizar categoría |
| POST | `/delete` | Eliminar categoría |

---

# 4️⃣ ORDER ITEM CONTROLLER

### **Base Path:** `/order-items`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/list/id` | Buscar item por ID |
| POST | `/list/all` | Listar items |
| POST | `/updateRecord` | Actualizar item |
| POST | `/delete` | Eliminar item |
| POST | `/validate/cart` | Validar existencia de carrito |
| POST | `/list/cart` | Listar items por ID de carrito |

---

# 5️⃣ PARAMETERS CONTROLLER

### **Base Path:** `/api/parameters`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/list/all` | Listar parámetros del sistema |
| POST | `/code` | Buscar por código |
| POST | `/create` | Crear parámetro |
| POST | `/update` | Actualizar parámetro |
| POST | `/delete` | Eliminar parámetro |

---

# 6️⃣ PAYPAL CONTROLLER

### **Base Path:** `/paypal`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/pay` | Crear transacción con PayPal |
| GET | `/success` | Confirmación de pago |
| GET | `/cancel` | Pago cancelado |

---

# 7️⃣ PERMISSION CONTROLLER

### **Base Path:** `/permission`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/list/id` | Buscar permiso por ID |
| POST | `/list/all` | Listar permisos |
| POST | `/addRecord` | Crear permiso |
| POST | `/updateRecord` | Actualizar permiso |
| POST | `/list/role` | Listar permisos por rol |

---

# 8️⃣ ROLE CONTROLLER

### **Base Path:** `/role`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/list/id` | Buscar rol por ID |
| POST | `/list/all` | Listar roles |
| POST | `/addRecord` | Crear rol |
| POST | `/updateRecord` | Actualizar rol |
| POST | `/list/permissions` | Obtener rol con permisos |
| POST | `/list/user` | Obtener usuario con sus roles |

---

## 📌 Notas Importantes

- Todas las respuestas son `ResponseEntity<String>` en formato JSON.  
- El sistema utiliza **Swagger** para auto-documentar la API.  
- Se usa **POST para todas las operaciones**, incluso consultas, por decisión de arquitectura.  
- Este módulo hace parte del ecosistema del e-commerce **Sak Global**.

---


## 👤 Autores
Jefferson Andrés Moreno Pedraza  
Johan Sebastián Cárdenas Orozco  
