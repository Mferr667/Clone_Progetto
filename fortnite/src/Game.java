import java.util.ArrayList;
import java.util.List;

public class Game {
    GameState currentState;
    final List<Player> players;
    Board board;
    int currentPlayerIndex;
    int numPlayers;

    // constructors are protected: only setup() can call them
    protected Game(int numPlayers) {
        this.currentState       = null;
        this.players            = new ArrayList<>(numPlayers);
        this.board              = new Board(numPlayers);
        this.currentPlayerIndex = 0;
        this.numPlayers         = numPlayers;
    }

    // called if a Game game crashes, gets the arguments from the latest JSON snapshot
    protected Game(GameState lastCurrentState,
                   List<Player> lastPlayers,
                   Board lastBoard,
                   int lastCurrentPlayerIndex) {
        this.currentState       = lastCurrentState;
        this.players            = lastPlayers;
        this.board              = lastBoard;
        this.currentPlayerIndex = lastCurrentPlayerIndex;
    }

    public void placeTotem() {
        // TODO
    }

    public void pickCard() {
        // TODO
    }

    // SETTER:
    protected void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    // GETTERS:
    protected Board getBoard() {
        return board;
    }

    protected GameState getCurrentState() {
        return currentState;
    }

    protected int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    protected List<Player> getPlayers() {
        return players;
    }
}

abstract class GameState {

    // TODO: set formal parameters
    abstract protected void positionTotem();
    abstract protected void pickCard();
    abstract protected void nextState();
    abstract protected void endRound();
}

class PickState extends GameState {

    @Override
    protected void positionTotem() {
        // TODO
    }

    @Override
    protected void pickCard() {
        // TODO
    }

    @Override
    protected void nextState() {
        // TODO
    }

    @Override
    protected void endRound() {
        // TODO
    }
}

class PositionState extends GameState {

    @Override
    protected void positionTotem() {
        // TODO
    }

    @Override
    protected void pickCard() {
        // TODO
    }

    @Override
    protected void nextState() {
        // TODO
    }

    @Override
    protected void endRound() {
        // TODO
    }
}

class EndRoundState extends GameState {

    @Override
    protected void positionTotem() {
        // TODO
    }

    @Override
    protected void pickCard() {
        // TODO
    }

    @Override
    protected void nextState() {
        // TODO
    }

    @Override
    protected void endRound() {
        // TODO
    }
}

class EndGameState extends GameState {

    @Override
    protected void positionTotem() {
        // TODO
    }

    @Override
    protected void pickCard() {
        // TODO
    }

    @Override
    protected void nextState() {
        // TODO
    }

    @Override
    protected void endRound() {
        // TODO
    }
}