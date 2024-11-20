/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3_heroic_fantasy_herrada;

/**
 *
 * @author herra
 */
import Personnages.Personnage;
import Personnages.Magicien;
import Personnages.Guerrier;
import Armes.Baton;
import Armes.Epee;
import Armes.Arme;
import java.util.ArrayList;

public class TP3_Heroic_Fantasy_HERRADA {
    public static void main(String[] args) {

        Baton Chene = new Baton("Chêne", 4, 5);
        Baton Charme = new Baton("Charme", 5, 6);
        Epee Excalibur = new Epee("Excalibur", 7, 5);
        Epee Durandal = new Epee("Durandal", 4, 7);

        Guerrier Conan = new Guerrier("Conan", 100, true);  // Guerrier avec cheval
        Magicien Gandalf = new Magicien("Gandalf", 65, false); // Magicien non confirmé

        Conan.ajouterArme(Excalibur);
        Conan.ajouterArme(Charme);
        Gandalf.ajouterArme(Chene);
        Gandalf.ajouterArme(Durandal);

        Conan.equiperArme("Excalibur");
        Gandalf.equiperArme("Chêne");

        System.out.println("Avant le combat : ");
        System.out.println("Magicien: " + Gandalf);
        System.out.println("Guerrier: " + Conan);

        Gandalf.attaquer(Conan);
        System.out.println("\nAprès l'attaque du magicien : ");
        System.out.println("Magicien: " + Gandalf);
        System.out.println("Guerrier: " + Conan);
        
        Conan.attaquer(Gandalf);
        System.out.println("\nAprès l'attaque du guerrier : ");
        System.out.println("Magicien: " + Gandalf);
        System.out.println("Guerrier: " + Conan);

        System.out.println("\nEst-ce que les personnages sont toujours vivants ?");
        System.out.println("Magicien vivant ? " + Gandalf.estVivant());
        System.out.println("Guerrier vivant ? " + Conan.estVivant());
    }
}
