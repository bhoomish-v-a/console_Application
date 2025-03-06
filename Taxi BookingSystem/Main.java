import java.util.*;
class TaxiDetails{
    int id;
    String name;
    boolean currentStatus;
    String currentLocation;
    //double arrvingTime;
    //String arrivingLocation;
                
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
        System.out.println("Enter car name");
        String a=s.nextLine();
        System.out.println("Current Loaction of the taxi");
        String b=s.nextLine();
        TaxiDetails td=new TaxiDetails(taxi.size()+1,a,b);
        //System.out.println(td.name);
        taxi.add(td);
        //System.out.println(taxi.size());
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
    private void getTravelDetails() {
        System.out.println("Enter Dispatch location:");
        this.dispachLocation = s.next(); 
        System.out.println("Enter Dispatch time:");
        while (!s.hasNextDouble()) { 
            System.out.println("Invalid input! Please enter a valid number for dispatch time:");
            s.next(); 
        }
        this.dispachTime = s.nextDouble();
        s.nextLine(); 
    
        System.out.println("Enter Destination Location:");
        this.distinationLocation = s.nextLine(); // Read destination location
    }
    void bookTaxi(){
        for(TaxiDetails x:taxi){
            System.out.println(x.currentLocation+"   "+this.dispachLocation);
            if(x.currentLocation==this.dispachLocation&&x.currentStatus==false){
                System.out.println("Your Booking is confirmed-----------");
                System.out.println("Your booking is confirm with"+x.name);
                x.currentLocation=this.dispachLocation;
                return;
            }
        }
        System.out.println("Your booking is cancelled due to available of car in your dispach location");
    }
    void checkTaxi(){
        System.out.println("Checking taxi details");
        System.out.println(taxi);
        for(TaxiDetails x:taxi){
            System.out.println(x.name+"  :  "+x.currentLocation);
        }
        return;
    }
}
class Main{
    public static void main(String[] args) {
            loop();
    }
    public static void loop(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter \n1.customer login\n2. taxi owner login\n3. Close application");
        int x=s.nextInt();
        if(x==3)
        return;
        System.out.print("Enter the User name:");
        String uname=s.next();
        System.out.print("Enter the Password:");
        String password=s.next(); 
        TaxiBooking tb=new TaxiBooking(uname); 
        if(x==1){
                  
            while(tb.getAction()){}
        }
        else{
            
            boolean x1=true;
            while(x1){
                System.out.println("1. Add taxi\n2. View taxi\n3. Exit");

                switch(s.nextInt()){
                    case 1:
                    tb.addDetails();
                    break;
                    case 2:
                    tb.checkTaxi();
                    break;
                    case 3:
                    x1=false;
                    System.out.println("Thank you for your visit");
                    break;
                }
            }
        }
        loop();
    }
}
