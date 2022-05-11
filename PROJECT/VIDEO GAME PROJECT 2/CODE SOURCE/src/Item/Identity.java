package Item;

public class Identity {

    private final int value;
    private final String name;
    private final String description;

    public Identity(int value, String name, String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}