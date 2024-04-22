package modele;

public class PositionHelper {
	
	 public static Position milieu(Position p1, Position p2) {
	        return new Position((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
	    }

	    public static double distance(Position a,Position b) {
	        return MathHelper.distance(a.getX(),a.getY(),b.getX(),b.getY());
	    }

}
