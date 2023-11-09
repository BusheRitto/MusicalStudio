package CommandForMusicAlbum;

import Command.Command;
import MusicAlbum.MusicAlbum;
import MusicComposition.MusicComposition;
import Disk.Disk;

import java.util.Scanner;

import static org.example.Main.chooseAlbum;

public class RemoveCompositionFromAlbumCommand implements Command {

    private Disk disk;

    public RemoveCompositionFromAlbumCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        MusicAlbum selectedAlbum = chooseAlbum(disk);
        if (selectedAlbum == null) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Композиції у альбомі - " + selectedAlbum.getTitle());
        System.out.println(selectedAlbum);
        System.out.println("Введіть назву композиції, яку бажаєте видалити - ");
        String name = scanner.nextLine();
        for (MusicComposition composition : selectedAlbum.getAlbum()) {
            if (name.toLowerCase().equals(composition.getName().toLowerCase())) {
                selectedAlbum.removeCompositionInAlbum(composition);
                System.out.println("Композицію успішно видалено з альбому " + selectedAlbum.getTitle());
                return;
            }
        }
        System.out.println("Задану композицію не знайдено в альбомі.");
    }


    @Override
    public String getDescription() {
        return "Видалити задану композицію з альбому.";
    }
}
