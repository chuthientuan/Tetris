package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Model.model;
import View.view;

public class controlGame implements KeyListener {
    private model Model;
    private view View;
    private boolean gameOver;
    private int FPS = 60;
    private int dropBlock = 60;
    public boolean running;

    public controlGame(model Model, view View) {
        this.Model = Model;
        this.View = View;
        gameOver = false;
        running = true;
        View.addKeyListener(this);
    }

    public void gameLoop() {
        new Thread(() -> {
            while (running && !gameOver) {
                updateGame();
                View.render();
                try {
                    Thread.sleep(1000 / FPS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!running) return;
            View.Over();
        }).start();
    }

    public void updateGame() {
    	Model.clearBlock();
    	
    	if(dropBlock == 0){
    		Model.descend();
    		dropBlock = 60;
    	}
    	else dropBlock--;
    	
    	if(Model.checkCollapsed()) {gameOver = true; return;}
    	else Model.checkLine();
    	
    	Model.drawBlock();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Model.clearBlock();
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                Model.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                Model.moveRight();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                Model.descend();
                dropBlock = 60;
                break;
            case KeyEvent.VK_C:
            case KeyEvent.VK_J:
                Model.rotate();
                break;
            case KeyEvent.VK_L:
            case KeyEvent.VK_Z:
                Model.Hold();
                if(Model.checkCollapsed()) Model.Hold();
                break;
            case KeyEvent.VK_K:
            case KeyEvent.VK_X:
                Model.fastDescend();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }
}