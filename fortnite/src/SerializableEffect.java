
@FunctionalInterface //In order to have only 1 method
public interface SerializableEffect {
    void effect(Player player, Game game);
}
