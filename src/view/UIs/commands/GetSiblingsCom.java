package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class GetSiblingsCom extends Command{
    public GetSiblingsCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getSiblings();
    }
}