# 📌 Evaluación T2 - API Atenciones Médicas

## 🧾 Descripción

API REST desarrollada con Spring Boot para la gestión de atenciones médicas.
Permite registrar, consultar, actualizar y eliminar atenciones, así como obtener historial por paciente y consultas por rango de fechas.

---

## 🚀 Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* Lombok
* OpenAPI / Swagger

---

## 📂 Endpoints disponibles

### 🔹 1. Listar todas las atenciones

* **GET** `/api/atenciones`
* **Respuesta:** 200 OK

---

### 🔹 2. Crear una atención

* **POST** `/api/atenciones`
* **Body:**

```json
{
  "nombrePaciente": "Juan",
  "apellidoPaciente": "Perez",
  "nombreMedico": "Carlos",
  "apellidoMedico": "Ramirez",
  "fechaAtencion": "2026-04-10",
  "referencia": "Control general"
}
```

* **Respuestas:**

  * 201 → Creado correctamente
  * 400 → Datos inválidos

---

### 🔹 3. Historial de paciente

* **GET** `/api/atenciones/historial?nombrePaciente=Juan&apellidoPaciente=Perez`
* **Respuestas:**

  * 200 → Lista ordenada por fecha DESC
  * 404 → No se encontraron registros
  * 400 → Parámetros faltantes

---

### 🔹 4. Buscar por rango de fechas

* **GET** `/api/atenciones/rango?fechaInicio=2026-04-01&fechaFin=2026-04-30`
* **Respuestas:**

  * 200 → Lista de atenciones
  * 404 → No hay resultados
  * 400 → Parámetros inválidos

---

### 🔹 5. Actualizar una atención

* **PUT** `/api/atenciones/{id}`
* **Respuestas:**

  * 201 → Actualizado correctamente
  * 404 → No existe el ID

---

### 🔹 6. Eliminar una atención

* **DELETE** `/api/atenciones/{id}`
* **Respuestas:**

  * 204 → Eliminado correctamente
  * 404 → No existe la atención

---

## ⚠️ Validaciones

* Campos obligatorios:

  * nombrePaciente
  * apellidoPaciente
  * nombreMedico
  * apellidoMedico
  * fechaAtencion
* Si faltan → retorna **400 Bad Request**

---

## 🧠 Consideraciones técnicas

* Se utiliza `LocalDate` para fechas
* Se implementa control de concurrencia con `@Version`
* Uso de DTOs para separación de capas
* Manejo de errores con códigos HTTP adecuados

---

## ▶️ Ejecución del proyecto

1. Clonar repositorio
2. Ejecutar:

```bash
mvn spring-boot:run
```

3. Acceder a Swagger:

```
http://localhost:8080/swagger-ui.html
```

---

## 👨‍💻 Autor

* Alexander Kevin Cochachin Infantes

---
