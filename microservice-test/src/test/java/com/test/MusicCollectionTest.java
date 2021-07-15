//package com.test;
//
//import musiccollection.MusicCollection;
//import musiccollection.Record;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//class MusicCollectionTest {
//    private MusicCollection musicCollection;
//    private Record record1;
//    private Record record2;
//    private Record record3;
//    @BeforeEach
//    void runBefore() {
//        this.musicCollection = new MusicCollection();
//        this.record1 = new Record("The Doors", "Waiting for the Sun", 1968);
//        this.record2 = new Record("The Rolling Stones", "Aftermath", 1966);
//        this.record3 = new Record("The Beatles", "A Hard Day's Night", 1964);
//    }
//    @Test
//    void testConstructor() {
//        assertEquals(0, musicCollection.getTotalNumberOfRecords());
//    }
//    @Test
//    void testAddOne() {
//        musicCollection.addRecord(record1);
//        assertEquals(1, musicCollection.getTotalNumberOfRecords());
//    }
//    @Test
//    void testAddMany() {
//        musicCollection.addRecord(record1);
//        musicCollection.addRecord(record2);
//        musicCollection.addRecord(record3);
//        assertEquals(3, musicCollection.getTotalNumberOfRecords());
//    }
//    @Test
//    void testRecordsReleasedBeforeEmpty() {
//        assertEquals(0, musicCollection.getRecordsReleasedBefore(1970).size());
//    }
//    @Test
//    void testRecordsReleasedBeforeNoneExpected() {
//        musicCollection.addRecord(record1);
//        musicCollection.addRecord(record2);
//        musicCollection.addRecord(record3);
//        assertEquals(0, musicCollection.getRecordsReleasedBefore(1950).size());
//    }
//    @Test
//    void testRecordsReleasedBeforeManyExpected() {
//        musicCollection.addRecord(record1);
//        musicCollection.addRecord(record2);
//        musicCollection.addRecord(record3);
//        List<Record> filtered = musicCollection.getRecordsReleasedBefore(1968);
//        assertEquals(2, filtered.size());
//        assertEquals("The Rolling Stones", filtered.get(1).getArtist());
//        assertEquals("The Beatles", filtered.get(0).getArtist());
//    }
//    @Test
//    void testRecordsReleasedBeforeMultipleCalls() {
//        musicCollection.addRecord(record1);
//        musicCollection.addRecord(record2);
//        musicCollection.addRecord(record3);
//        List<Record> filtered = musicCollection.getRecordsReleasedBefore(1967);
//        assertEquals(2, filtered.size());
//        filtered = musicCollection.getRecordsReleasedBefore(1965);
//        assertEquals(1, filtered.size());
//    }
//}