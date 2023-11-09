package MusicAlbum;


import MusicComposition.MusicComposition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class MusicAlbumTest {
    private MusicAlbum album;

    @BeforeEach
    public void setUp() {
        album = new MusicAlbum("Album1", "Artist1");
    }

    @Test
    public void testCalculateTheDuration() {
        MusicComposition composition1 = new MusicComposition("Song1", "Artist1", "Pop", 3.5);
        MusicComposition composition2 = new MusicComposition("Song2", "Artist1", "Rock", 2.5);
        album.addCompositionInAlbum(composition1);
        album.addCompositionInAlbum(composition2);

        double expectedMinuteDuration = 3.5 + 2.5;
        double expectedHourDuration = expectedMinuteDuration / 60;

        assertEquals(2, album.calculateTheDuration().size());
        assertEquals(expectedMinuteDuration, album.calculateTheDuration().get(0), 0.01);
        assertEquals(expectedHourDuration, album.calculateTheDuration().get(1), 0.01);
    }
    @Test
    public void testGetTitle() {
        assertEquals("Album1", album.getTitle());
    }

    @Test
    public void testGetArtist() {
        assertEquals("Artist1", album.getArtist());
    }

    @Test
    public void testAddCompositionInAlbum() {
        MusicComposition composition = new MusicComposition("Song1", "Artist1", "Pop", 3.5);
        album.addCompositionInAlbum(composition);
        assertEquals(1, album.getAlbum().size());
        assertTrue(album.getAlbum().contains(composition));
    }

    @Test
    public void testRemoveCompositionInAlbum() {
        MusicComposition composition = new MusicComposition("Song1", "Artist1", "Pop", 3.5);
        album.addCompositionInAlbum(composition);
        album.removeCompositionInAlbum(composition);
        assertEquals(0, album.getAlbum().size());
    }


}