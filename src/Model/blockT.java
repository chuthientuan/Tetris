package Model;

public class blockT extends tetrominoes{
	public blockT(){
        super(new int[][] {{0, 4}, {4, 4, 4}});
    }

    @Override
    public void rotate() {
    	rotation++;
    	if(rotation == 4) rotation -= 4;
    	if(rotation == 0) setShape(new int[][] {{0, 4}, 
    											{4, 4, 4}});
    	
        if(rotation == 1) setShape(new int[][] {{4}, 
        										{4, 4},
        										{4}});
        
        if(rotation == 2) setShape(new int[][] {{4, 4, 4}, 
        										{0, 4}});
        
        if(rotation == 3) setShape(new int[][] {{0, 4},
        										{4, 4}, 
        										{0, 4}});
    }
}
