package org.skypro.skyshop.search;

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

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (Searchable item : searchables) {
            if (item == null) {
                continue;
            }

            if (item.getSearchTerm().contains(query)) {
                results[count] = item;
                count++;

                if (count == 5) {
                    break;
                }
            }
        }

        return results;
    }
    public void
}