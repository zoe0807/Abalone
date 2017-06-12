package modele;
import java.awt.Color;

import modele.Config.Direction;
import modele.Config.Possible;

public class Deplacement {
	
	public Possible move_possible(Pion p1, Pion p2, Pion p3, Direction dir, int tab[][]){
		return Possible.LINE;
	}
	public Possible move_possible_1(Pion p1, Direction dir,int tab[][])
	{
		switch(dir)
		{
			case LEFT : return move_possible_left_1(p1,tab); 
			case RIGHT : return move_possible_right_1(p1,tab); 
			case UPLEFT : return move_possible_up_left_1(p1,tab); 	
			case UPRIGHT : return move_possible_up_right_1(p1,tab); 
			case DOWNLEFT : return move_possible_down_left_1(p1,tab); 
			case DOWNRIGHT : return move_possible_down_right_1(p1,tab); 
			default : return Possible.IMPOSSIBLE;
		}
	}
	public Possible move_possible_left_1(Pion p1,int tab[][])
	{
		if (tab[p1.getX()][p1.getY()-2]==0) return	Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}
	
	public Possible move_possible_right_1(Pion p1,int tab[][])
	{
		if (tab[p1.getX()][p1.getY()+2]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_1(Pion p1,int tab[][])
	{
		if (tab[p1.getX()-1][p1.getY()-1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_1(Pion p1,int tab[][])
	{
		if (tab[p1.getX()-1][p1.getY()+1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_1(Pion p1,int tab[][])
	{
		if (tab[p1.getX()+1][p1.getY()-1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_1(Pion p1,int tab[][])
	{
		if (tab[p1.getX()+1][p1.getY()+1]==0) return Possible.LINE;
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_1(Pion p1, Direction dir,int tab[][])
	{
		switch(dir)
		{
			case LEFT : move_left_1(p1,tab); 
				break;
			case RIGHT : move_right_1(p1,tab); 
				break;
			case UPLEFT : move_up_left_1(p1,tab); 	
				break;
			case UPRIGHT : move_up_right_1(p1,tab); 
				break;
			case DOWNLEFT : move_down_left_1(p1,tab); 
				break;
			case DOWNRIGHT : move_down_right_1(p1,tab); 
				break;
			default : break;
		}
	}
	public void move_left_1 (Pion p1,int tab[][]) 
	{
		tab[p1.getX()][p1.getY()-2]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	public void move_right_1 (Pion p1,int tab[][])
	{
		tab[p1.getX()][p1.getY()+2]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	public void move_up_left_1 (Pion p1,int tab[][])
	{
		tab[p1.getX()-1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	public void move_up_right_1 (Pion p1,int tab[][])	
	{			      
		tab[p1.getX()-1][p1.getY()+1]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	
	public void move_down_left_1 (Pion p1,int tab[][])
	{
		tab[p1.getX()+1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}

	public void move_down_right_1 (Pion p1,int tab[][])
	{
		tab[p1.getX()+1][p1.getY()+1]=tab[p1.getX()][p1.getY()];
		tab[p1.getX()][p1.getY()]=0;
	}
	public Possible move_possible_2(Pion p1,Pion p2, Direction dir,int tab[][], Joueur j)
	{

		switch(dir)
		{
			case LEFT : return move_possible_left_2(p1,p2,tab,j); 
			case RIGHT : return move_possible_right_2(p1,p2,tab,j); 
			case UPLEFT : return move_possible_up_left_2(p1,p2,tab,j); 	
			case UPRIGHT : return move_possible_up_right_2(p1,p2,tab,j); 
			case DOWNLEFT : return move_possible_down_left_2(p1,p2,tab,j); 
			case DOWNRIGHT : return move_possible_down_right_2(p1,p2,tab,j); 
			default : return Possible.IMPOSSIBLE;
		}

			
	}
	public Possible move_possible_left_2(Pion p1,Pion p2,int tab[][],Joueur j)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la m�me lignes, on verrifie donc s'il y a un sumito ou si la case � gauche est vide.
		{
			if ((tab[p1.getX()][p2.getY()-2]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p1.getX()][p2.getY()-2]==2))||((j.getCouleur()==Color.WHITE) && (tab[p1.getX()][p2.getY()-2]==1))) && ((tab[p1.getX()][p2.getY()-4]==0) || (tab[p1.getX()][p2.getY()-4]==3))) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ( (tab[p1.getX()][p1.getY()-2]==0) && (tab[p2.getX()][p2.getY()-2]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ( (tab[p1.getX()][p1.getY()-2]==0) && (tab[p2.getX()][p2.getY()-2]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_right_2(Pion p1,Pion p2,int tab[][],Joueur j)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la m�me lignes, on verrifie donc s'il y a un sumito ou si la case � gauche est vide.
		{
			if ((tab[p1.getX()][p2.getY()+2]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p1.getX()][p2.getY()+2]==2))||((j.getCouleur()==Color.WHITE) && (tab[p1.getX()][p2.getY()+2]==1))) && ((tab[p1.getX()][p2.getY()+4]==0) || (tab[p1.getX()][p2.getY()+4]==3))) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ( (tab[p1.getX()][p1.getY()+2]==0) && (tab[p2.getX()][p2.getY()+2]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1))) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ( (tab[p1.getX()][p1.getY()+2]==0) && (tab[p2.getX()][p2.getY()+2]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_2( Pion p1, Pion p2,int tab[][],Joueur j)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX())  //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � gauche sont vides.
		{
			if ( (tab[p1.getX()-1][p1.getY()-1]==0) && (tab[p2.getX()-1][p2.getY()-1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (tab[p1.getX()-1][p1.getY()-1]==0) && (tab[p2.getX()-1][p2.getY()-1]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (tab[p2.getX()-1][p2.getY()-1]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p2.getX()-1][p2.getY()-1]==2))||((j.getCouleur()==Color.WHITE) && (tab[p2.getX()-1][p2.getY()-1]==1))) && ((tab[p2.getX()-2][p2.getY()-2]==0) || (tab[p2.getX()-2][p2.getY()-2]==3))) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_2( Pion p1, Pion p2,int tab[][], Joueur j)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX())  //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � droite sont vides.
		{
			if ( (tab[p1.getX()-1][p1.getY()+1]==0) && (tab[p2.getX()-1][p2.getY()+1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (tab[p1.getX()-1][p1.getY()+1]==0) && (tab[p2.getX()-1][p2.getY()+1]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) ) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (tab[p2.getX()-1][p2.getY()+1]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p2.getX()-1][p2.getY()+1]==2))||((j.getCouleur()==Color.WHITE) && (tab[p2.getX()-1][p2.getY()+1]==1))) && ((tab[p2.getX()-2][p2.getY()+2]==0) || (tab[p2.getX()-2][p2.getY()+2]==3))) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_2( Pion p1, Pion p2,int tab[][],Joueur j)
	{
		if (p1.getY() < p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en bas � gauche sont vides.
		{
			if ( (tab[p1.getX()+1][p1.getY()-1]==0) && (tab[p2.getX()+1][p2.getY()-1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) ) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ( (tab[p1.getX()+1][p1.getY()-1]==0) && (tab[p2.getX()+1][p2.getY()-1]==0) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) ) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p2.getX()+1][p2.getY()-1]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p2.getX()+1][p2.getY()-1]==2))||((j.getCouleur()==Color.WHITE) && (tab[p2.getX()+1][p2.getY()-1]==1))) && ((tab[p2.getX()+2][p2.getY()-2]==0) || (tab[p2.getX()+2][p2.getY()-2]==3))) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_2( Pion p1, Pion p2,int tab[][],Joueur j)
	{
		if (p1.getY() > p2.getY()){
			int x=p1.getX();
			int y=p1.getY();
			p1.setX(p2.getX());
			p1.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getX()==p2.getX()) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � gauche sont vides.
		{
			if ( (tab[p1.getX()+1][p1.getY()+1]==0) && (tab[p2.getX()+1][p2.getY()+1]==0) ) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1)  ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1)  )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ( (tab[p1.getX()+1][p1.getY()+1]==0) && (tab[p2.getX()+1][p2.getY()+1]==0) ) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p2.getX()+1][p2.getY()+1]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p2.getX()+1][p2.getY()+1]==2))||((j.getCouleur()==Color.WHITE) && (tab[p2.getX()+1][p2.getY()+1]==1))) && ((tab[p2.getX()+2][p2.getY()+2]==0) || (tab[p2.getX()+2][p2.getY()+2]==3))) ) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_2(Pion p1, Pion p2, Direction dir,int tab[][], Possible alignment, Joueur j)
	{
		switch(dir)
		{
			case LEFT : move_left_2( p1, p2,tab, alignment,j); 
				break;
			case RIGHT : move_right_2( p1, p2,tab, alignment,j); 
				break;
			case UPLEFT : move_up_left_2(p1, p2,tab, alignment,j); 	
				break;
			case UPRIGHT : move_up_right_2( p1, p2,tab, alignment,j); 
				break;
			case DOWNLEFT : move_down_left_2( p1, p2,tab, alignment,j); 
				break;
			case DOWNRIGHT : move_down_right_2( p1, p2,tab, alignment,j); 
				break;
			default : break;
		}
	}
	
	public void move_left_2 (Pion p1,Pion p2,int tab[][],Possible al,Joueur j)
	{
		if (al != Possible.LINE)
		{
			tab[p1.getX()][p1.getY()-2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()][p2.getY()-2]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
		else
		{
			if (p2.getY() < p1.getY())
			{
				int x=p1.getX(); 	
				int y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
				}
			if (tab[p1.getX()][p1.getY()-2] != 0)
			{
				if (tab[p1.getX()][p1.getY()-4] == 0)
				{
					tab[p1.getX()][p1.getY()-4]=tab[p1.getX()][p1.getY()-2];
				}
				else {
				j.setScore(j.getScore()+1);
				}
			}
			tab[p1.getX()][p1.getY()-2]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
	}
	public void move_right_2 (Pion p1,Pion p2,int tab[][],Possible alignment,Joueur j)
	{	
		int x,y;
		if (alignment != Possible.LINE)
		{
			tab[p1.getX()][p1.getY()+2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()][p2.getY()+2]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
		else
		{
			if (p2.getY() < p1.getY())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());  
				p1.setY(p2.getY());
				p2.setX(x);     
				p2.setY(y);
			}
			if (tab[p2.getX()][p2.getY()+2] != 0)
			{
				if (tab[p2.getX()][p2.getY()+4] == 0)
				{
					tab[p2.getX()][p2.getY()+4]=tab[p2.getX()][p2.getY()+2];
				}
				else {
					j.setScore(j.getScore()+1);
				}
			}
			tab[p2.getX()][p2.getY()+2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_left_2 (Pion p1, Pion p2,int tab[][],Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment == Possible.LINE || alignment==Possible.DL) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()-1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()-1][p2.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getX() < p1.getX())
			{
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (tab[p1.getX()-1][p1.getY()-1] != 0)
			{
				if (tab[p1.getX()-2][p1.getY()-2] == 0)
				{
					tab[p1.getX()-2][p1.getY()-2]=tab[p1.getX()-1][p1.getY()-1];
				}
				else {
					j.setScore(j.getScore()+1);
				}
			}
			tab[p1.getX()-1][p1.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}	
	}
	
	public void move_up_right_2 (Pion p1, Pion p2,int tab[][],Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment == Possible.DR) 
		//Cas o� on les pions se trouvent sur la m�me ligne, ou en diagonale (pas sumito)
		{
			tab[p1.getX()-1][p1.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()-1][p2.getY()+1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getY() < p1.getY())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (tab[p2.getX()-1][p2.getY()+1] != 0)
			{
				if (tab[p2.getX()-2][p2.getY()+2] == 0)
				{
					tab[p2.getX()-2][p2.getY()+2]=tab[p2.getX()-1][p2.getY()+1];
				}
				else {
					j.setScore(j.getScore()+1);
				}
				
			}
			tab[p2.getX()-1][p2.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}	
	}
	
	public void move_down_left_2 (Pion p1, Pion p2,int tab[][], Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas o� on les pions se trouvent sur la m�me ligne,ou en diagonale (pas sumito)
		{
			tab[p1.getX()+1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()+1][p2.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p1.getX() < p2.getX())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());  p1.setY(p2.getY());
				p2.setX(x);     p2.setY(y);
			}
			if (tab[p1.getX()+1][p1.getY()-1] != 0)
			{
				if (tab[p1.getX()+2][p1.getY()-2] == 0)
				{
					tab[p1.getX()+2][p1.getY()-2]=tab[p1.getX()+1][p1.getY()-1];
				}
				else{
					j.setScore(j.getScore()+1);
				}
			tab[p1.getX()+1][p1.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
			}
		}	
	}

	public void move_down_right_2 (Pion p1, Pion p2,int tab[][],Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) 
		//Cas o� on les pions se trouvent sur la m�me ligne, ou en diagonale (pas sumito)
		{
			tab[p1.getX()+1][p1.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()+1][p2.getY()+1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getY() < p1.getY())
			{
				x=p1.getX(); 	y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (tab[p2.getX()+1][p2.getY()+1] != 0)
			{
				if (tab[p2.getX()+2][p2.getY()+2] == 0)
				{
					tab[p2.getX()+2][p2.getY()+2]=tab[p2.getX()+1][p2.getY()+1];
				}
				else 
				{
					j.setScore(j.getScore()+1);
				}
			}
			tab[p2.getX()+1][p2.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}	
	}
	
	public Possible move_possible_3(Pion p1,Pion p2,Pion p3, Direction dir,int tab[][],Joueur j)
	{

		switch(dir)
		{
			case LEFT : return move_possible_left_3(p1,p2,p3,tab,j); 
			case RIGHT : return move_possible_right_3(p1,p2,p3,tab,j); 
			case UPLEFT : return move_possible_up_left_3(p1,p2,p3,tab,j); 	
			case UPRIGHT : return move_possible_up_right_3(p1,p2,p3,tab,j); 
			case DOWNLEFT : return move_possible_down_left_3(p1,p2,p3,tab,j); 
			case DOWNRIGHT : return move_possible_down_right_3(p1,p2,p3,tab,j); 
			default : return Possible.IMPOSSIBLE;
		}

			
	}
	public Possible move_possible_left_3( Pion p1, Pion p2, Pion p3,int tab[][],Joueur j)
	{
		int x,y;
		if (p2.getY() < p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() < p2.getY()){
			if (p1.getY() < p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}	
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc s'il y a un sumito ou si la case � gauche est vide.
		{
			if ((tab[p1.getX()][p3.getY()-2]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p1.getX()][p3.getY()-2]==2))||((j.getCouleur()==Color.WHITE) && (tab[p1.getX()][p3.getY()-2]==1))) && ((tab[p1.getX()][p3.getY()-4]==0) || (tab[p1.getX()][p3.getY()-4]==3))) || ((((j.getCouleur()==Color.BLACK) && (tab[p1.getX()][p3.getY()-2]==2) && (tab[p1.getX()][p3.getY()-4]==2))||((j.getCouleur()==Color.WHITE) && (tab[p1.getX()][p3.getY()-2]==1) && (tab[p1.getX()][p3.getY()-4]==1))) && ((tab[p1.getX()][p3.getY()-6]==0) || (tab[p1.getX()][p3.getY()-6]==3)))) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ((tab[p1.getX()][p1.getY()-2]==0) && (tab[p2.getX()][p2.getY()-2]==0) && (tab[p3.getX()][p3.getY()-2]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ((tab[p1.getX()][p1.getY()-2]==0) && (tab[p2.getX()][p2.getY()-2]==0) && (tab[p3.getX()][p3.getY()-2]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_right_3( Pion p1, Pion p2, Pion p3,int tab[][],Joueur j)
	{
		int x,y;
		if (p2.getY() > p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() > p2.getY()){
			if (p1.getY() > p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc s'il y a un sumito ou si la case � gauche est vide.
		{
			if ((tab[p1.getX()][p3.getY()+2]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p1.getX()][p3.getY()+2]==2))||((j.getCouleur()==Color.WHITE) && (tab[p1.getX()][p3.getY()+2]==1))) && ((tab[p1.getX()][p3.getY()+4]==0) || (tab[p1.getX()][p3.getY()+4]==3))) || ((((j.getCouleur()==Color.BLACK) && (tab[p1.getX()][p3.getY()+2]==2) && (tab[p1.getX()][p3.getY()+4]==2))||((j.getCouleur()==Color.WHITE) && (tab[p1.getX()][p3.getY()+2]==1) && (tab[p1.getX()][p3.getY()+4]==1))) && ((tab[p1.getX()][p3.getY()+6]==0) || (tab[p1.getX()][p3.getY()+6]==3)))) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ((tab[p1.getX()][p1.getY()+2]==0) && (tab[p2.getX()][p2.getY()+2]==0) && (tab[p3.getX()][p3.getY()+2]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales droites, on verrifie donc que les 3 cases � gauche sont vides.
		{
			if ((tab[p1.getX()][p1.getY()+2]==0) && (tab[p2.getX()][p2.getY()+2]==0) && (tab[p3.getX()][p3.getY()+2]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_left_3( Pion p1, Pion p2, Pion p3,int tab[][],Joueur j)
	{
		int x,y;
		if (p2.getY() < p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() < p2.getY()){
			if (p1.getY() < p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}	
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � gauche sont vides.
		{
			if ((tab[p1.getX()-1][p1.getY()-1]==0) && (tab[p2.getX()-1][p2.getY()-1]==0) && (tab[p3.getX()-1][p3.getY()-1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p1.getX()-1][p1.getY()-1]==0) && (tab[p2.getX()-1][p2.getY()-1]==0) && (tab[p3.getX()-1][p3.getY()-1]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p3.getX()-1][p3.getY()-1]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p3.getX()-1][p3.getY()-1]==2))||((j.getCouleur()==Color.WHITE) && (tab[p3.getX()-1][p3.getY()-1]==1))) && ((tab[p3.getX()-2][p3.getY()-2]==0) || (tab[p3.getX()-2][p3.getY()-2]==3))) || ((((j.getCouleur()==Color.BLACK) && (tab[p3.getX()-1][p3.getY()-1]==2) && (tab[p3.getX()-2][p3.getY()-2]==2))||((j.getCouleur()==Color.WHITE) && (tab[p3.getX()-1][p3.getY()-1]==1) && (tab[p3.getX()-2][p3.getY()-2]==1))) && ((tab[p3.getX()-3][p3.getY()-3]==0) || (tab[p3.getX()-3][p3.getY()-3]==3)))) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_up_right_3( Pion p1, Pion p2, Pion p3,int tab[][],Joueur j)
	{
		int x,y;
		if (p2.getY() > p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() > p2.getY()){
			if (p1.getY() > p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � droite sont vides.
		{
			if ((tab[p1.getX()-1][p1.getY()+1]==0) && (tab[p2.getX()-1][p2.getY()+1]==0) && (tab[p3.getX()-1][p3.getY()+1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p1.getX()-1][p1.getY()+1]==0) && (tab[p2.getX()-1][p2.getY()+1]==0) && (tab[p3.getX()-1][p3.getY()+1]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2)) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p3.getX()-1][p3.getY()+1]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p3.getX()-1][p3.getY()+1]==2))||((j.getCouleur()==Color.WHITE) && (tab[p3.getX()-1][p3.getY()+1]==1))) && ((tab[p3.getX()-2][p3.getY()+2]==0) || (tab[p3.getX()-2][p3.getY()+2]==3))) || ((((j.getCouleur()==Color.BLACK) && (tab[p3.getX()-1][p3.getY()+1]==2) && (tab[p3.getX()-2][p3.getY()+2]==2))||((j.getCouleur()==Color.WHITE) && (tab[p3.getX()-1][p3.getY()+1]==1) && (tab[p3.getX()-2][p3.getY()+2]==1))) && ((tab[p3.getX()-3][p3.getY()+3]==0) || (tab[p3.getX()-3][p3.getY()+3]==3)))) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_left_3( Pion p1, Pion p2, Pion p3,int tab[][], Joueur j)
	{
		int x,y;
		if (p2.getY() > p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() > p2.getY()){
			if (p1.getY() > p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en bas � gauche sont vides.
		{
			if ((tab[p1.getX()+1][p1.getY()-1]==0) && (tab[p2.getX()+1][p2.getY()-1]==0) && (tab[p3.getX()+1][p3.getY()-1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if ( ((p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()+2)) || ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) ) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p1.getX()+1][p1.getY()-1]==0) && (tab[p2.getX()+1][p2.getY()-1]==0) && (tab[p3.getX()+1][p3.getY()-1]==0)) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2)) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p3.getX()+1][p3.getY()-1]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p3.getX()+1][p3.getY()-1]==2))||((j.getCouleur()==Color.WHITE) && (tab[p3.getX()+1][p3.getY()-1]==1))) && ((tab[p3.getX()+2][p3.getY()-2]==0) || (tab[p3.getX()+2][p3.getY()-2]==3))) || ((((j.getCouleur()==Color.BLACK) && (tab[p3.getX()+1][p3.getY()-1]==2) && (tab[p3.getX()+2][p3.getY()-2]==2))||((j.getCouleur()==Color.WHITE) && (tab[p3.getX()+1][p3.getY()-1]==1) && (tab[p3.getX()+2][p3.getY()-2]==1))) && ((tab[p3.getX()+3][p3.getY()-3]==0) || (tab[p3.getX()+3][p3.getY()-3]==3)))) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}

	public Possible move_possible_down_right_3( Pion p1, Pion p2, Pion p3,int tab[][],Joueur j)
	{
		int x,y;
		if (p2.getY() < p3.getY()){
			x=p3.getX(); 	
			y=p3.getY();
			p3.setX(p2.getX());
			p3.setY(p2.getY());
			p2.setX(x);
			p2.setY(y);
		}
		if (p1.getY() < p2.getY()){
			if (p1.getY() < p3.getY()){
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p3.getX());
				p1.setY(p3.getY());
				p3.setX(x);
				p3.setY(y);
			}
			else {
				x=p1.getX(); 	
				y=p1.getY();
				p1.setX(p2.getX());
				p1.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
		}	
		if ((p1.getX()==p2.getX()) && (p1.getX()==p3.getX())) //Les pions sont sur la m�me lignes, on verrifie donc que les 3 cases en haut � gauche sont vides.
		{
			if ((tab[p1.getX()+1][p1.getY()+1]==0) && (tab[p2.getX()+1][p2.getY()+1]==0) && (tab[p3.getX()+1][p3.getY()+1]==0)) return Possible.LINE;
			else return Possible.IMPOSSIBLE;
		}
		else if (( (p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()+1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()+2) ) || ( (p1.getX()==p2.getX()+1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()+2) && (p1.getY()==p3.getY()-2) )) //Les pions sont en diagonales gauches ( de haut en bas ).
		{
			if ((tab[p1.getX()+1][p1.getY()+1]==0) && (tab[p2.getX()+1][p2.getY()+1]==0) && (tab[p3.getX()+1][p3.getY()+1]==0)) return Possible.DL;
			else return Possible.IMPOSSIBLE;
		}
		else if ((p1.getX()==p2.getX()-1) && (p1.getY()==p2.getY()-1) && (p1.getX()==p3.getX()-2) && (p1.getY()==p3.getY()-2)) //Les pions sont en diagonales droites ( de haut en bas ).
		{
			if ((tab[p3.getX()+1][p3.getY()+1]==0) || ((((j.getCouleur()==Color.BLACK) && (tab[p3.getX()+1][p3.getY()+1]==2))||((j.getCouleur()==Color.WHITE) && (tab[p3.getX()+1][p3.getY()+1]==1))) && ((tab[p3.getX()+2][p3.getY()+2]==0) || (tab[p3.getX()+2][p3.getY()+2]==3))) || ((((j.getCouleur()==Color.BLACK) && (tab[p3.getX()+1][p3.getY()+1]==2) && (tab[p3.getX()+2][p3.getY()+2]==2))||((j.getCouleur()==Color.WHITE) && (tab[p3.getX()+1][p3.getY()+1]==1) && (tab[p3.getX()+2][p3.getY()+2]==1))) && ((tab[p3.getX()+3][p3.getY()+3]==0) || (tab[p3.getX()+3][p3.getY()+3]==3)))) return Possible.DR;
			else return Possible.IMPOSSIBLE;
		}
		else return Possible.IMPOSSIBLE;
	}
	
	public void move_3( Pion p1, Pion p2, Pion p3, Direction dir,int tab[][], Possible alignment,Joueur j)
	{
		switch(dir)
		{
			case LEFT : move_left_3( p1, p2, p3, tab,alignment,j); 
				break;
			case RIGHT : move_right_3( p1, p2, p3, tab,alignment,j); 
				break;
			case UPLEFT : move_up_left_3( p1, p2, p3, tab,alignment,j); 	
				break;
			case UPRIGHT : move_up_right_3( p1, p2, p3, tab,alignment,j); 
				break;
			case DOWNLEFT : move_down_left_3(p1, p2, p3, tab,alignment,j); 
				break;
			case DOWNRIGHT : move_down_right_3( p1, p2, p3, tab,alignment,j); 
				break;
			default : break;
		}
	}
	public void move_left_3 (Pion p1,Pion p2,Pion p3,int tab[][],Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment != Possible.LINE)
		{
			tab[p1.getX()][p1.getY()-2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()][p2.getY()-2]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()][p3.getY()-2]=tab[p3.getX()][p3.getY()];
			tab[p3.getX()][p3.getY()]=0;
		}
		else
		{
			//Aligner les pions
			if (p2.getY() < p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() < p2.getY()){
				if (p1.getY() < p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}	
			if (tab[p3.getX()][p3.getY()-2] != 0)
			{
				if ((tab[p3.getX()][p3.getY()-4] != 0) && (tab[p3.getX()][p3.getY()-6] == 3))
				{
					j.setScore(j.getScore()+1);
				}
				else if (tab[p3.getX()][p3.getY()-4] == 0)
				{
					tab[p3.getX()][p3.getY()-4]=tab[p3.getX()][p3.getY()-2];
				}
				else
				{
					tab[p3.getX()][p3.getY()-6]=tab[p3.getX()][p3.getY()-2];
				}
			}
			tab[p3.getX()][p3.getY()-2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_right_3 (Pion p1,Pion p2,Pion p3,int tab[][],Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment != Possible.LINE)
		{
			tab[p1.getX()][p1.getY()+2] = tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()][p2.getY()+2] = tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()] = 0;
			tab[p3.getX()][p3.getY()+2] = tab[p3.getX()][p3.getY()];
			tab[p3.getX()][p3.getY()] = 0;
		}
		else
		{
			if (p2.getY() > p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() > p2.getY()){
				if (p1.getY() > p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}
			if (tab[p3.getX()][p3.getY()+2] != 0)
			{
				if ((tab[p3.getX()][p3.getY()+4] != 0) && (tab[p3.getX()][p3.getY()+6] == 3))
				{
					j.setScore(j.getScore()+1);
				}
				else if (tab[p3.getX()][p3.getY()+4] == 0)
				{
					tab[p3.getX()][p3.getY()+4]=tab[p3.getX()][p3.getY()+2];
				}
				else
				{
					tab[p3.getX()][p3.getY()+6]=tab[p3.getX()][p3.getY()+2];
				}
			}
			tab[p3.getX()][p3.getY()+2]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_left_3 (Pion p1, Pion p2,Pion p3,int tab[][],Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()-1][p1.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()-1][p2.getY()-1]=tab[p2.getX()][p2.getY()];
			tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()-1][p3.getY()-1]=tab[p3.getX()][p3.getY()];
			tab[p3.getX()][p3.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			//Aligner les pions
			if (p2.getY() < p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() < p2.getY()){
				if (p1.getY() < p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}
			if (tab[p3.getX()-1][p3.getY()-1] != 0)
			{
				if ((tab[p3.getX()-2][p3.getY()-2] != 0) && (tab[p3.getX()-3][p3.getY()-3] == 3))
				{
					j.setScore(j.getScore()+1);
				}
				else if (tab[p3.getX()-2][p3.getY()-2] == 0)
				{
					tab[p3.getX()-2][p3.getY()-2]=tab[p3.getX()-1][p3.getY()-1];
				}
				else
				{
					tab[p3.getX()-3][p3.getY()-3]=tab[p3.getX()-1][p3.getY()-1];
				}
			}
			tab[p3.getX()-1][p3.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_up_right_3 (Pion p1, Pion p2,Pion p3,int tab[][],Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()-1][p1.getY()+1]=tab[p1.getX()][p1.getY()];	tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()-1][p2.getY()+1]=tab[p2.getX()][p2.getY()];	tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()-1][p3.getY()+1]=tab[p3.getX()][p3.getY()];	tab[p3.getX()][p3.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getY() > p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() > p2.getY()){
				if (p1.getY() > p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}
			if (tab[p3.getX()-1][p3.getY()+1] != 0)
			{
				if ((tab[p3.getX()-2][p3.getY()+2] != 0) && (tab[p3.getX()-3][p3.getY()+3] == 3))
				{
					j.setScore(j.getScore()+1);
				}
				else if (tab[p3.getX()-2][p3.getY()+2] == 0)
				{
					tab[p3.getX()-2][p3.getY()+2]=tab[p3.getX()-1][p3.getY()+1];
				}
				else
				{
					tab[p3.getX()-3][p3.getY()+3]=tab[p3.getX()-1][p3.getY()+1];
				}
			}
			tab[p3.getX()-1][p3.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	
	public void move_down_left_3 (Pion p1, Pion p2,Pion p3,int tab[][], Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DR) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()+1][p1.getY()-1]=tab[p1.getX()][p1.getY()];	tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()+1][p2.getY()-1]=tab[p2.getX()][p2.getY()];	tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()+1][p3.getY()-1]=tab[p3.getX()][p3.getY()];	tab[p3.getX()][p3.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			//Aligner les pions
			if (p2.getY() < p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() < p2.getY()){
				if (p1.getY() < p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}	
			if (tab[p3.getX()+1][p3.getY()-1] != 0)
			{
				if ((tab[p3.getX()+2][p3.getY()-2] != 0) && (tab[p3.getX()+3][p3.getY()-3] == 3))
				{
					j.setScore(j.getScore()+1);
				}
				else if (tab[p3.getX()+2][p3.getY()-2] == 0)
				{
					tab[p3.getX()+2][p3.getY()-2]=tab[p3.getX()+1][p3.getY()-1];
				}
				else
				{
					tab[p3.getX()+3][p3.getY()-3]=tab[p3.getX()+1][p3.getY()-1];
				}
			}
			tab[p3.getX()+1][p3.getY()-1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}

	public void move_down_right_3 (Pion p1, Pion p2,Pion p3,int tab[][],Possible alignment,Joueur j)
	{
		int x,y;
		if (alignment==Possible.LINE || alignment==Possible.DL) //Cas o� les pions sont sur la m�me ligne, ou deplacement simple (pas sumito)
		{
			tab[p1.getX()+1][p1.getY()+1]=tab[p1.getX()][p1.getY()];	tab[p1.getX()][p1.getY()]=0;
			tab[p2.getX()+1][p2.getY()+1]=tab[p2.getX()][p2.getY()];	tab[p2.getX()][p2.getY()]=0;
			tab[p3.getX()+1][p3.getY()+1]=tab[p3.getX()][p3.getY()];	tab[p3.getX()][p3.getY()]=0;
		}
		else //Cas diagonales (possible sumito)
		{
			if (p2.getY() > p3.getY()){
				x=p3.getX(); 	
				y=p3.getY();
				p3.setX(p2.getX());
				p3.setY(p2.getY());
				p2.setX(x);
				p2.setY(y);
			}
			if (p1.getY() > p2.getY()){
				if (p1.getY() > p3.getY()){
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p3.getX());
					p1.setY(p3.getY());
					p3.setX(x);
					p3.setY(y);
				}
				else {
					x=p1.getX(); 	
					y=p1.getY();
					p1.setX(p2.getX());
					p1.setY(p2.getY());
					p2.setX(x);
					p2.setY(y);
				}
			}
			if (tab[p3.getX()+1][p3.getY()+1] != 0)
			{
				if ((tab[p3.getX()+2][p3.getY()+2] != 0) && (tab[p3.getX()+3][p3.getY()+3] == 3))
				{
					j.setScore(j.getScore()+1);
				}
				else if (tab[p3.getX()+2][p3.getY()+2] == 0)
				{
					tab[p3.getX()+2][p3.getY()+2]=tab[p3.getX()+1][p3.getY()+1];
				}
				else
				{
					tab[p3.getX()+3][p3.getY()+3]=tab[p3.getX()+1][p3.getY()+1];
				}
			}
			tab[p3.getX()+1][p3.getY()+1]=tab[p1.getX()][p1.getY()];
			tab[p1.getX()][p1.getY()]=0;
		}
	}
	

}

