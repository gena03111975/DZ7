package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class GetChildsCom extends Command{
    public GetChildsCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getChildren();
    }
}