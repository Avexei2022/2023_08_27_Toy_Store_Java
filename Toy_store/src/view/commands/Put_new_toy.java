package view.commands;

import view.ConsoleUI;

public class Put_new_toy extends Command{
    public Put_new_toy(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Ввод новой игрушки для розыгрыша;";
    }
    public void execute() {
        consoleUI.put_new_toy();
    }
}
