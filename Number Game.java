import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGameGUI {
    private int targetNumber;
    private int tries;

    private JFrame frame;
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField guessField;
    private JButton guessButton;

    public NumberGameGUI() {
        targetNumber = new Random().nextInt(100) + 1; // Generate a random number between 1 and 100
        tries = 0;

        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        messageLabel = new JLabel("Guess a number between 1 and 100:");

        guessField = new JTextField(10);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());

        panel.add(messageLabel);
        panel.add(guessField);
        panel.add(guessButton);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class GuessButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(guessField.getText());
                tries++;

                if (guess < targetNumber) {
                    messageLabel.setText("Too low! Try again.");
                } else if (guess > targetNumber) {
                    messageLabel.setText("Too high! Try again.");
                } else {
                    messageLabel.setText("Congratulations! You guessed it in " + tries + " tries.");
                    guessField.setEnabled(false);
                    guessButton.setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid input. Please enter a number.");
            }

            guessField.setText("");
            guessField.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGameGUI();
            }
        });
    }
}
