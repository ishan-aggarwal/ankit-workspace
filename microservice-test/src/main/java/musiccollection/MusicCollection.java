package musiccollection;

import java.util.ArrayList;
import java.util.List;

// Represents a music collection having many records
public class MusicCollection {
    private List<Record> allRecords;
    private List<Record> filtered;

    // EFFECTS: constructs an empty music collection
    public MusicCollection() {
        this.allRecords = new ArrayList<>();
        this.filtered = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds `record` to this music collection
    public void addRecord(Record record) {
        this.allRecords.add(0, record);
    }

    // REQUIRES: `yearReleased` is a positive integer
    // EFFECTS: returns a list of all the records in this music collection which
    // were released before `yearReleased` (not including records released in the
    // year `yearReleased`), in the order in which they were added to the collection
    public List<Record> getRecordsReleasedBefore(int yearReleased) {
        this.filtered = new ArrayList<>();
        for (Record record : this.allRecords) {
            if (record.getYearReleased() < yearReleased) {
                this.filtered.add(record);
            }
        }
        return filtered;
    }

    // EFFECTS: returns the total number of records in this collection
    public int getTotalNumberOfRecords() {
        return this.allRecords.size();
    }
}