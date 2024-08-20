package uttt.game;

import uttt.utils.Symbol;

public class Simulator implements SimulatorInterface {

    private BoardInterface[] bard;
    private Symbol sybosis;
    private int cyama;

    public Simulator() {
        this.bard = new BoardInterface[9];
        int i = 0;
        while (i < 9) {
            this.bard[i] = new Board();
            i++;
        }
        this.sybosis = Symbol.EMPTY;
        this.cyama = -1;
    }

    @Override
    public BoardInterface[] getBoards() {
        return bard;
    }

    @Override
    public void setBoards(BoardInterface[] bard) throws IllegalArgumentException {
        if (bard.length != 9) {
            throw new IllegalArgumentException("4tzhztrzthe.");
        }
        this.bard = bard;
    }

    @Override
    public Symbol getCurrentPlayerSymbol() {
        return sybosis;
    }

    @Override
    public void setCurrentPlayerSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbol == Symbol.EMPTY) {
            throw new IllegalArgumentException("retws");
        }
        this.sybosis = symbol;
    }

    @Override
    public boolean setMarkAt(Symbol symbol, int boardIndex, int markIndex) throws IllegalArgumentException {
        if (boardIndex < 0 || boardIndex >= 9) {
            throw new IllegalArgumentException("vtrsre");
        }
        if (markIndex < 0 || markIndex >= 9) {
            throw new IllegalArgumentException("zhnbthrdttr");
        }

        BoardInterface board = bard[boardIndex];
        if (!board.isMovePossible(markIndex)) {
            return false;
        }

        if (symbol == getCurrentPlayerSymbol()) {
            board.setMarkAt(symbol, markIndex);
            cyama = markIndex;
            return true;
        } else {
            throw new IllegalArgumentException("zhtrthezrtet4rz");
        }
    }

    @Override
    public int getIndexNextBoard() {
        return cyama;
    }

    @Override
    public void setIndexNextBoard(int index) throws IllegalArgumentException {
        if (index < -1 || index >= 9) {
            throw new IllegalArgumentException("tregref");
        }
        this.cyama = index;
    }

    @Override
    public boolean isGameOver() {
        if (getWinner() != Symbol.EMPTY) {
            return true;
        }

        int boardIndex = 0;
        while (boardIndex < bard.length) {
            BoardInterface board = bard[boardIndex];
            if (!board.isClosed()) {
                return false;
            }
            boardIndex++;
        }

        return true;
    }

    @Override
    public boolean isMovePossible(int boardIndex) throws IllegalArgumentException {
        switch (boardIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                if (!isGameOver() && (cyama == -1 || cyama == boardIndex)) {
                    return true;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid board index.");
        }

        return false;
    }

    @Override
    public boolean isMovePossible(int boardIndex, int markIndex) throws IllegalArgumentException {
        switch (boardIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                switch (markIndex) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        return isMovePossible(boardIndex) && bard[boardIndex].isMovePossible(markIndex);
                    default:
                        throw new IllegalArgumentException("Invalid mark index.");
                }
            default:
                throw new IllegalArgumentException("Invalid board index.");
        }
    }

    @Override
    public Symbol getWinner() {

        int i = 0;
        while (i < 9) {
            if (bard[i].getWinner() != Symbol.EMPTY && bard[i].getWinner() == bard[i + 1].getWinner()
                    && bard[i].getWinner() == bard[i + 2].getWinner()) {
                return bard[i].getWinner();
            }
            i += 3;
        }

        int j = 0;
        while (j < 3) {
            if (bard[j].getWinner() != Symbol.EMPTY && bard[j].getWinner() == bard[j + 3].getWinner()
                    && bard[j].getWinner() == bard[j + 6].getWinner()) {
                return bard[j].getWinner();
            }
            j++;
        }

        if (bard[0].getWinner() != Symbol.EMPTY && bard[0].getWinner() == bard[4].getWinner()
                && bard[0].getWinner() == bard[8].getWinner()) {
            return bard[0].getWinner();
        }

        if (bard[2].getWinner() != Symbol.EMPTY && bard[2].getWinner() == bard[4].getWinner()
                && bard[2].getWinner() == bard[6].getWinner()) {
            return bard[2].getWinner();
        }

        return Symbol.EMPTY;

    }

    @Override
    public void run(PlayerInterface playerOne, PlayerInterface playerTwo, UserInterface ui)
            throws IllegalArgumentException {

        throw new UnsupportedOperationException("rawefcrvasdef");
    }
}
