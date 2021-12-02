
/**
 * Write a description of class Genre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Genre
{
    private String name;
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class Genre
     */
    public Genre(String name)
    {
        this.name = name;
        
    }

    public String genreName(){
        return this.name;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod(int y)
    {
        // put your code here
        
    }
    @Override
    public String toString() { 
        return name; 
    }
}
