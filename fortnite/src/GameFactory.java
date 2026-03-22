import java.util.Collections;

public class GameFactory {
    public Game setup(int numPlayers) {
        // create gameObjects:
        Game newGame = new Game(numPlayers);
        DeckableCard d = null;

        Board currentBoard = newGame.getBoard();
        // TODO: when all players connect, they are inserted into currentBoard.players

        // setup: phases 3 and 4
        for (int i = 0; i < numPlayers + 1; ) {
            d = currentBoard.getTribeDeck().getDeckableDeck().pop();
            i += d.setupPhaseFour(this);
        }

        // setup: phase 5
        currentBoard.pickDeckableAndAddToTop(numPlayers - currentBoard.getTopDeckableRow().size());

        // setup: phase 6a
        for (int i = 0; i < currentBoard.getBuildingDeck().getBuildingDecks().get(1).size(); i++) {
            currentBoard.addBuildingTopRow(
                    currentBoard.getBuildingDeck().getBuildingDecks().get(1).get(i)
            );
        }

        return newGame;
    }
}


/*
setupPhaseFour(Board) {
    // in Event:
    Board.addDeckableTopRow(this);
    return 0;

    // in Character:
    Board.addDeckableBottomRow(this);
    return 1;
}
 */