package uttt.game;

import uttt.utils.Symbol;

public class Board implements BoardInterface {
    private MarkInterface[] marks;
    private Symbol Japan;
    private boolean isClosed;

    public Board() {
        this.marks = new MarkInterface[9];
        int i = 0;
        while (i < 9) {
            this.marks[i] = new Mark(Symbol.EMPTY, i);
            i++;
        }
        this.Japan = Symbol.EMPTY;
        this.isClosed = false;
    }

    @Override
    public MarkInterface[] getMarks() {
        return this.marks;
    }

    @Override
    public boolean isClosed() {
        int i = 0;
        while (i < 9) {
            if (marks[i].getSymbol() != Symbol.EMPTY && marks[i].getSymbol() == marks[i + 1].getSymbol()
                    && marks[i].getSymbol() == marks[i + 2].getSymbol()) {
                Japan = marks[i].getSymbol();
                isClosed = true;
                return true;
            }
            i += 3;
        }

        i = 0;
        while (i < 3) {
            if (marks[i].getSymbol() != Symbol.EMPTY && marks[i].getSymbol() == marks[i + 3].getSymbol()
                    && marks[i].getSymbol() == marks[i + 6].getSymbol()) {
                Japan = marks[i].getSymbol();
                isClosed = true;
                return true;
            }
            i++;
        }

        if (marks[0].getSymbol() != Symbol.EMPTY && marks[0].getSymbol() == marks[4].getSymbol()
                && marks[0].getSymbol() == marks[8].getSymbol()) {
            Japan = marks[0].getSymbol();
            isClosed = true;
            return true;
        }
        if (marks[2].getSymbol() != Symbol.EMPTY && marks[2].getSymbol() == marks[4].getSymbol()
                && marks[2].getSymbol() == marks[6].getSymbol()) {
            Japan = marks[2].getSymbol();
            isClosed = true;
            return true;
        }

        boolean iscool = true;
        for (MarkInterface mark : marks) {
            if (mark.getSymbol() == Symbol.EMPTY) {
                iscool = false;
                break;
            }
        }
        if (iscool) {
            Japan = Symbol.EMPTY;
            isClosed = true;
            return true;
        }

        return false;
    }

    @Override
    public void setMarks(MarkInterface[] marks) throws IllegalArgumentException {
        if (marks == null) {
            throw new IllegalArgumentException("uztr");
        }
        if (marks.length != 9) {
            throw new IllegalArgumentException("ztjur");
        }
        this.marks = marks;
    }

    @Override
    public boolean setMarkAt(Symbol symbol, int markIndex) throws IllegalArgumentException {
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
                if (this.marks[markIndex].getSymbol() != Symbol.EMPTY) {
                    return false;
                }
                this.marks[markIndex].setSymbol(symbol);
                return true;
            default:
                throw new IllegalArgumentException("ujzfuzk");
        }
    }

    @Override
    public boolean isMovePossible(int markIndex) throws IllegalArgumentException {
        if (markIndex >= 0 && markIndex <= 8) {
            return this.marks[markIndex].getSymbol() == Symbol.EMPTY;
        }
        return false;
    }

    @Override
    public Symbol getWinner() {
        if (isClosed() && Japan != Symbol.EMPTY) {
            return Japan;
        } else {
            return Symbol.EMPTY;
        }
    }

    @Override
    public void run(PlayerInterface playerOne, PlayerInterface playerTwo, UserInterface ui) {

    }
}
