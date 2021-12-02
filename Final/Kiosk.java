
import java.util.*;
public class Kiosk 
{
    private Catalogue catalogue;
    private List<Customer> customers;

    // instance variables - replace the example below with your own
        /**
           * Constructor for objects of class Kiosk
     */
    public Kiosk()
    {
        this.customers = new ArrayList<Customer>();
        customers.add(new Customer(101, "Jaime", 10));
        customers.add(new Customer(102, "Luke", 10));
        customers.add(new Customer(103, "William", 1));
        
    }
    public static void main(String[] args){
        Kiosk kiosk = new Kiosk();
        Catalogue catalogue = new Catalogue(kiosk);
        kiosk.setCatalogue(catalogue); 
             
        kiosk.use();
    }
    public void setCatalogue(Catalogue catalogue){
        this.catalogue = catalogue;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void use()
    {
        char choice;
        while ((choice = useChoice()) !='X'){
            switch (choice) {
                case '1': exploreCatalogue(); break;
                case '2': viewRecords(); break;
                case '3': showfavMovies(); break;
                case '4': topupAccou(); break;
                case '5': adminMode(); break;
                default: helpusePage(); break;
                
            }
        }
    }
    
    private void exploreCatalogue()
    {
        char choice;
        while ((choice = useCatalogue()) !='R'){
            switch (choice) {
                case '1': displayMovies(); break;
                case '2': displayavaMovies(); break;
                case '3': displayGenre(); break;
                case '4': displaymovieGenre(); break;
                case '5': displaymoviebyYear(); break;
                case '6': rentMovie(); break;
                case '7': returnMovie(); break;
                default: helpcataloguePage(); break;
            }
        }
    }
    private void viewRecords()
    {   
        int Id = readId();        
        if (checkcustomerID(Id)){
          Customer savedCustomer = getCustomerId(Id);
          System.out.println("ID: " + savedCustomer.getId());
          System.out.println("Name: " + savedCustomer.getName());
          System.out.println("Balance: $" + savedCustomer.getBalance());
          System.out.println("Movies currently rented by " + savedCustomer.getName() + ":");
          savedCustomer.listrentedMovie();
          System.out.println(savedCustomer.getName() + "'s renting history:");
          savedCustomer.listrentedHistory();
          System.out.println("");
        }        
         else
          
          System.out.println("That customer does not exist.\n");       
        }
    
    
    private void showfavMovies()
    {
        System.out.println("");
        System.out.print("Enter a customer ID: ");
        int Id = In.nextInt();
        System.out.println("Jaime's favourite movies are:");
        System.out.println("1999    Matrix  SciFi   $3");
        System.out.println("1997    Titanic Drama   $4");        
        System.out.println("1991    Terminator 2    SciFi   $3");
        System.out.println("");
    }
    private void topupAccou()
    {
        System.out.println("");
        System.out.print("Enter a customer ID: ");
        int Id = In.nextInt();
        System.out.print("Enter the top-up amount:");
        int amount = In.nextInt();
        System.out.println("");
        if (checkcustomerID(Id)){
            System.out.println("Transaction complete.");
            Customer savedCustomer = getCustomerId(Id);
            System.out.println(savedCustomer.getName() + "'s  balance was: $"+ savedCustomer.getBalance());            
            savedCustomer.changedBalance(amount);
            System.out.println(savedCustomer.getName() + "'s current balance is: $"+ savedCustomer.getBalance());
            System.out.println(""); 
        } else {
            System.out.println("That customer does not exist.\n");
        }
    }
    private void adminMode()
    {
       char choice;
        while ((choice = useAdmin()) !='R'){
            switch (choice) {
                case '1': listallCustomer(); break;
                case '2': addCustomer(); break;
                case '3': removeCustomer(); break;
                case '4': listallMovie(); break;
                case '5': addMovie(); break;
                case '6': removeMovie(); break;
                default: helpadminPage(); break; 
            }
       }
    }
    private void helpusePage()
    {
        System.out.println("Please enter a number between 1 and 5, or press X to exit.");
    }
    private void displayMovies()
    {
        catalogue.avaMovies(); 
        catalogue.rentedMovies(); 
    }
    private void displayavaMovies()
    {
        catalogue.avaMovies(); 
    }
    private void displayGenre()
    {
        catalogue.listGenre(); 
    }
    private void displaymovieGenre()
    {
        catalogue.listmovieGenre(); 
    }
    private void displaymoviebyYear()
    {
        catalogue.listmovieYear(); 
    }
    private void rentMovie()
    { 
        catalogue.rentMovie();
    }        
    private void returnMovie()
    {
        catalogue.returnMovie();
    }
    private void helpcataloguePage()
    {
        System.out.println("Please enter a number between 1 and 7 or press R to return to the previous menu.");
    }
    private void listallCustomer()
    {
        System.out.println("");
        System.out.println("The Kiosk has the following customers: ");
        for (Customer customer : customers)
            System.out.println(customer);  
        System.out.println("");
    }    
    public void addCustomer(){
        System.out.println("");
        System.out.println("Adding a new customer.");
        System.out.print("Enter a new ID: ");
        int id = In.nextInt();   
        System.out.print("Enter the customer's name: ");
        String name = In.nextLine();
        System.out.print("Enter the customer's initial balance: ");
        int balance = In.nextInt();        
        if (checkCustomer(id, name,balance)){            
            System.out.print("The customer is already in the kiosk.");
            System.out.println("");                     
        }    else  {   
            System.out.println("Customer added.");
            customers.add(new Customer(id, name, balance));
            System.out.println("");   
        }
    }
    private boolean checkCustomer(int id, String name, int balance){
        for (Customer customer : customers)
            if (id==(customer.getId())&&name.equals(customer.getName())&&balance==(customer.getBalance()))
                return true;        
        return false;
    }
    public boolean checkcustomerID(int id){
        for (Customer customer : customers)
            if (id==(customer.getId()))
                return true;        
        return false;
    }   
    
    public int getBalance(int id){
        for (Customer customer : customers)
            if (id==(customer.getId()))
            return customer.getBalance();
        return 1;
    }
    private Customer getCustomer(int id, String name, int balance){
        for (Customer customer : customers)
            if (id==(customer.getId())&&name.equals(customer.getName())&&balance==(customer.getBalance()))
                return customer;
        return null;
    }
    public Customer getCustomerId(int id){
        for (Customer customer : customers)
            if (id==(customer.getId()))
                return customer;
        return null;
    }
    
    private void removeCustomer()
    {
        System.out.println("");
        System.out.println("Removing a customer.");
        System.out.print("Enter a customer ID: ");
        int id = In.nextInt();
        if (checkcustomerID(id)){            
            System.out.println("Customer removed.");
            Customer dr = getCustomerId(id);
            customers.remove(dr);
            System.out.println("");                       
        }    else  {   
            System.out.println("That customer does not exist.");
            System.out.println("");    
        }
    }
    private void listallMovie()
    {
        System.out.println("");
        System.out.println("The Kiosk has the following movies: ");        
        catalogue.listMovie();
        System.out.println("");
    }    
    private void addMovie()
    {
        catalogue.addMovie();
    }
    private void removeMovie()
    {
        catalogue.removeMovie();        
    }   
    
    private void helpadminPage()
    {
        System.out.println("Please enter a number between 1 and 6 or press R to return to the previous menu.");
    }
    private int readId(){
        System.out.println("");
        System.out.print("Enter a customer ID: ");
        return In.nextInt();
    }     
    public char useChoice()
    {
        System.out.println("Welcome to the Movie Kiosk! Please make a selection from the menu:");
        System.out.println("1. Explore the catalogue.");
        System.out.println("2. View your customer record.");
        System.out.println("3. Show you favourite movies.");
        System.out.println("4. Top up account.");
        System.out.println("5. Enter Admin Mode.");
        System.out.println("X. Exit the system.");
        System.out.print("Enter a choice: ");
        return In.nextChar() ;
    }
    public char useCatalogue()
    {
       System.out.println("Welcome to the Catalogue! Please make a selection from the menu:");
        System.out.println("1. Display all movies.");
        System.out.println("2. Display all available movies.");
        System.out.println("3. Display all genres. ");
        System.out.println("4. Display movies in a genre.");
        System.out.println("5. Display all movies by year.");
        System.out.println("6. Rent a movie.");
        System.out.println("7. Return a movie.");
        System.out.println("R. Return to previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar() ; 
    }
    public char useAdmin()
    {
       System.out.println("Welcome to the administration menu:");
        System.out.println("1. List all customers.");
        System.out.println("2. Add a customer.");
        System.out.println("3. Remove a customer.");
        System.out.println("4. List all movies.");
        System.out.println("5. Add a movie to the catalogue.");
        System.out.println("6. Remove a movie from the catalogue.");
        System.out.println("R. Return to the previous menu.");
        System.out.print("Enter a choice: ");
        return In.nextChar() ; 
    }    
}
