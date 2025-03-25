import java.util.Scanner;

public class MoneyConverter{
    public static void main(String[] args)
    {
        runProgram();
    }
    public static void runProgram()
    {
        System.out.println("USD to Euro Converter");
        Scanner k = new Scanner ( System.in );
        String keep_going = "yes";
        while(keep_going.equalsIgnoreCase("yes"))
        {
            displayMenu();
            System.out.println();
            System.out.print("Do you want to run the program again? Enter yes or no: ");
            keep_going = k.next();
            System.out.println();
        }
    System.out.println("Program has terminated!");
    
    }
    public static void displayMenu()
    {
        System.out.println();
        System.out.println("Menu");
        System.out.println();
        // give your programs better names
        System.out.println("1) Dollars to Euros: ");
        System.out.println("2) Euros To Dollars: ");
        System.out.println("3) Exit: ");
        System.out.println();
        System.out.print ( "Selection: " );
        Scanner k = new Scanner ( System.in );
        // change the cases below to better reflect the programs you are running
        switch ( k.nextInt() )
        {
            case 1:
                dollarsToEuros(k);
                displayMenu();
                break;
            case 2:
                eurosToDollars(k);
                displayMenu();
                break;
            case 3:
                System.out.println("");
                System.out.println ( "Exiting the program" );
                break;
            default:
                System.out.println("");
                System.out.println ( "Unrecognized option..Try again" );
                System.out.println("");
                displayMenu();
                //break;
        }
        
    }
    
    public static void dollarsToEuros(Scanner k) {
        double dollars, eurosPerDollar, grossEuros, rate, ratePercent, netDollars;
                    
        System.out.print("How many dollars do you want to convert? ");        
        dollars = k.nextDouble();        
        
        eurosPerDollar = 0.93; 
               
        if (dollars >= 1500) {
            rate = 3;
        } else {
            rate = 4.5;
        }
        
        ratePercent = rate / 100;
        netDollars = dollars - (dollars * ratePercent);
        //dollars to euros
        grossEuros = netDollars * eurosPerDollar;
         
        System.out.println(dollars + " Dollars => " + grossEuros + " Gross Euros");

	    System.out.println("Thank you for using the Dollars to Euros Converter\n");	
        System.out.println(dollars + " \tDollars\n" + 
                eurosPerDollar + " \tEuros Per Dollar Exchange Rate\n" +
                rate + " \tFee Percentage %\n" + 
                netDollars + "\tNet Dollars"); 
        System.out.printf("%.2f", grossEuros);
        System.out.print("\tGross Euros\n");
    }
    public static void eurosToDollars(Scanner k){
        double euros, dollarsPerEuro, grossDollars, rate, ratePercent, netEuros;
                    
        System.out.print("How many euros do you want to convert? ");        
        euros = k.nextDouble();        
        
        dollarsPerEuro = 1.08; 
               
        if (euros >= 1500) {
            rate = 3;
        } else {
            rate = 4.5;
        }
        
        ratePercent = rate / 100;
        netEuros = euros - (euros * ratePercent);
        //dollars to euros
        grossDollars = netEuros * dollarsPerEuro;
         
        System.out.println(euros + " Euros => " + grossDollars + " Gross Dollars");

	    System.out.println("Thank you for using the Euros to Dollars Converter\n");	
        System.out.println(euros + " \tEuros\n" + 
                dollarsPerEuro + " \tDollars Per Euro Exchange Rate\n" +
                rate + " \tFee Percentage %\n" + 
                netEuros + "\tNet Euros"); 
        System.out.printf("%.2f", grossDollars);
        System.out.print("\tGross Dollars\n");
    }
}