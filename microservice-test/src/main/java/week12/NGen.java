package week12;

public class NGen<T> {

    private T data;
    private NGen<T> next;

    public NGen() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NGen<T> getNext() {
        return next;
    }

    public void setNext(NGen<T> next) {
        this.next = next;
    }

    public NGen (T o, NGen<T> link) {
        data = o;
        next = link;
    }

}
