package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public abstract class Command {
    protected String name;
    protected ConsoleUI view;

    public Command(String name, ConsoleUI view) {
        this.name = name;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public abstract void exec();
}