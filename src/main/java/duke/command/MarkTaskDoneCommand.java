package duke.command;

import duke.Storage;
import duke.Ui;
import duke.exception.DukeException;
import duke.task.TaskList;

public class MarkTaskDoneCommand extends Command {
    private int taskNumber;

    public MarkTaskDoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) throws DukeException {
        // TODO: Integer.parseInt(cmd.substring(5))
        Ui.prettyPrint(tasks.markTaskDone(this.taskNumber));
    }
}