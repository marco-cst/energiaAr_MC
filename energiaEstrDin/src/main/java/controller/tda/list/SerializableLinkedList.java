package controller.tda.list;

import java.util.ArrayList;
import java.util.List;

public class SerializableLinkedList<E> {
    private List<E> elements;

    public SerializableLinkedList(LinkedList<E> linkedList) {
        elements = new ArrayList<>();
        Node<E> current = linkedList.getHeader();
        while (current != null) {
            elements.add(current.getInfo());
            current = current.getNext();
        }
    }

    public List<E> getElements() {
        return elements;
    }
}