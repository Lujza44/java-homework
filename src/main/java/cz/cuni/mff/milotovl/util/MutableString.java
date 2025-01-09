package cz.cuni.mff.milotovl.util;

public interface MutableString {
    void append(String str);
    void append(char ch);
    void insert(int pos, String str);
    void insert(int pos, char ch);
    void delete(int pos, int length);
    String toString();
    int length();
}
