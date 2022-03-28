import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SortingTests {
    Packer packer;
    List<Transaction> transactions;

    @BeforeEach
    public void init()
    {
        packer = new Packer();

        transactions = new ArrayList<>();
        Transaction transactionOne = new Transaction(125,"Market",125.45);
        transactions.add(transactionOne);
        Transaction transactionTwo = new Transaction( 126, "Hardware", 34.95);
        transactions.add(transactionTwo);
        Transaction transactionThree = new Transaction(127,"Video",7.45);
        transactions.add(transactionThree);
        Transaction transactionFour = new Transaction(128,"Book",14.32);
        transactions.add(transactionFour);
        Transaction transactionFive = new Transaction(129,"Gasoline",16.10);
        transactions.add(transactionFive);
    }

    @Test
    public void test_sorting() {
        transactions = packer.getOrderOfTransaction(transactions);
        boolean bool = true;
        for(int i = 0; i < transactions.size() - 1; i++) {
            if(!(transactions.get(i).sequenceNumber < transactions.get(i+1).sequenceNumber)) {
                bool = false;
            }
        }
        Assertions.assertTrue(bool);
    }

    @Test
    public void test_nameSorting1()
    {
        transactions = packer.getOrderOfTransaction(transactions);
        Assertions.assertEquals("Market",transactions.get(0).expenseName);
    }

    @Test
    public void test_nameSorting2()
    {
        transactions = packer.getOrderOfTransaction(transactions);
        Assertions.assertEquals("Hardware", transactions.get(1).expenseName);
    }

    @Test
    public void test_nameSorting3()
    {
        transactions = packer.getOrderOfTransaction(transactions);
        Assertions.assertEquals("Video", transactions.get(2).expenseName);
    }
}
