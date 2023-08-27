package presenter;

import model.Service;
import view.ConsoleUI;
import view.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public Presenter() {

    }

    public void put_new_toy(String toy_name, int toy_weight) {
        String info = service.put_new_toy(toy_name, toy_weight);
        view.printAnswer(info);
    }

    public void printToyList() {
        String info = service.printToyList();
        view.printAnswer(info);
    }

    public void clearToyList() {
        String info = service.getToyList().clearToyList();
        view.printAnswer(info);
    }

    public boolean checkIsId(int toyId) {
        return service.checkIsId(toyId);
    }

    public void editToyWeight(int toyId, int toyWeight) {
        String info = service.editToyWeight(toyId, toyWeight);
        view.printAnswer(info);
    }

    public boolean checkListIsEmpty() {
        return service.checkListIsEmpty();
    }

    public void deleteToy(int toyId) {
        String info = service.deleteToy(toyId);
        view.printAnswer(info);
    }

    public void loadToyList() {
        String info = service.loadToyList();
        view.printAnswer(info);
    }

    public void saveToyList() {
        String info = service.saveToyList();
        view.printAnswer(info);
    }

    public void toy_lottery() {
        String info = service.toy_lottery();
        view.printAnswer(info);
    }

    public String printDialog(String info){
        return new ConsoleUI().printDialog(info);
    }

    public void print_info(String info) {
        new ConsoleUI().printAnswer(info);
    }
}


