package dkit.oop;   // CA3 Mock Prep. Exam - PARTIAL SOLUTIONS

import java.util.*;

public class App {

    Set<String> userNamesSet = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("CA3 Mock  Example");
        App app = new App();
        app.start();
    }

    public void start() {
//        Awesome Games needs usernames used for the Average Joes game to be unique.
//        Using an appropriate data structure write an addNewUser(String username) which
//        will add the username to the data structure if it is not already there. If the username
//        is already there it should return an appropriate error message to the user.

        String username = "basher";

        if( addNewUser( username ) ) System.out.println("added successfully");

        if( addNewUser( "basher" ) ) System.out.println("added successfully");
        if( addNewUser( "moose" ) ) System.out.println("added successfully");
        if( addNewUser( "moose" ) ) System.out.println("added successfully");
        countWords();
        wordPositions();
    }
    public boolean addNewUser(String username) {

//        if( userNamesSet.contains( username ) ) {
//            return false; // already exists
//        }
//        userNamesSet.add(username);
//        return true;   // not added, it already exists
//    }

        return userNamesSet.add(username);
    }

//    c) Awesome Games has a number of titles – “Average Joes”,
//    “The Legend of Welda”, “World of Bushcraft”, and “The Womble Series”.
//    Using an appropriate data structure
//    write a method to print each world in the game titles and the
//    number of times it has occurred in all of the game titles.
//    E.g “Average” : 1, “The” : 2…

    public void countWords(){
        String title = "The legend of the World of Bushcraft of the universe";
        String array[] = title.split(" ");

        for(String s : array)
            System.out.println(s +", ");

        Map<String, Integer> wordCountMap = new HashMap<>();

        for(String word : array) {
            Integer count = wordCountMap.get(word);
            if (count != null) {

                wordCountMap.put(word,(count+1));

            } else {
                wordCountMap.put(word, 1); // add new word with count 1
            }
        }
        System.out.println("Count of 'of' : = " +wordCountMap.get("of"));
    }


//    Question 3 (20 marks)
//            “He found the end of the rainbow and was surprised at what he found there.”
//    a) One way to compress data is to find repeated words and where they occur in a
//    sentence. Using an appropriate data structure find and store the positions of each
//    distinct word in the above sentence

    public void wordPositions(){
        String title = "The legend of the World of Bushcraft of the universe";
        String array[] = title.split(" ");
        for(String s : array)
            System.out.println(s +", ");
        Map<String, ArrayList<Integer>> wordPositionMap = new HashMap<>();
        int wordPosition = 0;
        for(String word : array) {
            wordPosition++;     // first word is at position 1
            ArrayList<Integer> positions = wordPositionMap.get(word);
            if (positions != null) {  // so, it is there
                positions.add(wordPosition);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(wordPosition);
                wordPositionMap.put(word,list ); // add new word with count 1
            }
        }
        //System.out.println("Count of 'of' : = " +wordPositionMap.get("of"));
    }

}



