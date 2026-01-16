# Simple Java Application

This is a basic Java Maven project with a GUI for managing a list of products. You can view, add, and remove products.

## Dependencies

- JUnit 4.13.2 (for testing)
- Apache Commons Lang 3.12.0

## Files

- pom.xml: Maven configuration
- src/main/java/com/example/App.java: Main application with Swing GUI for product management
- src/main/java/com/example/Product.java: Product model class
- src/test/java/com/example/AppTest.java: Unit test

## How to Compile and Run

1. Ensure Maven is installed.
2. Run `mvn clean compile` to compile.
3. Run `mvn exec:java -Dexec.mainClass="com.example.App"` to run the GUI.

Or use an IDE like VS Code with Java extensions. The GUI allows adding new products via dialogs and removing selected ones.