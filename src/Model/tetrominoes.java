package Model;

public abstract class tetrominoes {
    protected int[][] shape;
    protected int rotation;
    protected void setShape(int[][] shape) {
    	this.shape = shape;
    }

    public tetrominoes(int[][] shape) {
        this.shape = shape;
        rotation = 0;
    }
    
    public abstract void rotate();
    
    public void undoRotate(){
    	rotate();rotate();rotate();
    };
    public int getRow() {
    	return shape.length;
    };
    public int getCol(int i) {
    	return shape[i].length;
    }
    public int getValue(int row, int col) {
    	return shape[row][col];
    }
    public int[][] getShape() {
    	return shape;
    };
}
