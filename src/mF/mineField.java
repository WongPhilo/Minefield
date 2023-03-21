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
		setMines();
		currentX = 0;
		currentY = 0;
		current = mines[currentX][currentY];
	}
	public void setMines()
	{
		int random = 0;
		for(int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				random = (int) (Math.random() * 100);
				if (random <= percentMined-1) {
					mines[i][j] = new Mine(true);
				} else {
					mines[i][j] = new Mine(false);
				}
			}
		}
		mines[0][0] = new Mine(false);
		mines[size - 1][size - 1] = new Mine(false);
		int nearby = 0;
		for(int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				nearby = 0;
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
					if(j+1<=size-1)
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
				if(i+1<=size-1)
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
					if(j+1<=size-1)
					{
						if(mines[i+1][j+1].isMined()) {
							nearby++;
						}
					}
				}
				if(j+1<=size-1)
				{
					if(mines[i][j+1].isMined()) {
						nearby++;
					}
				}
				mines[i][j].setNearby(nearby);
			}
		}
		mines[0][0].setStepped(true);
	}

	public void move(Heading heading) {
		// if (heading = Heading.NW) .. blah blah blah, move and stuff
		if(heading == Heading.N)
		{
			currentY--;
			if(currentY<0)
			{
				currentY++;
				Utilities.inform("Must stay one the grid.");
			}
		}
		if(heading == Heading.NE)
		{
			currentY--;
			currentX++;
			if(currentY<0 || currentX>=size)
			{
				currentY++;
				currentX--;
				Utilities.inform("Must stay one the grid.");
			}
		}
		if(heading == Heading.NW)
		{
			currentY--;
			currentX--;
			if(currentY<0 || currentX<0)
			{
				currentY++;
				currentX++;
				Utilities.inform("Must stay one the grid.");
			}
		}
		if(heading == Heading.E)
		{
			currentX++;
			if(currentX>=size)
			{
				currentX--;
				Utilities.inform("Must stay one the grid.");
			}
		}
		if(heading == Heading.W)
		{
			currentX--;
			if(currentX<0)
			{
				currentX++;
				Utilities.inform("Must stay one the grid.");
			}
		}
		if(heading == Heading.SE)
		{
			currentY++;
			currentX++;
			if(currentY>=size || currentX>=size)
			{
				currentY--;
				currentX--;
				Utilities.inform("Must stay one the grid.");
			}
		}
		if(heading == Heading.SW)
		{
			currentY++;
			currentX--;
			if(currentY>=size || currentX<0)
			{
				currentY--;
				currentX++;
				Utilities.inform("Must stay one the grid.");
			}
		}
		current = mines[currentX][currentY];
		current.setStepped(true);
		if(current.isMined())
		{
			gameOver(false);
		}
		else if(current == mines[size - 1][size - 1])
		{
			gameOver(true);
		}
		changed();
	}
	public void gameOver(boolean won)
	{
		if(won)
			Utilities.inform("Game over, you won!");
		else
			Utilities.inform("Game over, you lost.");
		setMines();
		currentX = 0;
		currentY = 0;
		current = mines[currentX][currentY];
		changed();
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

public class mineField{

	public mineField(){

	}
	public static void main(String args[]) {
		AppFactory factory = new fieldFactory();
		AppPanel panel = new fieldPanel(factory);
		panel.display();
	}
}