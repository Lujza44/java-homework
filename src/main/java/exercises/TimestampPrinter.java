package exercises;

public class TimestampPrinter extends GenericPrinter{
    
    public TimestampPrinter(){
        System.out.println(this.getClass().getSimpleName());
    }

    public void print(String msg){
        System.out.println(new java.util.Date() + " " + msg);
    }
}
