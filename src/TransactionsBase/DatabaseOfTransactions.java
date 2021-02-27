package TransactionsBase;
import java.util.*;

public class DatabaseOfTransactions {
    private Set<Transaction> base = new TreeSet<>();
    public boolean addElemToBase(){
        Transaction newTrans = new Transaction();
        if(newTrans.setTransInfo()){
            base.add(newTrans);
            return true;
        }
        else {
            System.out.println("You've written invalid data.");
            return false;
        }
    }
    public void showInfoInTheBase(){
        System.out.println("ID        "+"Name       "+"Surname    "+"Date of start    "+"Date of finish");
        System.out.println("___________________________________________________________________________");
        for(Transaction transaction : base){
            transaction.showInfoAboutTransaction();
        }
    }
    public void showTransactionsInPeriod(){
        Transaction period =new Transaction();
        System.out.println("Start of the period: ");
        period.setDateOfStart();
        System.out.println("End of the period: ");
        period.setDateOfFinish();
        System.out.println("ID        "+"Name       "+"Surname    "+"Date of start    "+"Date of finish");
        System.out.println("___________________________________________________________________________");
        for(Transaction transaction:base){
            if(transaction.getDateOfStart().after(period.getDateOfStart()) && transaction.getDateOfFinish().before(period.getDateOfFinish())){
                transaction.showInfoAboutTransaction();
            }
        }

    }
}
