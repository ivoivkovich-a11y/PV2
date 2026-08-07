package org.skypro.skyshop.search;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final Set<Searchable> searchables;

    // Компаратор для сортировки: сначала по длине имени (от длинного к короткому), затем по натуральному порядку
    private static final Comparator<Searchable> SEARCH_RESULT_COMPARATOR = (s1, s2) -> {
        int lengthComparison = Integer.compare(s2.getName().length(), s1.getName().length());
        if (lengthComparison != 0) {
            return lengthComparison;
        }
        return s1.getName().compareTo(s2.getName());
    };

    // Конструктор
    public SearchEngine(int size) {
        this.searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    // Возвращает отсортированный Set (сортировка: от длинного имени к короткому, затем по натуральному порядку)
    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(SEARCH_RESULT_COMPARATOR);
        int count = 0;
        for (Searchable item : searchables) {
            if (item.getSearchTerm().contains(query)) {
                results.add(item);
                count++;
                if (count == 5) {
                    break;
                }
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
