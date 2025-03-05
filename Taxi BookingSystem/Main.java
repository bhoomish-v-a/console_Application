
import java.util.*;

class TaxiBooking{
    private String uname;
    private String dispachLocation;
    private String distinationLocation;
    private double dispachTime;
    
    Scanner s=new Scanner(System.in);
    TaxiBooking(String uname){
        this.uname=uname;
        System.out.println("Hello "+uname+"! Welcome to RedTaxi..");
    }
    boolean getAction(){
        System.out.println("1. Would you like to book taxi \n2. Enqurie for taxi\n3. Exit");
        int a=s.nextInt();
        switch(a){
            case 1:
            getTravelDetails();
            bookTaxi();
            break;
            case 2:
            getTravelDetails();
            checkTaxi();
            break;
            case 3:
            return false;
            default:
            System.out.println("Invalid input!");
            getAction();
        }
        return true;
    }
    private void getTravelDetails(){
        System.out.println("Enter Dispach loaction\nDistination Location\nDispach time");
        this.dispachLocation=s.nextLine();
        this.distinationLocation=s.nextLine();
        this.dispachTime=s.nextDouble();
    }
    void bookTaxi(){}
    void checkTaxi(){}


}


class Main{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the User name:");
        String uname=s.nextLine();
        System.out.print("Enter the Password:");
        String password=s.nextLine(); 
        TaxiBooking tb=new TaxiBooking(uname);       
        while(tb.getAction()){}
    }
}