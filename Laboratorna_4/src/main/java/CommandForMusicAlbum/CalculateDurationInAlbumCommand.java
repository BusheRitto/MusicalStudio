package CommandForMusicAlbum;

import Command.Command;
import MusicAlbum.MusicAlbum;

import java.util.ArrayList;

import Disk.Disk;

import static org.example.Main.chooseAlbum;

public class CalculateDurationInAlbumCommand implements Command {
    private Disk disk;

    public CalculateDurationInAlbumCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        MusicAlbum selectedAlbum = chooseAlbum(disk);
        if (selectedAlbum == null) {
            return;
        }
        ArrayList<Double> res = selectedAlbum.calculateTheDuration();
        double roundedHours = Math.round(res.get(1) * 10.0) / 10.0;
        System.out.println("Тривалість альбому " + selectedAlbum.getTitle() + " " + res.get(0) + " хвилин - " + roundedHours + " годин.");


    }

    @Override
    public String getDescription() {
        return "Порахувати тривалість альбому.";
    }
}
