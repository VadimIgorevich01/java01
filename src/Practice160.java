import java.util.*;

//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, 
//их необходимо считать, как одного человека с разными телефонами. 
//Вывод должен быть отсортирован по убыванию числа телефонов.
public class Practice160 {
    public static void main(String[] args) {
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
        filledPhBook = phoneBookObj.smartAddToBook(name2, numb2, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name1, numb3, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name3, numb4, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name4, numb5, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name4, numb6, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name5, numb7, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name5, numb8, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name4, numb9, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name5, numb10, filledPhBook);
        filledPhBook = phoneBookObj.smartAddToBook(name4, numb11, filledPhBook);

        System.out.println("Наша книга до сортировки:\n" + filledPhBook);
        LinkedHashMap <String, ArrayList <Integer>> sortedPhBook = new LinkedHashMap<>();
        sortedPhBook = phoneBookObj.sortMyBook(filledPhBook);
        System.out.println("Наша книга после сортировки(с LinkedHashMap):\n" + sortedPhBook);
        phoneBookObj.showSortedBook(filledPhBook); //если в задании имеется в виду, что вывод должен быть из именно HashMap без LinkedHashMap
        // то метод showSortedBook просто делает вывод с сортировкой
        // в идеале хотелось решить задачу, изменив хэш у метода HashMap, чтобы хэш был равен количеству телефонов у человека
        // чтобы его вывод был упорядочен по хэшу - по количеству телефонов в нашем случае, но я не смог этого добиться =)
    }
}

class PhoneBook {
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
    
    LinkedHashMap <String, ArrayList<Integer>> sortMyBook (HashMap <String, ArrayList<Integer>> phoneBook) {
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
                    sortedPhBook.put(key, phoneBook.get(key));
                }
            }
            phBookValues.remove(indexOfmaxNumbersPerson);
        }
        return sortedPhBook;
    }

    void showSortedBook (HashMap <String, ArrayList<Integer>> phoneBook) {
        ArrayList <ArrayList<Integer>> phBookValues = new ArrayList<>(phoneBook.values());
        System.out.println("Вывод отсортированной книги(не исользуя LinkedHashMap): ");
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
    }

}

