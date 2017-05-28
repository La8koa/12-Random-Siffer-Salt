import java.util.Random;
/**
 * @author Njål Henriksen La8koa(at)gmail.com
 * @version v3 beta 
 */
public class RandomDigit
{
    private String twelveDigitStr;
    private long checkPrimeNr;
    private boolean isPrime;
    private int randomNumInt1;
    private int randomNumInt2;
    private int randomNumInt3;
    private int digit;

    public String randomNum()
    {
        randomNumInt1 = ranDigit(); 
        String rdnr1 = Integer.toString(randomNumInt1);
        randomNumInt2 = ranDigit();
        String rdnr2 = Integer.toString(randomNumInt2);
        randomNumInt3 = ranDigit();
        String rdnr3 = Integer.toString(randomNumInt3);

        twelveDigitStr = rdnr1 + rdnr2 + rdnr3;
        checkPrimeNr = Long.parseLong(twelveDigitStr);
        if(this.isPrime(checkPrimeNr)== true){
            return "Prime number occurred, try again!";
        }

        return rdnr1 + "-" + rdnr2 + "-"+ rdnr3;
    }

    private int ranDigit()
    {
        Random RandInt = new Random();
        digit = RandInt.nextInt(9999-1000)+1000;
        return digit;
    }

    private boolean isPrime(long checkPrime) {
        long n = checkPrimeNr;
        // fast even test.
        if(n > 2 && (checkPrime & 1) == 0){
            isPrime = false;
            return false;
        }

        // only odd factors need to be tested up to n^0.5
        for(long i = 3; i * i <= n; i += 2)
            if (n % i == 0) {
                isPrime = false;
                return false;
            }else{
                isPrime = true;
            }
        return true;
    }
}
