

public class Building extends Card {
    private final int cost;
    private final int prestigePoints;
    private Phase actionPhase;
    private SerializableEffect effectStrategy;

    public Building(int cost, int prestigePoints, int age, int id, Phase actionPhase, SerializableEffect effectStrategy) {
        this.cost = cost;
        this.prestigePoints = prestigePoints;
        this.actionPhase = actionPhase;
        this.effectStrategy = effectStrategy;
        super(age, id);
    }

    public int getCost() {
        return cost;
    }
    public int getPrestigePoints() {
        return prestigePoints;
    }
    public Phase getActionPhase() {
        return actionPhase;
    }

    @Override
    public void applyEffect(Player player, Game game) {
        this.effectStrategy.effect(player, game);
    }

    @Override
    public boolean isPickable(Player player) {
        if (player.getNumFood() < cost) return false;
        return true;
    }
}
