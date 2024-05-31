package Model;

public class blockZ2 extends tetrominoes{
	public blockZ2(){
        super(new int[][] {{0, 5, 5}, 
        				   {5, 5}});
    }

    @Override
    public void rotate() {
    	rotation++;
    	if(rotation == 2) rotation -= 2;
    	if(rotation == 0) setShape(new int[][] {{0, 5, 5}, 
    											{5, 5}}); 
    	
        if(rotation == 1) setShape(new int[][] {{5}, 
        										{5, 5}, 
        										{0, 5}});
    }
    
}
