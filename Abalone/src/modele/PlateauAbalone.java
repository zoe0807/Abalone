package modele;
import java.util.ArrayList;

import modele.Config.PositionDepart;

public class PlateauAbalone {
	private int[][] plateau;
	private ArrayList<Joueur> listeJoueurs;
	
	public PlateauAbalone(){
		int tableau[][] =   {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
							{5,5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5,5},
							{5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5},
							{5,5,3,5,0,5,0,5,2,5,2,5,2,5,0,5,0,5,3,5,5},
							{5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
							{3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3},
							{5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
							{5,5,3,5,0,5,0,5,1,5,1,5,1,5,0,5,0,5,3,5,5},
							{5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5},
							{5,5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5,5},
							{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
		
		this.plateau = tableau;	
		listeJoueurs = new ArrayList<Joueur>();
	}
	
	
	public PlateauAbalone(PositionDepart pos, Joueur j1, Joueur j2){
		switch (pos){
		case STANDARD : 
			int tab_standard[][] =   {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
									{5,5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5,5},
									{5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5},
									{5,5,3,5,0,5,0,5,2,5,2,5,2,5,0,5,0,5,3,5,5},
									{5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
									{3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3},
									{5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
									{5,5,3,5,0,5,0,5,1,5,1,5,1,5,0,5,0,5,3,5,5},
									{5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5},
									{5,5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5,5},
									{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_standard;							
			break;
		case DAISY : 
			int tab_daisy[][] =   {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
								   {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								   {5,5,5,3,5,2,5,2,5,0,5,0,5,1,5,1,5,3,5,5,5},
								   {5,5,3,5,2,5,1,5,2,5,0,5,1,5,2,5,1,5,3,5,5},
								   {5,3,5,0,5,2,5,2,5,0,5,0,5,1,5,1,5,0,5,3,5},
								   {3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3},
								   {5,3,5,0,5,1,5,1,5,0,5,0,5,2,5,2,5,0,5,3,5},
								   {5,5,3,5,1,5,2,5,1,5,0,5,2,5,1,5,2,5,3,5,5},
								   {5,5,5,3,5,1,5,1,5,0,5,0,5,2,5,2,5,3,5,5,5},
								   {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								   {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_daisy;
			break;
		case DOMINATION :
			int tab_domination[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
								    {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								    {5,5,5,3,5,2,5,0,5,0,5,0,5,0,5,1,5,3,5,5,5},
								    {5,5,3,5,2,5,2,5,0,5,0,5,0,5,1,5,1,5,3,5,5},
								    {5,3,5,2,5,2,5,2,5,2,5,0,5,1,5,1,5,1,5,3,5},
								    {3,5,0,5,0,5,0,5,1,5,0,5,1,5,0,5,0,5,0,5,3},
								    {5,3,5,1,5,1,5,1,5,0,5,2,5,2,5,2,5,2,5,3,5},
								    {5,5,3,5,1,5,1,5,0,5,0,5,0,5,2,5,2,5,3,5,5},
								    {5,5,5,3,5,1,5,0,5,0,5,0,5,0,5,2,5,3,5,5,5},
								    {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								    {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_domination;
			break;
		case ALLIANCE : 
			int tab_alliance[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
								  {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								  {5,5,5,3,5,0,5,2,5,2,5,1,5,1,5,0,5,3,5,5,5},
								  {5,5,3,5,0,5,2,5,0,5,2,5,1,5,1,5,0,5,3,5,5},
								  {5,3,5,0,5,2,5,0,5,1,5,2,5,0,5,1,5,0,5,3,5},
								  {3,5,0,5,2,5,0,5,1,5,0,5,2,5,0,5,1,5,0,5,3},
								  {5,3,5,0,5,2,5,0,5,1,5,2,5,0,5,1,5,0,5,3,5},
								  {5,5,3,5,0,5,2,5,2,5,1,5,0,5,1,5,0,5,3,5,5},
								  {5,5,5,3,5,0,5,2,5,2,5,1,5,1,5,0,5,3,5,5,5},
								  {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								  {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_alliance;
			break;
		case FACETOFACE : 
			int tab_facetoface[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
									  {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
									  {5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5},
									  {5,5,3,5,2,5,2,5,0,5,0,5,0,5,1,5,1,5,3,5,5},
									  {5,3,5,2,5,2,5,2,5,0,5,0,5,1,5,1,5,1,5,3,5},
									  {3,5,2,5,2,5,2,5,2,5,0,5,1,5,1,5,1,5,1,5,3},
									  {5,3,5,2,5,2,5,2,5,0,5,0,5,1,5,1,5,1,5,3,5},
									  {5,5,3,5,2,5,2,5,0,5,0,5,0,5,1,5,1,5,3,5,5},
									  {5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5},
									  {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
									  {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_facetoface;
			break;
		case SNAKE : 
			int tab_snake[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
					   {5,5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5,5},
					   {5,5,5,3,5,1,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5},
					   {5,5,3,5,1,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5},
					   {5,3,5,1,5,0,5,0,5,1,5,1,5,2,5,2,5,0,5,3,5},
					   {3,5,0,5,1,5,0,5,1,5,0,5,2,5,0,5,2,5,0,5,3},
					   {5,3,5,0,5,1,5,1,5,2,5,2,5,0,5,0,5,2,5,3,5},
					   {5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,2,5,3,5,5},
					   {5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,2,5,3,5,5,5},
					   {5,5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5,5},
					   {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};			
			this.plateau = tab_snake;
			break;
		case LABYRINTHE : 
			int tab_labyrinthe[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
							           {5,5,5,5,3,5,0,5,0,5,1,5,2,5,1,5,3,5,5,5,5},
									   {5,5,5,3,5,0,5,2,5,0,5,0,5,0,5,1,5,3,5,5,5},
									   {5,5,3,5,0,5,2,5,1,5,2,5,0,5,0,5,1,5,3,5,5},
									   {5,3,5,0,5,2,5,0,5,0,5,2,5,0,5,0,5,2,5,3,5},
									   {3,5,0,5,2,5,0,5,1,5,0,5,2,5,0,5,1,5,0,5,3},
									   {5,3,5,1,5,0,5,0,5,1,5,0,5,0,5,1,5,0,5,3,5},
									   {5,5,3,5,2,5,0,5,0,5,1,5,2,5,1,5,0,5,3,5,5},
									   {5,5,5,3,5,2,5,0,5,0,5,0,5,1,5,0,5,3,5,5,5},
									   {5,5,5,5,3,5,2,5,1,5,2,5,0,5,0,5,3,5,5,5,5},
									   {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_labyrinthe;
			break;
		case RANDOM : 
			int tab_random[][] = random();			
			this.plateau = tab_random;
			break;	
		}
		listeJoueurs = new ArrayList<Joueur>();
		listeJoueurs.add(j1);
		listeJoueurs.add(j2);
		
		
	}
	
	public PlateauAbalone(PositionDepart pos, Joueur j1, Joueur j2, int nbObstacles){
		switch (pos){
		case STANDARD : 
			int tab_standard[][] =   {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
									{5,5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5,5},
									{5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5},
									{5,5,3,5,0,5,0,5,2,5,2,5,2,5,0,5,0,5,3,5,5},
									{5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
									{3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3},
									{5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
									{5,5,3,5,0,5,0,5,1,5,1,5,1,5,0,5,0,5,3,5,5},
									{5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5},
									{5,5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5,5},
									{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_standard;							
			break;
		case DAISY : 
			int tab_daisy[][] =   {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
								   {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								   {5,5,5,3,5,2,5,2,5,0,5,0,5,1,5,1,5,3,5,5,5},
								   {5,5,3,5,2,5,1,5,2,5,0,5,1,5,2,5,1,5,3,5,5},
								   {5,3,5,0,5,2,5,2,5,0,5,0,5,1,5,1,5,0,5,3,5},
								   {3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3},
								   {5,3,5,0,5,1,5,1,5,0,5,0,5,2,5,2,5,0,5,3,5},
								   {5,5,3,5,1,5,2,5,1,5,0,5,2,5,1,5,2,5,3,5,5},
								   {5,5,5,3,5,1,5,1,5,0,5,0,5,2,5,2,5,3,5,5,5},
								   {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								   {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_daisy;
			break;
		case DOMINATION :
			int tab_domination[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
								    {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								    {5,5,5,3,5,2,5,0,5,0,5,0,5,0,5,1,5,3,5,5,5},
								    {5,5,3,5,2,5,2,5,0,5,0,5,0,5,1,5,1,5,3,5,5},
								    {5,3,5,2,5,2,5,2,5,2,5,0,5,1,5,1,5,1,5,3,5},
								    {3,5,0,5,0,5,0,5,1,5,0,5,1,5,0,5,0,5,0,5,3},
								    {5,3,5,1,5,1,5,1,5,0,5,2,5,2,5,2,5,2,5,3,5},
								    {5,5,3,5,1,5,1,5,0,5,0,5,0,5,2,5,2,5,3,5,5},
								    {5,5,5,3,5,1,5,0,5,0,5,0,5,0,5,2,5,3,5,5,5},
								    {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								    {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_domination;
			break;
		case ALLIANCE : 
			int tab_alliance[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
								  {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								  {5,5,5,3,5,0,5,2,5,2,5,1,5,1,5,0,5,3,5,5,5},
								  {5,5,3,5,0,5,2,5,0,5,2,5,1,5,1,5,0,5,3,5,5},
								  {5,3,5,0,5,2,5,0,5,1,5,2,5,0,5,1,5,0,5,3,5},
								  {3,5,0,5,2,5,0,5,1,5,0,5,2,5,0,5,1,5,0,5,3},
								  {5,3,5,0,5,2,5,0,5,1,5,2,5,0,5,1,5,0,5,3,5},
								  {5,5,3,5,0,5,2,5,2,5,1,5,0,5,1,5,0,5,3,5,5},
								  {5,5,5,3,5,0,5,2,5,2,5,1,5,1,5,0,5,3,5,5,5},
								  {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
								  {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_alliance;
			break;
		case FACETOFACE : 
			int tab_facetoface[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
									  {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
									  {5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5},
									  {5,5,3,5,2,5,2,5,0,5,0,5,0,5,1,5,1,5,3,5,5},
									  {5,3,5,2,5,2,5,2,5,0,5,0,5,1,5,1,5,1,5,3,5},
									  {3,5,2,5,2,5,2,5,2,5,0,5,1,5,1,5,1,5,1,5,3},
									  {5,3,5,2,5,2,5,2,5,0,5,0,5,1,5,1,5,1,5,3,5},
									  {5,5,3,5,2,5,2,5,0,5,0,5,0,5,1,5,1,5,3,5,5},
									  {5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5},
									  {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
									  {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_facetoface;
			break;
		case SNAKE : 
			int tab_snake[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
					   {5,5,5,5,3,5,1,5,1,5,1,5,1,5,1,5,3,5,5,5,5},
					   {5,5,5,3,5,1,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5},
					   {5,5,3,5,1,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5},
					   {5,3,5,1,5,0,5,0,5,1,5,1,5,2,5,2,5,0,5,3,5},
					   {3,5,0,5,1,5,0,5,1,5,0,5,2,5,0,5,2,5,0,5,3},
					   {5,3,5,0,5,1,5,1,5,2,5,2,5,0,5,0,5,2,5,3,5},
					   {5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,2,5,3,5,5},
					   {5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,2,5,3,5,5,5},
					   {5,5,5,5,3,5,2,5,2,5,2,5,2,5,2,5,3,5,5,5,5},
					   {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};			
			this.plateau = tab_snake;
			break;
		case LABYRINTHE : 
			int tab_labyrinthe[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
							           {5,5,5,5,3,5,0,5,0,5,1,5,2,5,1,5,3,5,5,5,5},
									   {5,5,5,3,5,0,5,2,5,0,5,0,5,0,5,1,5,3,5,5,5},
									   {5,5,3,5,0,5,2,5,1,5,2,5,0,5,0,5,1,5,3,5,5},
									   {5,3,5,0,5,2,5,0,5,0,5,2,5,0,5,0,5,2,5,3,5},
									   {3,5,0,5,2,5,0,5,1,5,0,5,2,5,0,5,1,5,0,5,3},
									   {5,3,5,1,5,0,5,0,5,1,5,0,5,0,5,1,5,0,5,3,5},
									   {5,5,3,5,2,5,0,5,0,5,1,5,2,5,1,5,0,5,3,5,5},
									   {5,5,5,3,5,2,5,0,5,0,5,0,5,1,5,0,5,3,5,5,5},
									   {5,5,5,5,3,5,2,5,1,5,2,5,0,5,0,5,3,5,5,5,5},
									   {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
			this.plateau = tab_labyrinthe;
			break;
		case RANDOM : 
			int tab_random[][] = random();			
			this.plateau = tab_random;
			break;	
		}
		listeJoueurs = new ArrayList<Joueur>();
		listeJoueurs.add(j1);
		listeJoueurs.add(j2);
		ajoutObstacles(nbObstacles,plateau);
	}
	
	public void affiche_listeJoueurs(){
		for (Joueur j : listeJoueurs){
			System.out.println(j.getNom());
		}
	}
	public int[][] random(){
		int tab_random[][] = {{5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5},
							   {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
							   {5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5},
							   {5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5},
							   {5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
							   {3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3},
							   {5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5},
							   {5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5},
							   {5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5},
							   {5,5,5,5,3,5,0,5,0,5,0,5,0,5,0,5,3,5,5,5,5},
							   {5,5,5,5,5,3,5,3,5,3,5,3,5,3,5,3,5,5,5,5,5}};
		 //Pour chaque joueur
		for (int i=0;i<14;i++){
			for (int j=1;j<3;j++){//On place 14 pions par joueur 
				int cpt = 0;
				int alea = (int) ((Math.random() * 39) + 1);
				boolean ajout = false;
				for (int x=0;x<11;x++){
					for (int y=0;y<21;y++){
						if (tab_random[x][y] == 0 && ajout==false){
							if (cpt == alea){
								tab_random[x][y] = j; //On associe la valeur du joueur 1 ou du joueur 2
								ajout = true;
							}
							else
								cpt++;
						}
					}
				}
			}
		}
		return tab_random;
	}
	
	public int[][] ajoutObstacles (int tab[][]){
		for (int i=0; i<5; i++){
			int cpt = 0;
			int alea = (int) ((Math.random() * (29)) + 1);
			boolean ajout = false;
			for (int x=0;x<11;x++){
				for (int y=0;y<21;y++){
					if (tab[x][y] == 0 ){
						if (cpt == alea && ajout == false){
							tab[x][y] = 4; //Correspond à un mur
							ajout = true;
						}
						else 
							cpt++;
					}
				}
			}
		}
		return tab;
	}
	
	// A supprimer dans la version finale
	public void affichePlateau(){
		for (int i=0;i<11;i++){
			for (int j=0;j<21;j++){
				if (plateau[i][j] == 1){
					System.out.print(" 1");
				}
				else if (plateau[i][j] == 2){
					System.out.print(" 2");
				}
				else if (plateau[i][j] == 0){
					System.out.print(" *");
				}
				else if (plateau[i][j] == 4)
					System.out.print(" |");
				else 
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	public int is_victory(int aEjecter){
		for (int i=1;i<=2;i++){
			if (listeJoueurs.get(i).getScore() == aEjecter) 	
				return i; //Retourne le nombre du joueur qui a gagné
		}
		return 0; //Renvoie 0 quand il n'y a pas victoire
	}
	
	public int[][] getPlateau(){
		return plateau;
	}

}
