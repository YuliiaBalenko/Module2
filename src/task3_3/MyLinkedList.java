package task3_3;

public class MyLinkedList<E> {

    private Item<E> head;

    public void add(E value) {
        Item<E> item = new Item<E>(value);

        if (head != null) {
            Item<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            item.previous = temp;
            temp.next = item;
        } else {
            head = item;
        }
    }

    public void remove(int index) {
        if (head == null)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            head = head.next;
            head.previous = null;
            return;
        }

        Item<E> temp = head;
        while (temp.next != null || index == 0) {
            index--;
            temp = temp.next;
            if (index == 0) {
                if (temp.next != null)
                    temp.next.previous = temp.previous;

                temp.previous.next = temp.next;
                return;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    public E get(int index) {
        if (head == null)
            throw new IndexOutOfBoundsException();

        if (index == 0)
            return head.value;

        Item<E> temp = head;
        while (temp.next != null) {
            index--;
            temp = temp.next;
            if (index == 0) {
                return temp.value;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        if (head == null)
            return "";

        Item<E> temp = head;
        String result = temp.value.toString();
        while (temp.next != null) {
            temp = temp.next;
            result += "," + temp.value;
        }

        return result;
    }

    class Item<E> {
        public E value;
        public Item<E> previous;
        public Item<E> next;

        public Item(E value) {

            this.value = value;
        }
    }
}
