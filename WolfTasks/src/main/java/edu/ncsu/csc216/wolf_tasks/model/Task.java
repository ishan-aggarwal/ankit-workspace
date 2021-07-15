package edu.ncsu.csc216.wolf_tasks.model;

public class Task {

    private String taskName;
    private boolean isActive;
    private boolean isRecurring;
    private boolean isCompleted;
    private int priorityNumber;
    private String description;

    public Task(String taskName, boolean isActive, boolean isRecurring, boolean isCompleted,
                int priorityNumber, String description) {
        this.taskName = taskName;
        this.isActive = isActive;
        this.isRecurring = isRecurring;
        this.isCompleted = isCompleted;
        this.priorityNumber = priorityNumber;
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", isActive=" + isActive +
                ", isRecurring=" + isRecurring +
                ", isCompleted=" + isCompleted +
                ", priorityNumber=" + priorityNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
