import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
    JTextField field;
    JButton Guessbutton;
    JButton PlayAgainbutton;
    JLabel guessLabel;
    JLabel highlowLabel;
    JLabel lastguessLabel;
    Random rand = new Random();
    int randomInt;

    GuessingGame()
    {
      Random rand = new Random(100);
      System.out.println(rand);
      randomInt = rand.nextInt(100) + 1;
      JFrame frame = new JFrame("Guessing Game");
      frame.setLayout(new FlowLayout());
      frame.setSize(240,120);
      field = new JTextField(10);
      field.setActionCommand("myTF");
      JButton Guessbutton = new JButton("Guess");
      JButton PlayAgainbutton = new JButton("Play Again");
      field.addActionListener(this);
      Guessbutton.addActionListener(this);
      guessLabel = new JLabel("Enter your Guess: ");
      highlowLabel = new JLabel("");
      lastguessLabel = new JLabel("");
      frame.add(guessLabel);
      frame.add(field);
      frame.add(Guessbutton);
      frame.add(highlowLabel);
      frame.add(PlayAgainbutton);
      frame.add(lastguessLabel);
      frame.setVisible(true);
    }

  public void actionPerformed(ActionEvent ae) 
  {
    if (ae.getActionCommand().equals("Guess")) 
    {
      int guessLabel = Integer.parseInt(field.getText());
      if(guessLabel>randomInt)
      {
        highlowLabel.setText("Too High!");
      }
      else if (guessLabel<randomInt)
      {
        highlowLabel.setText("Too Low!");
      }
      else
      {
        highlowLabel.setText("You got it!");
      }
      lastguessLabel.setText("Last Guess was: " +field);

    }
    else if(ae.getActionCommand().equals("Play Again"))
    {
        Random rand = new Random();
        randomInt = rand.nextInt(100) + 1;
        Guessbutton.setText("Enter your Guess");
        highlowLabel.setText("");
        lastguessLabel.setText("");
        field.setText("");
    }
    else
    {
      highlowLabel.setText("You pressed enter. Please press the guess button");
    }
  }
}
