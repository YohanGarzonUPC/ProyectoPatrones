package estructuraD;

import java.util.Iterator;

public class DoubleLLI<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int count;

    public DoubleLLI() {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    private class Node {

        Item item;
        Node next;
        Node previous;
    }

    public void add(int index, Item element) {
        if (index <= count+1 && index >0) {  
            Node Actual = new Node();
            Actual.item = element;
            int i = 1;
            if (count == 0) {
                first = Actual;
                last = Actual;
            } else {
                Node temp = first;
                while (i < index-1) {
                    i++; 
                    temp = temp.next;
                }
                if (index == 1 && count>1) { //Caso especial inicio first
                    temp.previous = Actual;
                    Actual.next = temp;
                    first = Actual;
                } else if (count+1 == index) { //Caso especial final 
                    temp.next = Actual;
                    Actual.previous = temp;
                    last = Actual;
                    } else { //Añadir normal cauqluier posicion
                        Actual.next = temp.next;
                        temp.next = Actual;
                        Actual.previous = temp;
                        Actual.next.previous = Actual;
                }
            }
            count++;
        }
    }

    
    public boolean addLast(Item item) {
        add(count+1, item);
        return true;
    }
    
    public boolean addFirst(Item item) {
        add(1, item);
        return true;
    }
    
    public void clear() {
        first = null;
        last=null;
        count = 0;
    }

    public boolean contains(Item item) {
        if(indexOf(item)>0){
            return true;
        }
        return false;
    }

    public int indexOf(Item item) {
        int countTemp = 0;
        for (Node i = first; i != null; i = i.next) {
            countTemp++;
            if (i.item.equals(item)) {
                return countTemp;
            }
        }
        return -1;
    }

    public int lastIndexOf(Item item) {
        int countTemp = count;  
        for (Node i = last; i != null; i = i.previous) {
            if (item.equals(i.item)) {
                return countTemp;
            }
            countTemp--;
        }
        return -1;
    }

    public Item remove(int index) { //1
        if (index <= count && index > 0) {
        int i = 0;
        Node temp = first;
        while (i < index-1) {
            i++; 
            temp = temp.next;
        }
                if (i == 0) {
                    Item item = temp.item;
                    first = temp.next;
                    count--;
                    return item;
                }
                
                if (index == count) { 
                    Item item = temp.item;
                    temp.previous.next = null;
                    last = temp.previous;
                    count--;
                    return item;
                }

                if (count == 1) {
                    Item item = temp.item;
                    first = null;
                    last = null;
                    count--;
                    return item;
                }
                
                Item item = temp.item;
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                count--;
                return item;
        }
        return null;
    }

    public boolean removeBoolean(Item Object) {
        if(contains(Object)){
            remove(indexOf(Object));
            return true;
        }
        return false;
    }

    public Item removeLast(Item item) {
        return remove(count);
    }
    
    public Item removeFirst(Item item) {
        return remove(1);
    }
    
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Item set(int index, Item element) {
        if (index <= count) {
            indexOf(element);
            int i = 0;
            for (Node temp = first; temp != null; temp = temp.next) {
                if (i++ == index - 1) {
                    Item TempElement = temp.item;
                    temp.item = element;
                    return TempElement;
                }
            }
            
        }
        return null;
    }

    public Item[] toArray() {
        Item[] a = (Item[]) new Object[count];
        int temp = 0;
        for (Node i = first; i != null; i = i.next) {
            a[temp++] = i.item;
        }
        return a;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LLiterator();
    }

    public class LLiterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
