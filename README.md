# Hotel Management System

A console-based Java application for managing hotel rooms, customers, bookings, and additional services.

This project is a **Java Object-Oriented Programming foundation capstone** focused on practicing abstraction, interfaces, inheritance, polymorphism, composition, encapsulation, packages, and `HashMap`.

The application is built as a multi-file Java project and uses hardcoded data in `Main.java` instead of `Scanner` input.

---

## 📌 Project Overview

The Hotel Management System allows the hotel to:

* Add and manage rooms
* Create customers
* Book available rooms
* Add additional services to booked rooms
* Calculate the total booking cost
* Display booking details
* Display all rooms and their availability
* Search for rooms using their room number
* List all available rooms
* Validate invalid room and customer data

The system supports three room types:

* Standard Room
* Deluxe Room
* Suite Room

And three additional services:

* Spa Service
* Dining Service
* Gym Service

---

## 🧠 Concepts Practiced

This project focuses on Java Object-Oriented Programming concepts:

* Classes and Objects
* Encapsulation
* Access Modifiers
* Constructors
* Inheritance
* Abstract Classes
* Abstract Methods
* Interfaces
* `implements`
* `extends`
* Polymorphism
* Composition
* `ArrayList`
* `HashMap`
* Varargs
* Method Overriding
* Method Parameters and Return Values
* Packages
* `String.format`
* Input Validation
* Basic Data Processing

---

## 🏗️ OOP Design

The project uses an abstract `Room` class as the base of the room hierarchy.

```text
                    Room
                  (abstract)
                     │
          ┌──────────┼──────────┐
          │          │          │
     StandardRoom DeluxeRoom SuiteRoom
```

The project also uses a `Service` interface:

```text
                  Service
                (interface)
                     │
          ┌──────────┼──────────┐
          │          │          │
     SpaService DiningService GymService
```

The `Hotel` class manages all rooms using a `HashMap`.

A `Room` also owns its services using an `ArrayList`, demonstrating **composition**.

---

## 🏨 Room Hierarchy

### `Room`

`Room` is an abstract class containing the common properties and behavior of all rooms.

Private fields include:

* `roomNumber`
* `baseRate`
* `services`
* `isBooked`
* `customer`

The class provides:

* Room booking
* Service management
* Total cost calculation
* Booking details
* Getters
* Validation

It also defines the abstract method:

```java
abstract String getDescription();
```

Each room type provides its own implementation.

### `StandardRoom`

Returns:

```text
Standard Room
```

### `DeluxeRoom`

Returns:

```text
Deluxe Room
```

### `SuiteRoom`

Returns:

```text
Suite Room
```

---

## 🛎️ Services

The `Service` interface defines two methods:

```java
double getCost();
String getName();
```

The project provides three implementations:

| Service        |   Cost |
| -------------- | -----: |
| Spa Service    | $100.0 |
| Dining Service |  $50.0 |
| Gym Service    |  $30.0 |

This demonstrates **interface-based polymorphism** because the `Room` can work with any object implementing `Service`.

---

## 👤 Customer

The `Customer` class stores customer information:

* Name
* Email
* Phone number

The constructor validates the provided information.

Example:

```text
John Smith (john@email.com, 555-0101)
```

---

## 🏨 Hotel Management

The `Hotel` class manages the hotel's rooms using:

```java
HashMap<String, Room>
```

The room number is used as the key.

For example:

```java
rooms.get("102");
```

allows the application to directly retrieve room `102` without looping through all rooms.

The `Hotel` class provides functionality to:

* Add rooms
* Retrieve rooms
* Book rooms
* Add services
* Display booking details
* Display all rooms
* Get available rooms
* Get the hotel name

---

## 🗂️ Project Structure

The project is organized into Java packages:

```text
Hotel Management System/
├── src/
│   ├── Main.java
│   │
│   └── com/
│       └── hotel/
│           ├── management/
│           │   └── Hotel.java
│           │
│           ├── models/
│           │   ├── Room.java
│           │   ├── StandardRoom.java
│           │   ├── DeluxeRoom.java
│           │   ├── SuiteRoom.java
│           │   └── Customer.java
│           │
│           └── services/
│               ├── Service.java
│               ├── SpaService.java
│               ├── DiningService.java
│               └── GymService.java
│

└── .gitignore
```

---

## 🔧 Main Components

| Component       | Responsibility                |
| --------------- | ----------------------------- |
| `Room`          | Abstract base class for rooms |
| `StandardRoom`  | Standard room implementation  |
| `DeluxeRoom`    | Deluxe room implementation    |
| `SuiteRoom`     | Suite room implementation     |
| `Customer`      | Stores customer information   |
| `Service`       | Defines the service contract  |
| `SpaService`    | Spa service implementation    |
| `DiningService` | Dining service implementation |
| `GymService`    | Gym service implementation    |
| `Hotel`         | Manages rooms and bookings    |
| `Main`          | Runs the application          |

---

## 💰 Cost Calculation

Each room has a base rate.

Additional services increase the total booking cost.

The total cost is calculated as:

```text
Total Cost = Base Rate + Service Costs
```

For example:

```text
Deluxe Room
Base Rate       = $300.0
Dining Service  = $50.0
Gym Service     = $30.0
--------------------------------
Total Cost      = $380.0
```

---

## 🔍 HashMap Usage

The hotel stores rooms using:

```java
HashMap<String, Room>
```

The room number is the key.

Example:

```java
Room room = rooms.get("102");
```

This provides direct lookup by room number instead of searching through every room.

Conceptually:

```text
"102"
  ↓
HashMap
  ↓
DeluxeRoom
```

---

## 🔄 Polymorphism

The project uses polymorphism in both the room and service hierarchies.

A `Room` reference can point to different room types:

```java
Room room = new DeluxeRoom("102", 300.0);
```

And a `Service` reference can point to different services:

```java
Service service = new DiningService();
```

The appropriate overridden implementation is used at runtime.

---

## 🧩 Composition

A `Room` contains a collection of services:

```java
ArrayList<Service> services;
```

This represents a **has-a relationship**:

```text
Room
 └── has many Services
```

The room manages the services associated with its booking.

---

## 🛡️ Validation

The project uses `if`/`else` validation instead of exceptions.

Examples of handled validation cases include:

```text
Invalid base rate: must be positive
Invalid room number: cannot be empty
Cannot add service: room is not booked
Room is already booked
Invalid name: cannot be empty
Invalid email: must contain @
Invalid phone number: cannot be empty
Room [number] already exists
Room [number] not found
Room [number] is not available
```

The application prints the validation message and returns without using:

```java
try
catch
throw
```

---

## 📋 Example Scenario

The application creates a hotel:

```text
Grand Plaza Hotel
```

Then adds four rooms:

```text
Standard Room - Room 101 ($200.0)
Deluxe Room - Room 102 ($300.0)
Suite Room - Room 103 ($500.0)
Standard Room - Room 104 ($200.0)
```

Three customers are created and three rooms are booked with additional services.

Example:

```text
Booking for Deluxe Room - Room 102
Customer: Jane Doe (jane@email.com, 555-0102)
Services:
  - Dining Service: $50.0
  - Gym Service: $30.0
Total Cost: $380.0
```

The application also attempts to book an occupied room and displays:

```text
Room 101 is not available
```

Finally, it displays the remaining available room:

```text
Standard Room - Room 104 ($200.0)
```

---

## ▶️ Running the Project

### Using IntelliJ IDEA

Open the project in IntelliJ IDEA and run:

```text
src/Main.java
```

The application uses hardcoded data, so no user input is required.

### Using the Terminal

From the project directory, the source files can be compiled and executed using Java.

For example:

```bash
javac -d out src/Main.java src/com/hotel/models/*.java src/com/hotel/services/*.java src/com/hotel/management/*.java
```

Then:

```bash
java -cp out Main
```

---

## 🛠️ Technologies

* Java
* IntelliJ IDEA
* Git
* GitHub

---

## 🎯 Learning Progression

This project is part of the Java learning progression after Java Fundamentals.

```text
Java Fundamentals
        ↓
Classes & Objects
        ↓
Encapsulation
        ↓
Inheritance
        ↓
Polymorphism
        ↓
Abstract Classes
        ↓
Interfaces
        ↓
Composition
        ↓
Collections
        ↓
HashMap
        ↓
OOP Capstone
```

It brings together the main OOP concepts before moving into more advanced Java topics such as design patterns, architecture, Maven, and logging.

---

## 🚀 Future Improvements

The original project includes optional extensions such as:

* Cancel a booking / check-out
* Seasonal pricing using a `PricingStrategy`
* Revenue reports
* Additional hotel services

These extensions are intentionally kept outside the core implementation.

---

## 👩‍💻 Author

**Mariam Saeed**

QA / Software Testing Engineer
