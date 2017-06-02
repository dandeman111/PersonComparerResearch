package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Person> students = new ArrayList<>();
        List<Person> teachers = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i<30; i++){
            String s = "student"+ i;
            int c = rnd.nextInt(10)+1;
            students.add(new Person(s,rnd.nextInt(10)+1,rnd.nextInt(10)+1,rnd.nextInt(10)+1,rnd.nextInt(10)+1));
        }
         students.set(1,new Person("teststudent",8,1,7,3));
        for (int i = 0; i<100; i++){
            String s = "teacher"+ i;
            int c = rnd.nextInt(10)+1;
            teachers.add(new Person(s,rnd.nextInt(10)+1,rnd.nextInt(10)+1,rnd.nextInt(10)+1,rnd.nextInt(10)+1));
        }
        HashMap<Person, Double> points = new HashMap<Person, Double>();
        for (Person p: teachers) {
            points.put(p, students.get(1).compareWithPerson(p));
        }

        Object[] pointsSorted = points.entrySet().toArray();
        Arrays.sort(pointsSorted, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<Person, Double>) o2).getValue()
                        .compareTo(((Map.Entry<Person, Double>) o1).getValue());
            }
        });

        for(Object e : pointsSorted){
            System.out.println("Docent: " + ((Map.Entry<Person, Double>) e).getKey().toString() + " percentage match: " + (10 - ((Map.Entry<String, Double>) e).getValue()) * 10 + "%");
        }

        System.out.println(students.get(1).toString());
    }
}
