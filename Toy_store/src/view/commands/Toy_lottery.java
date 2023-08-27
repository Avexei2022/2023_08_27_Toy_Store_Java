package view.commands;

import view.ConsoleUI;

public class Toy_lottery extends Command{

    public Toy_lottery(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Провести розыгрыш игрушек;";
    }
    public void execute() {
        consoleUI.toy_lottery();
    }
}
