
/**
 * Write a description of class Movie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Movie
{
    private String title;
    private int year;
    private int price;
    private Genre genre;
    // instance variables - replace the example below with your own
        

    /**
     * Constructor for objects of class Movie
     */
    public Movie(String title, int year, Genre genre, int price)
    {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }    
    public String getTitle()
    {
        return this.title;
    }
    public int getYear()
    {
        return this.year; 
    }
    public Genre getGenre()
    {
        return this.genre; 
    }
    public int getPrice()
    {
        return this.price; 
    }
    
    @Override
    public String toString() { 
        return year +"\t"+ title +"\t"+ genre +"\t"+"$"+ price; 
    }
    
}
