
import java.util.*;
public class Customer
{
    private int ID;
    private String name;
    private int balance;
    private List<Movie> currentlyRented;
    private List<Movie> rentingHistory;

    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Customer
     */
    public Customer(int ID, String name, int balance)
    {
        this.ID = ID;
        this.name = name;
        this.balance = balance;
        this.currentlyRented = new ArrayList<Movie>();
        this.rentingHistory = new ArrayList<Movie>();
        
    }
    
    public int getId(){
        return this.ID;
    }  
    public String getName(){
        return this.name;
    }  
    public int getBalance(){
        return this.balance;
    }
    public void changedBalance(int amount){
        balance = balance + amount;
    }
    public void saveRented(Movie savedMovie){
        currentlyRented.add(savedMovie);
        rentingHistory.add(savedMovie);
        balance -= savedMovie.getPrice();
    }
    public void listrentedMovie(){
        for (Movie movie : currentlyRented)
            System.out.println(movie);
    }
    public void listrentedHistory(){
        for (Movie movie : rentingHistory)
            System.out.println(movie);
    }
    public void removeRented(Movie savedMovie){
        currentlyRented.remove(savedMovie);              
    }
    
    
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void Records(int y)
    {
        // put your code here
        
    }
    @Override
    public String toString() { 
        return ID +"\t"+ name +"\t"+"$ "+ balance; 
    }
}
