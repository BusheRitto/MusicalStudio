package CommandForDisk;

import MusicComposition.MusicComposition;
import Command.Command;
import Disk.Disk;

import java.util.ArrayList;
import java.util.Scanner;

public class FindCompositionByLengthCommand implements Command {
    private Disk disk;


    public FindCompositionByLengthCommand(Disk disk) {
        this.disk = disk;

    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        double r1 = 0, r2 = 0;
        while (r1 < 0 || r2 <= 0) {
            System.out.println("Введіть діапазон для пошуку від 0.");
            System.out.println("Від - ");
            r1 = scan.nextDouble();
            System.out.println("До - ");
            r2 = scan.nextDouble();
        }
        ArrayList<MusicComposition> composition = disk.findCompositionByLenghtOfTracks(r1, r2);
        System.out.println(composition);


    }

    @Override
    public String getDescription() {
        return "Знайти композицію, що відповідає заданому діапазону довжини треків.";
    }
}
