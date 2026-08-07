package org.skypro.skyshop.search;

// Добавлено: implements Searchable
public final class Article implements Searchable {
    private final String nameArticle;
    private final String text;

    public Article(String nameArticle, String text) {
        this.nameArticle = nameArticle;
        this.text = text;
    }
    @Override
    public String toString() {
        return "Название статьи = " + nameArticle + " - Текст статьи = " + text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() { return toString();}

    // Реализация методов интерфейса Searchable
    @Override
    public String getName() {
        return nameArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return nameArticle.equals(article.nameArticle);
    }

    @Override
    public int hashCode() {
        return nameArticle.hashCode();
    }
}