package modele;

public class Config {
	public enum Direction {
		LEFT,
		RIGHT,
		UPLEFT,
		UPRIGHT,
		DOWNLEFT,
		DOWNRIGHT
	}
	
	public enum Possible {
		IMPOSSIBLE,
		LINE,
		DR,
		DL
	}
	
	public enum PositionDepart {
		STANDARD,
		DAISY,
		DOMINATION,
		FACETOFACE,
		SNAKE,
		ALLIANCE,
		LABYRINTHE,
		RANDOM
	}
}
