import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Printer152 {
    public static void main(String[] args) {
        PhoneBook1 phoneBook = new PhoneBook1();
        String name1 = "Ivanov";
        String name2 = "Petrov";
        String name3 = "Petrov";
        int phone1 = 123456;
        int phone2 = 654321;
        int phone3 = 987654;
        phoneBook.add(name1, phone1);
        phoneBook.add(name2, phone2);
        phoneBook.add(name3, phone3);
        System.out.println(phoneBook.find("Ivanov"));
        System.out.println(phoneBook.find("Petrov"));
        System.out.println(phoneBook.find("me"));
        System.out.println(phoneBook.getPhoneBook());

    }
}

class PhoneBook1 {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        ArrayList <Integer> phNumArrayList = new ArrayList<>(Collections.singleton(phoneNum));
        if (phoneBook.containsKey(name)) {
            ArrayList <Integer> tempArrList = new ArrayList<>(phoneBook.get(name));
            tempArrList.add(phoneNum);
            phoneBook.put(name, tempArrList);
        }
        else {
            phoneBook.put(name, phNumArrayList);
        }
        System.out.println(phoneBook.entrySet());
    }

    public ArrayList<Integer> find(String name) {
        if (phoneBook.get(name) == null) {
            return new ArrayList<>();
        }
        else {
            return phoneBook.get(name);
        }
    }

    public static HashMap <String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }
}
