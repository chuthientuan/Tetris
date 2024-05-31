package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class instruction extends JPanel {
    private static final long serialVersionUID = 1L;
    
    public JLabel title = new JLabel("Instruction");
    public JLabel txtrIn = new JLabel();
    public JButton backButton = new JButton("Back");

    public instruction() {
        this.setBackground(Color.BLACK);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        this.TitleIns();
        this.lblIns();
        this.BtnBack();
    }
    
    public void TitleIns(){
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds((655 - 430) / 2, 20, 430, 40);
        this.add(title);
    }
    
    public void lblIns(){
    	txtrIn.setForeground(Color.WHITE);
        txtrIn.setBackground(Color.BLACK);
        txtrIn.setFont(new Font("Arial", Font.PLAIN, 16));
        txtrIn.setText("<html>In Tetris, players complete lines by moving differently shaped pieces (tetrominoes), "
                + "which descend onto the playing field. The completed lines disappear and grant the player points, "
                + "and the player can proceed to fill the vacated spaces. The game ends when the uncleared lines reach the top of the playing field.<br>"
                + "<b>Controls:</b><br>"
                + "- Left Arrow / A: Move left<br>"
                + "- Right Arrow / D: Move right<br>"
                + "- Down Arrow / S: Move down faster<br>"
                + "- J / C: Rotate<br>"
                + "- K / X: Fast descend<br>"
                + "- L / Z: Hold<br>"
                + "<b>Objective:</b><br>"
                + "Clear as many lines as possible to score points. The game becomes progressively faster and more challenging as you clear more lines.<br>"
                + "<b>Scoring System:</b><br>"
                + "- Single Line: 100 points<br>"
                + "- Double Line: 200 points<br>"
                + "- Triple Line: 300 points<br>"
                + "- Tetris (Four Lines): 400 points<br>"
                + "</html>");
        txtrIn.setBounds((655 - 430) / 2, 80, 430, 500);
        txtrIn.setVerticalAlignment(SwingConstants.TOP);
        this.add(txtrIn);
    }
    
    public void BtnBack(){
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds((655 - 200) / 2, 550, 200, 40);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        this.add(backButton);
    }
}