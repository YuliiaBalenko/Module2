package task3_3;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> elements = new MyLinkedList();

        elements.add("1");
        elements.add("2");
        elements.add("3");
        elements.add("4");
        elements.add("5");
        System.out.println("Source list: "  + elements);

        elements.remove(2);
        System.out.println("Remove index 2: " + elements);

        System.out.println("Get index 3: " + elements.get(3));
    }
}
