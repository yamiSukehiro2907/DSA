# Object-Oriented Programming (OOP) in Java

A comprehensive guide and code repository demonstrating the fundamental concepts of Object-Oriented Programming in Java through practical examples and detailed implementations.

## 📚 Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Core Concepts](#core-concepts)
  - [Introduction to OOP](#introduction-to-oop)
  - [Encapsulation](#encapsulation)
  - [Inheritance](#inheritance)
  - [Polymorphism](#polymorphism)
  - [Abstraction](#abstraction)
- [Additional Concepts](#additional-concepts)
  - [Packages](#packages)
  - [Access Control](#access-control)
- [Key Features Demonstrated](#key-features-demonstrated)
- [Getting Started](#getting-started)
- [Code Examples](#code-examples)
- [Learning Path](#learning-path)
- [Contributing](#contributing)

## 🎯 Overview

This repository serves as a practical learning resource for understanding Object-Oriented Programming principles in Java. Each concept is implemented with clear, well-documented code examples that demonstrate real-world applications and best practices.

## 📁 Project Structure

```
OOPS/
├── Introduction/          # Basic OOP concepts, classes, and objects
├── Encapsulation/        # Data hiding and getter/setter patterns
├── Inheritance/          # Parent-child relationships and code reuse
├── Polymorphism/         # Method overloading and overriding
├── Abstraction/          # Abstract classes and interfaces
├── Packages/             # Code organization and static concepts
└── Access Control/       # Access modifiers and package visibility
```

## 🔑 Core Concepts

### Introduction to OOP

**What you'll learn:**
- Classes as blueprints for objects
- Object creation and the `new` keyword
- Constructor overloading
- The `this` keyword
- Memory management (Heap vs Stack)
- Wrapper classes
- The `final` keyword
- Garbage collection

**Key Files:**
- `Introduction/src/Student.java` - Demonstrates class structure, constructors, and object properties
- `Introduction/src/Memory.java` - Explains memory allocation for objects

**Core Concepts Covered:**
```java
// Object has three properties:
// 1. State - Current attributes/characteristics
// 2. Behaviour - Actions that can be performed
// 3. Identity - Memory address distinguishing objects
```

### Encapsulation

**Definition:** Wrapping data (attributes) and methods in a single unit while restricting direct access to internal details.

**What you'll learn:**
- Private attributes and public methods
- Getter and setter patterns
- Data hiding principles
- Controlled access to object state

**Key Files:**
- `Encapsulation/src/Counters/Counter.java` - Demonstrates encapsulation with a counter class

**Example:**
```java
public class Counter {
    private int count;  // Hidden from direct access
    
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
}
```

### Inheritance

**Definition:** Mechanism allowing a new class to inherit properties and methods from an existing class.

**What you'll learn:**
- Parent-child class relationships
- The `super` keyword
- Multi-level inheritance
- Constructor chaining
- Types of inheritance (Single, Multi-level, Hierarchical)
- Why multiple inheritance isn't supported in Java

**Key Files:**
- `Inheritance/src/Parent/Parent.java`
- `Inheritance/src/Child/Child.java`
- `Inheritance/src/GrandChild/GrandChild.java`

**Important Notes:**
- Child classes can access non-private parent members
- `super()` must be called first in child constructor
- Reference type determines accessible members

### Polymorphism

**Definition:** The ability to represent objects in multiple forms.

**What you'll learn:**
- **Compile-time Polymorphism:** Method overloading (same name, different parameters)
- **Runtime Polymorphism:** Method overriding and dynamic method dispatch
- Upcasting and late binding
- The `@Override` annotation
- Final methods and classes

**Key Files:**
- `Polymorphism/src/Shapes/` - Shape hierarchy demonstrating polymorphism

**Example:**
```java
Shape shape = new Circle();  // Upcasting
shape.area();  // Calls Circle's area() at runtime (Dynamic Method Dispatch)
```

### Abstraction

**Definition:** Hiding unnecessary implementation details while showing only essential features.

**What you'll learn:**
- Abstract classes and methods
- Interfaces and their properties
- Multiple interface implementation
- Default and static methods in interfaces
- Interface inheritance
- Nested interfaces
- Annotations

**Key Files:**
- `Abstraction/src/package1/Event.java` - Abstract class example
- `Abstraction/src/Interfaces/Engine.java` - Interface definition
- `Abstraction/src/package2/Car.java` - Interface implementation

**Key Concepts:**
```java
// Abstract classes:
// - Cannot be instantiated
// - Can have abstract and concrete methods
// - Children must implement abstract methods

// Interfaces:
// - All fields are public static final
// - All methods are public abstract (by default)
// - Can have default and static methods
// - Support multiple inheritance
```

## 🔧 Additional Concepts

### Packages

**What you'll learn:**
- Organizing code into packages
- Import statements
- Static members and methods
- Static blocks and initialization
- Singleton pattern
- The `static` keyword with classes

**Key Files:**
- `Packages/src/staticExample/Human.java` - Static members and methods
- `Packages/src/Singleton/Singleton.java` - Singleton design pattern

**Built-in Java Packages:**
1. `java.lang` - Automatically imported
2. `java.io` - Input/Output operations
3. `java.util` - Data structures
4. `java.net` - Networking
5. `java.awt` - GUI components

### Access Control

**What you'll learn:**
- Four types of access modifiers
- Visibility rules across packages and classes
- `public`, `protected`, `default`, and `private` modifiers
- Object equality with `equals()` and `hashCode()`
- The `instanceof` operator

**Key Files:**
- `Access Control/src/Package1/CounterPackage1.java`
- `Access Control/src/Package2/CounterPackage2.java`

**Access Modifier Rules:**

| Modifier | Same Class | Same Package | Subclass (Same Package) | Subclass (Different Package) | Different Package |
|----------|------------|--------------|-------------------------|------------------------------|-------------------|
| `public` | ✅ | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ✅ | ❌ |
| default | ✅ | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ | ❌ |

## ✨ Key Features Demonstrated

### Memory Management
- Heap vs Stack memory allocation
- Object header, instance data, and padding
- Reference storage in stack

### Design Patterns
- Singleton pattern implementation
- Factory pattern (with Engine interfaces)

### Best Practices
- Proper encapsulation with getters/setters
- Constructor chaining
- Method overriding with `@Override`
- Interface segregation
- Proper use of access modifiers

### Object Methods
```java
@Override
public boolean equals(Object other) { ... }

@Override
public int hashCode() { ... }

@Override
public String toString() { ... }
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- An IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Running the Examples

1. Clone the repository:
```bash
git clone https://github.com/yamiSukehiro2907/OOPS.git
cd OOPS
```

2. Navigate to any module:
```bash
cd Introduction
```

3. Compile and run:
```bash
javac src/Main.java
java Main
```

## 📖 Code Examples

### Creating a Class and Object
```java
public class Student {
    public int rollNo;
    public String name;
    
    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}

// Usage
Student student = new Student(21, "Vimal");
```

### Implementing Inheritance
```java
public class Parent {
    public int num;
    public Parent(int num) { this.num = num; }
}

public class Child extends Parent {
    public int num2;
    public Child(int num, int num2) {
        super(num);  // Call parent constructor
        this.num2 = num2;
    }
}
```

### Using Interfaces
```java
public interface Engine {
    void start();
    void stop();
}

public class PowerEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Starting Power Engine");
    }
    
    @Override
    public void stop() {
        System.out.println("Stopping Power Engine");
    }
}
```

## 🎓 Learning Path

**Recommended order for beginners:**

1. **Introduction** - Understand classes, objects, and basic Java concepts
2. **Packages** - Learn code organization and static members
3. **Encapsulation** - Master data hiding and access control
4. **Inheritance** - Understand code reuse and class hierarchies
5. **Polymorphism** - Learn method overloading and overriding
6. **Abstraction** - Master abstract classes and interfaces
7. **Access Control** - Understand visibility and access modifiers

## 💡 Important Notes

### Limitations and Design Decisions

- **No Multiple Inheritance:** Java doesn't support multiple inheritance with classes to avoid ambiguity (Diamond Problem)
- **Final Classes:** Cannot be extended (e.g., `String` class)
- **Final Methods:** Cannot be overridden
- **Static Methods:** Can be inherited but not overridden
- **Abstract Classes:** Cannot have constructors for object creation
- **Private Members:** Not accessible even in subclasses

### Common Pitfalls

1. **Reference vs Object Type:**
```java
Parent p = new Child();
// Can only access Parent's members through 'p'
```

2. **Constructor Chaining:**
```java
// super() or this() must be first statement in constructor
```

3. **Static Context:**
```java
// Cannot use non-static members in static methods
```

## 🤝 Contributing

Contributions are welcome! If you'd like to add more examples or improve existing ones:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/NewConcept`)
3. Commit your changes (`git commit -m 'Add new concept'`)
4. Push to the branch (`git push origin feature/NewConcept`)
5. Open a Pull Request

## 📝 License

This project is open source and available for educational purposes.

## 📧 Contact

For questions or suggestions, please open an issue on GitHub.

---

**Happy Learning! 🎉**

*Master Object-Oriented Programming one concept at a time.*
