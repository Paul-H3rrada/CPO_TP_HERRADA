/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;


import Armes.Arme;
import Armes.Baton;
import Armes.Epee;
import java.util.ArrayList;
import tp3_heroic_fantasy_herrada.etreVivant;
public abstract class Personnage implements etreVivant {
    private String nom;
    private int LvlVie;
    private ArrayList<Arme> inventaire;
    private Arme Arme_en_Main;
    private Arme armeFavorite;

    private static int totalPersonnages = 0;
    private static int totalGuerriers = 0;
    private static int totalMagiciens = 0;

    public Personnage(String nom, int LvlVie) {
        this.nom = nom;
        this.LvlVie = LvlVie;
        this.inventaire = new ArrayList<>();
        this.Arme_en_Main = null;
        this.armeFavorite = null;
        totalPersonnages++;
    }

    // Méthode finalize() pour décrémenter les compteurs lorsque l'objet est détruit
    @Override
    protected void finalize() throws Throwable {
        // Décrémentation du compteur de personnages
        totalPersonnages--;
        System.out.println("Un personnage a été détruit. Nombre actuel de personnages : " + totalPersonnages);
        if (this instanceof Guerrier) {
            totalGuerriers--;
            System.out.println("Un guerrier a été détruit. Nombre actuel de guerriers : " + totalGuerriers);
        } else if (this instanceof Magicien) {
            totalMagiciens--;
            System.out.println("Un magicien a été détruit. Nombre actuel de magiciens : " + totalMagiciens);
        }
        super.finalize();
    }

    // Getters pour les attributs statiques
    public static int getTotalPersonnages() {
        return totalPersonnages;
    }

    public static int getTotalGuerriers() {
        return totalGuerriers;
    }

    public static int getTotalMagiciens() {
        return totalMagiciens;
    }

    public String getNom() {
        return nom;
    }

    public void ajouterArme(Arme arme) {
        if (inventaire.size() < 5) {
            inventaire.add(arme);
            System.out.println(arme.getNom() + " a été ajoutée à l'inventaire de " + getNom());
        } else {
            System.out.println("L'inventaire est plein !");
        }
    }

    public void equiperArme(String nomArme) {
        for (Arme arme : inventaire) {
            if (arme.getNom().equals(nomArme)) {
                Arme_en_Main = arme;
                System.out.println(nomArme + " a été équipée par " + getNom());
                return;
            }
        }
        System.out.println("L'arme " + nomArme + " n'est pas dans l'inventaire de " + getNom());
    }


    public void definirArmeFavorite(String nomArme) {
        for (Arme arme : inventaire) {
            if (arme.getNom().equals(nomArme)) {
                armeFavorite = arme;
                System.out.println(nomArme + " a été définie comme arme favorite pour " + getNom());
                return;
            }
        }
        System.out.println("L'arme " + nomArme + " n'est pas dans l'inventaire de " + getNom());
    }

    @Override
    public String toString() {
        String armeDetails = (Arme_en_Main != null) ? ", Arme en main : " + Arme_en_Main : ", Pas d'arme en main";
        String armeFavoriteDetails = (armeFavorite != null) ? ", Arme favorite : " + armeFavorite : ", Pas d'arme favorite";
        return "Personnage{nom=" + nom + ", LvlVie=" + LvlVie + armeDetails + armeFavoriteDetails + ", Inventaire=" + inventaire + "}";
    }

    public static void personnageCreer(Class<?> typePersonnage) {
        if (typePersonnage == Guerrier.class) {
            totalGuerriers++;
        } else if (typePersonnage == Magicien.class) {
            totalMagiciens++;
        }
    }
    
    @Override
    public void seFatiguer() {
        LvlVie -= 10;
        if (LvlVie < 0) {
            LvlVie = 0; 
        }
    }

    @Override
    public boolean estVivant() {
        return LvlVie > 0;
    }

    public void estAttaque(int points) {
        LvlVie -= points;
        if (LvlVie < 0) {
            LvlVie = 0; // 
        }
    }

    public int getNiveauVie() {
        return LvlVie;
    }
    
    public void attaquer(Personnage cible) {
    int degats = Arme_en_Main.getNiveauAttaque();
    if (this instanceof Magicien && Arme_en_Main instanceof Baton) {
        degats *= ((Baton) Arme_en_Main).getAge();  // Multiplier par l'âge du bâton
    } else if (this instanceof Guerrier && Arme_en_Main instanceof Epee) {
        degats *= ((Epee) Arme_en_Main).getFinesse();  // Multiplier par la finesse de l'épée
    }
    if (this instanceof Magicien && ((Magicien) this).Confirme) {
        degats /= 2;  // Si le magicien est confirmé, diviser les dégâts par 2
    } else if (this instanceof Guerrier && ((Guerrier) this).Cheval) {
        degats /= 2;  // Si le guerrier est à cheval, diviser les dégâts par 2
    }

    System.out.println(getNom() + " attaque " + cible.getNom() + " et inflige " + degats + " points de dégâts !");
    cible.estAttaque(degats);

    seFatiguer();
}

}

