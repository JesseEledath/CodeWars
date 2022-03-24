import org.json.*;
import org.json.JSONString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String output = "125 Market 125.45\n126 Hardware 34.95\n127 Video 7.45\n128 Book 14.32\n129 Gasoline 16.10";
        System.out.println(EasyBal(output, 1000.00));
    }

    public static JSONObject EasyBal(String checkbook, double originalBalance) {
        double currentBalance = originalBalance;
        double totalExpense = 0.0;
        double averageExpense = 0.0;
        double closingBalance = 0.0;
        int transactionCounter = 0;
        List<String> transactionString;
        ArrayList<String> transactionsNum = new ArrayList<>();
        ArrayList<String> expenseName = new ArrayList<>();
        ArrayList<String> expenseAmount = new ArrayList<>();

        JSONObject completedCheckBook = new JSONObject();
        completedCheckBook.put("originalBalance", originalBalance);

        String[] transactionsArray = checkbook.split("\n");

        for (String ele : transactionsArray) {
            transactionString = Arrays.asList(ele.split((" ")));
            transactionsNum.add(transactionString.get(0));
            expenseName.add(transactionString.get(1));
            expenseAmount.add(transactionString.get(2));
            transactionCounter += 1;
        }

        JSONArray transactionArray = new JSONArray();

        for (int i = 0; i < transactionCounter; i++) {
            JSONObject transaction = new JSONObject();
            double beforeBalance = currentBalance;
            transaction.put("beforeBalance", beforeBalance);
            currentBalance = currentBalance - Double.parseDouble((expenseAmount.get(i)));
            transaction.put("sequenceNumber", Integer.parseInt(transactionsNum.get(i)));
            transaction.put("expense", expenseName.get(i));
            transaction.put("expenseAmount", Double.parseDouble(expenseAmount.get(i)));
            transaction.put("afterBalance", currentBalance);
            transactionArray.put(transaction);

            totalExpense = totalExpense + Double.parseDouble(expenseAmount.get(i));
        }

        averageExpense = totalExpense / transactionCounter;

        completedCheckBook.put("transactions", transactionArray);
        completedCheckBook.put("closingBalance", currentBalance);
        completedCheckBook.put("totalExpenses", totalExpense);
        completedCheckBook.put("averageExpense", averageExpense);

        try {
            FileWriter file = new FileWriter("C:\\Users\\JesseEledath\\IdeaProjects\\CodingProblems\\src\\main\\book.json");
            file.write(completedCheckBook.toString(4));
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return completedCheckBook;
    }
}


//        {
////      "sequenceNumber": <int>,
////      "expense": <text>,
////      "expenseAmount": <double>,
////      "balanceAfter": <double>,
////      "balanceBefore": <double>
////    },

//let transactions = { sequenceNumber:125, expense: "market", expenseAmount: 125.45}
// double originalBalance = 1000.00
// put checkbook into a string (without starting balance)
// split the checkbook [sequenceNumber: 125; expense: "Market"; expenseAmount: 125.45;]
// do math to calculate the balance before (double balance = originalBalance) and balance after (balance - expenseAmount)
// counter to track number of transactions
// double averageExpense = totalExpenses / counter; do calc at the end to divide averageExpense by # of transactions.
// double totalExpenses =+ expense
// double closingBalance = originalBalance; closingBalance =- expense;

//end goal v
//{
//  "originalBalance": <original balance as a double>,
//  "transactions":[
//    {
////      "sequenceNumber": <int>,
////      "expense": <text>,
////      "expenseAmount": <double>,
////      "balanceAfter": <double>,
////      "balanceBefore": <double>
////    },
//    {
//      "sequenceNumber": <int>,
//      "expense": <text>,
//      "expenseAmount": <double>,
//      "balanceAfter": <double>,
//      "balanceBefore": <double>
//    }
//  ],
//  "closingBalance": <double>,
//  "totalExpenses": <double>,
//  "averageExpense": <double>
//}