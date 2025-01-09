package exercises;

public class TestPrinter {
    
    public static void main(String[] args){

        Logger l = new Logger();

        
        GenericPrinter p1 = new GenericPrinter();
        
        l.addPrinter(p1);

        l.setLevel(2);


        TimestampPrinter p2 = new TimestampPrinter(); // vzdy sa spusti najprv rodicovsky konstruktor

        l.addPrinter(p2);


        LabelPrinter p3 = new LabelPrinter("nejakyLabel"); // vzdy sa spusti najprv rodicovsky konstruktor

        l.addPrinter(p3);

        l.log(1, "hello");
        l.log(2, "nice");
        l.log(3, "world!");

    }
}
