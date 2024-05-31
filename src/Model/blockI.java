package Model;

public class blockI extends tetrominoes{
	public blockI(){
        super(new int[][] {{1, 1, 1, 1}});
    }

    @Override
    public void rotate() {
    	rotation++;
    	if(rotation == 2) rotation -= 2;
    	if(rotation == 0) setShape(new int[][] {{1, 1, 1, 1}});
    	
    	if(rotation == 1) setShape(new int[][] {{1},
    											{1},
    											{1},
    											{1}});
    }
}
