

import java.util.*;

class app {
 
                static app obj = new app();
                static Vector<Car> cr = new Vector<Car>();
                static Vector<Customer> cus = new Vector<Customer>();
                
                
        public static void main(String[] args){
                char ch; 
                Scanner sc1= new Scanner(System.in);
                do
                {

                System.out.print("\n\nMAIN MENU"); 
                System.out.print("\n01. RENT A CAR"); 
                System.out.print("\n02. DROP OFF CAR"); 
                System.out.print("\n03. ADMINISTRATOR MENU"); 
                System.out.print("\n04. EXIT"); 
                System.out.print("\nPlease Select Your Option (1-4)"); 
                ch = sc1.next().charAt(0);
                switch(ch)
                {
                        case '1':
                                obj.car_issue();
                                break;
                        case '2':
                                obj.car_deposit();
                                break;
                        case '3':
                                admin_menu();
                                break;
                        case '4': 
                }
                }while(ch!='4');
        }

        public static void admin_menu(){
                // app obj = new app();

                int ch;
                String c;
                Scanner sc2= new Scanner(System.in);    
                System.out.print("\n01.CREATE CUSTOMER RECORD"); 
                System.out.print("\n02.DISPLAY ALL CUSTOMER RECORD"); 
                System.out.print("\n03.DISPLAY SPECIFIC CUSTOMER RECORD"); 
                System.out.print("\n04.MODIFY CUSTOMER RECORD"); 
                System.out.print("\n05.DELETE CUSTOMER RECORD"); 
                System.out.print("\n06.CREATE CAR"); 
                System.out.print("\n07.DISPLAY ALL CARS"); 
                System.out.print("\n08.DISPLAY SPECIFIC CAR"); 
                System.out.print("\n09.MODIFY CAR"); 
                System.out.print("\n10.DELETE CAR"); 
                System.out.print("\n11.BACK TO MAIN MENU");
                System.out.print("\nPlease Enter Your Choice (1-11)");

                ch = sc2.nextInt();
                c = sc2.nextLine();

                switch(ch)
                {
                        case 1:
                                obj.write_cus(); break;
                        case 2:
                                obj.display_allcus();break;
                        case 3:
                                {
                                String num;
                                System.out.print("\n\nPlease Enter The Customer No. ");
                                num = sc2.nextLine();
                                obj.display_spcus(num);
                                break;
                                }
                        case 4:
                                {
                                String num;
                                System.out.print("\n\nMODIFY CUSTOMER REOCORD ");
                                System.out.print("\n\nEnter The registration number of the customer: ");
                                num= sc2.nextLine();
                                obj.modify_cus(num);
                                break;
                                }
                        case 5:
                                {
                                String num;
                                System.out.print("\n\nDELETE CUSTOMER REOCORD ");
                                System.out.print("\n\nEnter The registration number of the Customer: ");
                                num= sc2.nextLine();
                                obj.delete_cus(num);
                                break;
                                }   
                        case 6:
                                obj.write_car();break;
                        case 7:
                                obj.display_allc();break;
                        case 8:
                                {
                                String num;
                                System.out.print("\n\nPlease Enter The Car No. ");
                                num = sc2.nextLine();
                                obj.display_spc(num);
                                break;
                                }
                        case 9: 
                                {
                                String num;
                                System.out.print("\n\nMODIFY CAR REOCORD ");
                                System.out.print("\n\nEnter The registration number of the car: ");
                                num= sc2.nextLine();
                                obj.modify_car(num);
                                break;
                                }
                        case 10:
                                {
                                String num;
                                System.out.print("\n\nDELETE CAR REOCORD ");
                                System.out.print("\n\nEnter The registration number of the car: ");
                                num= sc2.nextLine();
                                obj.delete_car(num);
                                break;
                                }
                               
                        case 11: return; 
                        default: System.out.println("a");
                }
                admin_menu();

        }
// --------------------Car Fuctions-------------------//
 
        public void write_car()
        { 
                Scanner sc3= new Scanner(System.in);    
                char ch;
                String n;
                System.out.print("\nNEW CAR ENTRY\n");
                do
                {   
                        int flag=0;
                        String c = sc3.nextLine();
                        System.out.print("\nEnter the car registration number: ");
                        n = sc3.nextLine();
                        for(Car str : cr)
                        {
                                String x = str.retcno();
                                boolean areEqual = x.equals(n);
                                if(areEqual)
                                {
                                        System.out.print("\nNumber already exists, record not created");
                                        flag=1;
                                        break;
                                }
                        }
                        if (flag==0)
                        {
                                Car ca = new Car();
                                ca.create_car(n);
                                cr.add(ca);
                                System.out.print("\n\n\nCar record created");
                        }  
                        System.out.print("\n\nDo you want to add more record (y/n?): ");
                        ch = sc3.next().charAt(0);           
                }while(ch=='y'||ch=='Y');
        }




        void display_allc()
        {
                System.out.print("\n\n\t\t\t\t\t\tCAR LIST\n\n");
                System.out.print("===========================================================================================================\n");
                System.out.print("Car Registration Number\t\tCar Name\t\t\tModel Number\t\t\tBase rate\t\t\tRate Per Hour\n");
                System.out.print("===========================================================================================================\n");

                for (Car str : cr) {           
                        str.report();  
                }  
        }

        void display_spc(String n)
        {
                System.out.print("\nCAR LIST\n");
                int flag=0;
                for(Car str : cr)
                {
                        String x = str.retcno();
                        boolean areEqual = x.equals(n);
                        if(areEqual)
                        {
                                str.show_car();
                                flag=1;
                        }
                }
                if(flag==0){
                        System.out.print("\n\n Car does not exist");
                }
        }

        void modify_car(String n)
        {
                int found=0;
                for(Car str : cr)
                {
                        String x = str.retcno();
                        boolean areEqual = x.equals(n);
                        if(areEqual)
                        {
                                found=1;
                                if(str.rettoken()==0)
                                {
                                        str.show_car();
                                        System.out.print("\n Enter The New Details of The car: \n");
                                        str.modify_car();
                                        System.out.print("\n\n\t Record Updated");
                                }
                                else
                                System.out.print("\n Car has been rented by a customer, record cannot be modified until car is returned");
                        }
                }
                if(found==0){
                        System.out.print("\n\n Record Not Found ");
                }
        }

        void delete_car(String n)
        {
                int flag=0;
                for(Car str : cr)
                {
                        String x = str.retcno();
                        boolean areEqual = x.equals(n);
                        if(areEqual)
                        {
                                flag=1;
                                cr.remove(str);
                                System.out.print("\n\n\t Record Updated");
                                break;
                        }
                }
                if(flag==0){
                        System.out.print("\n\n Car does not exist");
                }
        }

// --------------------Customer Fuctions-------------------//

        public void write_cus()
        { 
                Scanner sc3= new Scanner(System.in);    
                char ch;
                String n;
                System.out.print("\nNEW CUSTOMER ENTRY\n");
                do
                {   
                        int flag=0;
                        String c = sc3.nextLine();
                        System.out.print("\n Enter the customer registration number: ");
                        n = sc3.nextLine();
                        for(Customer str : cus)
                        {
                                String x = str.retcusno();
                                boolean areEqual = x.equals(n);
                                if(areEqual)
                                {
                                        System.out.print("\n Number already exists, record not created");
                                        flag=1;
                                        break;
                                }
                        }
                        if (flag==0)
                        {
                                Customer cu = new Customer();
                                cu.create_customer(n);
                                cus.add(cu);
                                System.out.print("\n\n\n Customer record created");
                        }  
                        System.out.print("\n\n Do you want to add more record (y/n?): ");
                        ch = sc3.next().charAt(0);           
                }while(ch=='y'||ch=='Y');
        }




        void display_allcus()
        {
                System.out.print("\n\n\t\t\t\t\t\tCUSTOMER LIST\n\n");
                System.out.print("===========================================================================================================\n");
                System.out.print("Customer Number\t\t\tCustomer Name\n");
                System.out.print("===========================================================================================================\n");

                for (Customer str : cus) {           
                        str.report();  
                }  
        }

        void display_spcus(String n)
        {
                System.out.print("\nCUSTOMER LIST\n");
                int flag=0;
                for(Customer str : cus)
                {
                        String x = str.retcusno();
                        boolean areEqual = x.equals(n);
                        if(areEqual)
                        {
                                str.show_customer();
                                flag=1;
                        }
                }
                if(flag==0){
                        System.out.print("\n\n Customer does not exist");
                }
        }

        void modify_cus(String n)
        {
                int found=0;
                for(Customer str : cus)
                {
                        String x = str.retcusno();
                        boolean areEqual = x.equals(n);
                        if(areEqual)
                        {
                                found=1;
                                if(str.rettoken()==0)
                                {
                                        str.show_customer();
                                        System.out.print("\n Enter The New Details of The car: \n");
                                        str.modify_customer();
                                        System.out.print("\n\n\t Record Updated");
                                }
                                else
                                System.out.print("\n Car has been rented by a customer, record cannot be modified until car is returned");
                        }
                }
                if(found==0){
                        System.out.print("\n\n Record Not Found ");
                }
        }

        void delete_cus(String n)
        {
                int flag=0;
                for(Customer str : cus)
                {
                        String x = str.retcusno();
                        boolean areEqual = x.equals(n);
                        if(areEqual)
                        {
                                flag=1;
                                cus.remove(str);
                                System.out.print("\n\n\t Record Updated");
                                break;
                        }
                }
                if(flag==0){
                        System.out.print("\n\n Customer does not exist");
                }

        }

// --------------------Main Fuctions-------------------//
        
        void car_issue()
        {
                Scanner sc6= new Scanner(System.in);
        	int fcus=0, fcr=0, h=0;
        	String cn , crn;
        	System.out.print("\n\n\t\t\t\t\t       RENT A CAR\n\n");
        	System.out.print("\n\n Choose from the list below:");
        	display_allc();
        	System.out.print("\n\n Enter customer number: ");
        	cn = sc6.nextLine();
                for(Customer str:cus)
                {
                        String x = str.retcusno();
                        boolean areEqual = x.equals(cn);
                        if(areEqual)
                        {
                                fcus=1;
                                if(str.rettoken()==0)
                                {
                                        System.out.print("\n\n Enter the registration number of the car you want to rent: ");
                                        crn = sc6.nextLine();

                                        for(Car str1:cr)
                                        {
                                                String x1 = str1.retcno();
                                                boolean areEqual1 = x1.equals(crn);
                                                if(areEqual1)
                                                {
                                                        fcr=1;
                                                        if (str1.rettoken()==0)
                                                        {
                                                                str1.show_car();
                                                                System.out.print("\n Enter number of hours you want to rent the car for: ");
                                                                h =sc6.nextInt();
                                                                str1.gethr(h);
                                                                str1.addtoken();
                                                                str.addtoken();
                                                                str1.getcuscno(str.retcusno()); // car obj me customer ka no.
                                                                str.getcuscno(str1.retcno()); // cus object me cus car no. 
                                                                System.out.print("\n\n Transaction issued successfully ");
                                                                System.out.print("\n Deposit of 5000 has been taken and will adjusted in the total cost when car is deposited ");
                                                                System.out.print("\n The cost of rent is calculated as such: Base Rate + ( Number of hours car rented for * Rate per hour) + Late Fees ");
                                                                System.out.print("\n The late fee is calculated as such: Extra hours driven * 1000");
                                                        }
                                                        else{
                                                                System.out.print("\n\n Car already rented, Please try a different Car ");
                                                        }
                                                }
                                                else if(fcr==0){
                                                        System.out.print("\n\n Car not found!");
                                                }
                                        }
                                }
                                else{
                                        System.out.print("\n\n Customer can rent only one car at once ");
                                }
                        }
                        else if(fcus==0){
                                System.out.print("\n\n Customer not found");
                        }
                }
        }

        void car_deposit()
        {
                Scanner sc6= new Scanner(System.in);
                int fcus=0,fcr=0,hours=0,fine=0, rent=0,com=0;
                String cn;
                System.out.print("\n\n CAR DEPOSIT ");
                System.out.print("\n\n Enter your customer number: ");
                cn = sc6.nextLine();
                for(Customer str : cus)
                {
                        String x = str.retcusno();
                        boolean areEqual = x.equals(cn);
                        if(areEqual)
                        {
                                fcus=1;
                                if(str.rettoken()==1)
                                {
                                        for(Car str1 : cr)
                                        {
                                                String x1 = str.retcuscno(); 
                                                boolean areEqual1 = x1.equals(str1.retcno());
                                                if(areEqual1)
                                                {
                                                        fcr=1;
                                                        str1.show_car();
                                                        System.out.print("\n\n Car deposited in no. of hours?");
                                                        hours= sc6.nextInt();
                                                        if(hours<str1.rethr())
                                                        {
                                                                rent= str1.retbaserate() + (hours*str1.retratephr());
                                                        }
                                                        else
                                                        {
                                                                fine= (hours-str1.rethr())*1000;
                                                                rent= str1.retbaserate() + (hours*str1.retratephr()) + fine;
                                                        }
                                                        System.out.print("\n The cost of rent is calculated as such: Base Rate + ( Number of hours car rented for * Rate per hour) + Late Fees ");
                                                        System.out.print("\n The late fee is calculated as such: Extra hours driven * 1000");
                                                        System.out.print("\n\n The total cost of the rent is : " + rent);
                                                        str1.resettoken();
                                                        str.resettoken();
                                                        System.out.print("\n\n Car deposited successfully");
                                                }        
                                        }
                                }
                        }  
                }              
        }

}

class Car
{
        Scanner sc4= new Scanner(System.in);
        
        String cno ; // car no.
        String cname ;
        String mno ;
        int baserate;
	int ratephr;
        String cuscno ; // customer no. 
        int hr;
        int token; // 0 1

	public void create_car(String n)
	{
		cno = n;
                String c = sc4.nextLine();
		System.out.print("\nEnter the name of the car: ");
		cname = sc4.nextLine();
		System.out.print("\nEnter the model number: ");
		mno = sc4.nextLine();
		System.out.print("\nEnter the base rate of this car: ");
                baserate = sc4.nextInt();
		System.out.print("\nEnter the rate per hour: ");
		ratephr = sc4.nextInt();
		token=0;
		cuscno="";
		hr=0; 
	}

	public void show_car()
	{
		System.out.print("\nCar registration number : " + cno);
		System.out.print("\nCar Name : " + cname);
		System.out.print("\nModel Number : " + mno);
		System.out.print("\nBase rate: " + baserate);
		System.out.print("\nRate per hour: " + ratephr);
		if(token==1)
                System.out.print("\nCar is rented by customer number : " + cuscno);
	}

	public void modify_car()
	{
		System.out.print("\nCar registration number : " + cno);
                String c = sc4.nextLine();
		System.out.print("\nModify car name : ");
                cname = sc4.nextLine();
		System.out.print("\nModify model number of the car : ");
                mno = sc4.nextLine();
		System.out.print("\nModify base rate :");
                baserate = sc4.nextInt();
		System.out.print("\nModify rate per hour :");
                ratephr = sc4.nextInt();
	}

	public String retcno()
	{
                return cno;
	}

	public int rethr()
	{
		return hr;
	}

	public int retratephr()
	{
		return ratephr;
	}

	public int retbaserate()
	{
		return baserate;
	}

	public int rettoken()
	{
		return token;
	}

	public String retcuscno()
	{
		return cuscno;
	}

	public void addtoken()
	{
	    token=1;
        }

	public void resettoken()
	{
	    token=0;
        }

        public void getcuscno(String t)
	{
		cuscno = t;
	}

	public void gethr(int t)
	{
		hr=t;
	}

	void report()
	{
                System.out.print("\n"+cno + "\t\t\t" + cname + "\t\t\t" + mno + "\t\t\t" + baserate+ "\t\t\t" +ratephr+ "\t\t\t" +token);
        }
}

class Customer
{
        Scanner sc5= new Scanner(System.in);

	String cusno;
	String name;
	String cuscno; //cus car no. 
	int token;

	public void create_customer(String n)
	{
		cusno=n;
		System.out.print("\n\nEnter The Name of The Customer : ");
                name = sc5.nextLine();
		token=0;
		cuscno="";
	}

	public void show_customer()
	{
		System.out.print("\n Customer Number : " + cusno);
		System.out.print("\n Customer Name : " + name);
		
		if(token==1)
                        System.out.print("\n Car rented by customer : " + cuscno);
	}

	public void modify_customer()
	{
                System.out.print("\n Customer Number : " + cusno);
		System.out.print("\nModify Customer Name : ");
                name = sc5.nextLine();
	}

	public String retcusno()
	{
		return cusno;
	}

	public String retcuscno()
	{
		return cuscno;
	}

	public int rettoken()
	{
		return token;
	}

	public void addtoken()
	{
	    token=1;
        }

	public void resettoken()
	{
	    token=0;
        }

	public void getcuscno(String t) // car car no. set
	{ 
		cuscno = t;
	}

        void report()
	{
                System.out.print("\n"+cusno + "\t\t\t\t" + name + "\t\t\t\t" + token);
        }

}