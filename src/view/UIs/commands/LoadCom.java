package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class LoadCom extends Command{
    public LoadCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.load();
    }
}