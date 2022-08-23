import static org.junit.jupiter.api.Assertions.assertEquals;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.task.ToDo;
import org.junit.jupiter.api.Test;

public class TaskListTest {
    @Test
    public void accessTask_accessExistentTask_success() throws DukeException {
        TaskList tasklist = new TaskList();
        tasklist.addTask(new ToDo("Add JavaDocs"));
        tasklist.addTask(new ToDo("Fix Styling"));
        assertEquals(true, tasklist.isValidTask(2));
    }

    @Test
    public void accessTask_accessZeroTask_exceptionThrown() {
        try {
            TaskList tasklist = new TaskList();
            tasklist.addTask(new ToDo("Print out lab worksheet"));
            tasklist.isValidTask(0);
        } catch (DukeException e) {
            assertEquals("Hm... Duke can't find this task.", e.getMessage());
        }
    }

    @Test
    public void accessTask_accessInvalidNonexistentTask_exceptionThrown() {
        try {
            TaskList tasklist = new TaskList();
            tasklist.addTask(new ToDo("Buy bread"));
            tasklist.isValidTask(2);
        } catch (DukeException e) {
            assertEquals("Hm... Duke can't find this task.", e.getMessage());
        }
    }
}
