package Model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class model {
	private int[][] board;
	private int[][] hold;
	private int[][] next;
	
	private Queue<tetrominoes> nextBlock;
	private tetrominoes currentBlock;
	private tetrominoes holdBlock;
	private boolean holding;
	private int Score;
	private int locationR;
	private int locationC;
	
	public model(int height, int width) {
        board = new int[height+1][width+2];
        hold = new int[3][4];
        next = new int[9][4];
        for(int i = 0; i < board.length; i++) {board[i][0] = -1; board[i][width+1] = -1;}
        for(int j = 0; j < board[height].length; j++) board[height][j] = -1;
        
        nextBlock = new LinkedList<>();
        tetrominoes randomB = getRandomBlock();
		nextBlock.offer(randomB);
		for(int i = 0; i < randomB.getRow(); i++) {
			for(int j = 0; j < randomB.getCol(i); j++) {
				if(randomB.getValue(i, j) != 0) next[i][j] = randomB.getValue(i, j);
			}
		}
		randomB = getRandomBlock();
		nextBlock.offer(getRandomBlock());
		for(int i = 0; i < randomB.getRow(); i++) {
			for(int j = 0; j < randomB.getCol(i); j++) {
				if(randomB.getValue(i, j) != 0) next[i+3][j] = randomB.getValue(i, j);
			}
		}
		randomB = getRandomBlock();
		nextBlock.offer(getRandomBlock());
		for(int i = 0; i < randomB.getRow(); i++) {
			for(int j = 0; j < randomB.getCol(i); j++) {
				if(randomB.getValue(i, j) != 0) next[i+6][j] = randomB.getValue(i, j);
			}
		}
		
		Score = 0;
		locationR = 0;
		locationC = 4;
		
		holding = false;
		newBlock();
    }
	
	private tetrominoes getRandomBlock() {
        Random rand = new Random();
        int randomNum = rand.nextInt(7);
        switch(randomNum) {
        case 0:
        	return new blockZ2(); 
        case 1:
        	return new blockL1();
        case 2:
        	return new blockL2();
        case 3:
        	return new blockT();
        case 4:
        	return new blockSqr();
        case 5:
        	return new blockZ1();
        default:
        	return new blockI();
        }
    }
	
	public void drawBlock() {
		for (int i = 0; i < currentBlock.getRow(); i++) {
			if(locationR + i >= 20) break;
			for (int j = 0; j < currentBlock.getCol(i); j++) {
				if (currentBlock.getValue(i, j) != 0)
					board[locationR + i][locationC + j] = currentBlock.getValue(i, j);
			}
		}
	}
	
	public void clearBlock() {
        for (int i = 0; i < currentBlock.getRow(); i++)
            for (int j = 0; j < currentBlock.getCol(i); j++) {
            	if(locationR + i >= 20 || locationC + j <0 || locationC + j >10) continue;
                if (currentBlock.getValue(i, j) != 0)
                    board[locationR + i][locationC + j] = 0;
            }
    }
	
	public void newBlock() {
	    locationC = 4;
	    locationR = 0;
	    tetrominoes addedB = getRandomBlock();
	    currentBlock = nextBlock.poll();
	    nextBlock.offer(addedB);
	    // Clear the next array
	    for (int i = 0; i < next.length; i++) {
	        for (int j = 0; j < next[i].length; j++) {
	            next[i][j] = 0;
	        }
	    }
	    // Fill the next array with centered blocks
	    int blockIndex = 0;
	    for (tetrominoes block : nextBlock) {
	        int rowStart = blockIndex * 3;
	        int colStart = (4 - block.getCol(0)) / 2;
	        int[][] shape = block.getShape();
	        for (int i = 0; i < shape.length; i++) {
	            for (int j = 0; j < shape[i].length; j++) {
	                next[rowStart + i][colStart + j] = shape[i][j];
	            }
	        }
	        blockIndex++;
	    }
	}
	
	public void checkLine() {
		int dem = 0;
		for(int i = 0; i < board.length - 1; i++){
			boolean nogap = true;
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0) {
					nogap = false;
					break;
				}
			}
			if(nogap) {
				dem++;
				removeLine(i);
			}
		}
		Score += 100 * dem;
		if(dem >= 3 ){
			currentBlock = new blockSqr();
		}
	}
	
	
	private void removeLine(int lineIndex) {
		for (int i = lineIndex; i > 0; i--) {
			for (int j = 1; j < board[i].length - 1; j++) {
				board[i][j] = board[i - 1][j];
			}
		}
		for (int j = 1; j < board[0].length - 1; j++) {
			board[0][j] = 0;
		}
		board[0][0] = -1; board[11][0] = -1;
	}
	
	public void Hold() {
		if(holding) {
			tetrominoes tempBlock = currentBlock;
			currentBlock = holdBlock;
			holdBlock = tempBlock;
		}
		else {
			holdBlock = currentBlock;
			newBlock();
			holding = true;
		}
		hold = holdBlock.getShape();
	}

	public boolean checkCollapsed() {
	   for(int i = 0; i < currentBlock.getRow(); i++)
		   for(int j = 0; j < currentBlock.getCol(i); j++)
			   if(currentBlock.getValue(i, j) != 0 && board[i+locationR][j+locationC] !=0){
				   return true;
			   }
	   return false;
	}
	
	public void moveLeft() {
		locationC--;
		if(checkCollapsed()) locationC++;
	}
	
	public void moveRight() {
		locationC++;
		if(checkCollapsed()) locationC--;
	}
	
	public void rotate() {
	    currentBlock.rotate();
	    if(checkCollapsed()) currentBlock.undoRotate();
	}

	public void descend() {
		locationR++;
		if(checkCollapsed()){
			locationR--;
			drawBlock();
			newBlock();
		}
	}
	
	public void fastDescend() {
		locationR = board.length - currentBlock.getRow();
		while(checkCollapsed()) locationR--;
		drawBlock();
		newBlock();
	}
	
	public int[][] getBoard() {
		return board;
	}

	public int[][] getHold() {
		if(!holding) return new int[3][4];
		return holdBlock.getShape();
	}
	
	public int[][] getNext() {
		return next;
	}
	
	public int getScore(){
		return Score;
	};
}