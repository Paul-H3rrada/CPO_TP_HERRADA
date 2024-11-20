/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;

/**
 *
 * @author herra
 */
public class Guerrier extends Personnage {
    boolean Cheval;

    public Guerrier(String nom, int LvlVie, boolean Cheval) {
        super(nom, LvlVie);
        this.Cheval = Cheval;
        // Incrémentation du compteur de guerriers
        personnageCreer(Guerrier.class);
    }

    public void setCheval(boolean Cheval) {
        this.Cheval = Cheval;
    }

    public void attaquer(Personnage cible) {
        System.out.println(getNom() + " (Guerrier) attaque " + cible.getNom() + " et inflige 30 points de dégâts !");
        cible.estAttaque(30);
    }

    @Override
    public void estAttaqué(int points) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

