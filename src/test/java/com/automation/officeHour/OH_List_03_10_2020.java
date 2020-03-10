package com.automation.officeHour;

import java.util.*;

public class OH_List_03_10_2020 {

    public static void main(String[] args) {


        /***
         * Under List Interface:
         *
         * - ArrayList : (indexes, faster to read, but its slower when we do manipulations (remove or add elements))
         * - Vector : (same as ArrayList, but thread safe)
         * - Stack : (Last in First out (Like a stack of paper))
         * - LinkedList : (node (each element reference to previous and next element in the list))
         * (Performance - sensitive, memory allocation)
         */

        /**
         *  Set Interface : (contain only unique values and will not have duplicates)
         *
         *  HashSet : no indexes - faster because it is using hashing
         *  (it does not keep an order), also allows 1 null value
         *
         *  TreeSet : Sorted Set - there is no nulls
         *
         *  LinkedHashSet : Keeps the order (1,2,3)
         *
         */


        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        for (String each : Arrays.asList("Value5", "Value1","Value3")){
            hashSet.add(each);
            treeSet.add(each);
            linkedHashSet.add(each);
        }
        System.out.println("HashSet : "+hashSet);            //[Value3, Value1, Value5]
        System.out.println("TreeSet : "+treeSet);            //[Value1, Value3, Value5]
        System.out.println("LinkedHashSet : "+linkedHashSet);//[Value5, Value1, Value3]


        Iterator<String> iteratorSet = hashSet.iterator();
        while (iteratorSet.hasNext()){
            System.out.println(iteratorSet.next());
        }

        ArrayList<Integer> dropdown = new ArrayList<>();
        dropdown.add(1);
        dropdown.add(2);
        dropdown.add(3);
        dropdown.add(4);
        dropdown.add(5);
        dropdown.add(1);
        //[1,2,3,4,5,1]
        System.out.println("List : "+dropdown); //[1, 2, 3, 4, 5, 1]

        HashSet<Integer> optionSet = new HashSet<>(dropdown);
        System.out.println("OptionSet : "+optionSet);//[1, 2, 3, 4, 5]

        if (optionSet.size() == dropdown.size()){
            System.out.println("Expected is the same as actual");
        }else {
            System.out.println("Options contains duplicates");
        }

        //============================================================

        /*
        Queue
        - PriorityQueue - First in first out
                          can accept duplicates, but it does not have indexes

        - Deque - ArrayDeque - special in adding and removing

         */

        PriorityQueue <String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add("John");
        priorityQueue.add("Kate");
        priorityQueue.add("Tom");
        System.out.println("Queue : "+priorityQueue);

        System.out.println("Peek : "+priorityQueue.peek());
        //peeking (.peek()) - it will check and return the first in a Queue
        System.out.println("Queue after peek : "+priorityQueue);

        System.out.println("Poll : "+priorityQueue.poll());
        //polling will return the first value in a Queue and remove it
        System.out.println(priorityQueue);

        ArrayDeque<String> deque = new ArrayDeque<>();



    }
}
