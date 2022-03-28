public class Transaction implements Comparable {
    Integer sequenceNumber;
    String expenseName;
    double expenseAmount;

    public Transaction(Integer sequenceNumber, String expenseName, double expenseAmount) {
        this.sequenceNumber = sequenceNumber;
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
    }

    @Override
    public int compareTo(Object otherTransaction) {
        return this.sequenceNumber.compareTo(((Transaction)otherTransaction).sequenceNumber);
    }
}
