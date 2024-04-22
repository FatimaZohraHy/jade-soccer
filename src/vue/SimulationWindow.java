package vue;

import controller.Simulation;

import javax.swing.*;
import java.awt.*;

public class SimulationWindow extends Canvas {
    public SimulationWindow(int width, int height, String title, Simulation simulation) {
        JFrame frame = createFrame(width, height, title);
        addComponents(frame, simulation);
        frame.setVisible(true);
        simulation.start();
    }

    private JFrame createFrame(int width, int height, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private void addComponents(JFrame frame, Simulation simulation) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add((Component) simulation, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(mainPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton startButton = new JButton("Start Match");
        startButton.setBackground(new Color(0, 128, 128));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(e -> simulation.startMatch());
        buttonPanel.add(startButton);

        JButton endButton = new JButton("End Match");
        endButton.setBackground(new Color(0, 128, 128));
        endButton.setForeground(Color.WHITE);
        endButton.addActionListener(e -> simulation.endMatch());
        buttonPanel.add(endButton);

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(buttonPanel, BorderLayout.CENTER);
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(controlPanel, BorderLayout.PAGE_END);
    }


}
