package com.icolak;

public class LengthOfLastWord {

    public static void main(String[] args) {

        String s1 = "Hello world";
        String s2 = "   fly me  to  the  moon   ";
        String s3 = "luffy is still joyboy";
        String s4 = "a";

        System.out.println(lengthOfLastWord(s1));
        System.out.println(lengthOfLastWord(s2));
        System.out.println(lengthOfLastWord(s3));
        System.out.println(lengthOfLastWord(s4));

    }

    private static int lengthOfLastWord(String str) {
        int length = 0;
        for(int i = str.length() - 1; i >= 0; i--) { // start iterating from last index
            if(!Character.isLetter(str.charAt(i))) { // if there is no letter (space or smt not letter)
                continue;                           // than continue
            }
            else {             // if there is a letter (this is the last letter of last word)
                do {
                    length ++;  // increase the length of that word

                    if (i == 0) // prevent index from out of range exception
                        return length;

                    i --;       // keep iterating the index
                } while(Character.isLetter(str.charAt(i))); // till the beginning of the last word
            }
            return length;
        }
        return -1;
    }
    /*
    Example 1:
    Input s = "Hello world"
    Output: 5

    Example 2:
    Input s = "   fly me  to  the moon  "
    Output: 4

    Example 3:
    Input s = "luffy is still joyboy"
    Output: 6
    */

}
