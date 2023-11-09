package CommandForDisk;

import Command.Command;
import Disk.Disk;
import MusicAlbum.MusicAlbum;

import static org.example.Main.chooseAlbum;

public class ShowAlbumsOnDiskCommand implements Command {
    private Disk disk;


    public ShowAlbumsOnDiskCommand(Disk disk) {
        this.disk = disk;

    }

    @Override
    public void execute() {
        MusicAlbum selectedAlbum = chooseAlbum(disk);
        if (selectedAlbum == null) {
            return;
        }
        System.out.println(selectedAlbum);
    }

    @Override
    public String getDescription() {
        return "Доступні альбоми на диску.";
    }
}
