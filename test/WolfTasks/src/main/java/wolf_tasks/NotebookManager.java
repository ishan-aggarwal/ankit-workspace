package wolf_tasks;

public class NotebookManager {

    private static NotebookManager INSTANCE;
    private Notebook notebook;
    private TaskList currentTaskList;
    private TaskList activeTaskList;

    private NotebookManager() {

    }

    public static NotebookManager getInstance() {
        return null;
    }

    public void createNoteBook(String notebookName) {

    }

    public void quit() {

    }

    public void loadFromFile(String fileName) {

    }

    public void saveToFile(String fileName) {

    }

    public TaskList getActiveTaskList() {
        return null;
    }

    public TaskList getCurrentTaskList() {
        return currentTaskList;
    }

    public void setCurrentTaskList(TaskList currentTaskList) {
        this.currentTaskList = currentTaskList;
    }

    public void updateActiveTaskList() {

    }

}
