//import java.util.Arrays;
//import java.util.Scanner;
public class input{
    public static void main(String[] args){

        switch (args.length) {

            //Get random number
            case 1:
            int rand = (int)(Math.random() * Integer.parseInt(args[0])) + 1; //convert int rand to random integer times int
            System.out.println(rand);
            break;
    
            //Print a string x times
            case 2:
            int x = Integer.parseInt(args[0]); //convert the string to int
            for (int i=0; i<x; i++) {
                System.out.println(args[1]);
            }
            break;
    
            //Default case
            default:
            break;
    
            }
    }
}