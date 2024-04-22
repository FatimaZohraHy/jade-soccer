package modele;
import java.awt.*;

public class ReglesDuJeu {
	public static final int NBJOUEURS = 8;
    public static final Color COULEUR_GARDIENS = new Color(50, 150, 200);
    public static final Color COULEUR_EQUIPE_1 = new Color(128, 0, 128);
    public static final Color COULEUR_EQUIPE_2 = Color.PINK;
    public static final Color COULEUR_ARBITRE = new Color(0, 128, 128);
    public static final int TAILLE_JOUEUR = 20;
    public static final int TAILLE_BALLON = 12;
    public static final int TAILLE_ARBITRE = TAILLE_JOUEUR;
    public static final int LARGEUR_TERRAIN = 400;
    public static final int LONGUEUR_TERRAIN = 600;
    public static final Position MILIEU_DE_TERRAIN = new Position(LONGUEUR_TERRAIN / 2, LARGEUR_TERRAIN / 2);
    public static final Position BUT_EQUIPE_1 = new Position(25, MILIEU_DE_TERRAIN.getY());
    public static final Position BUT_EQUIPE_2 = new Position(LONGUEUR_TERRAIN - 25, MILIEU_DE_TERRAIN.getY());
    public static final double SEUIL_PROXIMITE = 10;


}
