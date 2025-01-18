# Journal Registration System

This project implements a **Journal Registration System** in Java. It uses custom exception handling to validate journal details and ensure data integrity. Invalid entries are flagged with specific error messages, while valid entries are displayed in a tabular format.

## Features
- Validates journal details using **custom exceptions**:
  - **CHECK_NAME**: Ensures the name is within 30 characters and contains only alphabets.
  - **CHECK_JOURNAL_ID**: Ensures the journal ID is alphanumeric.
  - **ISSUE_NUMBER**: Ensures the issue number does not exceed 20 characters.
  - **CHECK_ISSN**: Ensures the ISSN is exactly 9 characters long, with a hyphen at the 5th position.
- Collects journal details from the user.
- Displays valid journal details in a formatted table.
- Provides meaningful error messages for invalid inputs.

## How to Run
1. **Compile the Code**:
   ```bash
   javac JournalRegistration.java
   ```
2. **Run the Program**:
   ```bash
   java JournalRegistration
   ```
3. **Enter Input**:
   - Specify the number of journals to register.
   - Provide details for each journal (name, ID, issue number, ISSN).

## Sample Input
```
Enter the number of journals to register:
3

Enter details for Journal 1:
Name: TechTimes
Journal ID: JID123
Issue Number: Issue001
ISSN: 1234-5678

Enter details for Journal 2:
Name: Science&News
Journal ID: SCI789
Issue Number: Issue002
ISSN: 9876-5432

Enter details for Journal 3:
Name: ArtMag
Journal ID: ART202
Issue Number: Issue005
ISSN: 1357-2468
```

## Sample Output
```
Error adding journal: Journal name contains invalid characters.

==== Valid Journals ====
Name                 Journal ID      Issue Number             ISSN      
----------------------------------------------------------------------
TechTimes            JID123          Issue001                 1234-5678
ArtMag               ART202          Issue005                 1357-2468
```

## Files
- **JournalRegistration.java**: The main program file containing the logic for journal validation and registration.

## Key Concepts Used
- **Object-Oriented Programming (OOP)**: Classes and objects.
- **Custom Exception Handling**: Creating and throwing user-defined exceptions.
- **Input Validation**: Ensuring correct data formats.
- **Formatted Output**: Displaying data in a clean, tabular layout.

## Author
- Sarvesh Kumar soni


