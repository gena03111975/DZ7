package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class SetParentCom extends Command{
    public SetParentCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.setParent();
    }
}