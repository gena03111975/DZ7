package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class GetHumanCom extends Command{
    public GetHumanCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getById();
    }
}