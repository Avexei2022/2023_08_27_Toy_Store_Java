package view.commands;

import view.ConsoleUI;

public class ClearToyList extends Command{

    public ClearToyList(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Очистить список игрушек в розыгрыше;";
    }
    public void execute() {
        consoleUI.clearToyList();
    }
}
