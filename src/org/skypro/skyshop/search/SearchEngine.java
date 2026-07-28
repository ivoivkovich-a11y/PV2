package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final List<Searchable> searchables;

    public SearchEngine(int size) {this.searchables = new ArrayList<>(size);}

    public void add(Searchable searchable) {
        if (searchables.size() < searchables.size()) {
            searchables.add(searchable);
        } else {
            System.out.println("Массив заполнен");
        }
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable item : searchables) {
            if (item.getSearchTerm().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }

    public class BestResultNotFound extends Exception {
        public BestResultNotFound(String query) {super("Не найден подходящий результат для запроса: " + query);}
    }

    public Searchable findMostRelevant(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound(search);
        }

        Searchable best = null;
        int maxCount = 0;

        for (Searchable item : searchables) {
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
