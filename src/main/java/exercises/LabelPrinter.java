package exercises;

public class LabelPrinter extends GenericPrinter{
    
    String label;

    public LabelPrinter(String label){
        this.label = label;
        System.out.println(this.getClass().getSimpleName());
    }
    public void print(String msg){
        System.out.println(label + " " + msg);
    }
}
