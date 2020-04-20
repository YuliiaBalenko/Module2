package Tests;

import org.junit.Before;
import org.junit.Test;
import task3_3.MyLinkedList;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    private MyLinkedList<String> elements = new MyLinkedList();
    private MyLinkedList<Integer> elementsInt = new MyLinkedList();

    @Before
    public void setUp() {

        elements.add("1");
        elements.add("2");
        elements.add("3");
        elements.add("4");
        elements.add("5");

        elementsInt.add(1);
        elementsInt.add(2);
        elementsInt.add(3);
        elementsInt.add(4);
        elementsInt.add(5);
    }

    @Test
    public void add() {

        assertEquals("1,2,3,4,5", elements.toString());
        assertEquals("1,2,3,4,5", elementsInt.toString());

    }

    @Test
    public void remove() {
        elements.remove(2);
        assertEquals("1,2,4,5", elements.toString());
        elementsInt.remove(0);
        assertEquals("2,3,4,5", elementsInt.toString());
    }

    @Test
    public void get() {
        assertEquals("4", elements.get(3));
        assertEquals("2", elementsInt.get(1).toString());

    }

}