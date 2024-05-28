# Room Management System Project
### Intention of the project
To learn and prep about various concepts in core Java, OOPS concepts, SOLID principles and Design patterns(Singleton, Builder, Factory).

### Project Statement
The Room Management System project is designed to handle hotel room operations, including checking room availability, displaying amenities, booking rooms, and checking out rooms. It incorporates various object-oriented principles and design patterns to ensure a flexible and maintainable codebase.

**Key Functionalities**:
1. **Check Room Availability**: Determine available rooms based on the number of people and a specific date.
2. **Display Room Amenities**: Show amenities for a specific room before booking.
3. **Book a Room**: Reserve a room for a specific date.
4. **Check Out Room**: Mark a room as checked out for a specific date.
5. **Add Rooms**: Reception can add new rooms with specific configurations.

**Design Patterns and Principles**:
- **Singleton Pattern**: Ensures only one instance of the `Reception` class exists.
- **Builder Pattern**: Facilitates the creation of complex `Room` objects with various amenities and configurations.
- **Factory Pattern**: Creates different types of `Room` objects (`StandardRoom`, `DeluxeRoom`, `SuiteRoom`) based on input.
- **DAO Pattern**: Manages booking data through file operations, abstracting data access logic into the `BookingDAO` class.

**OOPS Concepts**:
- **Abstract Class**: Abstract classes provide a way to define a common base class that cannot be instantiated on its own but can provide common functionality for derived classes. here `Room` is an abstract class that defines the common properties and methods for different room types. 
- **Inheritance**: Inheritance allows a class to inherit properties and methods from another class, promoting code reuse. Here `StandardRoom`, `DeluxeRoom`, and `SuiteRoom` inherit from the `Room` abstract class.
- **Polymorphism**: Polymorphism enables a single interface to represent different underlying forms (data types). It allows methods to be used interchangeably on objects of different types that share a common base class or interface. Here Allows the `Reception` class to handle different room types through a common `Room` interface.
- **Interfaces**: Interfaces define a contract that implementing classes must fulfill, promoting a separation of concerns and enabling polymorphism. Here `IReception` interface defines the contract for the Reception class.
- 
**SOLID Principles**:
- **Single Responsibility Principle**: Each class has a single responsibility. For instance, BookingDAO is solely responsible for handling file operations related to bookings.
- **Open/Closed Principle**: The system is open for extension but closed for modification. New room types can be added by extending the Room class without modifying existing code.
- **Liskov Substitution Principle**: Instances of subclasses (`StandardRoom`, `DeluxeRoom`, `SuiteRoom`) can be used interchangeably with instances of the superclass (`Room`).
- **Interface Segregation Principle**: Interfaces are kept small and specific. IReception provides a specific contract for reception-related operations.
- **Dependency Inversion Principle**:High-level modules (`Reception`) do not depend on low-level modules (`BookingDAO`), but rather on abstractions (interfaces).

**File Operations**:
- Bookings are stored in a CSV file, and the system checks this file for availability before booking. The `BookingDAO` class handles reading and writing to the CSV file, ensuring data persistence.
