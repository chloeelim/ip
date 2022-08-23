package duke.command;

import duke.Storage;
import duke.Ui;
import duke.exception.DukeException;
import duke.task.TaskList;

public class ExitCommand extends Command {
    public ExitCommand() {
        this.stillRunning = false;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) throws DukeException {
        Ui.prettyPrint("Bye. Hope to see you again soon!");
        storage.writeToFile(tasks.toSaveFormat());
    }
}