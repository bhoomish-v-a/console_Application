import java.util.*;
class TaxiDetails{
    int id;
    String name;
    boolean currentStatus;
    String currentLocation;
    double arrvingTime;
    String arrivingLocation;
                
    TaxiDetails(int id,String name,String loc){
        this.currentLocation=loc;
        this.id=id;
        this.name=name;
        this.currentStatus=false;
    }
}
class TaxiAllocation{
    List<TaxiDetails> taxi = new ArrayList<>();
  
    Scanner s=new Scanner(System.in);
    void addDetails(){
        System.out.println("Enter car name\n Current Loaction of the taxi\n");
        TaxiDetails td=new TaxiDetails(taxi.size()+1,s.nextLine(),s.nextLine());
        taxi.add(td);
    }
}
class TaxiBooking extends TaxiAllocation{
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
    void bookTaxi(){
        
    }
    void checkTaxi(){
        
    }


}


class Main{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter 1 for customer login\n 2 for taxi owner login");
        int x=s.nextInt();
        System.out.print("Enter the User name:");
        String uname=s.next();
        System.out.print("Enter the Password:");
        String password=s.next(); 
        TaxiBooking tb=new TaxiBooking(uname); 
        if(x==1){
                  
            while(tb.getAction()){}
        }
        else{
            TaxiAllocation ta=new TaxiAllocation();
            ta.addDetails();
            while(tb.getAction()){}
        }
       
    }
}
