package CommandForDisk;

import Command.Command;
import Disk.Disk;
import MusicAlbum.MusicAlbum;

import static org.example.Main.chooseAlbum;

public class DeleteCollectionFromDiskCommand implements Command {
    private Disk disk;


    public DeleteCollectionFromDiskCommand(Disk disk) {
        this.disk = disk;

    }

    @Override
    public void execute() {

        MusicAlbum selectedAlbum = chooseAlbum(disk);
        if (selectedAlbum == null) {
            return;
        }
        disk.deleteAlbumFromDisk(selectedAlbum);
        System.out.println("Альбом успішно видалено!");

    }

    @Override
    public String getDescription() {
        return "Видалити альбом із диску.";
    }
}