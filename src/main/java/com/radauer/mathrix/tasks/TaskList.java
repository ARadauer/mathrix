package com.radauer.mathrix.tasks;

import com.radauer.mathrix.Mathrix;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of calculation tasks
 */
public class TaskList implements Task
{

    private List<Task> taskList = new ArrayList<>();

    public TaskList(Task... tasks)
    {
        for (Task task : tasks) {
            addTask(task);
        }
    }

    public TaskList addTask(Task task) {
        taskList.add(task);
        return this;
    }

    @Override
    public void calc(Mathrix mathrix)
    {
        for (Task task : taskList)
        {
            task.calc(mathrix);
        }

    }
}
