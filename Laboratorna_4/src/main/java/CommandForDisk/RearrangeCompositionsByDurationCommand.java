package CommandForDisk;


import Command.Command;
import Disk.Disk;

public class RearrangeCompositionsByDurationCommand implements Command {
    private Disk disk;

    public RearrangeCompositionsByDurationCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        this.disk.rearrangeCompositionsByDuration();
    }

    @Override
    public String getDescription() {
        return "Перестановка композицій за тривалістю.";
    }

}
