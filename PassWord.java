
/**
 * Write a description of class PassWord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PassWord
{
    
    private static final String ALPHA_CAPS  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA   = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUM     = "0123456789";
    private static final String SPL_CHARS   = "!@#$%^&*_=+-/";
    
    char[] pswd = new char[15];
    
    
    
    /**
     * Constructor for objects of class PassWord
     */
    public PassWord()
    {
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    
    public String passWord(){

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        //String pwd = RandomStringUtils.random( 15, characters );
        return characters;
    }
}
