package musiccollection;

public class Record {
    private String artist;
    private String title;
    private int yearReleased;

    // REQUIRES: `yearReleased` is a positive integer
    // EFFECTS: constructs a record with `artist`, `title`, and `yearReleased`
    public Record(String artist, String title, int yearReleased) {
        this.artist = artist;
        this.title = title;
        this.yearReleased = yearReleased;
    }

    public String getArtist() {
        return artist;
    }

    public int getYearReleased() {
        return yearReleased;
    }
}