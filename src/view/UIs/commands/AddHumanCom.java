package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class AddHumanCom extends Command{
    public AddHumanCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        System.out.println("Adding...");
        view.addHuman();
    }
}