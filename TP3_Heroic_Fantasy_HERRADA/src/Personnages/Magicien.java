/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;

/**
 *
 * @author herra
 */
public class Magicien extends Personnage {
    boolean Confirme;

    public Magicien(String nom, int LvlVie, boolean Confirme) {
        super(nom, LvlVie);
        this.Confirme = Confirme;
        // Incrémentation du compteur de magiciens
        personnageCreer(Magicien.class);
    }

    public void setConfirme(boolean Confirme) {
        this.Confirme = Confirme;
    }

    public void attaquer(Personnage cible) {
        System.out.println(getNom() + " (Magicien) attaque " + cible.getNom() + " et inflige 20 points de dégâts !");
        cible.estAttaque(20);
    }

    @Override
    public void estAttaqué(int points) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

