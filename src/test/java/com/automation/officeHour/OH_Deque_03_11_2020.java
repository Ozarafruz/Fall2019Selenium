package com.automation.officeHour;

import java.util.ArrayDeque;
import java.util.Deque;

public class OH_Deque_03_11_2020 {

    public static void main(String[] args) {


        /*

        Deque - double sided
        We can add and retrieve elements from dequeue from both sides (head , end)

         */


        Deque<Integer> numbers = new ArrayDeque<>();

        numbers.addFirst(20);
        numbers.addFirst(30);
        numbers.addFirst(50);
        System.out.println(numbers);

        numbers.add(90);
        System.out.println(numbers);

        numbers.add(33);
        System.out.println(numbers);

        Integer num = numbers.pollFirst(); //return and delete first element
        System.out.println(num);
        System.out.println(numbers);

        System.out.println(numbers.getLast()+" peek: "+ numbers.peekLast());

        System.out.println("Deque after peek : "+ numbers);
        //peek -> returns the value (its similar as get())
        //poll - > returns the value and remove it from the Queue

   /*
            What collections you are using in your project?
            describe all different collections (List, Queue, Set)
            explain the differences between them

            List -> ArrayList most of the times, bcs I would usually
            just need to store some values.
            I would use LinkedList if I know I will need to manipulate my date
            (consistently add, remove, etc.)

            Set -> HashSet - for unique values
                    TreeSet - for unique sorted values
            Queue -> if I need to check FIFO logic in my project





    */

   /**
    *           Map Interface :
    *
    *
    *
    *
    */


    }
}
