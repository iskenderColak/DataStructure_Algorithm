package com.icolak;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

public class TimeNeededToBuyTickets {

    public static void main(String[] args) {

        int[] tickets1 = {2, 3, 2};
        int[] tickets2 = {5, 1, 1, 1};

        System.out.println("*************FirstMethod*************");
        System.out.println(timeRequiredToBuy1(tickets1, 2));
        System.out.println(timeRequiredToBuy1(tickets2, 0));

        System.out.println("*************SecondMethod*************");
        System.out.println(timeRequiredToBuy2(tickets1, 2));
        System.out.println(timeRequiredToBuy2(tickets2,0));

    }

    private static int timeRequiredToBuy2(int[] tickets, int k) {
        int seconds = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] < tickets[k]) {
                seconds += tickets[i];
            } else {
                if (i <= k) {
                    seconds += tickets[k];
                } else {
                    seconds += tickets[k] - 1;
                }
            }
        }
        return seconds;
    }

    public static int timeRequiredToBuy1(int[] tickets, int k) {

        Queue<Integer> ticketQueue = Arrays.stream(tickets).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(ticketQueue);
        int totalTime = 0;
        while(!ticketQueue.isEmpty()) {
            int leftTicketCount = ticketQueue.poll() -1;
            totalTime ++;

            if(leftTicketCount == 0) {
                if (k == 0) {
                    return totalTime;
                } else if (k > 0) {
                    k--;
                }
            } else {
                ticketQueue.add(leftTicketCount);
                if (k > 0) {
                    k--;
                } else if (k == 0) {
                    k = ticketQueue.size() -1;
                }
            }
        }
        return -1;
    }


    /*
    Example 1:
    Input tickets = [2,3,2], k = 2
    Output: 6
    Explanation:
    - In the first pass, everyone in the line buys a ticket and the line becomes [1, 2, 1].
    - In the second pass, everyone in the line buys a ticket and the line becomes [0, 1, 0].
    The person at position 2 has successfully bought 2 tickets and it took 3 + 3 = 6 seconds.

    Example 2:
    Input: tickets = [5,1,1,1], k = 0 Output: 8
    Explanation:
    - In the first pass, everyone in the line buys a ticket and the line becomes [4, 0, 0, 0].
    - In the next 4 passes, only the person in position 0 is buying tickets.
    The person at position 0 has successfully bought 5 tickets and it took 4 + 1 + 1 + 1 + 1 = 8 seconds.
    */

}
