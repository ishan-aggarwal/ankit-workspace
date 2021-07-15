package test;

public class InstaAudio extends InstaItem {

    private String audioFile;

    //default constructor
    public InstaAudio() {
        super();
        audioFile = "None";
    }

    //second constructor
    public InstaAudio(String audioFile, String location, long timestamp) {
        super(location, timestamp);
        this.audioFile = audioFile;
    }

    @Override
    public String toString() {
        return "AUD " + this.audioFile + " " + super.toString();
    }


    public static void main(String[] args) {
        InstaAudio instaAudio = new InstaAudio("Rocking Beat", "Club Tech", 210501);
        InstaPost instaPost = new InstaPost();
        instaPost.add(instaAudio);
        instaPost.add(instaAudio);

        instaPost.printAll();
    }

}
