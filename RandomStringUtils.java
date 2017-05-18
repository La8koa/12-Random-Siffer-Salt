import java.util.Random;
/**
 * Write a description of class RandomStringUtils here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomStringUtils extends Object   
{
    // instance variables - replace the example below with your ow


    public RandomStringUtils()
    {
    }

    public String passWord()
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( 15, characters );
        return pwd;
    }
}