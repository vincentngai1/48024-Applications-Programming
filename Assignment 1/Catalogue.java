import java.util.*;
public class Catalogue
{
    private Kiosk kiosk;
    private List<Movie> moviesAvailable;
    private List<Movie> moviesRented;
    private List<Genre> genres;
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Catalogue1
     */
    public Catalogue(Kiosk kiosk){  
        this.genres = new ArrayList<Genre>();
        genres.add(new Genre("SciFi"));
        genres.add(new Genre("Drama"));
        genres.add(new Genre("Crime"));
        this.moviesAvailable = new ArrayList<Movie>();
        moviesAvailable.add(new Movie("Matrix", 1999, genreType("SciFi"), 3));        
        moviesAvailable.add(new Movie("Jurassic Park", 1993, genreType("SciFi"), 4));
        moviesAvailable.add(new Movie("Terminator 2", 1991, genreType("SciFi"), 3));
        moviesAvailable.add(new Movie("Titanic", 1997, genreType("Drama"), 4));
        moviesAvailable.add(new Movie("The Silence of the Lambs", 1991, genreType("Crime"), 3));       
        this.moviesRented = new ArrayList<Movie>();
        
        this.kiosk = kiosk;
    }
    private Genre genreType(String genreName){
        for (Genre genre : genres)
            if (genreName.equals(genre.genreName()))
                return genre;
        return null;
    }
    public void removeMovie()
    {
        System.out.println("");
        System.out.println("Removing a movie.");
        System.out.print("Enter the title of the movie: ");
        String title = In.nextLine();   
        System.out.print("Enter the year: ");
        int year = In.nextInt();        
        if (checkMovieTitleYear(title, year)){            
            Movie dr = getMovie(title,year);
            System.out.println(dr + " removed from catalogue.");
            moviesAvailable.remove(dr);
        }    else     
            System.out.println("No such movie found.");
            System.out.println("");
    }    
    private boolean checkMovieTitleYear(String title, int year){
        for (Movie movie: moviesAvailable)
            if (title.equals(movie.getTitle())&&year==(movie.getYear()))
            return true;        
        return false;
    } 
    private Movie getMovie(String movieName, int year){
        for (Movie movie : moviesAvailable)
            if (movieName.equals(movie.getTitle())&&year==(movie.getYear()))
                return movie;
        return null;
    }    
    public void addMovie(){
        System.out.println("");
        System.out.println("Adding a new movie.");
        System.out.print("Enter the title of the movie: ");
        String title = In.nextLine();   
        System.out.print("Enter the year: ");
        int year = In.nextInt();
        System.out.print("Enter the genre: ");
        String genre = In.nextLine();
        System.out.print("Enter price: ");
        int price = In.nextInt();
        if (checkMovieTitleYear(title, year)){            
            System.out.print("The movie is already in the catalogue.");
            System.out.println("");
        }    else  {   
            System.out.print("");
            moviesAvailable.add(new Movie(title, year, genreAdd(genre), price));
            System.out.println("");
        }
    }
    private Genre genreAdd(String genreName){
        for (Genre genre : genres)
            if (genreName.equals(genre.genreName()))
                return genre; 
        genres.add(new Genre(genreName));
        return genreType(genreName);
    }
    public void listMovie(){
        for (Movie movie : moviesAvailable)
            System.out.println(movie);
    }  
    public void listGenre(){
        System.out.println("");
        System.out.println("The Kiosk has movies in the following genres:");
        for (Genre genre : genres)
            System.out.println(genre);
        System.out.println("");
    }
    public void listmovieGenre(){
        System.out.println("");
        System.out.print("Enter a genre: ");
        String genreName = In.nextLine();
        System.out.println("The kiosk has the following movies in that genre:");
        for (Movie movie : moviesAvailable)
        if (movie.getGenre().equals(genreType(genreName)))
            System.out.println(movie);
        System.out.println("");
    }
    public void listmovieYear(){
        System.out.println("");
        System.out.print("Enter the year: ");
        int year = In.nextInt();
        System.out.println("The kiosk has the following movies by that year:");
        for (Movie movie : moviesAvailable)
        if (year==(movie.getYear()))
            System.out.println(movie);
        System.out.println("");
    }
    public void avaMovies(){
        System.out.println("");
        System.out.println("The following movies are available:");
        for (Movie movie : moviesAvailable)
            System.out.println(movie);
        System.out.println("");
    }
    public void rentedMovies(){
        for (Movie movie : moviesAvailable)
            System.out.println(moviesRented);
    }
    public void rentMovie()
    {        
        System.out.println("");
        System.out.print("Enter a valid customer ID: ");
        int id = In.nextInt();   
        System.out.print("Enter the title of the movie you wish to rent: ");
        String name = In.nextLine();
        if (checkmovieTitle(name)){
          
           if (kiosk.checkcustomerID(id)){
           
           if (checkcustomerBalance(id,getmovieName(name))){
                   Movie savedMovie = getmovieName(name);
                   System.out.println("Movie rented. ");
                   moviesAvailable.remove(savedMovie);
                   moviesRented.add(savedMovie);
                   kiosk.getCustomerId(id).saveRented(savedMovie);           
                   System.out.println("");
           }    else{
            System.out.println("You don't have sufficient funds to rent this movie.");     
            System.out.println("");  
           }
                }   else   { 
            System.out.println("Invalid Id.");            
            System.out.println("");   
            
        }           
        } else {           
            System.out.println("That movie is not available or doesn't exist.");  
            System.out.println("");   
        }
    }

    private Movie getmovieName(String name){
        for (Movie movie : moviesAvailable)
            if (name.equals(movie.getTitle()))
                return movie;
        return null;
    }
    private Movie getreturnedmovieName(String name){
        for (Movie movie : moviesRented)
            if (name.equals(movie.getTitle()))
                return movie;
        return null;
    }
    public boolean checkcustomerBalance(int id, Movie movie){
        if (movie.getPrice()<=(kiosk.getBalance(id)))
            return true;
        return false;
    }
    public boolean checkmovieTitle(String name){
        for (Movie movie : moviesAvailable)
            if (name.equals(movie.getTitle()))
                return true;
        return false;
    }
    public void returnMovie(){
        System.out.println("");
        System.out.print("Enter a valid customer ID: ");
        int id = In.nextInt();
        if (kiosk.checkcustomerID(id)) {
            Customer savedCustomer = kiosk.getCustomerId(id);
            System.out.println(savedCustomer.getName() +" has the following movies:  ");
            System.out.println("Movies currently rented by " + savedCustomer.getName() +":");
            savedCustomer.listrentedMovie(); 
            System.out.print("Enter the title of the movie you wish to return: ");
            String name = In.nextLine();
            System.out.println(name + " has been returned.");
            System.out.println("");
            Movie savedMovie = getreturnedmovieName(name);
            moviesRented.remove(savedMovie);
            moviesAvailable.add(savedMovie);
            kiosk.getCustomerId(id).removeRented(savedMovie);
        } else  {
            System.out.println("Not a valid customer ID");            
            System.out.println("");   
        }
    }    
}
