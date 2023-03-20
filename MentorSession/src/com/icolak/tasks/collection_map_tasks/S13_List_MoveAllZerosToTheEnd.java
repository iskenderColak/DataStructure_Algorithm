package com.icolak.tasks.collection_map_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S13_List_MoveAllZerosToTheEnd {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(0);
        list.add(5);
        list.add(0);
        list.add(4);
        System.out.println(moveZerosToEnd1(list));
        System.out.println(moveZerosToEnd2(list));
    }

    private static List<Integer> moveZerosToEnd1(List<Integer> list) {
        int size = list.size();
        list.removeAll(Arrays.asList(0));
        int newSize = list.size();
        int numberOfZero = size - newSize;
        for (int i = 0; i < numberOfZero; i++) {
            list.add(0);
        }
        return list;
    }

    public static List<Integer> moveZerosToEnd2(List<Integer> list) {
        return
        Arrays.stream(
            Arrays.copyOf(list.stream().mapToInt(Integer::intValue).filter(f -> f != 0).toArray(),
                list.size())).boxed().collect(Collectors.toList());
    }
}
// write a program that can move all the zeros to the end of the List of integers
