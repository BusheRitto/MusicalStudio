package CommandForMusicAlbum;

import Command.Command;
import MusicAlbum.MusicAlbum;
import MusicComposition.MusicComposition;
import Disk.Disk;

import static org.example.Main.chooseAlbum;
import static org.example.Main.enterComposition;


public class AddCompositionInAlbumCommand implements Command {

    private Disk disk;


    public AddCompositionInAlbumCommand(Disk disk) {
        this.disk = disk;
    }


    @Override
    public void execute() {
        MusicAlbum selectedAlbum = chooseAlbum(disk);
        if (selectedAlbum == null) {
            return;
        }
        MusicComposition composition = enterComposition();
        selectedAlbum.addCompositionInAlbum(composition);
        System.out.println("Композицію успішно додано до альбому " + selectedAlbum.getTitle());

    }

    @Override
    public String getDescription() {
        return "Додати композицію в альбом.";
    }
}
