import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Board {
    private TurnOrderCard turnOrderCard;
    private Map<Character, TrackCard> offersPath;
    private Stack<DeckableCard> tribeDeck;
    private Stack<Building> buildingDeck;
    private ArrayList<DeckableCard> topDeckableRow;
    private ArrayList<Building> topBuildingRow;
    private ArrayList<DeckableCard> bottomDeckableRow;
    private ArrayList<Building> bottomBuildingRow;
    private ArrayList<Event> toResolveEventRow;

    // overrides the default constructor
    protected Board() {
        this.turnOrderCard      = null;
        this.offersPath         = null;
        this.tribeDeck          = null;
        this.buildingDeck       = null;
        this.topDeckableRow     = null;
        this.topBuildingRow     = null;
        this.bottomDeckableRow  = null;
        this.bottomBuildingRow  = null;
        this.toResolveEventRow  = null;
    }

    // calls the zero-args constructor, sets turnOrderCard, offersPath, tribeDeck;
    // exists in case those objects are created before this
    protected Board(TurnOrderCard turnOrderCard,
                    Map<Character, TrackCard> offersPath,
                    Stack<DeckableCard> tribeDeck) {
        this();
        this.turnOrderCard  = turnOrderCard;
        this.offersPath     = offersPath;
        this.tribeDeck      = tribeDeck;
    }


    // GETTERS
    protected ArrayList<Building> getTopBuildingRow() {
        return topBuildingRow;
    }
    protected ArrayList<Building> getBottomBuildingRow() {
        return bottomBuildingRow;
    }
    protected ArrayList<DeckableCard> getBottomDeckableRow() {
        return bottomDeckableRow;
    }
    protected ArrayList<DeckableCard> getTopDeckableRow() {
        return topDeckableRow;
    }
    protected ArrayList<Event> getToResolveEventRow() {
        return toResolveEventRow;
    }
    protected Map<Character, TrackCard> getOffersPath() {
        return offersPath;
    }
    protected Stack<Building> getBuildingDeck() {
        return buildingDeck;
    }
    protected Stack<DeckableCard> getTribeDeck() {
        return tribeDeck;
    }
    protected TurnOrderCard getTurnOrderCard() {
        return turnOrderCard;
    }


    // SETTERS
    protected void setBottomBuildingRow(ArrayList<Building> bottomBuildingRow) {
        this.bottomBuildingRow = bottomBuildingRow;
    }
    protected void setBottomDeckableRow(ArrayList<DeckableCard> bottomDeckableRow) {
        this.bottomDeckableRow = bottomDeckableRow;
    }
    protected void setBuildingDeck(Stack<Building> buildingDeck) {
        this.buildingDeck = buildingDeck;
    }
    protected void setOffersPath(Map<Character, TrackCard> offersPath) {
        this.offersPath = offersPath;
    }
    protected void setTopBuildingRow(ArrayList<Building> topBuildingRow) {
        this.topBuildingRow = topBuildingRow;
    }
    protected void setTopDeckableRow(ArrayList<DeckableCard> topDeckableRow) {
        this.topDeckableRow = topDeckableRow;
    }
    protected void setToResolveEventRow(ArrayList<Event> toResolveEventRow) {
        this.toResolveEventRow = toResolveEventRow;
    }
    protected void setTribeDeck(Stack<DeckableCard> tribeDeck) {
        this.tribeDeck = tribeDeck;
    }
    protected void setTurnOrderCard(TurnOrderCard turnOrderCard) {
        this.turnOrderCard = turnOrderCard;
    }


    // ADDERS
    protected void addBuildingBottomRow(Building building) {
        this.bottomBuildingRow.add(building);
    }
    protected void addBuildingTopRow(Building building) {
        this.topBuildingRow.add(building);
    }
    protected void addDeckableBottomRow(DeckableCard card) {
        this.bottomDeckableRow.add(card);
    }
    protected void addDeckableTopRow(DeckableCard card) {
        this.topDeckableRow.add(card);
    }


    protected void switchDeckablesFromTop() {
        this.bottomDeckableRow.addAll(this.topDeckableRow);
        this.topDeckableRow = new ArrayList<>();
    }
    protected void switchBuildingsFromTop() {
        this.bottomBuildingRow.addAll(this.topBuildingRow);
        this.topBuildingRow = new ArrayList<>();
    }
    protected void idleEventsAndDiscardCharactersFromBottom() {
        for (DeckableCard c : this.bottomDeckableRow) {
            c.discardCard(this);
            // if c is a characterCard, nothing happens
            // if c is an eventCard, it is put into this.toResolveEventRow;
            //      moreover, if c is a gatheringEvent, it is put into last position;

            c = null;
            // then, it is eliminated from the board.
        }
    }
    protected void discardEvent() {
        this.toResolveEventRow = new ArrayList<>();
        // it deletes the previous list of events to resolve by assigning to the reference a
        // new object.
    }
    // whoever calls this method must pass the number of players of the current game
    protected void pickDeckableAndAddToTop(int numPlayers) {
        for (int i = 0; i < numPlayers + 4; i++) {
            this.addDeckableTopRow(this.tribeDeck.pop());
        }
    }
}
