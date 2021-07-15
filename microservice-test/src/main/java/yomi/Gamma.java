package yomi;

public class Gamma extends beta{

    public Gamma() {
        System.out.print("Gamma");
    }

    public static void main(String[] args) {
        Gamma g = new Gamma();
    }
}


class aplha {

    public aplha() {
        System.out.print("aplha");
    }

}

class beta extends aplha {

    public beta() {
        System.out.print("beta");
    }

}