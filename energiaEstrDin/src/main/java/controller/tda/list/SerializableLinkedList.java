package controller.tda.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializableLinkedList<T> implements Serializable {
    private List<T> elements;

    public SerializableLinkedList(LinkedList<T> linkedList) {
        elements = new ArrayList<>();
        Node<T> current = linkedList.getHeader();
        while (current != null) {
            elements.add(current.getInfo());
            current = current.getNext();
        }
    }

    public List<T> getElements() {
        return elements;
    }
}