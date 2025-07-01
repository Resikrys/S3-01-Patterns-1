# S3.01 - Patterns 1
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

### 🎯 Learning Objectives

Identify and build programs using design patterns. The use of patterns is
fundamental in building extensible and reusable software. The Java language, as
well as all software frameworks, are built according to the most important
software patterns.

## 📄 LVL 1: Singleton

Create a class that replicates the operation of the 'Undo' command. This class will be used by the Main class, which will allow you to enter options via console.

- The 'Undo' class must store the last commands entered. It must allow you to add or remove commands, as well as list the last commands entered (similar to the 'history' command in Linux).
- The 'Undo' class must implement a Singleton pattern.

## 📄 LVL 2: Abstract Factory
Create a small manager of international addresses and phone numbers.

- The application should allow adding international addresses and phone numbers 
to the address book. Taking into account the different formats of different 
countries, build the address book, addresses and phones by implementing an 
Abstract Factory pattern.

## 📄 LVL 3: Command
Design a parking lot for 4 vehicles: a car, a bicycle, a plane, and a boat.

- Show how the Command pattern works, implementing the start, accelerate, and 
brake methods for each type of vehicle.


## 💻 Technologies Used

| Package        | Version | Description                |
|----------------|--------|----------------------------|
| `java`         | ^1.8.0_441 | Principal project language |
| `Apache maven` | ^4.0.0 | Project management tool    |
| `java.util`    | ^1.8.0_441 | Java standard library      |


### REQUIREMENTS
Local environment: `IntelliJ or Eclipse`

###  INTELLIJ EXECUTION
To Run code, press `Ctrl F5` or click the `play` icon in the gutter.

### 🛠️ SCRIPTS

```bash
mvn compile          # Compile project
mvn package          # Package in .jar
```

## ▶️ How to Run Scripts

To Run code, press `Ctrl F5` or click the `play` icon in the gutter.

## 📚 Additional Resources

- [Refactoring guru](https://refactoring.guru/es/design-patterns)
- [Java Design Patterns](https://www.tutorialspoint.com/design_pattern/index.htm)