package assignment_10_1;

public class Main
{
    private int first;
    private int second;
   
    public Main(int first, int second) {
        this.first = first;
        this.second = -- second;
    }
   
    public void display() {
        class Sum {
            public void sum() {
                second = first +++ second;
            }
        }
        Sum d = new Sum();
        d.sum();
        System.out.println(first + " " + second);
    }
 
public static void main(String[] args) {
   Main m = new Main(1,2);
   m.display();
   System.out.println(m.first);
   System.out.print(m.second);
}
}