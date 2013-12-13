package extended.storage.stack;

/**
 *
 * @author main
 * @param <E>
 */
public class Stack<E> {

    E[] stack;
    int pointer = 0;

    public Stack(int size) {
        stack = (E[]) new Object[size];
    }

    public void push(E value) {
        try {
            stack[pointer++] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Stack overflow");
        }
    }

    public E pop() {
        try {
            return stack[--pointer];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Stack underflow");
        }
    }
}
