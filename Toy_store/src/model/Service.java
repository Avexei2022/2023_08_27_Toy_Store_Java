package model;


import model.lottery.Lottery;
import model.lottery.ToyOrder;
import model.toy.Toy;
import model.toy.ToyList;
import presenter.Presenter;

import java.util.ArrayList;
import java.util.Collections;


public class Service {

    private ToyList<Toy> toy_list;
    private Lottery<ToyOrder> lottery;
    private File_IO file_io;


    public Service() {
        toy_list = new ToyList<>();
        lottery = new Lottery<>();
        file_io = new File_IO();
    }

    public ToyList<Toy> getToyList() {
        return toy_list;
    }

    public void setToyList(ToyList<Toy> toy_list) {
        this.toy_list = toy_list;
    }

    public String put_new_toy(String toyName, int toyWeight) {
        Toy toy = new Toy(toyName, toyWeight);
        toy_list.addToToysList(toy);
        return "\nВ список розыгрыша добавлена новая игрушка:\n" + toy + "\n";
    }

    public String printToyList() {
        toy_list.printToyList();
        return toy_list.toString();
    }

    public boolean checkIsId(int toyId) {
        return toy_list.checkIsId(toyId);
    }

    public String editToyWeight(int toyId, int toyWeight) {
        String string = "";
        for (Toy toy : toy_list) {
            if (toy.getId() == toyId) {
                toy.setWeight(toyWeight);
                string = "\nВес игрушки в розыгрыше изменен:\n" + toy + "\n";
            }
        }
        return string;
    }

    public boolean checkListIsEmpty() {
        return toy_list.checkIsEmpty();
    }

    public String deleteToy(int toyId) {
        String string = "";
        if (toy_list.removeToy(toy_list.getById(toyId))) {
            string = "\nИгрушка удалена из списка.\n";
        }
        return string;
    }

    public String loadToyList() {
        String string = "\nФайл не найден, или его содержимое не поддерживается.";
        boolean flag = false;
        try {
            setToyList((ToyList<Toy>) file_io.load());
            flag = true;
        } catch (Exception ignored) {
        }
        if (flag) {
            string = "\nДанные из файла " + file_io.fileNameToy + " успешно загружены.\n";
        }
        return string;
    }

    public String saveToyList() {
        String string = "\nЧто-то пошло не так.";
        if (file_io.save(toy_list)) {
            string = "\nДанные успешно записаны в файл " + file_io.fileNameToy + " .\n";
        }
        return string;
    }

    public String toy_lottery() {
        if (toy_list.getSize() < 3) {
            return "\nВ списке на розыгрыш должно быть не менее 3 наименований игрушек.\n" +
                    "В существующем списке игрушек - " + toy_list.getSize() + ".\n";
        } else {
            ArrayList<ToyOrder> lotteryList = create_arrayList_for_lottery();
            lottery.setAll(lotteryList);
        }
        return run_lottery();
    }

    private ArrayList<ToyOrder> create_arrayList_for_lottery() {
        ArrayList<ToyOrder> lotteryList = new ArrayList<>();
        int count = 0;
        while (count < 10) {
            for (Toy toy : toy_list) {
                for (int i = 0; i < toy.getWeight(); i++) {
                    lotteryList.add(new ToyOrder(count, toy));
                    count++;
                }
            }
        }
        Collections.shuffle(lotteryList);
        return lotteryList;
    }

    private String run_lottery(){
        Presenter presenter = new Presenter();
        StringBuilder stringBuilder = new StringBuilder();
        int toy_count = lottery.getSize();
        String string;
        stringBuilder.append("В банке лотереи игрушек: " + toy_count + "\nВыйграны следующие игрушки:\n");
        presenter.print_info("\nРазыгрывается игрушек: " + toy_count);
        boolean flag = true;
        while (flag){
            if(!lottery.checkIsEmpty()){
                string = lottery.getItem().getToy().getName();
                stringBuilder.append(string + "\n");
                presenter.print_info("\nУра! Вы выграли игрушку: " + string);
                if (!lottery.checkIsEmpty()){
                    String checkNo = presenter.printDialog(
                            "\nВ розыгрыше осталось игрушек: " + lottery.getSize() + "\n" +
                                    "\nДля продолжения розыгрыша нажмите клавишу Enter.\n" +
                                    "Если не желаете продолжать розыгрыш введите No.\n" +
                                    "Продолжить: ");
                    if (checkNo.equalsIgnoreCase("no")) {
                        flag = false;
                        presenter.print_info("\nЖаль, не все игрушки разыграны.\nОстались не разыграны следующие игрушки:\n");
                        stringBuilder.append("Пользователь не пожелал завершить розыгрыш всех игрушек.\n" +
                                "Остались не разыграны следующие игрушки:\n");
                        while (!lottery.checkIsEmpty()) {
                            string = lottery.getItem().getToy().getName();
                            stringBuilder.append(string + "\n");
                            presenter.print_info(string);
                        }
                    }
                }
            } else {
                flag = false;
            }
        }
        file_io.file_writer(stringBuilder.toString());
        return "\nРозыгрыш игрушек завершен.\nРезультаты розыгрыша записаны в файл " + file_io.fileNameResult + "\n";
    }


}
