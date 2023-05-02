package edu.uaslp.objetos.taskslist;

public class InvalidDueDateException extends TaskListException{
    InvalidDueDateException() {
        super("Due date is set in the past");
    }
}
