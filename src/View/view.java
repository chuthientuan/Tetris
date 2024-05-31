package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import Controller.controlGame;
import Model.model;

public class view extends JFrame {
    private model Model;
    private instruction Ins = new instruction();
    private highscore Hi = new highscore();
    private play Play = new play();
    private controlGame controller;
    private home Home = new home();

    public view(model Model) {
        this.Model = Model;
        this.setTitle("Tetris");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20, 20, 655, 660);
        this.setResizable(false);
        this.setContentPane(Home);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setVisible(true);
        this.setupPlay();
        this.setupIns();
        this.setupHigh();
        this.setupBackIns();
        this.setupBackHigh();
        this.setupPause();
        this.setupResume();
        this.setupRestartP();
        this.setupQuitP();
        this.setupRestartO();
        this.setupQuitO();
    }

    public void setupPlay() {
        Home.lblPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                restartGame();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Home.lblPlay.setForeground(Color.WHITE);
            }
        });
        Home.lblPlay.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Home.lblPlay.setForeground(Color.RED);
            }
        });
    }
    
    public void setupIns() {
        Home.lblInstruction.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                switchToInstruction();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Home.lblInstruction.setForeground(Color.WHITE);
            }
        });
        Home.lblInstruction.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Home.lblInstruction.setForeground(Color.RED);
            }
        });
    }
    
    public void setupHigh() {
        Home.lblHighscore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                switchToHiscore();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Home.lblHighscore.setForeground(Color.WHITE);
            }
        });
        Home.lblHighscore.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Home.lblHighscore.setForeground(Color.RED);
            }
        });
    }
    
    public void setupQuitO() {
        Play.btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String playerName = Play.enter.getText().trim();
                int playerScore = Integer.parseInt(Play.Score.getText());
                if (!playerName.isEmpty()) {
                    Hi.addNewScore(playerName, playerScore);
                }
                switchoToHome();
            }
        });
    }
    
    public void setupBackIns() {
        Ins.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchoToHome();
            }
        });
    }

    public void setupBackHigh() {
        Hi.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchoToHome();
            }
        });
    }
    
    public void setupPause() {
        Play.pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.running = false;
            }
        });
    }
    
    public void setupResume() {
        Play.resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.running = true;
                controller.gameLoop();
            }
        });
    }
    
    public void setupRestartP() {
        Play.btnRestartP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
    }

    public void setupQuitP() {
        Play.quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchoToHome();
                Play.resetPausePanel();
                controller.running = false;
            }
        });
    }

    public void setupRestartO() {
        Play.btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String playerName = Play.enter.getText().trim();
                int playerScore = Integer.parseInt(Play.Score.getText());
                if (!playerName.isEmpty()) {
                    Hi.addNewScore(playerName, playerScore);
                }
            	restartGame();
            }
        });
    }
    
    private void restartGame() {
        Model = new model(20, 10); 
        controller = new controlGame(Model, this);
        if(controller.running = true){
            controller.gameLoop();
        }
        setContentPane(Play);
        Play.resetOverPanel();
        Play.resetPausePanel();
        revalidate();
        repaint();
    }
    
    private void switchoToHome() {
        Home.resetLabelColors();
        setContentPane(Home);
        revalidate();
        repaint();
    }
    
    private void switchToInstruction() {
        setContentPane(Ins);
        revalidate();
        repaint();
    }

    private void switchToHiscore() {
        Hi.loadHighScores();
        setContentPane(Hi);
        revalidate();
        repaint();
    }

    public void Over() {
        if (Model.checkCollapsed()) {
            if (!Play.opa.isVisible()) {
                Play.opa.setVisible(true);
                revalidate();
                repaint();
            }
        }
    }

    public void render() {
        Play.Update(Model.getBoard(), Model.getHold(), Model.getNext());
        String diem = String.valueOf(Model.getScore());
        Play.lblDiem.setText(diem);
        Play.Score.setText(diem);
    }
}