package life;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final List<Cell> neighbors = new ArrayList<>();

    private LifeState lifeState;

    private LifeState nextLifeState;

    public Cell(LifeState lifeState) {
        this.lifeState = lifeState;
        nextLifeState = this.lifeState;
    }

    public void addNeighbor(Cell neighbor) {
        neighbors.add(neighbor);
    }

    public void setLifeState(LifeState lifeState) {
        this.lifeState = lifeState;
    }

    public boolean isAlive() {
        return lifeState == LifeState.ALIVE;
    }

    public void calculateNextLifeState() {
        int aliveNeighbors = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor.isAlive()) {
                aliveNeighbors += 1;
            }
        }

        if (aliveNeighbors < 2 || aliveNeighbors > 3) {
            nextLifeState = LifeState.DEAD;
        } else if (aliveNeighbors == 3) {
            nextLifeState = LifeState.ALIVE;
        }
    }

    public void moveToNextLifeState() {
        setLifeState(nextLifeState);
    }

    @Override
    public String toString() {
        return lifeState.toString();
    }
}
