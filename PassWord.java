import java.util.Random;
/*
stolen from stackoverflow   
*/
public class PassWord {

    private static final char[] symbols;

    static {
        StringBuilder tmp = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ++ch)
            tmp.append(ch);
        for (char ch = 'a'; ch <= 'z'; ++ch)
            tmp.append(ch);
        for (char ch = 'A'; ch <= 'Z'; ++ch)
            tmp.append(ch);
        for (char ch = '!'; ch <= '.'; ++ch)
            tmp.append(ch);
        symbols = tmp.toString().toCharArray();
    }   

    private final Random random = new Random();
    private final char[] buf;
    private int length;

    public PassWord(int index) {
        //length = 16;
        switch(index){
            case 0:
            length = 256;
            break;
            case 1:
            length = 128;
            break;
            case 2:
            length = 64;
            break;
            case 3:
            length = 32;
            break;
            case 4: 
            length = 20;
            break;
            case 5:
            length = 16;
            break;
        }
        
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];
    }
    
    public String nextString() {
        String enterprise = "173467321476C32789777643T732V73117888732476789764376";
        String starTrek;
        for (int idx = 0; idx < buf.length; ++idx){ 
            buf[idx] = symbols[random.nextInt(symbols.length)];  
        }
        
        if(StarTrek(buf).equals(enterprise)){
            return new String("Starship Enterprise master code entered");
            }else{
                return new String(buf);
        }
    }
}