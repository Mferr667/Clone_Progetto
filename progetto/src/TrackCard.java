public class TrackCard {
    private Player playerTotem;
    private final char name;
    private final int numPicksTop;
    private final int numPicksBottom;
    private final int numFood;

    protected TrackCard(char name, int numPicksTop, int numPicksBottom, int numFood) {
        this.playerTotem = null;
        this.name = name;
        this.numPicksTop = numPicksTop;
        this.numPicksBottom = numPicksBottom;
        this.numFood = numFood;
    }

    protected void setPlayerTotem(Player playerTotem) {
        this.playerTotem = playerTotem;
    }

    protected Player getPlayerTotem() {
        return playerTotem;
    }

    protected char getName() {
        return name;
    }

    protected int getNumPicksTop() {
        return numPicksTop;
    }

    protected int getNumPicksBottom() {
        return numPicksBottom;
    }

    protected int getNumFood() {
        return numFood;
    }


    protected void effect(){
        playerTotem.setNumTopPicksLeft(numPicksTop);
        playerTotem.setNumBottomPicksLeft(numPicksBottom);
        playerTotem.setNumFood(playerTotem.getNumFood() + numFood);

    }

}
