//import java.util.Arrays;
public class input{
    public static void main(String[] args){
        input in = new input();
        int input = in.randomNumber();
        System.out.println(input);
        
    }
    public int randomNumber() {
        int x = (int)(Math.random()*50) + 1;
       
        return x;
        
    }
    
}