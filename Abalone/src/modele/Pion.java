package modele;

public class Pion {
	private int x; //Corresponds aux coordonnées
	private int y;

	
	public String toString() {
		return "Pion [x=" + x + ", y=" + y + "]";
	}

	public Pion(int x,int y){
		this.x=x;
		this.y=y;
	}
		
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
}
