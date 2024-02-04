import java.util.*;

// введены имена и телефоны
// программа пакует их в хэшМэп
// с учетом повторяющихся имен, ключ - имя

// вывод. создать массив массивов из значений.
// каждый элемент этого массва имеет свою длину
// сделать сортировку по этой длине, от большего к меньшему
// создаем цикл вывода. колво итераций равно колву элементов
// в итерации саут получаем ключ из мэпа по значению элемента массива, получаем значение по найденому ключу
public class Practice160 {
    public static void main(String[] args) {
        System.out.println("test");

        String name1 = "Anton"; //2 тел
        String name2 = "Oleg"; //1 тел
        String name3 = "Artur"; //1 тел
        String name4 = "Anna"; //4 тел
        String name5 = "Rita"; //3 тел
        int numb1 = 1234567;
        int numb2 = 1111111;
        int numb3 = 1222222;
        int numb4 = 7654321;
        int numb5 = 1001000;
        int numb6 = 2455481;
        int numb7 = 2429241;
        int numb8 = 2429291;
        int numb9 = 2429291;
        int numb10 = 2439291;
        int numb11 = 2122134;

        PhoneBook phoneBookObj = new PhoneBook();
        HashMap <String, ArrayList<Integer>> emptyPhBook = new HashMap<>();
        HashMap <String, ArrayList<Integer>> filledPhBook = phoneBookObj.smartAddToBook(name1, numb1, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name2, numb2, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name1, numb3, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name3, numb4, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name4, numb5, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name4, numb6, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name5, numb7, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name5, numb8, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name4, numb9, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name5, numb10, emptyPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name4, numb11, emptyPhBook);
        System.out.println(filledPhBook.entrySet());
        phoneBookObj.showSortedBook(filledPhBook);
    }
}

class PhoneBook {
    //HashMap <String, ArrayList<Integer>> phoneBook = new HashMap<>();

    HashMap <String, ArrayList<Integer>> smartAddToBook (String name, int number, HashMap <String, ArrayList<Integer>> phoneBook) {
        if (phoneBook.containsKey(name)) {
            ArrayList <Integer> numbersPhBook = new ArrayList<>(phoneBook.get(name));
            numbersPhBook.add(number);
            phoneBook.put(name, numbersPhBook);
        }
        else {
            ArrayList <Integer> numbersPhBook = new ArrayList<>();
            numbersPhBook.add(number);
            phoneBook.put(name, numbersPhBook);
        }
        return phoneBook;
    }
    LinkedHashMap showSortedBook (HashMap <String, ArrayList<Integer>> phoneBook) {
        ArrayList <ArrayList<Integer>> phBookValues = new ArrayList<>(phoneBook.values());
        LinkedHashMap <String, ArrayList<Integer>> sortedPhBook = new LinkedHashMap<>();
        for (int index = 0; index < phBookValues.size() + index; index++) {
            int maxNumbersPerson = phBookValues.getFirst().size();
            int indexOfmaxNumbersPerson = 0;
            for (int i = 0; i < phBookValues.size(); i++) {
                if (maxNumbersPerson < phBookValues.get(i).size()) {
                    maxNumbersPerson = phBookValues.get(i).size();
                    indexOfmaxNumbersPerson = i;
                }
            }
            for (String key: phoneBook.keySet()) {
                if (phoneBook.get(key).equals(phBookValues.get(indexOfmaxNumbersPerson))) {
                    System.out.printf(key + "=" + phoneBook.get(key) + " ");

                }
            }
            phBookValues.remove(indexOfmaxNumbersPerson);
        }
        System.out.println();
        System.out.println(phBookValues);
    }
}

