package enums;

/**
 * Represents the symbol which can be put in the tic tac board
 */
public enum Symbol {
    X("X"), O("O"), EMPTY("");

    private final String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
