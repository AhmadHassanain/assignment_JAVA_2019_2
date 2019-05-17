/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Ahmad
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Collection {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        HashMap<String,Integer> Hash= new HashMap();

        File file = new File("src/test.txt");
        Scanner in = new Scanner(file);

        while (in.hasNext()) {
           
            String latter =in.next();
            System.out.println(latter);

            Integer test = Hash.get(latter);
            if (test == null) {
                Hash.put(latter, 1);
            } else {
                Hash.put(latter, test + 1);
            } 
            
            for (int j = 0; j < latter.length(); j++) {

                Character chr = latter.charAt(j);
                System.out.println(chr);

                Integer test1 = Hash.get(chr.toString());
                if (test1 == null) {
                    Hash.put(chr.toString(), 1);
                } else {
                    Hash.put(chr.toString(), test1 + 1);
                }
            }

            System.out.println(Hash);
            
        }
    }
}

