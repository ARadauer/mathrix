package com.radauer.mathrix.tasks;

import com.radauer.mathrix.Mathrix;

/**
 * A list of calculation tasks
 */
public class TaskList implements Task
{

    private Task[] tasks;

    public TaskList(Task... tasks)
    {
        this.tasks = tasks;
    }

    @Override
    public void calc(Mathrix mathrix)
    {
        for (Task task : tasks)
        {
            task.calc(mathrix);
        }

    }
}
