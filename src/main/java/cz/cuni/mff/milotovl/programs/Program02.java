package cz.cuni.mff.milotovl.programs;
import cz.cuni.mff.milotovl.util.Array;

public class Program02{

    public static void main(String[] args){
        Array dynArray = new Array();
        
        if(args.length > 0){
            for(int i = 0; i < args.length; i++){
                dynArray.add(args[i]);
            }
            print(dynArray);

            test(dynArray);

        }
        else{
            System.out.println("no arguments given");
        }
    }

    public static void test(Array array){
        array.add("a");
        array.add("b");
        array.add("c");
        print(array);
        array.remove(1);
        print(array);
        array.remove("x");
        print(array);
        array.remove("a");
        print(array);
    }

    public static void test2(){
        Array arr = Array.of("hello", "world", "!", 3, 20, 'c');
        print(arr);
    }

    public static void print(Array array){
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
        //System.out.println(" ");
    }

}
