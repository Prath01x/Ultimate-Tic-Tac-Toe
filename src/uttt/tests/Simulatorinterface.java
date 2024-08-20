package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;

public class Simulatorinterface {

    @Test
    public void jjjjjjjjjj() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = simulator.getBoards();
        assertNotNull(boards);
        assertTrue(boards.length > 0);
    }

    @Test
    public void llllllllll() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = simulator.getBoards();
        for (BoardInterface board : boards) {
            assertNotNull(board);
        }
    }

    @Test
    public void ooooo() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = simulator.getBoards();
        assertEquals(9, boards.length);
    }

    @Test
    public void lllllllll() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = simulator.getBoards();
        for (BoardInterface board : boards) {
            MarkInterface[] marks = board.getMarks();
            for (MarkInterface mark : marks) {
                Symbol symbol = mark.getSymbol();
                assertEquals(Symbol.EMPTY, symbol);
            }
        }
    }

    // set boards
    @Test
    public void pppppppppppp() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];
        boards[0] = UTTTFactory.createBoard();
        boards[2] = null;
        boards[4] = UTTTFactory.createBoard();

        try {
            simulator.setBoards(boards);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void ttttttttttt() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];
        boards[0] = UTTTFactory.createBoard();
        boards[2] = null;
        boards[4] = UTTTFactory.createBoard();

        for (int i = 1; i < boards.length; i++) {
            if (boards[i] != null) {
                boards[i] = null;
            }
        }

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setBoards(boards);
        });
    }

    @Test
    public void jjjjjjjjjjjjjjjjjjjjjjjjjjj() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];
        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }
        simulator.setBoards(boards);
    }

    @Test
    public void mmmmmmmmm() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[0];
        simulator.setBoards(boards);
    }

    @Test
    public void rewf() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = null;
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setBoards(boards);
        });
    }

    @Test
    public void bitch() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];
        boards[0] = UTTTFactory.createBoard();
        boards[2] = null;
        boards[4] = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            if (boards[i] == null) {
                throw new IllegalArgumentException("Invalid boards: null value at index " + i);
            }
        }

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setBoards(boards);
        });
    }

    // cuurentplayersymbol
    @Test
    public void kjhgfd() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        simulator.setCurrentPlayerSymbol(Symbol.CROSS);
        Symbol currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertEquals(Symbol.CROSS, currentPlayerSymbol);
    }

    @Test
    public void thsfb() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        simulator.setCurrentPlayerSymbol(Symbol.CIRCLE);
        Symbol currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertEquals(Symbol.CIRCLE, currentPlayerSymbol);
    }

    @Test
    public void ntdzx() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertEquals(Symbol.EMPTY, currentPlayerSymbol);
    }

    @Test
    public void nfcgzt() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        simulator.setCurrentPlayerSymbol(Symbol.CROSS);
        Symbol currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertEquals(Symbol.CROSS, currentPlayerSymbol);

        simulator.setCurrentPlayerSymbol(Symbol.CIRCLE);
        currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertEquals(Symbol.CIRCLE, currentPlayerSymbol);
    }

    @Test
    public void fuztj() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol playerSymbol = simulator.getCurrentPlayerSymbol();
        assertNotNull(playerSymbol);
    }

    // set current player symbol
    @Test
    public void rstd() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol invalidSymbol = null;
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setCurrentPlayerSymbol(invalidSymbol);
        });
    }

    @Test
    public void fgbncx() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CIRCLE;
        simulator.setCurrentPlayerSymbol(symbol);
        Symbol currentPlayerSymbol = simulator.getCurrentPlayerSymbol();
        assertEquals(symbol, currentPlayerSymbol);
    }

    // setmarksat
    @Test
    public void gsfsdyx() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = simulator.getCurrentPlayerSymbol();
        int boardIndex = 0;
        int markIndex = 4;
        boolean markAdded = simulator.setMarkAt(symbol, boardIndex, markIndex);
        assertTrue(markAdded);
    }

    @Test
    public void srthd() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = simulator.getCurrentPlayerSymbol();
        int invalidBoardIndex = -1;
        int markIndex = 4;
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setMarkAt(symbol, invalidBoardIndex, markIndex);
        });
    }

    @Test
    public void hrdtxa() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = simulator.getCurrentPlayerSymbol();
        int boardIndex = 0;
        int invalidMarkIndex = 9;
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setMarkAt(symbol, boardIndex, invalidMarkIndex);
        });

    }

    // getIndexNextBoard
    @Test
    public void tfd() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int nextBoardIndex = simulator.getIndexNextBoard();
        assertEquals(-1, nextBoardIndex);
    }

    @Test
    public void refgse() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int boardIndex = 0;
        simulator.setIndexNextBoard(boardIndex);
        int nextBoardIndex = simulator.getIndexNextBoard();
        assertEquals(boardIndex, nextBoardIndex);
    }

    @Test
    public void mzughzfnnhguzt() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int invalidBoardIndex = 9;
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setIndexNextBoard(invalidBoardIndex);
        });
        int nextBoardIndex = simulator.getIndexNextBoard();
        assertEquals(-1, nextBoardIndex);
    }

    // nextindex
    @Test
    public void mdutdfcrdf() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int validIndex = 3;
        simulator.setIndexNextBoard(validIndex);
        int nextBoardIndex = simulator.getIndexNextBoard();
        assertEquals(validIndex, nextBoardIndex);
    }

    @Test
    public void ztjfhtsdfhgd() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int negativeIndex = -1;
        simulator.setIndexNextBoard(negativeIndex);
        int nextBoardIndex = simulator.getIndexNextBoard();
        assertEquals(negativeIndex, nextBoardIndex);
    }

    @Test
    public void hgfhgfdd() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int outOfBoundIndex = 10;
        try {
            simulator.setIndexNextBoard(outOfBoundIndex);
            fail("fail");
        } catch (IllegalArgumentException e) {

        }
    }

    // possiblemove
    @Test
    public void e56z5uez6() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int boardIndex = 5;
        boolean isPossible = simulator.isMovePossible(boardIndex);
        assertTrue(isPossible);
    }

    @Test
    public void hgjfhgj() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int boardIndex = 0;
        boolean isPossible = simulator.isMovePossible(boardIndex);
        assertTrue(isPossible);
    }

    @Test
    public void gjhmhgj() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int boardIndex = 8;
        boolean isPossible = simulator.isMovePossible(boardIndex);
        assertFalse(isPossible);
    }

    // boolismovepossible
    @Test
    public void gufhjzhgnjdf() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int boardIndex = 0; // Choose a valid board index
        int markIndex = 4; // Choose a valid mark index
        boolean isPossible = simulator.isMovePossible(boardIndex, markIndex);
        assertTrue(isPossible);
    }

    @Test
    public void jzhfgnddgtfh() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int boardIndex = -1; // Choose an invalid board index
        int markIndex = 4; // Choose a valid mark index
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.isMovePossible(boardIndex, markIndex);
        });
    }

    @Test
    public void fcxgbxdfby() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        int boardIndex = 0; // Choose a valid board index
        int markIndex = 9; // Choose an invalid mark index
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.isMovePossible(boardIndex, markIndex);
        });
    }

    // getwinner
    @Test
    public void fhgm() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol winner = simulator.getWinner();
        assertEquals(Symbol.EMPTY, winner);
    }

    @Test
    public void uzfkrstg() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        Symbol winner = simulator.getWinner();
        assertEquals(Symbol.EMPTY, winner);
    }

    @Test
    public void jruzhjztztrj() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol winner = simulator.getWinner();
        assertEquals(Symbol.CROSS, winner);
    }

}