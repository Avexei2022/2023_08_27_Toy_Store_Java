package view;
import presenter.Presenter;
import java.util.Scanner;
public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "\nВы ввели неверное значение\n";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;
    String user_string;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
        user_string = "";
    }
    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public String printDialog(String text) {
        System.out.print(text);
        return scanner.nextLine().trim();
    }

    public void run() {
        System.out.println("\nМАГАЗИН ИГРУШЕК (Розыгрыш).\n");
        while (work){
            System.out.println(menu.printMenu());
            execute();
        }
        System.out.println("\nМАГАЗИН ИГРУШЕК (Розыгрыш). Программа закрыта.\n");
    }

    private void execute(){
        System.out.print("Введите цифру соответствующего пункта меню: ");
        String string = scanner.nextLine();
        if (checkTextForInt(string)){
            int numCommand = Integer.parseInt(string);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }


    private boolean checkTextForInt(String string){
        if (string.matches("[1-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        int size = menu.getSize();
        if (numCommand <= size){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void put_new_toy(){
        System.out.println("\nВвод новой игрушки для розыгрыша.");
        String toy_name = checkNameInput();
        int toy_weight = checkWeightInput();
        presenter.put_new_toy(toy_name, toy_weight);
    }

    public void printToyList() {
        presenter.printToyList();
    }

    public void exit() {
        work = false;
    }

    public void toy_lottery() {
        presenter.toy_lottery();
    }

    public void clearToyList() {
        if(!presenter.checkListIsEmpty()) {
            System.out.print("\nСписок игрушек будет очищен.\n" +
                    "Для подтверждения введите 'Yes': ");
            String string = scanner.nextLine().trim();
            if (string.equalsIgnoreCase("yes")) {
                presenter.clearToyList();
            }
        } else {
            System.out.println("\nСписок игрушек пуст.\n");
        }
    }

    public void editToyWeight() {
        if(!presenter.checkListIsEmpty()) {
            presenter.printToyList();
            int toy_id = checkIdInput();
            int toy_weight = checkWeightInput();
            presenter.editToyWeight(toy_id, toy_weight);
        } else {
            System.out.println("\nСписок игрушек пуст.\n");
        }
    }

    public void deleteToy() {
        if(!presenter.checkListIsEmpty()) {
            presenter.printToyList();
            int toy_id = checkIdInput();
            presenter.deleteToy(toy_id);
        } else {
            System.out.println("\nСписок игрушек пуст.\n");
        }
    }

    public void loadToyList() {
        System.out.print("""

                Загрузка данных из файла. Текущий список игрушек будет удален.
                Для подтверждения введите "Yes":\s""");
        String str = scanner.nextLine();
        if (str.equalsIgnoreCase("Yes")){
            presenter.loadToyList();
            printToyList();
        } else {
            System.out.println("Действие отменено.");
        }
    }

    public void saveToyList() {

        System.out.print("""

                Сохранение в файл. Данные в файле будут заменены.
                Для подтверждения введите "Yes":\s""");
        String str = scanner.nextLine();
        if (str.equalsIgnoreCase("Yes")){
            System.out.println("Загружаю в файл следующий список игрушек:\n");
            printToyList();
            presenter.saveToyList();
        } else {
            System.out.println("\nДействие отменено.\n");
        }
    }

    private int checkWeightInput(){
        int toy_weight = 0;
        boolean flag = true;
        while (flag) {
            System.out.print("\nВведите вес для выпадения игрушки (от 1 до 10): ");
            try {
                toy_weight = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception ignore) {
            }
            if (toy_weight > 0 && toy_weight <= 10) {
                flag = false;
            } else {
                System.out.println("Условия ввода не выполнены!");
            }
        }
        return toy_weight;
    }

    private int checkIdInput(){
        int toy_id = -1;
        boolean flag = true;
        while (flag) {
            System.out.print("\nВведите ID игрушки из списка: ");
            try {
                toy_id = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception ignore) {
            }
            if (presenter.checkIsId(toy_id)) {
                flag = false;
            } else {
                System.out.println("Игрушки с таким ID в списке нет!");
            }
        }
        return toy_id;
    }

    private String checkNameInput(){
        String toy_name = "";
        boolean flag = true;
        while (flag) {
            System.out.print("\nВведите наименование игрушки: ");
            toy_name = scanner.nextLine().trim();
            if (toy_name.matches("\\p{L}*")){
                flag = false;
            } else {
                System.out.println("\nИспользуйте буквы в наименовании игрушки!");
            }
        }
        return toy_name;
    }

}
