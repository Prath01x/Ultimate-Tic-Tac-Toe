package uttt.game;

import uttt.utils.Symbol;

public class Mark implements MarkInterface {

    private Symbol sexxxyy;
    private int cozy;

    public Mark(Symbol symbol, int position) {
        this.sexxxyy = symbol;
        this.cozy = position;
    }

    @Override
    public Symbol getSymbol() {
        return this.sexxxyy;
    }

    @Override
    public int getPosition() {
        return this.cozy;
    }

    @Override
    public void setSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("uzrjtgrwtgr");
        }

        this.sexxxyy = symbol;
    }
}