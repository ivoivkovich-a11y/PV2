package org.skypro.skyshop.search;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private final Searchable[] searchables;

    // Конструктор
    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
        System.out.println("Массив заполнен");
    }

    // Возвращает отсортированную по имени мапу (ключ — имя, значение — сам объект Searchable)
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        int count = 0;

        for (Searchable item : searchables) {
            if (item == null) {
                continue;
            }

            if (item.getSearchTerm().contains(query)) {
                results.put(item.getName(), item);
                count++;

                if (count == 5) {
                    break;
                }
            }
        }

        return results;
    }

    public class BestResultNotFound extends Exception {
        public BestResultNotFound(String query) {
            super("Не найден подходящий результат для запроса: " + query);
        }
    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound(search);
        }

        Searchable best = null;
        int maxCount = 0;

        for (Searchable item : searchables) {
            if (item == null) {
                continue;
            }

            String term = item.getSearchTerm();
            int count = countOccurrences(term, search);

            if (count > maxCount) {
                maxCount = count;
                best = item;
            }
        }

        if (best == null) {
            throw new BestResultNotFound(search);
        }

        return best;
    }

    private int countOccurrences(String str, String substring) {
        if (str == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        int foundIndex = str.indexOf(substring, index);

        while (foundIndex != -1) {
            count++;
            index = foundIndex + substring.length();
            foundIndex = str.indexOf(substring, index);
        }
        return count;
    }
}