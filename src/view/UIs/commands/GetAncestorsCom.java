package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class GetAncestorsCom extends Command{
    public GetAncestorsCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getAncestors();
    }
}