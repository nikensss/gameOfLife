package life;

public class Game extends Thread {
    @Override
    public void run() {
        GameOfLife gameOfLife = new GameOfLife();
        Universe universe = null;
        while (true) {
            if (gameOfLife.isReset()) {
                universe = new Universe(100);
                gameOfLife.setUniverseSize(universe.getSize());
            }
            wait(150);
            gameOfLife.setGeneration(universe.getCurrentGeneration());
            gameOfLife.setAliveCellsCount(universe.getAliveCellsCount());
            updateCells(gameOfLife, universe);
            if (!gameOfLife.isPaused()) {
                universe.nextGeneration();
            }
        }
    }

    private void wait(int millis) {
        try {
            sleep(150);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    private static void updateCells(GameOfLife game, Universe universe) {
        int size = universe.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (universe.isAlive(i, j)) {
                    game.setCellAlive(i, j);
                } else {
                    game.setCellDead(i, j);
                }
            }
        }
    }
}
