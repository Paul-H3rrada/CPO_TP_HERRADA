/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armes;

import Armes.Arme;

/**
 *
 * @author herra
 */
public class Epee extends Arme {
    private int finesse; 
    
    public Epee(String nom, int niveauAttaque, int finesse) {
        super(nom, niveauAttaque); // Appelle le constructeur de la classe mère (donc Armes ici) 
        setFinesse(finesse); 
    }

    public int getFinesse() {
        return finesse;
    }

     public void setFinesse(int finesse) {
        if (finesse < 100) {
            this.finesse = finesse;
        } else {
            throw new IllegalArgumentException("La finesse doit être < 100");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Finesse: " + finesse;
    }
}
