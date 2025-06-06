# Enunciado

En un centro de Formación Profesional se desea almacenar las calificaciones de los alumnos de todos los ciclos formativos en una base de datos (BBDD).  
**Motivo**: centralizar la información para poder remitirla posteriormente a la Consellería de Educación.

Los profesores del ciclo **DAM (Desarrollo de Aplicaciones Multiplataforma)** disponen de los datos de sus módulos en formato **JSON**, accesibles mediante una **API REST**.

Como buenos informáticos, han decidido crear una aplicación que permita:

1. Obtener los datos desde el API. https://api.jsonbin.io/v3/b/684069908960c979a5a53c21
2. Transformarlos a objetos Java.
3. Almacenarlos en una base de datos relacional.

---

## Formato del JSON de ejemplo

```json
{
  "record": {
    "estudiantes": [
      {
        "nombre": "Lucía Pérez",
        "edad": 20,
        "matricula": "DAM2025-001",
        "ciclo": "Desarrollo de Aplicaciones Multiplataforma",
        "modulos": [
          {
            "nombre": "Programación",
            "nota": 8.5
          },
          {
            "nombre": "Bases de Datos",
            "nota": 9
          }
        ],
        "activo": true
      }
    ]
  }
}
```




## Hint
El script de base de datos está disponible en src/main/resources/sql/database_script.sql


El API está autenticado, para poder hacer una llamada de prueba, deberás usar Postman
En la pestaña authorization:
AuthType: API Key:
Key: X-Access-Key 
Value: $2a$10$4YgatT4iXPwhqpC6IRy44OTZjDNITUdJbtRwEIP2V58Vv9mzPJw3i

Así ya debería funcionar

El equivalente en código Java para conectarse al API Autenticado.

```java
HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath)).headers("X-Access-Key","$2a$10$4YgatT4iXPwhqpC6IRy44OTZjDNITUdJbtRwEIP2V58Vv9mzPJw3i",    "X-Bin-Meta", "false")
.method("GET", HttpRequest.BodyPublishers.noBody()).build();
```

Para construir la aplicación, se propone seguir la siguiente secuencia de pasos:

1.- Diseño de Capas: Estructura tu aplicación en las siguientes capas principales: app, service y dao.

2.- Modelado de DTOs: Dentro de la capa service, define las Clases de Transferencia de Datos (DTOs) que representen la estructura del JSON del API: ModuloDTO, RecordDTO y EstudianteDTO.

3.- Consumo del API: En la capa service, crea una clase llamada CalificacionesApiCaller. Esta clase será responsable de realizar la llamada al API y de devolver un objeto RecordDTO con los datos obtenidos.

4.- Modelado de Entidades DAO: En la capa DAO (Data Access Object), crea las clases Modulo y Calificacion. Estas clases representarán las tablas correspondientes en la base de datos.

5.- DAO para Módulos: Implementa una clase ModuloJDBCDAO en la capa DAO. Su función será obtener un objeto Modulo a partir de su nombre desde la base de datos (o persistirlo si no existe).

6.- Lógica de Negocio (Service): En la capa service, crea la clase CentroFPService. Esta clase orquestará la lógica de negocio principal. Implementa un método que reciba un RecordDTO del API y lo transforme en una lista de objetos Calificacion.

7.- Pruebas Iniciales (App): Desde una clase AppCentroFP (en la capa app), realiza pruebas para verificar que la transformación de datos entre RecordDTO y Calificacion funciona correctamente.

8.-DAO para Calificaciones: En la capa DAO, crea una clase CalificacionDAO con un método para insertar (insert) un objeto Calificacion en la base de datos.

9.- Proceso Completo (Service): En la clase CentroFPService, crea un método que encapsule el flujo completo:
Llamar al API para obtener los records.
Transformar los records obtenidos en una lista de Calificacion.
Persistir estas Calificaciones en la base de datos utilizando CalificacionDAO.

10.- Ejecución Final (App): Desde la clase AppCentroFP, invoca el método creado en el paso anterior para ejecutar todo el proceso de extracción, transformación y carga de datos.