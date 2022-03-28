import org.json.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public final static String SEQUENCE_NUMBER = "sequenceNumber";
    public final static String EXPENSE_NAME = "expense";
    public final static String EXPENSE_AMOUNT = "expenseAmount";
    String checkbook = "125 Market 125.45\n126 Hardware 34.95\n127 Video 7.45\n128 Book 14.32\n129 Gasoline 16.10"; // Original checkbook string
    double currentBalance = 1000.00; // Holds current balance
    double totalExpense = 0.0; // Holds total expenses
    final ArrayList<String> transactionsNum = new ArrayList<>(); // ArrayList to hold transaction #
    final ArrayList<String> expenseName = new ArrayList<>(); // ArrayList to hold transaction name
    final ArrayList<String> expenseAmount = new ArrayList<>(); // ArrayList to hold transaction cost
    int transactionCounter = 0; // Counter for # of transactions
    JSONObject completedCheckBook; //JSONObject to hold entire solution

    // Constructor
    public Main() {
        Setup(checkbook, currentBalance); // Call Setup() method
        Disassemble(); // Call Disassemble method
        Packer(); // Call Packer method
        SendToJSONFile(); // Call SendToJSONFile() method
    }

    // Main method to call the constructor
    public static void main(String[] args) {
        Main main = new Main();
        Packer packer = new Packer();
        Disassembler disassembler = new Disassembler();
        JSONArray transactions = disassembler.Disassemble(main.checkbook);
        //JSONObject completedCheckBook = packer.Pack(transactions);
    }

    // Setup method
    public void Setup(String checkbook, double currentBalance) {
        this.checkbook = checkbook;
        this.currentBalance = currentBalance;

        completedCheckBook = new JSONObject();
        completedCheckBook.put("originalBalance", currentBalance);
    }

    // Disassemble method to sort and store items
    public void Disassemble() {
        String[] transactionsArray = checkbook.split("\n");

        for (String ele : transactionsArray) {
            List<String> transactionString = Arrays.asList(ele.split((" ")));
            this.transactionsNum.add(transactionString.get(0));
            this.expenseName.add(transactionString.get(1));
            this.expenseAmount.add(transactionString.get(2));
            this.transactionCounter += 1;
        }
    }

    // Packer method for JSON objects/arrays + perform calculations
    public JSONObject Packer() {
        double averageExpense = 0.0;
        double beforeBalance = 0.0;
        JSONArray transactionArray = new JSONArray();

        for (int i = 0; i < transactionCounter; i++) {
            JSONObject transaction = new JSONObject();
            beforeBalance = currentBalance;
            transaction.put("beforeBalance", beforeBalance);
            currentBalance = currentBalance - Double.parseDouble((expenseAmount.get(i)));
            currentBalance = Math.round(currentBalance * 100.00) / 100.00;
            transaction.put("sequenceNumber", Integer.parseInt(transactionsNum.get(i)));
            transaction.put("expense", expenseName.get(i));
            transaction.put("expenseAmount", Double.parseDouble(expenseAmount.get(i)));
            transaction.put("afterBalance", currentBalance);
            transactionArray.put(transaction);

            totalExpense = totalExpense + Double.parseDouble(expenseAmount.get(i));
            totalExpense = Math.round(totalExpense * 100.00) / 100.00;
        }

        averageExpense = totalExpense / transactionCounter;

        completedCheckBook.put("transactions", transactionArray);
        completedCheckBook.put("closingBalance", currentBalance);
        completedCheckBook.put("totalExpenses", totalExpense);
        completedCheckBook.put("averageExpense", averageExpense);

        System.out.println(completedCheckBook);
        return completedCheckBook;
    }

    // SendToJSONFile to send solution to seperate file in JSON
    public void SendToJSONFile() {
        try {
            FileWriter file = new FileWriter("C:\\Users\\JesseEledath\\IdeaProjects\\CodingProblems\\src\\main\\book.json");
            file.write(completedCheckBook.toString(4));
            file.close();
            System.out.println("Sent to JSON file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not send to JSON file.");
        }
    }
}