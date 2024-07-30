package view.UIs.console;

import view.UIs.commands.*;
import view.UIs.helpers.CheckNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Command> commands;
    private ConsoleUI view;
    private boolean flag;
    private Scanner scanner;

    public Menu(ConsoleUI view) {
        this.commands = new ArrayList<>();
        this.view = view;
        scanner = new Scanner(System.in);
        flag = true;
        commands.add(new AddHumanCom("Добавить человека", view));
        commands.add(new GetHumanCom("Получить человека по ID", view));
        commands.add(new SetParentCom("Установить родителя", view));
        commands.add(new GetChildsCom("Показать детей", view));
        commands.add(new PrintTreeCom("Показать дерево", view));
        commands.add(new GetSiblingsCom("Показать братьев и сестер", view));
        commands.add(new GetAncestorsCom("Показать предков", view));
        commands.add(new GetDescendantsCom("Показать потомков", view));
        commands.add(new SaveCom("Сохранить", view));
        commands.add(new LoadCom("Загрузить", view));
        commands.add(new ExitCom("Выход", view));
    }

    void setFlag(boolean flag) {
        this.flag = flag;
    } // видно только ConsoleUI

    public void menu() {
        int choice;
        while (flag) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < commands.size(); i++) {
                sb.append(i + 1);
                sb.append(". ");
                sb.append(commands.get(i).getName());
                sb.append(System.lineSeparator());
            }
            System.out.println(sb.toString());
            String input = scanner.nextLine();
            if (CheckNumber.isNumber(input)){
                choice = Integer.parseInt(input);
                if (choice > 0 && choice <= commands.size())
                    commands.get(choice - 1).exec();
            }
        }
    }


}