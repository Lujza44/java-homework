package exercises;

public class GenericPrinter implements Printer{
    
    public GenericPrinter(){
        System.out.println(this.getClass().getSimpleName());
    }

    public void print(String msg){
        System.out.println(msg);
    }
}