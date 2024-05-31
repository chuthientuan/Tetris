package Model;

public class blockZ1 extends tetrominoes{
	public blockZ1(){
        super(new int[][] {{5, 5}, 
        				   {0, 5, 5}});
    }

    @Override
    public void rotate() {
    	rotation++;
    	if(rotation == 2) rotation -= 2;
    	if(rotation == 0) setShape(new int[][] {{5, 5}, 
    											{0, 5, 5}}); 
    	
        if(rotation == 1) setShape(new int[][] {{0, 5}, 
        										{5, 5}, 
        										{5}});
    }
}
