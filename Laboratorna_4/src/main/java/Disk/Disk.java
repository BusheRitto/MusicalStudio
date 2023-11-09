package Disk;


import MusicAlbum.MusicAlbum;
import MusicComposition.MusicComposition;
import SortAlbums.CompositionSortByDurationComparator;
import SortAlbums.CompostitionStyleComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.*;


public class Disk {
    private String disk_name;

    private ArrayList<MusicAlbum> albums_on_disk = new ArrayList<>();

    private static final Logger logger = Logger.getLogger(Disk.class.getName());

    public Disk(String disk_name) {
        this.disk_name = disk_name;

        Handler fileHandler;
        try {
            fileHandler = new FileHandler("disk_log.txt");
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Помилка при ініціалізації логгера", e);
        }
    }

    public void recordAlbumOnDisk(MusicAlbum collection) {
        this.albums_on_disk.add(collection);
        logger.log(Level.INFO, "Додано альбом на диск: " + collection.getTitle());
    }

    public void deleteAlbumFromDisk(MusicAlbum collection) {
        try {
            this.albums_on_disk.remove(collection);
            logger.log(Level.INFO, "Альбом видалено з диску: " + collection.getTitle());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка при видаленні альбому з диску", e);
        }
    }

    public void printRecordedAlbums() {
        if (albums_on_disk.isEmpty()) {

            logger.log(Level.WARNING, "На диску немає записаних альбомів.");
            return;
        }
        logger.log(Level.INFO, "Доступні альбоми на диску.");

        for (int i = 0; i < albums_on_disk.size(); i++) {
            MusicAlbum album = albums_on_disk.get(i);
            System.out.println((i + 1) + ". " + "Альбом - " + album.getTitle() + ", Виконавець - " + album.getArtist());
        }
    }

    public double[] calculateTheDurationOnDisk() {
        double minute = 0;
        double hour = 0;

        if (this.albums_on_disk.isEmpty()) {
            logger.log(Level.WARNING, "На диску немає записаних альбомів.");
            return new double[]{0, 0};
        }
        int i = 0;
        for (MusicAlbum album : albums_on_disk) {
            for (MusicComposition composition : album.getAlbum()) {
                minute += composition.getDuration();
                i++;
            }
        }

        hour = minute / 60;


        double[] duration = {minute, hour};

        return duration;
    }


    public void rearrangeCompositionsByStyle() {
        for (MusicAlbum album : albums_on_disk) {
            album.getAlbum().sort(new CompostitionStyleComparator());
        }
        System.out.println(albums_on_disk);
    }

    public void rearrangeCompositionsByDuration() {
        for (MusicAlbum album : albums_on_disk) {
            album.getAlbum().sort(new CompositionSortByDurationComparator());
        }
        System.out.println(albums_on_disk);
    }

    public ArrayList<MusicAlbum> getAlbumsOnDisk() {
        return albums_on_disk;
    }

    public ArrayList<MusicComposition> findCompositionByLenghtOfTracks(double r1, double r2) {
        ArrayList<MusicComposition> foundСompositions = new ArrayList<>();
        boolean found = false;
        for (MusicAlbum album : albums_on_disk) {
            for (MusicComposition composition : album.getAlbum()) {
                double duration = composition.getDuration();
                if (duration >= r1 && duration <= r2) {
                    foundСompositions.add(composition);
                    found = true;
                }
            }
        }
        if (found == false) {
            logger.log(Level.SEVERE, "Не найдено композицій за вказаним діапазоном " + r1 + " та " + r2);
            return null;
        } else {
            return foundСompositions;
        }

    }

    @Override
    public String toString() {
        return "Назва диску - " + disk_name + '\n' +
                "Альбоми на диску \n" + albums_on_disk;
    }
}
