import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception Classes
class CHECK_NAME extends Exception {
    public CHECK_NAME(String message) {
        super(message);
    }
}

class CHECK_JOURNAL_ID extends Exception {
    public CHECK_JOURNAL_ID(String message) {
        super(message);
    }
}

class ISSUE_NUMBER extends Exception {
    public ISSUE_NUMBER(String message) {
        super(message);
    }
}

class CHECK_ISSN extends Exception {
    public CHECK_ISSN(String message) {
        super(message);
    }
}

// Journal Class
class Journal {
    private final String name;
    private final String journalID;
    private final String issueNumber;
    private final String issn;

    public Journal(String name, String journalID, String issueNumber, String issn) throws CHECK_NAME, CHECK_JOURNAL_ID, ISSUE_NUMBER, CHECK_ISSN {
        validateName(name);
        validateJournalID(journalID);
        validateIssueNumber(issueNumber);
        validateISSN(issn);

        this.name = name;
        this.journalID = journalID;
        this.issueNumber = issueNumber;
        this.issn = issn;
    }

    private void validateName(String name) throws CHECK_NAME {
        if (name.length() > 30) {
            throw new CHECK_NAME("Journal name exceeds 30 characters.");
        }
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                throw new CHECK_NAME("Journal name contains invalid characters.");
            }
        }
    }

    private void validateJournalID(String journalID) throws CHECK_JOURNAL_ID {
        for (char c : journalID.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                throw new CHECK_JOURNAL_ID("Journal ID contains invalid characters.");
            }
        }
    }

    private void validateIssueNumber(String issueNumber) throws ISSUE_NUMBER {
        if (issueNumber.length() > 20) {
            throw new ISSUE_NUMBER("Issue number exceeds 20 characters.");
        }
    }

    private void validateISSN(String issn) throws CHECK_ISSN {
        if (issn.length() != 9 || issn.charAt(4) != '-') {
            throw new CHECK_ISSN("ISSN format is invalid. It must be 9 characters long, including a hyphen.");
        }
        for (int i = 0; i < issn.length(); i++) {
            if (i == 4) continue; // Skip the hyphen
            if (!Character.isDigit(issn.charAt(i))) {
                throw new CHECK_ISSN("ISSN contains invalid characters.");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-25s %-10s", name, journalID, issueNumber, issn);
    }
}

// Main Class
public class JournalRegistration {
    public static void main(String[] args) {
        List<Journal> validJournals = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n==== Journal Registration System ====");
            System.out.println("Enter the number of journals to register:");
            int numJournals = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            for (int i = 0; i < numJournals; i++) {
                System.out.println("\nEnter details for Journal " + (i + 1) + ":");
                
                System.out.print("Name: ");
                String name = scanner.nextLine();
                
                System.out.print("Journal ID: ");
                String journalID = scanner.nextLine();
                
                System.out.print("Issue Number: ");
                String issueNumber = scanner.nextLine();
                
                System.out.print("ISSN: ");
                String issn = scanner.nextLine();
                
                try {
                    Journal journal = new Journal(name, journalID, issueNumber, issn);
                    validJournals.add(journal);
                } catch (CHECK_ISSN | CHECK_JOURNAL_ID | CHECK_NAME | ISSUE_NUMBER e) {
                    System.out.println("Error adding journal: " + e.getMessage());
                }
            }
            
            // Print valid journals
            System.out.println("\n==== Valid Journals ====");
            System.out.printf("%-20s %-15s %-25s %-10s\n", "Name", "Journal ID", "Issue Number", "ISSN");
            System.out.println("----------------------------------------------------------------------");
            for (Journal journal : validJournals) {
                System.out.println(journal);
            }
        }
    }
}
