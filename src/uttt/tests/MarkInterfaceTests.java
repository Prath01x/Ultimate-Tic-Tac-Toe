package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import uttt.UTTTFactory;

import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class MarkInterfaceTests {

    MarkInterface mark;

    @Test
    public void g() {
        mark = UTTTFactory.createMark(Symbol.CIRCLE, 9);
        Symbol circle = mark.getSymbol();
        assertEquals(Symbol.CIRCLE, circle);
    }

    @Test
    public void ggg() {

        mark = UTTTFactory.createMark(Symbol.CIRCLE, 3);
        Symbol cross = mark.getSymbol();
        assertEquals(Symbol.CIRCLE, cross);
    }

    @Test
    public void hhhh() {
        mark = UTTTFactory.createMark(Symbol.EMPTY, 5);
        Symbol symbol = mark.getSymbol();
        assertEquals(Symbol.EMPTY, symbol);
    }

    @Test
    public void kkkkkkkkkkk() {
        mark = UTTTFactory.createMark(Symbol.valueOf("CUSTOM"), 2);
        Symbol symbol = mark.getSymbol();
        assertEquals(Symbol.valueOf("CUSTOM"), symbol);
    }

    @Test
    public void bbbbbbbbbbbb() {
        mark = UTTTFactory.createMark(Symbol.CROSS, 7);
        Symbol flippedSymbol = mark.getSymbol().flip();
        assertEquals(Symbol.CIRCLE, flippedSymbol);
    }

    // POSITION
    @Test
    public void bbbbbbbbbbb() {
        mark = UTTTFactory.createMark(Symbol.CIRCLE, 4);
        int position = mark.getPosition();
        assertEquals(4, position);
    }

    @Test
    public void kkkkkkkkk() {
        mark = UTTTFactory.createMark(Symbol.CROSS, 0);
        int position = mark.getPosition();
        assertEquals(0, position);
    }

    @Test
    public void qqqqqqqq() {
        mark = UTTTFactory.createMark(Symbol.EMPTY, 5);
        int position = mark.getPosition();
        assertEquals(5, position);
    }

    @Test
    public void rrrrrr() {
        mark = UTTTFactory.createMark(Symbol.CIRCLE, 9);
        int position = mark.getPosition();
        assertEquals(9, position);
    }

    // SETSYMBOL
    @Test
    public void iiiiiiiii() {
        mark = UTTTFactory.createMark(Symbol.CROSS, 0);
        mark.setSymbol(Symbol.CIRCLE);
        Symbol symbol = mark.getSymbol();
        assertEquals(Symbol.CIRCLE, symbol);
    }

    @Test
    public void kkkkkkkkkkkk() {
        mark = UTTTFactory.createMark(Symbol.CIRCLE, 2);
        mark.setSymbol(Symbol.CIRCLE);
        Symbol symbol = mark.getSymbol();
        assertEquals(Symbol.CIRCLE, symbol);
    }

    @Test(expected = IllegalArgumentException.class)
    public void llllll() {
        mark = UTTTFactory.createMark(Symbol.EMPTY, 5);
        mark.setSymbol(null);
    }

    @Test
    public void ooooooooooooo() {
        mark = UTTTFactory.createMark(Symbol.EMPTY, 8);
        mark.setSymbol(Symbol.CROSS);
        Symbol symbol = mark.getSymbol();
        assertEquals(Symbol.CROSS, symbol);
    }
}
