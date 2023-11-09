package CommandForMusicAlbum;

import Command.Command;
import CommandForDisk.RecordCollectionOnDiskCommand;
import Disk.Disk;
import MusicAlbum.MusicAlbum;
import ReadMusicAlbumFromFile.ReadMusicAlbumFromFile;

import java.util.ArrayList;


public class ReadMusicAlbumsFromFileCommand implements Command {
    private Disk disk;

    public ReadMusicAlbumsFromFileCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        ReadMusicAlbumFromFile read_from_file = new ReadMusicAlbumFromFile();
        ArrayList<MusicAlbum> albums = read_from_file.readMusicAlbums();
        for (MusicAlbum album : albums) {
            Command recordToDiskCommand = new RecordCollectionOnDiskCommand(disk, album);
            recordToDiskCommand.execute();
        }

    }

    @Override
    public String getDescription() {
        return "Зчитати музичні альбоми з файлу та записати їх на диск.";
    }

}
