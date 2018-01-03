package com.radauer.mathrix.tasks;

import com.radauer.mathrix.Mathrix;

/**
 * Created by Andreas on 03.01.2018.
 */
public class TaskList implements Task {

    private Task[] tasks;

    public TaskList(Task... tasks) {
        this.tasks = tasks;
    }

    @Override
    public void calc(Mathrix mathrix) {
        for (Task task : tasks) {
            task.calc(mathrix);
        }

    }
}
