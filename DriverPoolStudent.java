import java.util.Scanner;
/**
 * This program is used to unit test the Pool class.
 * The format of the dollar amount is not important.
 * You should not be concerned that there are no 
 * dollar signs or there are more than two decimal
 * places.
 * 
 * @author 
 * @version Spring 2019
 */
public class DriverPoolStudent
{
    public static void main(String args[])
    {
        //1.  Create a Pool object.
        Pool p = new Pool();

        //2.  Test bounds of the range for pool days
        //2A. day - lower bound test 
        p.addEntry(1,3,"entry",1.0);
        //2B. day - mid-range test
        p.addEntry(4,3,"entry",4.0);
        //2C. day - upper bound test
        p.addEntry(7,3,"entry",3.0);
        //3.  Test the bounds of the range for pool hours
        //3A. hour - lower bound test
        p.addEntry(1,1,"entry",3.0);
        //3B. hour - mid-range test
        p.addEntry(1,12,"entry",31.0);
        //3C. hour - upper bound test
        p.addEntry(1,23,"entry",32.0);
        System.out.println("The pool after 6 enteries have been added");
        System.out.println("\n" + p);
        //4A.  Test pool total; total is based on the pool entries above
        System.out.println("Expected total: 74.0");
        System.out.println("Actual total: " + p.poolTotal());
        //4B.  Test pool total with a new pool and no entries.
        Pool p2 = new Pool();
        p2.poolTotal();
        //5A.  Test getWinner - winner exists
        System.out.println("Expected that winner exists");
        System.out.println("Actual result: " + p.getWinner(1,3));
        //5B.  Test getWinner - no winner
        System.out.println("Expected that winner does not exist");
        System.out.println("Actual result: " + p.getWinner(25, 100));

        //6.   print the complete matrix
        System.out.println("\n" + p);

        /*
         * 7. 
         * Use the Pool object, p, you created above.  If there are entries 
         * still available (there should be lots!), ask the user to pick a day 
         * and time.  Keep asking until they have picked one that is not 
         * already used (is null).  Then, add the user to the pool.  You 
         * will need their name and the amount they would like to enter.
         * You only need to enter one user in the pool.
         */
         Scanner scnr = new Scanner(System.in);
        
        int day;
        int hour;
        String name;
        double amount;
        boolean check;
        
        do {
            System.out.println("Enter your day");
            day = scnr.nextInt();
            System.out.println("Enter your hour");
            hour = scnr.nextInt();
            System.out.println("Enter your name");
            name = scnr.next();
            System.out.println("Enter your amount");
            amount = scnr.nextDouble();
            
            check = p.addEntry(day,hour,name,amount);
            if(!check){
             System.out.println("Enter Valid input");  
            }
        }
        while(!check);
        
        System.out.println("\n" + p);
    }
}
