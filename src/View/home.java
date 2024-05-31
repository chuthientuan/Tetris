package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class home extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public JLabel lblTetris = new JLabel("TETRIS");
	public JLabel lblPlay = new JLabel("PLAY");
	public JLabel lblInstruction = new JLabel("INSTRUCTION");
	public JLabel lblHighscore = new JLabel("HIGHSCORE");
	
	public home(){
		this.setBackground(Color.BLACK);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.NameGame();
		this.ButtonPlay();
		this.ButtonInstruction();
		this.ButtonHighscore();
	}
	
	public void NameGame(){
		lblTetris.setHorizontalAlignment(SwingConstants.CENTER);
		lblTetris.setForeground(new Color(255, 255, 255));
		lblTetris.setFont(new Font("Bookman Old Style", Font.BOLD, 60));
		lblTetris.setBounds((655-240)/2, 10, 240,83);
		this.add(lblTetris);
	}
	
	public void ButtonPlay(){
		lblPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlay.setForeground(Color.WHITE);
		lblPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblPlay.setBounds((655-200)/2, 250, 200, 30);
		this.add(lblPlay);
	}
	
	public void ButtonInstruction(){
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setForeground(Color.WHITE);
		lblInstruction.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblInstruction.setBounds((655-200)/2, 300, 200, 30);
		this.add(lblInstruction);
	}
	
	public void ButtonHighscore(){
		lblHighscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighscore.setForeground(Color.WHITE);
		lblHighscore.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblHighscore.setBounds((655-200)/2, 350, 200, 30);
		this.add(lblHighscore);
	}
	
	 public void resetLabelColors() {
	        lblPlay.setForeground(Color.WHITE);
	        lblInstruction.setForeground(Color.WHITE);
	        lblHighscore.setForeground(Color.WHITE);
	    }
}