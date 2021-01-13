package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    private final JLabel generationLabel = new JLabel();
    private final JLabel aliveLabel = new JLabel();
    private final JPanel universePanel = new JPanel();
    private final JToggleButton pauseButton = new JToggleButton("Pause");
    private boolean paused = false;
    private final JButton resetButton = new JButton("Restart");
    private boolean reset = true;
    private JLabel[][] cells;
    private int universeSize;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        generationLabel.setName("GenerationLabel");
        pauseButton.setName("PlayToggleButton");
        aliveLabel.setName("AliveLabel");
        resetButton.setName("ResetButton");

        setGeneration(0);
        setAliveCellsCount(0);
        
        pauseButton.addActionListener(e -> {
            if (pauseButton.getText().equals("Pause")) {
                pauseButton.setText("Resume");
                paused = true;
            } else {
                pauseButton.setText("Pause");
                paused = false;
            }
        });

        resetButton.addActionListener(e -> {
            reset = true;
            if (isPaused()) {
                pauseButton.doClick();
            }
        });

        add(pauseButton);
        add(resetButton);
        add(generationLabel);
        add(aliveLabel);
        add(universePanel);

        setVisible(true);
    }

    public void setUniverseSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Universe size must be greater than 0!");
        }

        if (universeSize != 0) {
            //throw new IllegalStateException("Can't change universe size!");
        }
        universeSize = size;
        cells = new JLabel[universeSize][universeSize];
        initUniversePanel();
    }

    private void initUniversePanel() {
        universePanel.removeAll();
        for (int i = 0; i < universeSize; i++) {
            for (int j = 0; j < universeSize; j++) {
                cells[i][j] = new JLabel();
                universePanel.add(cells[i][j]);
            }
        }
        universePanel.setLayout(new GridLayout(universeSize, universeSize, 1, 1));
    }

    public void setGeneration(int generation) {
        generationLabel.setText("Generation #" + generation);
    }

    public void setAliveCellsCount(int alive) {
        aliveLabel.setText("Alive: " + alive);
    }

    public void setCellAlive(int i, int j) {
        cells[i][j].setOpaque(true);
        cells[i][j].setBackground(Color.WHITE);
    }

    public void setCellDead(int i, int j) {
        cells[i][j].setOpaque(true);
        cells[i][j].setBackground(Color.BLACK);
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isReset() {
        boolean temp = reset;
        reset = false;
        return temp;
    }
}
