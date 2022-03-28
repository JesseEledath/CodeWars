import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Packer {
    public Packer(){

    }

    public void Pack(JSONArray transactions){
//        double averageExpense = 0.0;
//        double beforeBalance = 0.0;
//        JSONArray transactionArray = new JSONArray();
//        int transactionCounter = transactions.length();
//
//
//        for (int i = 0; i < transactionCounter; i++)
//        {
//            JSONObject transaction = new JSONObject();
//            beforeBalance = currentBalance;
//            transaction.put("beforeBalance", beforeBalance);
//            currentBalance = currentBalance - Double.parseDouble((expenseAmount.get(i)));
//            currentBalance = Math.round(currentBalance * 100.00) / 100.00;
//            transaction.put("sequenceNumber", Integer.parseInt(transactionsNum.get(i)));
//            transaction.put("expense", expenseName.get(i));
//            transaction.put("expenseAmount", Double.parseDouble(expenseAmount.get(i)));
//            transaction.put("afterBalance", currentBalance);
//            transactionArray.put(transaction);
//
//            totalExpense = totalExpense + Double.parseDouble(expenseAmount.get(i));
//            totalExpense = Math.round(totalExpense * 100.00) / 100.00;
//        }
//
//        averageExpense = totalExpense / transactionCounter;
//
//        completedCheckBook.put("transactions", transactionArray);
//        completedCheckBook.put("closingBalance", currentBalance);
//        completedCheckBook.put("totalExpenses", totalExpense);
//        completedCheckBook.put("averageExpense", averageExpense);
//
//        System.out.println(completedCheckBook);
//        return completedCheckBook;
    }

    public List<Transaction> getOrderOfTransaction(List<Transaction> transactions)
    {
        Collections.sort(transactions);

        return  transactions;
    }
}
