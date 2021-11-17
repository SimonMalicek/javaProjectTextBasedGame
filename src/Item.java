public record Item(String name, String description) implements Describable {
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return (name + ":" + description);
    }
}
