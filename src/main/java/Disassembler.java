import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class Disassembler {
    public Disassembler() {
    }

    public JSONArray Disassemble(String checkbook) {
        String[] transactionsArray = checkbook.split("\n");
        JSONArray transactions = new JSONArray();
        for (String ele : transactionsArray) {
            JSONObject transaction = new JSONObject();
            List<String> transactionString = Arrays.asList(ele.split((" ")));
            transaction.put(Main.SEQUENCE_NUMBER, transactionString.get(0));
//            this.transactionsNum.add(transactionString.get(0));
            transaction.put(Main.EXPENSE_NAME, transactionString.get(1));
//            this.expenseName.add(transactionString.get(1));
            transaction.put(Main.EXPENSE_AMOUNT, transactionString.get(2));
//            this.expenseAmount.add(transactionString.get(2));
//            this.transactionCounter += 1;
            transactions.put(transaction);
        }
        return transactions;
    }
}
