package TransactionsBase;
import java.text.SimpleDateFormat;
import java.util.*;

public class Transaction implements Comparable{
    private String id;
    private String nameOfOwner;
    private String surnameOfOwner;
    private Date dateOfStart;
    private Date dateOfFinish;
    public void showInfoAboutTransaction(){
        SimpleDateFormat currentDate= new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(id + "      " + nameOfOwner+ "      " + surnameOfOwner + "        " + currentDate.format(dateOfStart) + "       " + currentDate.format(dateOfFinish));
    }
    public boolean setTransInfo(){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter id of the operation:");
        this.id = in.next();
        System.out.println("Enter name of owner:");
        this.nameOfOwner = in.next();
        System.out.println("Enter surname of owner:");
        this.surnameOfOwner = in.next();
        System.out.println("Start of the transaction: ");
        this.setDateOfStart();
        System.out.println("End of the transaction: ");
        this.setDateOfFinish();
        if(this.dateOfStart.after(this.dateOfFinish)){
            return false;
        }
        else {
            return true;
        }
    }

    public void setDateOfStart() {
        this.dateOfStart = setDate();
    }

    public void setDateOfFinish() {
        this.dateOfFinish = setDate();
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public Date getDateOfFinish() {
        return dateOfFinish;
    }

    public static Date setDate(){
        int year;
        int month;
        int day;
        Scanner in =new Scanner(System.in);
        System.out.println("Enter day of operation: ");
        day = in.nextInt();
        System.out.println("Enter month of operation: ");
        month = in.nextInt() -1;
        System.out.println("Enter year of operation: ");
        year = in.nextInt();
        Calendar cal1 = new GregorianCalendar(year,month,day);
        return cal1.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(nameOfOwner, that.nameOfOwner) && Objects.equals(surnameOfOwner, that.surnameOfOwner) && Objects.equals(dateOfStart, that.dateOfStart) && Objects.equals(dateOfFinish, that.dateOfFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfOwner, surnameOfOwner, dateOfStart, dateOfFinish);
    }

    @Override
    public int compareTo(Object o) {
        Transaction transaction   =(Transaction) o;
        return this.id.compareTo(transaction.id);
    }
}
