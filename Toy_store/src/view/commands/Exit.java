package view.commands;

import view.ConsoleUI;

public class Exit extends Command{
    public Exit(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Выход;";
    }
    public void execute() {
        consoleUI.exit();
    }
}
