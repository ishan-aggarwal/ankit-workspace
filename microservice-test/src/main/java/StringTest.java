import java.util.stream.Stream;

public class StringTest {

    public static void main(String[] args) {

//        String text = "+16048123193;npdi@75.156.205.188;user=phone. ";
        String text =":NPANXXXXXX;Y,Z...@x.x.x.x;yyyy;zzzz;....";
        long max = Stream.of(text.replaceAll("^\\D+","").split("\\D+"))
                .mapToLong(Long::parseLong)
                .max().orElse(-1);
        System.out.println(max);
    }
}
