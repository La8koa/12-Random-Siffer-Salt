import java.util.Random;
import java.util.Arrays;
/**
 * @author Njål Henriksen La8koa(at)gmail.com
 * @version v3 beta 
 */
public class RandomDigit
{
    public String digitStr;
    private long checkPrimeNr;
    private boolean isPrime;
    private int block;
    private int[] ranArr;

    public RandomDigit(int index){
        switch(index){
            case 0:
            block = 1;
            break;
            case 1:
            block = 2;
            break;
            case 2:
            block = 3;
            break;
            case 3:
            block = 4;
            break;
        }
    }

    public String randomNum()
    {
        //block is the length of key choosen by user in KeyGenerator class
        ranArr = new int[block];
        
        for(int i = 0;i<ranArr.length;){
            ranArr[i] = ranDigit();
            i++;
        }

        //get a string with the number from the array
        digitStr = Arrays.toString(ranArr).replaceAll("\\[|\\]|,|\\s", "");
        //parse the String to long 
        checkPrimeNr = Long.parseLong(digitStr);
        //check if the number is a prime number
        if(this.isPrime(checkPrimeNr)== true){
            return "Prime number occurred, try again!";
        }

        //return a number that is more readable.
        return Arrays.toString(ranArr).replaceAll("\\[|\\]||\\s", "");
    }

    //the random generator
    private int ranDigit()
    {
        Random RandInt = new Random();
        int digit = RandInt.nextInt(9999-1000)+1000;
        return digit;
    }

    //prime checker return false or true
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

    //methode to get the number from RandomNum() without any commas
    public String copyNrToClip(){

        return digitStr;
    }
}
