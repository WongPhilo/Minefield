package src.mF;
import src.MVC.*;
class Field extends Model{
	public static int percentMined = 5;
	public static int size = 20;
	boolean gameOver; //if true, JOptionPane an alert and make a new board when it's dismissed
	public Mine[][] mines;
	public int currentX;
	public int currentY;
	public Mine current;

	public Field() {
		gameOver = false;//initialize mines?
		mines = new Mine[size][size];
		int random = 0;
		for(int i = 0; i<size; i++) {
			for (int j = 0; j < size; j++) {
				random = (int) (Math.random() * 100);
				if (random <= 4) {
					mines[i][j] = new Mine(true);
				} else {
					mines[i][j] = new Mine(false);
				}
			}
		}
		int nearby = 0;
		for(int i = 0; i<size; i++) {
			for (int j = 0; j < size; j++) {
				if(i-1>=0)
				{
					if(mines[i-1][j].isMined()) {
						nearby++;
					}
					if(j-1>=0)
					{
						if(mines[i-1][j-1].isMined()) {
							nearby++;
						}
					}
					if(j+1<=19)
					{
						if(mines[i-1][j+1].isMined()) {
							nearby++;
						}
					}
				}
				if(j-1>=0)
				{
					if(mines[i][j-1].isMined()) {
						nearby++;
					}
				}
				if(i+1<=19)
				{
					if(mines[i+1][j].isMined()) {
						nearby++;
					}
					if(j-1>=0)
					{
						if(mines[i+1][j-1].isMined()) {
							nearby++;
						}
					}
					if(j+1<=19)
					{
						if(mines[i+1][j+1].isMined()) {
							nearby++;
						}
					}
				}
				if(j+1<=19)
				{
					if(mines[i][j+1].isMined()) {
						nearby++;
					}
				}
			}
		}
		currentX = 0;
		currentY = 0;
		current = mines[currentX][currentY];
		current.setStepped(true);
	}

	public void move(Heading heading) {
		// if (heading = Heading.NW) .. blah blah blah, move and stuff
		if(heading == Heading.N)
		{
			currentY--;
		}
		if(heading == Heading.NE)
		{
			currentY--;
			currentX++;
		}
		if(heading == Heading.NW)
		{
			currentY--;
			currentX++;
		}
		if(heading == Heading.E)
		{
			currentX++;
		}
		if(heading == Heading.W)
		{
			currentX--;
		}
		if(heading == Heading.SE)
		{
			currentY++;
			currentX++;
		}
		if(heading == Heading.SW)
		{
			currentY++;
			currentX--;
		}
		current = mines[currentX][currentY];
		current.setStepped(true);
	}
}

class Mine{
	public boolean mined;
	public int nearby;
	public boolean stepped;

	public Mine(boolean mined)
	{
		this.mined = mined;
		stepped = false;
		nearby = 0;
	}

	public boolean isMined() {
		return mined;
	}

	public void setMined(boolean mined) {
		this.mined = mined;
	}

	public int getNearby() {
		return nearby;
	}

	public void setNearby(int nearby) {
		this.nearby = nearby;
	}

	public boolean isStepped() {
		return stepped;
	}

	public void setStepped(boolean stepped) {
		this.stepped = stepped;
	}
}

public class MineField{

	public MineField(){

	}
	public static void main(String args[]) {
		fieldPanel.run(new fieldFactory());
	}
}