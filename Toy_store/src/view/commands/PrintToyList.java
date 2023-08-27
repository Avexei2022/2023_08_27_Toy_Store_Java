package view.commands;

import view.ConsoleUI;

public class PrintToyList extends Command{
    public PrintToyList(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Показать список игрушек в розыгрыше;";
    }
    public void execute(){
        consoleUI.printToyList();
    }
}
