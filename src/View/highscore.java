package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class highscore extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<String> playerNames = new ArrayList<>();
    private List<Integer> playerScores = new ArrayList<>();;
    private static final String HIGHSCORE_FILE = "highscores.txt";
    
    public JButton backButton = new JButton("Back");
    public JLabel title = new JLabel("HighScore");

    public highscore() {
        setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
        this.TitleHigh();
        this.Table();
        this.BtnBack();
        loadHighScores();
    }
    
    public void TitleHigh() {
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(430, 60));
        title.setBorder(new EmptyBorder(25, 0, 0, 0));
        this.add(title, BorderLayout.NORTH);
    }
    
    public void Table() {
    	 String[] columnNames = {"Player Name", "Score"};
         tableModel = new DefaultTableModel(columnNames, 0);
         table = new JTable(tableModel);
         // Center align text in cells
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
         centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
         table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
         table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
         // Create scroll pane with table and add white border
         JScrollPane scrollPane = new JScrollPane(table);
         scrollPane.setBorder(new LineBorder(Color.WHITE, 2));
         scrollPane.setBounds((655 - 430) / 2, 100, 430, 200);
         scrollPane.setPreferredSize(new Dimension(430, 200));
         
         JPanel tablePanel = new JPanel(null); // Use null layout for custom positioning
         tablePanel.setBackground(Color.BLACK);
         tablePanel.add(scrollPane);
         this.add(tablePanel, BorderLayout.CENTER);
    }
    
    public void BtnBack() {
    	backButton.setForeground(Color.WHITE);
    	backButton.setBackground(Color.DARK_GRAY);
    	backButton.setFont(new Font("Arial", Font.BOLD, 18));
    	backButton.setPreferredSize(new Dimension(200, 40));
    	backButton.setMaximumSize(backButton.getPreferredSize());
    	backButton.setFocusPainted(false);
    	backButton.setBorderPainted(false);
    	backButton.setAlignmentX(CENTER_ALIGNMENT);
    	
    	JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        buttonPanel.setBorder(new EmptyBorder(0, 0, 50, 0));
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public void addNewScore(String name, int score) {
        playerNames.add(name);
        playerScores.add(score);
        sortAndLimitHighScores();
        updateTable();
        saveHighScores();
    }

    private void sortAndLimitHighScores() {
        // Create a list of players and scores
        List<PlayerScore> playerScoreList = new ArrayList<>();
        for (int i = 0; i < playerNames.size(); i++) {
            playerScoreList.add(new PlayerScore(playerNames.get(i), playerScores.get(i)));
        }
        // Sort the list by score in descending order
        playerScoreList.sort(Comparator.comparingInt(PlayerScore::getScore).reversed());
        // Limit the lists to the top 10 scores
        playerNames.clear();
        playerScores.clear();
        for (int i = 0; i < Math.min(10, playerScoreList.size()); i++) {
            PlayerScore ps = playerScoreList.get(i);
            playerNames.add(ps.getName());
            playerScores.add(ps.getScore());
        }
    }
    
    public void saveHighScores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HIGHSCORE_FILE))) {
            for (int i = 0; i < playerNames.size(); i++) {
                writer.write(playerNames.get(i) + "," + playerScores.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadHighScores() {
        playerNames.clear();
        playerScores.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(HIGHSCORE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                playerNames.add(parts[0]);
                playerScores.add(Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortAndLimitHighScores();
        updateTable();
    }
    
    private void updateTable() {
        tableModel.setRowCount(0); // Clear the table
        for (int i = 0; i < playerNames.size(); i++) {
            tableModel.addRow(new Object[]{playerNames.get(i), playerScores.get(i)});
        }
    }
    
    private static class PlayerScore {
        private final String name;
        private final int score;

        public PlayerScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}