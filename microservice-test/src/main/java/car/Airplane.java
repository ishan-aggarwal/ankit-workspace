package car;

public class Airplane extends Flyer {
 @Override
 public String toString() {
 return super.toString() + "\n" + "This can fly for longer durations";
 }
}