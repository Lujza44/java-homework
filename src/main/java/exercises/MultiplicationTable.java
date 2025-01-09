package exercises;

public class MultiplicationTable {
    
    public static void main(String[] args){
        try{
            int number = Integer.parseInt(args[0]);
            write(number);
        } catch(NumberFormatException e){
            System.err.println("Not a valid integer!");
        }
    }

    public static void write(int number){
        for(int i = 1; i <= 10; i++){
            System.out.println(i + " * " + number + " = " + i*number);
        }
    }
}