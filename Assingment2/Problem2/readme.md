# Passenger Registration System

## Overview
The Passenger Registration System is a Java program that allows users to register passenger details, ensures unique identification for passengers, and enables sorting of passenger data based on various attributes. This program demonstrates the use of `Collections`, `Comparable`, and `Comparator` interfaces in Java to handle and manipulate data efficiently.

---

## Features
1. **Dynamic Passenger Registration**: Allows the user to input the number of passengers to register dynamically.
2. **Data Validation**: Validates user inputs for age and ticket class to ensure data integrity.
3. **Unique Passenger IDs**: Ensures all passenger IDs are unique to avoid duplication.
4. **Sorting Functionality**: Provides a menu for sorting passenger details by:
   - Name
   - Passenger ID
   - Age
   - Ticket Class
   - Destination
5. **Formatted Output**: Displays passenger details in a neat and organized table format.
6. **Error Handling**: Handles invalid inputs gracefully to enhance user experience.

---

## How to Run
1. **Prerequisites**:
   - Java Development Kit (JDK) installed.
   - Any text editor or Integrated Development Environment (IDE) (e.g., IntelliJ IDEA, Eclipse).

2. **Steps to Execute**:
   - Save the code in a file named `PassengerRegistration.java`.
   - Open a terminal or command prompt and navigate to the directory containing the file.
   - Compile the code using:
     ```
     javac PassengerRegistration.java
     ```
   - Run the program using:
     ```
     java PassengerRegistration
     ```
   - Follow the on-screen instructions to register passengers and sort the data.

---

## Input Format
The program will prompt the user for the following inputs:
1. Number of passengers to register.
2. For each passenger:
   - Name
   - Passenger ID (e.g., Aadhar number)
   - Age (must be a positive number)
   - Ticket Class (Economy, Business, or First)
   - Start Place
   - Destination
   - Seat Number

---

## Output Format
- The program displays passenger details in a tabular format with the following columns:
  - Name
  - Passenger ID
  - Age
  - Ticket Class
  - Start Place
  - Destination
  - Seat Number
- Sorted data is displayed in a similar tabular format based on the user’s choice of attribute.

---

## Example
### Input:
```
Enter the number of passengers to register: 2

Passenger 1
Name: Alice
Passenger ID (Aadhar): 123456789012
Age: 30
Ticket Class (Economy/Business/First): Economy
Start Place: New York
Destination: Los Angeles
Seat Number: 12A

Passenger 2
Name: Bob
Passenger ID (Aadhar): 987654321098
Age: 25
Ticket Class (Business): Business
Start Place: Chicago
Destination: Miami
Seat Number: 8B

Sort by:
1. Name
2. Passenger ID
3. Age
4. Ticket Class
5. Destination
Choose an option (1-5): 1
```

### Output:
```
Passenger Details:
Name                 Passenger ID   Age   Class      Start Place      Destination     Seat No.  
Alice                123456789012  30    Economy    New York         Los Angeles     12A       
Bob                  987654321098  25    Business   Chicago          Miami           8B        

Sorted Passenger Details:
Name                 Passenger ID   Age   Class      Start Place      Destination     Seat No.  
Alice                123456789012  30    Economy    New York         Los Angeles     12A       
Bob                  987654321098  25    Business   Chicago          Miami           8B        
```

---

## Key Concepts Demonstrated
1. **Collections Framework**: Usage of `ArrayList`, `HashSet`, and sorting mechanisms.
2. **Comparable and Comparator**: Implementation of sorting using both interfaces.
3. **Object-Oriented Programming (OOP)**: Modular design with a `Passenger` class encapsulating data and behaviors.
4. **Input Validation**: Ensures robust and error-free input handling.

---

## Customization
To add more features or enhance functionality, consider the following:
- Add additional attributes like email or phone number.
- Implement advanced sorting (e.g., multi-level sorting).
- Provide an option to save passenger data to a file or database.

---

## Acknowledgments
This program is a demonstration of Java's core features and is designed for educational purposes. Feel free to modify and enhance it as needed!

