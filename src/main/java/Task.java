/**
 * An abstract class representing a task (which has a description, and completion status).
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for a task, whose completion status is
     * initially set to not done upon initialisation.
     *
     * @param description The task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean completed) {
        this.description = description;
        this.isDone = completed;
    }

    /**
     * Returns the status icon of the task, completed tasks
     * are represented with an 'X'.
     *
     * @return An icon representing the completion status of the task
     */
    public String getStatusIcon() {
        return (this.isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as completed.
     */
    public void markTaskAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not completed.
     */
    public void markTaskAsUndone() {
        this.isDone = false;
    }

    public static TaskType readSavedTaskType(char data) throws DukeException {
        switch (data) {
            case 'T':
                return TaskType.TODO;
            case 'D':
                return TaskType.DEADLINE;
            case 'E':
                return TaskType.EVENT;
            default:
                throw new DukeException("Duke found an unknown data type: " + data);
        }
    }

    public abstract String toSaveFormat();

    /**
     * Returns a string representation for the task, indicating
     * the completion status of the task, followed by the task description.
     *
     * @return The string representation of the task
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), this.description);
    }
}
