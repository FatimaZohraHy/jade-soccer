package modele;

public class MathHelper {
	 public static int limit(int n, int min, int max) {
	        if (n < min)
	            return min;
	        else if (n > max)
	            return max;
	        else
	            return n;
	    }

	    public static double distance(int x1,int y1,int x2,int y2) {
	        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	    }

}
