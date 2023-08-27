package view.commands;

import view.ConsoleUI;

public class LoadToyList extends Command{

        public LoadToyList(ConsoleUI consoleUI){
            super(consoleUI);
            description = "Загрузить список игрушек из файла;";
        }
        public void execute(){
            consoleUI.loadToyList();
        }

}
