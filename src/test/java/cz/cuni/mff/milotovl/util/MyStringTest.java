package cz.cuni.mff.milotovl.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStringTest {

    MyString myString;
    @BeforeEach
    public void setUp() {
        myString = new MyString();
    }
    @Test
    public void testNewString() {
        assertTrue(myString.length() == 0);
    }
    @Test
    public void testInsertWithChar() {
        myString.insert(0, 'a');
        assertTrue(myString.equals('a'));
    }
    @Test
    public void testInsertWithStr() {
        myString.insert(0, "hello");
        assertTrue(myString.equals("hello"));
        myString.insert(2, "abc");
        assertTrue(myString.equals("heabcllo"));
    }

    @Test
    public void testAppendWithChar() {
        myString.append('a');
        assertTrue(myString.equals('a'));
    }
    @Test
    public void testAppendWithStr() {
        myString.append("hello");
        assertTrue(myString.equals("hello"));
        myString.append(" world");
        assertTrue(myString.equals("hello world"));
    }

    @Test
    public void testDelete() {
        myString = new MyString("abc");
        myString.delete(0,1);
        assertTrue(myString.equals("bc"));
    }
}
