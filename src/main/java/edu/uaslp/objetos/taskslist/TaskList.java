package edu.uaslp.objetos.taskslist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TaskList {

    private TreeSet<Task> tasklist;

    public TaskList() {
        tasklist = new TreeSet<Task>();
    }

    public void add(Task task) {
        tasklist.add(task);
    }

    public void remove(Task task) {
        tasklist.remove(task);
    }

    public Task find(String title) throws TaskNotFoundException{

        Iterator iterator = tasklist.iterator();
        while(iterator.hasNext()) {
            Task currentTask = (Task) iterator.next();
            if(currentTask.getTitle() == title) {
                return currentTask;
            }
        }
        throw new TaskNotFoundException(title);
    }

    public void markAsDone(String title) throws TaskNotFoundException {
        Task task = find(title);
        task.setDone(true);
    }

    public void markAsNotDone(String title) throws TaskNotFoundException {
        Task task = find(title);
        task.setDone(false);
    }

    public Task getNextTask() { //should probably add a check for undone tasks
        Task testTask = new Task(LocalDateTime.now());
        TreeSet<Task> nextTasks = new TreeSet<Task>();
        nextTasks = (TreeSet<Task>)tasklist.tailSet(testTask);
        return (Task) nextTasks.first();
    }

    public List<Task> getNextTasks() { //should probably add a check for undone tasks
        Task testTask = new Task(LocalDateTime.now());
        TreeSet<Task> nextTasks = (TreeSet<Task>)tasklist.tailSet(testTask);

        List<Task> nextTaskList = new ArrayList<Task>();
        for(Task t : nextTasks) {
            if(!t.isDone()) {
                nextTaskList.add(t);
            }
        }

        return nextTaskList;
    }

    public int getSize() {
        return tasklist.size();
    }
}
