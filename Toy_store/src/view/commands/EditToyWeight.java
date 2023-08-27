package view.commands;

import view.ConsoleUI;

public class EditToyWeight extends Command{

        public EditToyWeight(ConsoleUI consoleUI){
            super(consoleUI);
            description = "Редактировать вес игрушки в розыгрыше;";
        }
        public void execute(){
            consoleUI.editToyWeight();
        }
}
