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
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class collection2 {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        Random r = new Random();
        int random;
        int sum = 0;

        for (int i = 0; i < 30; i++) {
            random = r.nextInt(100);
            list.add(random);
        }
       
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("************************************************");

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) {
                    return 1;
                } else if (o2 < o1) {
                    return -1;
                }
                return 0;
            }
        });
      
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            sum += list.get(i);
        }

        System.out.println("****************************************************************");
        System.out.println("1 - The sum of the elements is : " + sum);
        System.out.println("2 - The floating-point average of the elements is :" + (sum / 30));
    }
}
