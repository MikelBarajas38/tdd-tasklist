package edu.uaslp.objetos.taskslist;

public class TaskNotFoundException extends TaskListException{
    public TaskNotFoundException(String title) {
        super("Task with title '" + title + "' not found");
    }
}
