package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class PrintTreeCom extends Command{
    public PrintTreeCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.printTree();
    }
}