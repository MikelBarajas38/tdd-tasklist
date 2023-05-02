package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;

public class Task implements Comparable<Task> {

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean done;

    Task() {

    }

    public Task(String title, String description, LocalDateTime dueDate, boolean done) throws TaskListException {

        validateDate(dueDate);

        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.done = done;

    }

    Task(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) throws TaskListException{
        validateDate(dueDate);
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public int compareTo(Task o) {
        if(dueDate.isEqual(o.getDueDate())) {
            return 0;
        } else if (dueDate.isAfter(o.getDueDate())) {
            return 1;
        }
        return -1;
    }

    private void validateDate(LocalDateTime date) throws TaskListException {
        if(date.isBefore(LocalDateTime.now())) {
            throw new InvalidDueDateException();
        }
    }
}
