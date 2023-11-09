package Disk;

import MusicAlbum.MusicAlbum;
import MusicComposition.MusicComposition;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;


import static org.junit.Assert.*;


public class DiskTest {


    @Test
    public void testRecordOnDisk() {
        Disk disk = new Disk("Disk");
        MusicAlbum album1 = new MusicAlbum("album1", "artist1");
        MusicAlbum album2 = new MusicAlbum("album1", "artist2");
        disk.recordAlbumOnDisk(album1);
        disk.recordAlbumOnDisk(album2);

        ArrayList<MusicAlbum> albums = disk.getAlbumsOnDisk();
        assertEquals(2, albums.size());


    }

    @Test
    public void testDeleteOnDisk() {
        Disk disk = new Disk("Disk");
        MusicAlbum album1 = new MusicAlbum("album1", "artist1");
        MusicAlbum album2 = new MusicAlbum("album1", "artist2");
        disk.recordAlbumOnDisk(album1);
        disk.recordAlbumOnDisk(album2);
        disk.deleteAlbumFromDisk(album1);

        ArrayList<MusicAlbum> albums = disk.getAlbumsOnDisk();

        assertEquals(1, albums.size());
        assertTrue(albums.contains(album2));
    }

    @org.junit.jupiter.api.Test
    void testCalculateTheDurationOnDisk() {
        Disk new_d = new Disk("didsds");
        MusicComposition composition1 = new MusicComposition("Song 1", "artist1", "pop", 180);
        MusicComposition composition2 = new MusicComposition("Song 2", "artist2", "pop", 240);
        MusicAlbum album = new MusicAlbum("Album", "Artist");
        album.addCompositionInAlbum(composition1);
        album.addCompositionInAlbum(composition2);
        new_d.recordAlbumOnDisk(album);

        double[] expectedDuration = {420, 7.0};
        double[] actualDuration = new_d.calculateTheDurationOnDisk();

        assertArrayEquals(expectedDuration, actualDuration, 0.01);

    }

    @org.junit.jupiter.api.Test
    void testRearrangeCompositionsByStyle() {
        Disk disk = new Disk("TestDisk");
        MusicComposition composition1 = new MusicComposition("Song1", "Artist1", "Pop", 5);
        MusicComposition composition2 = new MusicComposition("Song2", "Artist2", "Rock", 6);
        MusicComposition composition3 = new MusicComposition("Song3", "Artist3", "Jazz", 7);
        MusicComposition composition4 = new MusicComposition("Song4", "Artist4", "Pop", 1);

        MusicAlbum album1 = new MusicAlbum("Album1", "Artist1");
        album1.addCompositionInAlbum(composition1);
        album1.addCompositionInAlbum(composition2);

        MusicAlbum album2 = new MusicAlbum("Album2", "Artist2");
        album2.addCompositionInAlbum(composition3);
        album2.addCompositionInAlbum(composition4);

        disk.recordAlbumOnDisk(album1);
        disk.recordAlbumOnDisk(album2);


        disk.rearrangeCompositionsByStyle();

        ArrayList<MusicAlbum> albums = disk.getAlbumsOnDisk();
        for (MusicAlbum sortedAlbum : albums) {
            ArrayList<MusicComposition> compositions = sortedAlbum.getAlbum();
            for (int i = 0; i < compositions.size() - 1; i++) {
                String style1 = compositions.get(i).getStyle();
                String style2 = compositions.get(i + 1).getStyle();
                assertTrue(style1.compareTo(style2) <= 0);
            }
        }
    }


    @org.junit.jupiter.api.Test
    void testRearrangeCompositionsByDuration() {
        Disk disk = new Disk("TestDisk");
        MusicComposition composition1 = new MusicComposition("Song 1", "artist1", "pop", 6);
        MusicComposition composition2 = new MusicComposition("Song 2", "artist2", "pop", 1);
        MusicComposition composition3 = new MusicComposition("Song 3", "artist3", "pop", 2);

        MusicAlbum album = new MusicAlbum("TestAlbum", "TestArtist");
        album.addCompositionInAlbum(composition1);
        album.addCompositionInAlbum(composition2);
        album.addCompositionInAlbum(composition3);
        disk.recordAlbumOnDisk(album);

        disk.rearrangeCompositionsByDuration();

        ArrayList<MusicAlbum> albums = disk.getAlbumsOnDisk();


        for (MusicAlbum sortedAlbum : albums) {
            ArrayList<MusicComposition> compositions = sortedAlbum.getAlbum();
            double previousDuration = 0.0;
            for (MusicComposition composition : compositions) {
                double currentDuration = composition.getDuration();
                assertTrue(currentDuration >= previousDuration);
                previousDuration = currentDuration;
            }
        }
    }

    @org.junit.jupiter.api.Test
    void testGetAlbumsOnDisk() {
        Disk new_disk = new Disk("TestDisk");
        MusicAlbum album1 = new MusicAlbum("Album1", "Artist1");
        MusicAlbum album2 = new MusicAlbum("Album2", "Artist2");

        new_disk.recordAlbumOnDisk(album1);
        new_disk.recordAlbumOnDisk(album2);

        ArrayList<MusicAlbum> albums = new_disk.getAlbumsOnDisk();

        assertEquals(2, albums.size());
        assertTrue(albums.contains(album1));
        assertTrue(albums.contains(album2));
    }

    @org.junit.jupiter.api.Test
    void testFindCompositionByLenghtOfTracks() {
        Disk disk = new Disk("TestDisk");
        MusicComposition composition1 = new MusicComposition("Song 1", "artist1", "pop", 3); // 3 minutes
        MusicComposition composition2 = new MusicComposition("Song 2", "artist2", "pop", 4); // 4 minutes
        MusicComposition composition3 = new MusicComposition("Song 3", "artist3", "pop", 5); // 5 minutes
        MusicComposition composition4 = new MusicComposition("Song 4", "artist4", "pop", 2); // 2 minutes

        MusicAlbum album = new MusicAlbum("TestAlbum", "TestArtist");
        album.addCompositionInAlbum(composition1);
        album.addCompositionInAlbum(composition2);
        album.addCompositionInAlbum(composition3);
        album.addCompositionInAlbum(composition4);
        disk.recordAlbumOnDisk(album);

        double r1 = 1;
        double r2 = 4;

        ArrayList<MusicComposition> foundCompositions = disk.findCompositionByLenghtOfTracks(r1, r2);

        assertEquals(3, foundCompositions.size());
        assertTrue(foundCompositions.contains(composition1));
        assertTrue(foundCompositions.contains(composition4));
        assertTrue(foundCompositions.contains(composition2));

        double r3 = 6;
        double r4 = 7;

        ArrayList<MusicComposition> notFoundCompositions = disk.findCompositionByLenghtOfTracks(r3, r4);

        assertNull(notFoundCompositions);

    }

    @Test
    public void testToString() {
        Disk disk = new Disk("My Disk");
        MusicAlbum album1 = new MusicAlbum("Album1", "Artist1");
        MusicAlbum album2 = new MusicAlbum("Album2", "Artist2");
        disk.recordAlbumOnDisk(album1);
        disk.recordAlbumOnDisk(album2);

        String expectedOutput = "Назва диску - My Disk\n" +
                "Альбоми на диску \n[" + album1.toString() + ", " + album2.toString() + "]";

        assertEquals(expectedOutput, disk.toString());
    }
}