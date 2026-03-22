abstract public class Card {
    private final int age;
    private final int id;

    public Card(int age, int id) {
        this.age = age;
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }

    abstract public void applyEffect(Player player, Game game);
    abstract public boolean isPickable(Player player);
}
