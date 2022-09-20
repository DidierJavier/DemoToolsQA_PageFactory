package co.com.sofka.util.subjects;

public enum Subject {
    MATH("Maths"),
    ENGLISH("English"),
    BIOLOGY("Biology"),
    CHEMISTRY("Chemistry"),
    PHYSICS("Physics"),
    ACCOUNTING("Accounting"),
    ARTS("Arts"),
    COMMERCE("Commerce"),
    ECONOMICS("Economics"),
    HINDI("Hindi"),
    HISTORY("History");

    private final String value;

    public String getValue() {
        return value;
    }

    Subject(String value) {this.value = value;}
}
