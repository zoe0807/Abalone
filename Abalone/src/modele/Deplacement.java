package modele;
import modele.Config.Direction;

public class Deplacement {

	public Deplacement( Pion p,Direction dir,Joueur j){
		switch(dir){
			case LEFT : move_left_1(p,j);
			break;
		}
	}

	/*void move_1(Direction dir, Pion p,Joueur j, PlateauAbalone plateau)
	{
		switch(dir)
		{
			case LEFT : move_left_1(p); 
				break;
			case RIGHT : move_right_1(p); 
				break;
			case UPLEFT : move_up_left_1(p); 	
				break;
			case UPRIGHT : move_up_right_1(p); 
				break;
			case DOWNLEFT : move_down_left_1(p); 
				break;
			case DOWNRIGHT : move_down_right_1(p); 
				break;
			default : break;
		}
	}*/

	public void move_left_1 (Pion p,Joueur j) 
	{
		int x=p.getX();
		j.modifiePion(p,x-2);
	}

	/*void move_right_1 (COORD p1,CASE T[11][21])
	{
		T[p1.x][p1.y+2]=T[p1.x][p1.y];
		T[p1.x][p1.y]=0;
	}

	void move_up_left_1 (COORD p1,CASE T[11][21])
	{
		T[p1.x-1][p1.y-1]=T[p1.x][p1.y];
		T[p1.x][p1.y]=0;
	}

	void move_up_right_1 (COORD p1,CASE T[11][21])	
	{			      
		T[p1.x-1][p1.y+1]=T[p1.x][p1.y];
		T[p1.x][p1.y]=0;
	}

	void move_down_left_1 (COORD p1,CASE T[11][21])
	{
		T[p1.x+1][p1.y-1]=T[p1.x][p1.y];
		T[p1.x][p1.y]=0;
	}

	void move_down_right_1 (COORD p1,CASE T[11][21])
	{
		T[p1.x+1][p1.y+1]=T[p1.x][p1.y];
		T[p1.x][p1.y]=0;
	}*/
	
}
