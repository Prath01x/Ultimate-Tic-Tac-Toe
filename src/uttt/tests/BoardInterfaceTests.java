package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import uttt.UTTTFactory;

import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class BoardInterfaceTests {
    BoardInterface board;

    @Before
    public void setUp() throws Exception {
        this.board = UTTTFactory.createBoard();
    }

    @Test
    public void simpleboardtest() {
        assertNotNull(this.board);
    }

    @Test
    public void a1() {
        MarkInterface[] marks = board.getMarks();
        assertEquals(0, marks.length);
    }

    @Test
    public void a() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);

        MarkInterface[] marks = board.getMarks();
        assertEquals(3, marks.length);
    }

    @Test
    public void b() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);

        MarkInterface[] marks = board.getMarks();
        assertEquals(Symbol.CIRCLE, marks[0].getSymbol());
        assertEquals(Symbol.CROSS, marks[1].getSymbol());
        assertEquals(Symbol.CIRCLE, marks[2].getSymbol());
    }

    @Test
    public void c() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);

        MarkInterface[] marks = board.getMarks();
        assertEquals(Symbol.CIRCLE, marks[0].getSymbol());
        assertEquals(Symbol.CROSS, marks[1].getSymbol());
        assertEquals(Symbol.EMPTY, marks[2].getSymbol());
    }

    @Test
    public void d() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);

        MarkInterface[] marks = board.getMarks();
        assertEquals(0, marks[0].getPosition());
        assertEquals(1, marks[1].getPosition());
        assertEquals(2, marks[2].getPosition());
    }

    // setmarks
    @Test
    public void e() {
        MarkInterface[] marks = new MarkInterface[9];
        for (int i = 0; i < 9; i++) {
            marks[i] = UTTTFactory.createMark(Symbol.CIRCLE, i);
        }

        board.setMarks(marks);

        MarkInterface[] updatedMarks = board.getMarks();
        assertArrayEquals(marks, updatedMarks);
    }

    @Test
    public void f() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);

        MarkInterface[] marks = new MarkInterface[9];
        for (int i = 0; i < 9; i++) {
            marks[i] = UTTTFactory.createMark(Symbol.CIRCLE, i);
        }

        board.setMarks(marks);

        MarkInterface[] updatedMarks = board.getMarks();
        assertArrayEquals(marks, updatedMarks);
    }

    @Test
    public void i() {
        MarkInterface[] marks = new MarkInterface[8]; // Invalid length

        assertThrows(IllegalArgumentException.class, () -> {
            board.setMarks(marks);
        });
    }

    @Test
    public void j() {
        MarkInterface[] marks = null;

        assertThrows(IllegalArgumentException.class, () -> {
            board.setMarks(marks);
        });
    }

    /////////////// setmarksat
    @Test
    public void k() {
        boolean result = board.setMarkAt(Symbol.CIRCLE, 0);
        assertTrue(result);

        MarkInterface[] marks = board.getMarks();
        assertEquals(Symbol.CIRCLE, marks[0].getSymbol());
    }

    @Test
    public void kl() {
        board.setMarkAt(Symbol.CIRCLE, 0);

        boolean result = board.setMarkAt(Symbol.CROSS, 0);
        assertFalse(result);

        MarkInterface[] marks = board.getMarks();
        assertEquals(Symbol.CIRCLE, marks[0].getSymbol());
    }

    @Test
    public void m() {
        assertThrows(IllegalArgumentException.class, () -> {
            board.setMarkAt(Symbol.CROSS, -1);
        });
    }

    @Test
    public void mh() {
        assertThrows(IllegalArgumentException.class, () -> {
            board.setMarkAt(Symbol.CROSS, 9);
        });
    }

    // Additional tests can be added to cover other scenarios

    // is closed
    @Test
    public void tt() {
        boolean result = board.isClosed();
        assertFalse(result);
    }

    @Test
    public void bb() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);

        boolean result = board.isClosed();
        assertFalse(result);
    }

    @Test
    public void rtg() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CROSS, 5);
        board.setMarkAt(Symbol.CROSS, 6);
        board.setMarkAt(Symbol.CIRCLE, 7);
        board.setMarkAt(Symbol.CROSS, 8);

        boolean result = board.isClosed();
        assertTrue(result);
    }

    @Test
    public void tr() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);

        boolean result = board.isClosed();
        assertTrue(result);
    }

    // move
    @Test
    public void trt() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        boolean result = board.isMovePossible(1);
        assertTrue(result);
    }

    @Test
    public void tttt() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        boolean result = board.isMovePossible(0);
        assertFalse(result);
    }

    @Test
    public void kk() {
        boolean result = board.isMovePossible(-1);
        assertFalse(result);
    }

    @Test
    public void gh() {
        boolean result = board.isMovePossible(10);
        assertFalse(result);
    }

    @Test
    public void fg() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CROSS, 5);
        board.setMarkAt(Symbol.CIRCLE, 6);
        board.setMarkAt(Symbol.CROSS, 7);
        board.setMarkAt(Symbol.CIRCLE, 8);

        boolean result = board.isMovePossible(0);
        assertFalse(result);
    }

    // winner
    @Test
    public void ttzt() {
        Symbol result = board.getWinner();
        assertEquals(Symbol.EMPTY, result);
    }

    @Test
    public void ggt() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);
        Symbol result = board.getWinner();
        assertEquals(Symbol.EMPTY, result);
    }

    @Test
    public void ttr() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);
        Symbol result = board.getWinner();
        assertEquals(Symbol.CIRCLE, result);
    }

    @Test
    public void ttttr() {
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CROSS, 5);
        Symbol result = board.getWinner();
        assertEquals(Symbol.CROSS, result);
    }

    @Test
    public void hhhh() {
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 2);
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CROSS, 5);
        board.setMarkAt(Symbol.CROSS, 6);
        board.setMarkAt(Symbol.CIRCLE, 7);
        board.setMarkAt(Symbol.CROSS, 8);
        Symbol result = board.getWinner();
        assertEquals(Symbol.EMPTY, result);
    }

}
