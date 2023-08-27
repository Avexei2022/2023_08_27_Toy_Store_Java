package view;

import view.commands.Command;
import view.commands.Exit;
import view.commands.Put_new_toy;
import view.commands.PrintToyList;
import view.commands.EditToyWeight;
import view.commands.DeleteToy;
import view.commands.ClearToyList;
import view.commands.SaveToyList;
import view.commands.LoadToyList;
import view.commands.Toy_lottery;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new Put_new_toy(consoleUI));
        commandList.add(new PrintToyList(consoleUI));
        commandList.add(new EditToyWeight(consoleUI));
        commandList.add(new DeleteToy(consoleUI));
        commandList.add(new ClearToyList(consoleUI));
        commandList.add(new SaveToyList(consoleUI));
        commandList.add(new LoadToyList(consoleUI));
        commandList.add(new Toy_lottery(consoleUI));
        commandList.add(new Exit(consoleUI));

    }
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}
