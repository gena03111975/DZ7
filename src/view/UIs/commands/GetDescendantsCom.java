package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class GetDescendantsCom extends Command{
    public GetDescendantsCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getDescendants();
    }
}