import javax.swing.*;
import java.awt.*;

public class VirtualPetSimulatorGUI extends JFrame {
    private VirtualPet pet;
    private JLabel hungerLabel, happinessLabel, energyLabel, statusLabel;

    public VirtualPetSimulatorGUI(String petName) {
        pet = new VirtualPet(petName);
        setTitle("Virtual Pet Simulator - " + petName);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        hungerLabel = new JLabel();
        happinessLabel = new JLabel();
        energyLabel = new JLabel();
        statusLabel = new JLabel();

        JButton feedButton = new JButton("Feed");
        JButton playButton = new JButton("Play");
        JButton restButton = new JButton("Rest");

        feedButton.addActionListener(e -> {
            if (pet.isAlive()) {
                pet.feed();
                updateStatus();
            }
        });

        playButton.addActionListener(e -> {
            if (pet.isAlive()) {
                pet.play();
                updateStatus();
            }
        });

        restButton.addActionListener(e -> {
            if (pet.isAlive()) {
                pet.rest();
                updateStatus();
            }
        });

        add(hungerLabel);
        add(happinessLabel);
        add(energyLabel);
        add(statusLabel);
        add(feedButton);
        add(playButton);
        add(restButton);

        updateStatus();
        setVisible(true);
    }

    private void updateStatus() {
        hungerLabel.setText("Hunger: " + pet.getHunger() + "/100");
        happinessLabel.setText("Happiness: " + pet.getHappiness() + "/100");
        energyLabel.setText("Energy: " + pet.getEnergy() + "/100");

        if (!pet.isAlive()) {
            statusLabel.setText(" " + pet.getName() + " is no longer with us.");
        } else {
            statusLabel.setText(" " + pet.getName() + " is doing okay.");
        }
    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your pet's name:");
        if (name != null && !name.isEmpty()) {
            SwingUtilities.invokeLater(() -> new VirtualPetSimulatorGUI(name));
        } else {
            System.out.println("Pet name was not provided.");
        }
    }
}
