package life;

import java.io.IOException;
import java.util.Random;

public class Universe {
    private final Random random;

    private final int size;
    private final Cell[][] cells;
    private int currentGeneration = 0;

    public Universe(int size) {
        this(size, (long) (Math.random() * 1000));
    }

    public Universe(int size, long seed) {
        this.size = size;
        cells = new Cell[size][size];
        random = new Random(seed);
        init();
        connectCells();
    }

    public int getSize() {
        return size;
    }

    public int getCurrentGeneration() {
        return currentGeneration;
    }

    public void run(int generations) {
        for (int i = 0; i < generations; i++) {
            nextGeneration();
            printStatus();
        }
    }

    public void printStatus() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (InterruptedException | IOException ignored) {
        }
        System.out.println(toString());
    }

    public void nextGeneration() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j].calculateNextLifeState();
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j].moveToNextLifeState();
            }
        }
        currentGeneration += 1;
    }

    public int getAliveCellsCount() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].isAlive()) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public boolean isAlive(int x, int y) {
        return cells[x][y].isAlive();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Generation #").append(this.currentGeneration).append("\n");
        sb.append("Alive: ").append(getAliveCellsCount()).append("\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(cells[i][j].toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void init() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                cells[i][j] = new Cell(random.nextBoolean() ? LifeState.ALIVE : LifeState.DEAD);
            }
        }
    }

    private void connectCells() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                final int north = northRow(i);
                final int east = eastCol(j);
                final int south = southRow(i);
                final int west = westCol(j);
                cells[i][j].addNeighbor(cells[north][j]); //N
                cells[i][j].addNeighbor(cells[north][east]);//NE
                cells[i][j].addNeighbor(cells[i][east]);//E
                cells[i][j].addNeighbor(cells[south][east]);//SE
                cells[i][j].addNeighbor(cells[south][j]);//S
                cells[i][j].addNeighbor(cells[south][west]);//SW
                cells[i][j].addNeighbor(cells[i][west]);
                cells[i][j].addNeighbor(cells[north][west]); //NW
            }
        }
    }

    private int northRow(int currentRow) {
        return Math.floorMod(currentRow - 1, this.size);
    }

    private int southRow(int currentRow) {
        return Math.floorMod(currentRow + 1, this.size);
    }

    private int eastCol(int currentCol) {
        return Math.floorMod(currentCol + 1, this.size);
    }

    private int westCol(int currentCol) {
        return Math.floorMod(currentCol - 1, this.size);
    }
}
