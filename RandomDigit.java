import java.util.Random;
/**
 * @author Njål Henriksen La8koa(at)gmail.com
 * @version v3 beta 
 */
public class RandomDigit
{
    private String twelveDigit;
    private int randomNumInt1;
    private int randomNumInt2;
    private int randomNumInt3;
    private int randFourDigit;

    public String randomNum()
    {
        randomNumInt1 = ranDigit(); 
        String rdnr1 = Integer.toString(randomNumInt1);
        randomNumInt2 = ranDigit();
        String rdnr2 = Integer.toString(randomNumInt2);
        randomNumInt3 = ranDigit();
        String rdnr3 = Integer.toString(randomNumInt3);
        return rdnr1 + "-" + rdnr2 + "-"+ rdnr3;
    }

    public int ranDigit()
    {
        Random RandInt = new Random();
        int digit = RandInt.nextInt(9999);
        int length = (int) Math.log10(digit) + 1;
        if(length != 4)
        {
            digit = RandInt.nextInt(9999);
        }
        return digit;
    }

}
