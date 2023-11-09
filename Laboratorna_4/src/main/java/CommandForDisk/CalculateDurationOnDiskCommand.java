package CommandForDisk;

import Command.Command;
import Disk.Disk;

public class CalculateDurationOnDiskCommand implements Command {
    private Disk disk;


    public CalculateDurationOnDiskCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        double[] duration = disk.calculateTheDurationOnDisk();
        double roundedHours = Math.round(duration[1] * 10.0) / 10.0;
        System.out.println("Загальна тривалість на диску: " + duration[0] + " хвилин (" + roundedHours + " годин)");
    }

    @Override
    public String getDescription() {
        return "Підрахувати загальну тривалість кожного альбому на диску.";
    }


}
