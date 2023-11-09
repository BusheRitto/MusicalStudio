package CommandForDisk;

import Disk.Disk;
import Command.Command;

public class RearrangeCompositionsByStyleCommand implements Command {
    private Disk disk;

    public RearrangeCompositionsByStyleCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        disk.rearrangeCompositionsByStyle();
    }

    @Override
    public String getDescription() {
        return "Перестановка композицій диску на основі " +
                "належності до стилю.";
    }
}
