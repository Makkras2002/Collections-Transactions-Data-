package TransactionsBase;
import java.lang.String;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("The program has launched...");
        System.out.println("\n");
        Scanner in =new Scanner(System.in);
        int choice;
        DatabaseOfTransactions newBase = new DatabaseOfTransactions();
        while(true){
            System.out.println("_____________________MENU______________________");
            System.out.println("1.Add element into the base.");
            System.out.println("2.Show what the base contains.");
            System.out.println("3.Show transactions in a specific time period.");
            System.out.println("4.Exit.");
            System.out.println("\n");
            System.out.println("Make a decision: ");
            choice = in.nextByte();
            switch (choice){
                case 1:{
                    if(newBase.addElemToBase()){}
                    else{
                        System.out.println("Transaction wasn't added to the base.");
                    }
                    break;
                }
                case 2:{
                    newBase.showInfoInTheBase();
                    break;
                }
                case 3:{
                    newBase.showTransactionsInPeriod();
                    break;
                }
                case 4:{
                    return;
                }
                default:{
                    System.out.println("Such command doesn't exist.");
                    break;
                }
            }
        }
    }
}
