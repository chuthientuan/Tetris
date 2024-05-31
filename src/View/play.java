package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class play extends JPanel{
	private static final long serialVersionUID = 1L;

	private final int rows = 20;  
    private final int cols = 12;
	private JPanel[][] cellPanels;
	private JPanel[][] cellHolds;
	private JPanel[][] cellNexts;
	
	public JPanel hold = new JPanel();
	public JPanel next = new JPanel();
	public JLabel lblDiem = new JLabel("0");
	public JLabel lblCap = new JLabel("1");
	public JPanel Playarea = new JPanel();
	public JPanel NextBlock = new JPanel();
	public JLabel lblNext = new JLabel("Next");
	public JLabel lblScore = new JLabel("Score");
	public JPanel HoldBlock = new JPanel();
	public JLabel lblHold = new JLabel("Hold");
	public JPanel border3 = new JPanel();
	public JPanel border2 = new JPanel();
	public JButton pause = new JButton("| |");
	
	public JPanel pausePanel = new JPanel();
    public JLabel pauseLabel = new JLabel("Paused");
    public JPanel opacity = new JPanel();
    public JButton resume = new JButton("Resume");
    public JButton quit = new JButton("Quit Game");
    public JPanel opa = new JPanel();
    public JPanel over = new JPanel();
    public JLabel gameover = new JLabel("Game Over");
    public JPanel overPanel = new JPanel();
    public JLabel yscore = new JLabel("Your Score");
    public JLabel Score = new JLabel("0");
    public JLabel yname = new JLabel("Enter Your Name:");
    public JTextField enter = new JTextField();
    public JButton btnQuit = new JButton("Quit");
    public JButton btnRestart = new JButton("Restart");
    public JButton btnRestartP = new JButton("Restart");
    
    public int padding = 25;
	
	public play(){
		this.setBackground(Color.BLACK);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setBounds(20, 20, 655, 660);
		this.Hold();
		this.Score();
		this.PlayA();
		this.Next();
		this.Pause();
		this.PausePanel();
		this.GameOver();
	}
	
	public void Hold(){
		border3.setBounds(15, 50, 124, 124);
		this.add(border3);
		border3.setLayout(null);
		
		HoldBlock.setBackground(Color.BLACK);
		HoldBlock.setBounds(2, 2, 120, 120);
		HoldBlock.setLayout(new GridLayout(4, 4, 1, 1));
		cellHolds = new JPanel[4][4];
		for(int i=0; i<4;i++){
			for(int j=0;j<4;j++){ 
				JPanel cellHold = new JPanel();
				cellHold.setBackground(Color.BLACK);
				HoldBlock.add(cellHold);
				cellHolds[i][j] = cellHold;
			}
		}
		border3.add(HoldBlock);
		
		lblHold.setHorizontalAlignment(SwingConstants.CENTER);
		lblHold.setForeground(Color.WHITE);
		lblHold.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblHold.setBounds(15, 20, 124, 25);
		this.add(lblHold);
	}
	
	public void Score(){
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblScore.setBounds(15, 400, 124, 30);
		this.add(lblScore);
		
		lblDiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiem.setForeground(Color.WHITE);
		lblDiem.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		lblDiem.setBounds(15, 440, 124, 20);
		this.add(lblDiem);
	}
	
	public void PlayA(){
		Playarea.setBounds((335)/2, 10, 300, 600);
		Playarea.setLayout(new GridLayout(rows, cols - 2, 1, 1));
		Playarea.setBackground(Color.GRAY);
		cellPanels = new JPanel[rows][cols-2];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols - 2; j++){
				JPanel cellPanel = new JPanel();
				cellPanel.setBackground(Color.BLACK);
				cellPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                Playarea.add(cellPanel);
                cellPanels[i][j] = cellPanel;
			}
		}
		this.add(Playarea);
	}
	
	public void Next(){
		border2.setBounds(500, 50, 124, 304);
		this.add(border2);
		border2.setLayout(null);
		
		NextBlock.setBackground(Color.BLACK);
		NextBlock.setBounds(2, 2, 120, 300);
		NextBlock.setLayout(new GridLayout(10, 4, 1, 1));
		cellNexts = new JPanel[10][4];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 4; j++){
				JPanel cellNext = new JPanel();
				cellNext.setBackground(Color.BLACK);
				NextBlock.add(cellNext);
				cellNexts[i][j] = cellNext;
			}
		}
		border2.add(NextBlock);
		
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(Color.WHITE);
		lblNext.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNext.setBounds(500, 20, 124, 25);
		this.add(lblNext);
	}
	
	public void Pause(){
		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				if (!opacity.isVisible()){
			        opacity.setVisible(true);
			        revalidate();
			        repaint();
			    }    
			}
		});		
		
		pause.setFocusPainted(false);
		pause.setBounds(574, 595, 50, 20);
		pause.setBackground(Color.LIGHT_GRAY);
		pause.setBorderPainted(false);
		this.add(pause);
	}
	
	public void PausePanel(){
		opacity.setBackground(new Color(0, 0, 0, 125));
		opacity.setLayout(null);
		opacity.setBounds(1, 1, 655, 660);
		this.add(opacity);
		opacity.setVisible(false);
		
		pausePanel.setLayout(new BoxLayout(pausePanel, BoxLayout.Y_AXIS));
        pausePanel.setBackground(Color.DARK_GRAY); 
        pausePanel.setBounds(166, 99, 304, 424);
        
        pauseLabel.setForeground(Color.WHITE);
        pauseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pauseLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
        pauseLabel.setAlignmentX(CENTER_ALIGNMENT);
        pauseLabel.setBorder(new EmptyBorder(padding, 0, padding, 0));
        pausePanel.add(pauseLabel);
        Resume();
        Restart();
        QuitGame();
        opacity.add(pausePanel);
        this.setComponentZOrder(opacity, 0);
	}
	
	public void resetPausePanel() {
	    opacity.setVisible(false);
	    pause.setEnabled(true);
	}
	
	public void Resume(){
		resume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				opacity.setVisible(!opacity.isVisible());
				revalidate();
				repaint();
				pause.setEnabled(true);
			}
		});		

		resume.setFocusPainted(false);
		resume.setPreferredSize(new Dimension(200, 50));
		resume.setMaximumSize(resume.getPreferredSize());
		resume.setBackground(Color.LIGHT_GRAY);
		resume.setAlignmentX(CENTER_ALIGNMENT);
		resume.setBorderPainted(false);
		pausePanel.add(Box.createRigidArea(new Dimension(0, padding)));
		pausePanel.add(resume);
	}
	
	public void Restart(){
		btnRestartP.setFocusPainted(false);
		btnRestartP.setPreferredSize(new Dimension(200, 50));
		btnRestartP.setMaximumSize(btnRestartP.getPreferredSize());
		btnRestartP.setBackground(Color.LIGHT_GRAY);
		btnRestartP.setAlignmentX(CENTER_ALIGNMENT);
		btnRestartP.setBorderPainted(false);
		pausePanel.add(Box.createRigidArea(new Dimension(padding, padding)));
		pausePanel.add(btnRestartP);
	}
	
	public void QuitGame(){
		quit.setFocusPainted(false);
		quit.setPreferredSize(new Dimension(200, 50));
		quit.setMaximumSize(quit.getPreferredSize());
		quit.setBackground(Color.LIGHT_GRAY);
		quit.setAlignmentX(CENTER_ALIGNMENT);
		quit.setBorderPainted(false);
		pausePanel.add(Box.createRigidArea(new Dimension(0, padding)));
		pausePanel.add(quit);
		pausePanel.add(Box.createRigidArea(new Dimension(0, padding)));
	}
	
	public void GameOver() {
		opa.setBackground(new Color(0, 0, 0, 125));
		opa.setLayout(null);
		opa.setBounds(1, 1, 655, 660);
		this.add(opa);
		opa.setVisible(false);
		
		overPanel.setLayout(new BoxLayout(overPanel, BoxLayout.Y_AXIS));
		overPanel.setBackground(Color.DARK_GRAY);
		overPanel.setBounds(166, 99, 304, 424);
		
		gameover.setForeground(Color.WHITE);
	    gameover.setHorizontalAlignment(SwingConstants.CENTER);
	    gameover.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
	    gameover.setAlignmentX(CENTER_ALIGNMENT); 
	    overPanel.add(Box.createRigidArea(new Dimension(0, padding)));
	    overPanel.add(gameover);
	    
	    yscore.setForeground(Color.WHITE);
	    yscore.setHorizontalAlignment(SwingConstants.CENTER);
	    yscore.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
	    yscore.setAlignmentX(CENTER_ALIGNMENT);  
	    overPanel.add(Box.createRigidArea(new Dimension(0, padding)));
	    overPanel.add(yscore);
	    
	    Score.setForeground(Color.WHITE);
	    Score.setHorizontalAlignment(SwingConstants.CENTER);
	    Score.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
	    Score.setAlignmentX(CENTER_ALIGNMENT);  
	    overPanel.add(Score);
	    
	    yname.setForeground(Color.WHITE);
	    yname.setHorizontalAlignment(SwingConstants.CENTER);
	    yname.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
	    yname.setAlignmentX(CENTER_ALIGNMENT);  
	    overPanel.add(Box.createRigidArea(new Dimension(0, padding)));
	    overPanel.add(yname);
	    
	    enter.setMaximumSize(new Dimension(150, 25));
	    overPanel.add(enter);
	    
	    opa.add(overPanel);
	    ButtonRestart();
	    ButtonQuit();
	    this.setComponentZOrder(opa, 0);
	}
	
	public void ButtonRestart() {
		btnRestart.setMaximumSize(new Dimension(150, 40));
		btnRestart.setBackground(Color.LIGHT_GRAY);
		btnRestart.setFocusPainted(false);
		btnRestart.setBorderPainted(false);
		btnRestart.setAlignmentX(CENTER_ALIGNMENT);
		overPanel.add(Box.createRigidArea(new Dimension(0, padding)));
	    overPanel.add(btnRestart);
	}
	
	public void ButtonQuit() {
		btnQuit.setMaximumSize(new Dimension(150, 40));
		btnQuit.setBackground(Color.LIGHT_GRAY);
		btnQuit.setFocusPainted(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setAlignmentX(CENTER_ALIGNMENT);
		overPanel.add(Box.createRigidArea(new Dimension(0, padding)));
	    overPanel.add(btnQuit);
	}
	
	public void resetOverPanel() {
	    opa.setVisible(false);
	}
	
	public void Update(int[][] board, int[][] hold, int[][] next) {
	    // Update the main play area
	    for (int i = 0; i < rows; i++) {
	        for (int j = 1; j < cols - 1; j++) {
	            setColor(i, j - 1, board[i][j], cellPanels);
	        }
	    }
	    // Clear the hold area
	    for(int i = 0; i < cellHolds.length; i++) {
	        for(int j = 0; j < cellHolds[i].length; j++) {
	            cellHolds[i][j].setBackground(Color.BLACK);
	        }
	    }
	    // Center and set the hold block
	    if (hold.length > 0 && hold[0].length > 0) {
	        int holdRowStart = (4 - hold.length) / 2;
	        int holdColStart = (4 - hold[0].length) / 2;
	        for (int i = 0; i < hold.length; i++) {
	            for (int j = 0; j < hold[i].length; j++) {
	                setColor(holdRowStart + i, holdColStart + j, hold[i][j], cellHolds);
	            }
	        }
	    }
	    // Clear the next area
	    for(int i = 0; i < cellNexts.length; i++) {
	        for(int j = 0; j < cellNexts[i].length; j++) {
	            cellNexts[i][j].setBackground(Color.BLACK);
	        }
	    }
	    // Center and set the next block
	    for (int blockIndex = 0; blockIndex < 3; blockIndex++) {
	        int nextRowStart = blockIndex * 3;
	        int nextColStart = (4 - next[blockIndex * 3].length) / 2;
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 4; j++) {
	                setColor(nextRowStart + i, nextColStart + j, next[nextRowStart + i][j], cellNexts);
	            }
	        }
	    }
	    repaint();
	}


	public void setColor(int row, int col, int value, JPanel[][] panels) {
		Color color;
		switch(value) {
		case 1:
			color = Color.red;
			break;
		case 2:
			color = Color.blue;
			break;
		case 3:
			color = Color.orange;
			break;
		case 4:
			color = Color.yellow;
			break;
		case 5:
			color = Color.cyan;
			break;
		default:
			color = Color.black;
		}
		panels[row][col].setBackground(color);
	}
}