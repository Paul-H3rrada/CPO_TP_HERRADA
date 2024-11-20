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
public class Baton extends Arme {
    private int age; 

    // Constructeur
    public Baton(String nom, int niveauAttaque, int age) {
        super(nom, niveauAttaque); // Appelle le constructeur de la classe mère
        setAge(age); 
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 100) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("L'age doit être < 100");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Age: " + age;
    }
}
