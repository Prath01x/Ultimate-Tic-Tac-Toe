package uttt.game;

import uttt.utils.Move;
import uttt.utils.Symbol;

public class player implements PlayerInterface {

    private Symbol baby;

    public player(Symbol symbol) {
        this.baby = symbol;
    }

    @Override
    public Symbol getSymbol() {
        return baby;
    }

    @Override
    public Move getPlayerMove(SimulatorInterface game, UserInterface ui) throws IllegalArgumentException {
        if (ui != null) {
            return ui.getUserMove();
        } else {
            BoardInterface[] sexxx = game.getBoards();
            int sexxxyy = game.getIndexNextBoard();
            BoardInterface board = sexxx[sexxxyy];
            int markIndex = 0;
            while (markIndex < 9) {
                if (board.isMovePossible(markIndex)) {
                    return new Move(sexxxyy, markIndex);
                }
                markIndex++;
            }
            return null;
        }
    }

}