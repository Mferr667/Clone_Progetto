import java.util.*;

public class Board {
    private TurnOrderCard turnOrderCard;
    private Map<Character, TrackCard> offersPath;
    private TribeDeck tribeDeck;
    private BuildingDeck buildingDeck;
    private ArrayList<DeckableCard> topDeckableRow;
    private ArrayList<Building> topBuildingRow;
    private ArrayList<DeckableCard> bottomDeckableRow;
    private ArrayList<Building> bottomBuildingRow;
    private ArrayList<Event> toResolveEventRow;

    // overrides the default constructor
    protected Board(int numPlayers) {
        this.turnOrderCard      = new TurnOrderCard();
        this.offersPath         = new HashMap<>();
        this.tribeDeck          = new TribeDeck();
        this.buildingDeck       = new BuildingDeck(numPlayers);
        this.topDeckableRow     = new ArrayList<>();
        this.topBuildingRow     = new ArrayList<>();
        this.bottomDeckableRow  = new ArrayList<>();
        this.bottomBuildingRow  = new ArrayList<>();
        this.toResolveEventRow  = new ArrayList<>();
    }

    // called in case of a game crash, gets values read from a JSON files (by another method)
    public Board(TurnOrderCard turnOrderCard,
                 Map<Character, TrackCard> offersPath,
                 TribeDeck tribeDeck,
                 BuildingDeck buildingDeck,
                 ArrayList<DeckableCard> topDeckableRow,
                 ArrayList<Building> topBuildingRow,
                 ArrayList<DeckableCard> bottomDeckableRow,
                 ArrayList<Building> bottomBuildingRow,
                 ArrayList<Event> toResolveEventRow) {
        this.turnOrderCard      = turnOrderCard;
        this.offersPath         = offersPath;
        this.tribeDeck          = tribeDeck;
        this.buildingDeck       = buildingDeck;
        this.topDeckableRow     = topDeckableRow;
        this.topBuildingRow     = topBuildingRow;
        this.bottomDeckableRow  = bottomDeckableRow;
        this.bottomBuildingRow  = bottomBuildingRow;
        this.toResolveEventRow  = toResolveEventRow;
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
    protected BuildingDeck getBuildingDeck() {
        return buildingDeck;
    }
    protected TribeDeck getTribeDeck() {
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
    protected void setBuildingDeck(BuildingDeck buildingDeck) {
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
    protected void setTribeDeck(TribeDeck tribeDeck) {
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
            this.addDeckableTopRow(this.tribeDeck.getDeckableDeck().pop());
        }
    }


}

class TribeDeck {
    Stack<DeckableCard> deckableDeck;

    protected TribeDeck() {
        Map<Integer, ArrayList<DeckableCard>> decks = new HashMap<>();
        // reads values from JSON data file, puts DeckableCards in the corresponding eras;
        // TODO [...]


        // shuffles the decks separately:
        Collections.shuffle(decks.get(1));
        Collections.shuffle(decks.get(2));
        Collections.shuffle(decks.get(3));

        // pushes the shuffled cards in the Queue;
        // TODO: final events must be pushed first (so that they are last in the stack)
        for (int i = 1; i <= 3; i++) {
            for (DeckableCard c : decks.get(i)) {
                this.deckableDeck.push(c);
            }
        }
    }

    public Stack<DeckableCard> getDeckableDeck() {
        return deckableDeck;
    }
}

class BuildingDeck {
    Map<Integer, ArrayList<Building>> buildingDecks;

    protected BuildingDeck(int numPlayers) {
        this.buildingDecks = new HashMap<>();
        // reads values from JSON data file, puts Buildings in the corresponding eras;
        // TODO: put all the buildings inside this Map
        Map<Integer, ArrayList<Building>> completeDecks = new HashMap<>();
        // TODO: put all building numbers inside this matrix
        int[][] initialBuildings = new int[4][3];

        // shuffles the decks separately:
        Collections.shuffle(completeDecks.get(1));
        Collections.shuffle(completeDecks.get(2));
        Collections.shuffle(completeDecks.get(3));

        // pushes the shuffled cards in the Queue;
        for (int i = 1; i <= 3; i++) {      // cycles through ages 1 to 3
            for (int j = 0; j < initialBuildings[numPlayers - 1][i - 1]; j++) {
                // initialBuildings[numPlayers - 1][i - 1] is the number of building cards
                // given numPlayers, for the current era i;
                this.buildingDecks.get(i).add(completeDecks.get(i).get(j));
            }
        }
    }

    public Map<Integer, ArrayList<Building>> getBuildingDecks() {
        return buildingDecks;
    }
}
