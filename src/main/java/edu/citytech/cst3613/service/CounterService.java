package edu.citytech.cst3613.service;
//Developer: Usman, Muhammad
import java.util.List;
import java.util.ArrayList;

public class CounterService {

    public class Digit extends Object {

        public Digit(String description, int number) {
            this.description = description;
            this.number = number;
        }
        public final String description; public final int number;

        @Override
        public String toString() {
            return "Digit [description=" + description + ", number=" + number + "]";
        }
        
    };

    private List<Digit> listOfNumbers =  new ArrayList<Digit>();//ArrayList aka a dynamic array: you can add data to it w/o knowing how much data there is ahead of time
    
    public List<Digit> getNumbers() {
        return this.listOfNumbers;
    }

    public CounterService() {
        //A Constructor here has same name as the class
        //when we instantiate this, this will be the first thing executed

        listOfNumbers.add(new Digit("one", 1));
        listOfNumbers.add(new Digit("two", 2));
        listOfNumbers.add(new Digit("three", 3));
        listOfNumbers.add(new Digit("four", 4));
        listOfNumbers.add(new Digit("five", 5));
        listOfNumbers.add(new Digit("six", 6));
        listOfNumbers.add(new Digit("seven", 7));
        listOfNumbers.add(new Digit("eight", 8));
        listOfNumbers.add(new Digit("nine", 9));
        listOfNumbers.add(new Digit("ten", 10));
        listOfNumbers.add(new Digit("eleven", 11));
        listOfNumbers.add(new Digit("twelve", 12));
        listOfNumbers.add(new Digit("thirteen", 13));
        listOfNumbers.add(new Digit("fourteen", 14));
        listOfNumbers.add(new Digit("fifteen", 15));
        listOfNumbers.add(new Digit("sixteen", 16));
        listOfNumbers.add(new Digit("seventeen", 17));
        listOfNumbers.add(new Digit("eighteen", 18));
        listOfNumbers.add(new Digit("nineteen", 19));
        listOfNumbers.add(new Digit("twenty", 20));
        listOfNumbers.add(new Digit("twenty-one", 21));
        listOfNumbers.add(new Digit("twenty-two", 22));
        listOfNumbers.add(new Digit("twenty-three", 23));
        listOfNumbers.add(new Digit("twenty-four", 24));
        listOfNumbers.add(new Digit("twenty-five", 25));
        listOfNumbers.add(new Digit("twenty-six", 26));
        listOfNumbers.add(new Digit("twenty-seven", 27));
        listOfNumbers.add(new Digit("twenty-eight", 28));
        listOfNumbers.add(new Digit("twenty-nine", 29));
        listOfNumbers.add(new Digit("thirty", 30));
    }



    public static void main(String[] args) {
        CounterService cs = new CounterService();
//      ^^Class        ^^object
        cs.getNumbers().forEach(System.out::println);
        System.out.println( "Developer: Usman, Muhammad " + new java.util.Date() );
    }


}
