package modele;

import java.awt.Color;
import java.util.ArrayList;

import modele.Config.Direction;
import modele.Config.Possible;

public class Ia {
	private int[][] valeurPlateau;
	private int[][] plateauJeu;

	public Ia(PlateauAbalone jeu){
		int tab[][] =  {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,10,0,10,0,10,0,10,0,10,0,0,0,0,0,0},
						{0,0,0,0,0,10,0,50,0,50,0,50,0,50,0,10,0,0,0,0,0},
						{0,0,0,0,10,0,50,0,75,0,75,0,75,0,50,0,10,0,0,0,0},
						{0,0,0,10,0,50,0,75,0,85,0,85,0,75,0,50,0,10,0,0,0},
						{0,0,10,0,50,0,75,0,85,0,100,0,85,0,75,0,50,0,10,0,0},
						{0,0,0,10,0,50,0,75,0,85,0,85,0,75,0,50,0,10,0,0,0},
						{0,0,0,0,10,0,50,0,75,0,75,0,75,0,50,0,10,0,0,0,0},
						{0,0,0,0,0,10,0,50,0,50,0,50,0,50,0,10,0,0,0,0,0},
						{0,0,0,0,0,0,10,0,10,0,10,0,10,0,10,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		valeurPlateau = tab;
		plateauJeu = jeu.getPlateau();
		Pion p1 = new Pion(0,0);
		Pion p2 = new Pion(0,0);
		Pion p3 = new Pion(0,0);
	}
	
	public int[][] getValeurPlateau(){
		return valeurPlateau;
	}
	
	public int value_board (int tab[][],Color couleur){
		int of,def;
		int val = 0;
		if (couleur == Color.BLACK){
			of=1;	def=2;
		}
		else{
			of = 2;	def =1;
		}
		
		for (int l=0;l<11;l++){
			for (int c=0;c<21;c++){
				if (tab[l][c] == of){
					val += valeurPlateau[l][c];
					val += 100;
				}
				else if (tab[l][c] == def){
					val -= valeurPlateau[l][c];
					val -= 100;
				}
			}
		}
		return val;
	}
	
	public ArrayList<GroupePions> add_liste(ArrayList<GroupePions> regroupementPions,Pion p1, Pion p2, Pion p3){
		
		GroupePions gpe = new GroupePions(p1,p2,p3);
		regroupementPions.add(gpe);
		return regroupementPions;
	}
	
	public ArrayList<GroupePions> pions_together(ArrayList<GroupePions> regroupementPions,Color couleur, int l, int c){
		
		Pion p1 = new Pion(l,c);
		regroupementPions = add_liste(regroupementPions,p1,new Pion(0,0),new Pion(0,0));
		int joueur ;
		if (couleur == Color.BLACK)
			joueur = 1;
		else
			joueur = 2;
		
		if (plateauJeu[l][c+2] == joueur){ //Cas en ligne
			Pion p2 = new Pion(l,c+2);
			regroupementPions = add_liste(regroupementPions,p1,p2,new Pion(0,0));
			if (plateauJeu[l][c+4] == joueur){
				Pion p3 = new Pion(l,c+4);
				regroupementPions = add_liste(regroupementPions,p1,p2,p3);
			}
		}
		if (plateauJeu[l+1][c-1] == joueur){ //Cas DL
			Pion p4 = new Pion(l+1,c+1);
			regroupementPions = add_liste(regroupementPions,p1,p4,new Pion(0,0));
			if (plateauJeu[l+2][c-2] == joueur){
				Pion p5 = new Pion(l+2,c+2);
				regroupementPions = add_liste(regroupementPions,p1,p4,p5);
			}
		}
		
		if (plateauJeu[l+1][c+1] == joueur){ //Cas DR
			Pion p6 = new Pion(l+1,c+1);
			regroupementPions = add_liste(regroupementPions,p1,p6,new Pion(0,0));
			if (plateauJeu[l+2][c+2] == joueur){
				Pion p7 = new Pion(l+2,c+2);
				regroupementPions = add_liste(regroupementPions,p1,p6,p7);
			}
		}
		return regroupementPions;
	}

	
	public ArrayList<GroupePions> create_depPossibles(Color couleur){
		ArrayList<GroupePions> regroupementPions = new ArrayList<GroupePions>();
		int joueur;
		if (couleur == Color.BLACK){
			joueur = 1;
		}
		else
			joueur = 2;
		for (int l=0;l<11;l++){
			for (int c=0;c<21;c++){
				if (plateauJeu[l][c] == joueur){
					pions_together(regroupementPions,couleur,l,c);
				}
			}
		}
		return regroupementPions;
	}
	
	public void affichedep(ArrayList<GroupePions> regroupementPions){
		for (GroupePions gpe : regroupementPions){
			System.out.println(gpe.toString());
		}
	}
	
	public int maximum(int a,int b){
		if (a>b)
			return a;
		else
			return b;
	}
	
	public int minimum(int a,int b){
		if (a<b)
			return a;
		else
			return b;
	}
	
	public int Min(int tableau[][],int depth, int alpha, int beta, Color couleur){
		
		ArrayList<GroupePions> regroupementPions = new ArrayList<GroupePions>();
		regroupementPions = create_depPossibles(couleur);
		Deplacement dep = new Deplacement();
		int Min_val=10000;
		Possible result;
		Direction dir = null;
		Color opponent;
		if (couleur == Color.BLACK)
			opponent = Color.WHITE;
		else
			opponent = Color.BLACK;
		int tab[][] = copy_tab(tableau);
		
		if ((depth == 0) ||is_victory(tab))
			return value_board(tab,couleur);
		
		for (GroupePions gpe : regroupementPions){
			for (int i=0;i<6;i++){
				switch (i){
				case 0 : 
					dir = Direction.LEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 1 : 
					dir = Direction.RIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 2 : 
					dir = Direction.UPLEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 3 : 
					dir = Direction.UPRIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 4 : 
					dir = Direction.DOWNLEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 5 : 
					dir = Direction.DOWNRIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				default : 
					result = Possible.IMPOSSIBLE;
					break;
				}
				if (result != Possible.IMPOSSIBLE)
					dep.move(gpe.getP1(),gpe.getP2(),gpe.getP3(),dir,tab,result);
				else 
					continue;
				
				Min_val=minimum(Min_val,Max(tab,depth-1,alpha,beta,opponent));
				beta = minimum(beta,Min_val);
				tab = copy_tab(tableau);
				if (Min_val <= alpha)
					return Min_val;	
			}
		}
		return Min_val;
	}
	
	public int Max(int tableau[][],int depth, int alpha, int beta, Color couleur){
		ArrayList<GroupePions> regroupementPions = new ArrayList<GroupePions>();
		regroupementPions = create_depPossibles(couleur);
		
		Color opponent;
		if (couleur == Color.BLACK)
			opponent = Color.WHITE;
		else
			opponent = Color.BLACK;
		
		Deplacement dep = new Deplacement();
		int Max_val= -10000;
		Possible result;
		Direction dir=null;
		int tab[][] = copy_tab(tableau);

		if ((depth == 0) ||is_victory(tab))
			return value_board(tab,couleur);
		
		for (GroupePions gpe : regroupementPions){
			for (int i=0;i<6;i++){
				
				switch (i){
				case 0 : 
					dir = Direction.LEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 1 : 
					dir = Direction.RIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 2 : 
					dir = Direction.UPLEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 3 : 
					dir = Direction.UPRIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 4 : 
					dir = Direction.DOWNLEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 5 : 
					dir = Direction.DOWNRIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				default : 
					result = Possible.IMPOSSIBLE;
					break;
				}
				if (result != Possible.IMPOSSIBLE)
					dep.move(gpe.getP1(),gpe.getP2(),gpe.getP3(),dir,tab,result);
				else 
					continue;
				
				Max_val=maximum(Max_val, Min(tab,depth-1,alpha,beta,opponent));
				alpha = maximum(alpha,Max_val);
				tab = copy_tab(tableau);
				if (Max_val >= alpha)
					return Max_val;
			}
		}
		return Max_val;
	}
	
	public int[][] copy_tab(int origine[][]){
		int tab[][] = new int[11][21];
		for (int i=0;i<11;i++){
			for (int j=0;j<21;j++){
				tab[i][j] = origine[i][j];
			}
		}
		return tab;
	}
	
	public void alpha_beta(Color couleur,int depth){
		ArrayList<GroupePions> regroupementPions = new ArrayList<GroupePions>();
		regroupementPions = create_depPossibles(couleur);
		
		Deplacement dep= new Deplacement();
		int alpha = -10000;
		int beta = 10000;
		int Max_val = -10000;
		Possible result = null;
		Direction dir = null;
		Direction result_dir = null;
		Color opponent;
		if (couleur == Color.BLACK)
			opponent = Color.WHITE;
		else
			opponent = Color.BLACK;
		
		int tab[][] = copy_tab(plateauJeu);
		
		Pion pos1 = new Pion(0,0);
		Pion pos2 = new Pion(0,0);
		Pion pos3 = new Pion(0,0);
		
		for (GroupePions gpe : regroupementPions){
			for (int i=0;i<6;i++){					
				switch (i){
				case 0 : 
					dir = Direction.LEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 1 : 
					dir = Direction.RIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 2 : 
					dir = Direction.UPLEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 3 : 
					dir = Direction.UPRIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 4 : 
					dir = Direction.DOWNLEFT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				case 5 : 
					dir = Direction.DOWNRIGHT;
					result = dep.move_possible(gpe.getP1(), gpe.getP2(),gpe.getP3(),dir,tab,couleur);
					break;
				default : 
					result = Possible.IMPOSSIBLE;
					break;
				}
				
				if (result != Possible.IMPOSSIBLE){					
					dep.move(gpe.getP1(),gpe.getP2(),gpe.getP3(),dir,tab,result);
				}	
				else 
					continue;
				
				int tmp = Min(tab,depth, alpha,beta,opponent);
				if (tmp>Max_val){
					Max_val = tmp;
					result_dir = dir;
					pos1.setX(gpe.getP1().getX());
					pos1.setY(gpe.getP1().getY());
					pos2.setX(gpe.getP2().getX());
					pos2.setY(gpe.getP2().getY());
					pos3.setX(gpe.getP3().getX());
					pos3.setY(gpe.getP3().getY());		
				}
				tab = copy_tab(plateauJeu);
			}
		}
		GroupePions gpe = new GroupePions(pos1,pos2,pos3);
		System.out.println("Direction :" + result_dir + "  " + gpe.toString() );
		if (pos3.getX() == 0 && pos2.getX() == 0)
			dep.move_1(pos1,result_dir,plateauJeu);
		else if (pos3.getX() == 0)
			dep.move_2(pos1,pos2,result_dir,plateauJeu,result);
		else 
			dep.move_3(pos1,pos2,pos3,result_dir,plateauJeu,result);
		
	}
	
	public void affichePlateau(){
		for (int i=0;i<11;i++){
			for (int j=0;j<21;j++){
				if (plateauJeu[i][j] == 1){
					System.out.print(" 1");
				}
				else if (plateauJeu[i][j] == 2){
					System.out.print(" 2");
				}
				else if (plateauJeu[i][j] == 0){
					System.out.print(" *");
				}
				else 
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	public boolean is_victory(int tab[][]){
		int cpt1 = 0;
		int cpt2 = 0;
		for (int i=0;i<11;i++){
			for (int j=0;j<21;j++){
				if (tab[i][j] == 1)
					cpt1++;
				else if (tab[i][j] == 2)
					cpt2++;
			}
		}
		if (cpt1 == 8 || cpt2 == 8) 
			return true;
		else
			return false;
	}
	public void test_ia(){
		int tab[][]=plateauJeu;
		while (!is_victory(tab)){
			alpha_beta(Color.BLACK,2);
			affichePlateau();
			alpha_beta(Color.WHITE,2);
			affichePlateau();
		}
	}
}