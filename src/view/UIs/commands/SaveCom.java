package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class SaveCom extends Command {
    public SaveCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.save();
    }
}