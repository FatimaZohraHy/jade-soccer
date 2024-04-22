package modele;

public class Position {
	  private int x;
	    private int y;

	    public Position(int x, int y) {
	        super();
	        this.x = x;
	        this.y = y;
	    }

	    public Position(Position p) {
	        this.x = p.x;
	        this.y = p.y;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Position p = (Position) o;
	        return this.x == p.getX() && this.y == p.getY();
	    }

	    @Override
	    public int hashCode() {
	        int hash = 1;
	        hash = hash * 31 + x;
	        hash = hash * 31 + y;
	        return hash;
	    }

	    public int getX() {
	        return x;
	    }

	    public void setX(int xx) {
	        this.x = MathHelper.limit(xx, 10, ReglesDuJeu.LONGUEUR_TERRAIN - 10);
	    }

	    public int getY() {
	        return y;
	    }

	    public void setY(int yy) {
	        this.y = MathHelper.limit(yy, 10, ReglesDuJeu.LARGEUR_TERRAIN - 10);
	    }

	    public void approcher(Position p) {
	        if (getX() >= p.getX()) {
	            if (!(getX() == p.getX())) setX(getX() - 2);
	        } else {
	            setX(getX() + 2);
	        }
	        if (getY() >= p.getY()) {
	            if (!(getY() == p.getY())) setY(getY() - 2);
	        } else {
	            setY(getY() + 2);
	        }
	    }

	    public void Fuir(Position p) {
	        if (getX() >= p.getX()) {
	            if (!(getX() == p.getX())) setX(getX() + 2);
	        } else {
	            setX(getX() - 2);
	        }
	        if (getY() >= p.getY()) {
	            if (!(getY() == p.getY())) setY(getY() + 2);
	        } else {
	            setY(getY() - 2);
	        }
	    }
}
