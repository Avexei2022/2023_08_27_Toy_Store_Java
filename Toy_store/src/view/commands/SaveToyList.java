package view.commands;

import view.ConsoleUI;

public class SaveToyList extends Command{
    public SaveToyList(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сохранить список игрушек в файл;";
    }
    public void execute(){
        consoleUI.saveToyList();
    }
}
