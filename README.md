Aquí tienes un **README** bien estructurado que documenta el código que me compartiste. Está diseñado para que cualquiera pueda entender el funcionamiento del programa y cómo usarlo.

---

# **BibliotecaApp - Sistema de Gestión de Biblioteca**

Este proyecto implementa un sistema básico de gestión de biblioteca en **Java**, utilizando **arrays** y **listas enlazadas** para manejar libros, préstamos y un historial de operaciones.

El objetivo es simular el funcionamiento de una biblioteca sin usar bases de datos externas, ideal para practicar **estructuras de datos**.

---

## **Características principales**

* **Gestión de libros**:

  * Alta (registro de libros nuevos).
  * Baja lógica (desactiva un libro sin borrarlo físicamente).
  * Control de stock.

* **Gestión de préstamos**:

  * Registro de préstamos de libros a usuarios.
  * Devolución de libros prestados.
  * Lista de préstamos activos.

* **Historial de operaciones**:

  * Guarda todas las acciones realizadas en el sistema.
  * Se puede recorrer **de inicio a fin** y **de fin a inicio**.

* **Interfaz de consola con menú interactivo**:

  * El usuario puede seleccionar opciones numéricas para interactuar con el sistema.

---

## **Estructuras utilizadas**

El programa se basa en tres estructuras principales:

| Estructura                      | Tipo         | Descripción                                           |
| ------------------------------- | ------------ | ----------------------------------------------------- |
| **Catálogo de libros**          | Array (1D)   | Almacena hasta 100 libros (`Libro`).                  |
| **Disponibilidad por sucursal** | Matriz (2D)  | Controla el stock en 5 sucursales (`int[100][5]`).    |
| **Lista de préstamos**          | Lista simple | Cada nodo (`Prestamo`) representa un préstamo activo. |
| **Historial de operaciones**    | Lista doble  | Cada nodo (`Operacion`) guarda una acción realizada.  |

---

## **Clases principales**

### **1. Libro**

Guarda la información básica de un libro:

```java
int codigo;
String titulo;
String autor;
int stock;
boolean activo; // true = disponible, false = dado de baja
```

---

### **2. Prestamo**

Representa un préstamo activo.
Forma parte de una **lista simple**:

```java
int codigoLibro;
String usuario;
LocalDate fecha;
boolean devuelto;
Prestamo siguiente;
```

---

### **3. Operacion**

Guarda cada acción realizada en la biblioteca.
Forma parte de una **lista doble**:

```java
String tipo; // ALTA, BAJA, PRESTAMO, DEVOLUCION
String detalle;
LocalDateTime fecha;
Operacion anterior;
Operacion siguiente;
```

---

## **Flujo de trabajo**

### **Altas y bajas de libros**

1. **Alta:** Se registra un libro con sus datos y stock inicial.

   * Se guarda en el array `catalogo`.
   * Se registra en el historial como `"ALTA"`.

2. **Baja:** El libro se marca como inactivo (`activo = false`).

   * Se conserva el registro histórico.
   * Se registra en el historial como `"BAJA"`.

---

### **Préstamos**

* **Préstamo de libro:**

  1. Se verifica que el libro esté activo y con stock disponible.
  2. Se crea un nodo en la lista simple de préstamos.
  3. Se descuenta el stock en el catálogo.
  4. Se registra la operación como `"PRESTAMO"` en el historial.

* **Devolución de libro:**

  1. Se busca el préstamo correspondiente en la lista simple.
  2. Si existe, se marca como devuelto y se incrementa el stock.
  3. Se registra la operación como `"DEVOLUCION"` en el historial.

---

## **Menú interactivo**

El programa ofrece un menú para interactuar:

| Opción | Acción                   |
| ------ | ------------------------ |
| 1      | Alta de libro            |
| 2      | Baja de libro            |
| 3      | Prestar libro            |
| 4      | Devolver libro           |
| 5      | Listar préstamos activos |
| 6      | Historial (inicio → fin) |
| 7      | Historial (fin → inicio) |
| 8      | Salir del programa       |

---

## **Ejemplo de ejecución**

```
--- MENÚ ---
1. Alta libro
2. Baja libro
3. Prestar libro
4. Devolver libro
5. Listar préstamos
6. Historial adelante
7. Historial atrás
8. Salir
Opción: 1

Código: 101
Título: El principito
Autor: Antoine de Saint-Exupéry
Stock: 3
Libro agregado correctamente.
```

