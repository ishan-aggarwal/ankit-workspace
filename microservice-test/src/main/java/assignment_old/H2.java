package assignment_old;
interface StringMapper<T> {
    String map(T t);
}

class X {
    String s;
    public X(String s) {
        this.s = s;
    }
    public String toString() {
        return s.toLowerCase();
    }

    public String toLowerCase() {
        return s.toLowerCase();
    }
}

class Y<T> {
    T s;
    public Y(T s) {
        this.s = s;
    }
    public String toString() {
        return s.toString();
    }

}
public class H2 {


}
