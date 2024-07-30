package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class ExitCom extends Command{
    public ExitCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.exit();
    }
}