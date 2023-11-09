package MusicAlbum;

import MusicComposition.MusicComposition;

import java.util.ArrayList;

public class MusicAlbum {
    private String title;
    private String artist;


    private ArrayList<MusicComposition> album = new ArrayList<>();


    public MusicAlbum() {
        this.title = "Невідомо.";
        this.artist = "Невідомо.";
    }


    public MusicAlbum(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public ArrayList<Double> calculateTheDuration() {
        ArrayList<Double> album_duration = new ArrayList<>();
        double minute = 0;
        double hour = 0;

        if (this.album.isEmpty()) {
            System.out.println("На диску немає записаної збірки.");
            return new ArrayList<>();
        }

        for (MusicComposition composition : album) {
            minute += composition.getDuration();
        }

        hour = minute / 60;


        album_duration.add(minute);
        album_duration.add(hour);

        return album_duration;
    }

    public void addCompositionInAlbum(MusicComposition composition) {
        this.album.add(composition);
    }


    public void removeCompositionInAlbum(MusicComposition composition) {
        this.album.remove(composition);
    }


    public String getTitle() {
        return title;
    }


    public String getArtist() {
        return artist;
    }


    public String toString() {
        return "\nМузичний альбом - " + title + "\n" +
                "Артист - " + artist + '\n' +
                "Альбом - \n" + album;

    }

    public ArrayList<MusicComposition> getAlbum() {
        return album;
    }

}
