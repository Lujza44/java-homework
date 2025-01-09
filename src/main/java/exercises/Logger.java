package exercises;

import cz.cuni.mff.milotovl.util.Array;
import cz.cuni.mff.milotovl.util.MyCollection;

public class Logger {
    
    //private exercises.Printer printer; // interface

    private MyCollection printers = new Array();
    private int level;

    public void addPrinter(Printer p){
        this.printers.add(p);
    }

    public void log(int l, String msg){
        if (l >= this.level){ 
            //this.printer.print(msg);
            for (int i = 0; i < printers.size(); i++){
                Printer printer = (Printer) printers.get(i);
                printer.print(msg);
            }
        } 
    }

    public void setLevel(int level){
        this.level = level;
    }
}