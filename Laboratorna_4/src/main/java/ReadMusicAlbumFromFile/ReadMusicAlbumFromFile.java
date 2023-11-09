package ReadMusicAlbumFromFile;

import MusicAlbum.MusicAlbum;
import MusicComposition.MusicComposition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadMusicAlbumFromFile {
    public  ArrayList<MusicAlbum> readMusicAlbums() {
        String filePath = "C:\\Users\\denle\\Desktop\\java_projects\\Laboratorna_4\\src\\main\\java\\org\\example\\MusicCompositions";
        ArrayList<MusicComposition> compositions = new ArrayList<>();
        ArrayList<MusicAlbum> music_album = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                MusicAlbum currentAlbum = null;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length == 2) {
                        String title_album = parts[0];
                        String artist_of_album = parts[1];
                        currentAlbum = new MusicAlbum(title_album, artist_of_album);
                        music_album.add(currentAlbum);
                    }
                    if (parts.length == 4) {
                        if (currentAlbum != null) {
                            String name = parts[0];
                            String artist = parts[1];
                            String style = parts[2];
                            double duration = Double.parseDouble(parts[3]);

                            MusicComposition composition = new MusicComposition(name, artist, style, duration);
                            compositions.add(composition);
                            currentAlbum.addCompositionInAlbum(composition);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return music_album;
    }
}
