/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author tomas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random rd = new Random();
        ArrayList kniznica = new ArrayList();
        BST strom = new BST();
        int[] test= new int[]{81,25,1,59,56,98,123};
        String[] knihy= new String[]{"hadasd","sDAdas","dsda","dasdasd","sdasd","ASDASda"};
        int isbn;
        for (int i = 0; i < test.length; i++) {
            
            //System.out.println(isbn);
            strom.add(new BST_node(new Auto(test[i])));
            //strom.add(new BST_node(new Kniha(knihy[i])));
            //System.out.println(new BST_node(new Kniha(knihy[i])).toString());
        }

        System.out.println("----"+((BST_node)strom.search(1)).getPocetDeti());
         strom.delete(59);
        //strom.add(new BST_node(new Kniha(123)));
        strom.vypis();
        
        //System.out.println("cau".compareToIgnoreCase("caua"));
       // System.out.println("search:"+((BST_node)strom.search("haasd")));
    }

}
