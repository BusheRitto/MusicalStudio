package CommandForMusicAlbum;

import Command.Command;
import Disk.Disk;
import MusicAlbum.MusicAlbum;
import MusicComposition.MusicComposition;
import CommandForDisk.*;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.enterComposition;

public class CreateAlbumCommand implements Command {

    private Disk disk;


    public CreateAlbumCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість альбомів: ");
        int albumCount = scanner.nextInt();
        scanner.nextLine();

        ArrayList<MusicAlbum> albumsToRecord = new ArrayList<>();


        for (int i = 1; i <= albumCount; i++) {

            System.out.print("Введіть назву альбому " + i + ": ");
            String albumName = scanner.nextLine();
            System.out.print("Введіть виконавця для альбому " + i + ": ");
            String albumArtist = scanner.nextLine();

            MusicAlbum album = new MusicAlbum(albumName, albumArtist);


            System.out.print("Введіть кількість пісень для альбому " + i + ": ");
            int songCount = scanner.nextInt();
            scanner.nextLine();

            for (int j = 1; j <= songCount; j++) {
                MusicComposition song = enterComposition();
                album.addCompositionInAlbum(song);
            }

            albumsToRecord.add(album);
        }


        for (MusicAlbum album : albumsToRecord) {
            System.out.println("Альбом: " + album.getTitle() + " (" + album.getArtist() + ")");
            System.out.print("Записати цей альбом на диск? (так / ні): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("так")) {
                Command recordToDiskCommand = new RecordCollectionOnDiskCommand(disk, album);
                recordToDiskCommand.execute();
            }
        }
    }


    @Override
    public String getDescription() {
        return "Створити новий альбом.";
    }
}
