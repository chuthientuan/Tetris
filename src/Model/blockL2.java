package Model;

public class blockL2 extends tetrominoes{
	public blockL2(){
        super(new int[][] {{0, 2}, 
        				   {0, 2}, 
        				   {2, 2}});
    }

    @Override
    public void rotate() {
    	rotation++;
    	if(rotation == 4) rotation -= 4;
    	if(rotation == 0) setShape(new int[][] {{0, 2}, 
    											{0, 2}, 
    											{2, 2}}); 
    	
        if(rotation == 1) setShape(new int[][] {{2}, 
        										{2, 2, 2}});
        
        if(rotation == 2) setShape(new int[][] {{2, 2}, 
        										{2},
        										{2}});
        
        if(rotation == 3) setShape(new int[][] {{2, 2, 2},
        										{0, 0, 2}});
    }
}
