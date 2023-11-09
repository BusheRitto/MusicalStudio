package CommandForDisk;

import Command.Command;
import Disk.Disk;
import MusicAlbum.MusicAlbum;

public class RecordCollectionOnDiskCommand implements Command {
    private Disk disk;

    private MusicAlbum album;

    public RecordCollectionOnDiskCommand(Disk disk, MusicAlbum album) {
        this.disk = disk;
        this.album = album;
    }

    @Override
    public void execute() {
        disk.recordAlbumOnDisk(album);
        System.out.println("Альбом з назвою " + album.getTitle() + " успішно додано на диск!");
    }

    @Override
    public String getDescription() {
        return "Записати альбом на диск.";
    }
}
