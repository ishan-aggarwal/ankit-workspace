package wolf_tasks;

import java.util.ArrayList;
import java.util.List;

public class Notebook {

    private String notebookName;
    private List<TaskList> taskLists;

    public Notebook(String notebookName) {
        this.notebookName = notebookName;
        this.taskLists = new ArrayList<TaskList>();
    }

    public void addTaskList(String taskListName) {

    }

    public void editTaskList(String taskListName) {

    }

    public void removeTaskList() {

    }

    private void rearrangeTaskList() {

    }

    public String getNotebookName() {
        return notebookName;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<TaskList> taskLists) {
        this.taskLists = taskLists;
    }

}
