import java.util.HashMap;

public class Printer151 {
    public static void main(String[] args) {
        NamesCounter namesCounter = new NamesCounter();
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;
        name1 = "Elena";
        name2 = "Elena";
        name3 = "Elena";
        name4 = "Ivan";
        name5 = "Ivan";
        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);
        namesCounter.addName(name5);
        namesCounter.showNamesOccurrences();
    }

    static class NamesCounter {
        private HashMap<String, Integer> names = new HashMap<>();
        public void addName (String name) {
            int counter = 1;
            if (names.containsKey(name)) {
                counter = names.get(name);
                ++counter;
                names.put(name, counter);
            }
            else {
                names.put(name, counter);
            }
        }

        public void showNamesOccurrences() {
            System.out.println(names);
        }
    }
}
