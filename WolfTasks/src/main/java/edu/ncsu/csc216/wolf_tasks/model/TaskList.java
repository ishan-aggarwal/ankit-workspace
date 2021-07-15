package edu.ncsu.csc216.wolf_tasks.model;

import java.util.List;

public class TaskList {

    private String taskListName;
    private List<Task> tasks;
    private int completedTasksCount;
    private Task currentTask;

    public TaskList(String taskListName) {
        this.taskListName = taskListName;
    }

    public void addTask(String taskName) {
    }

    public void editTask(String taskName) {

    }

    public void deleteTask(String taskName) {

    }

    public void moveTaskUp(String taskName) {

    }

    public void moveTaskDown(String taskName) {

    }

    public void moveTaskToFront(String taskName) {

    }

    public void moveTaskToBack(String taskName) {

    }

    public void getSortedTaskList() {

    }

    public void markTaskAsComplete(String taskName) {

    }

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getCompletedTasksCount() {
        return completedTasksCount;
    }

    public void setCompletedTasksCount(int completedTasksCount) {
        this.completedTasksCount = completedTasksCount;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "taskListName='" + taskListName + '\'' +
                ", tasks=" + tasks +
                ", completedTasksCount=" + completedTasksCount +
                '}';
    }
}
