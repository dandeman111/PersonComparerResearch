package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dande on 2-6-2017.
 */
public class Person {
    public String naam;
    public double s;
    public double b;
    public double t;
    public double m;

    Object[]y;
    HashMap<String, Double> ownRoutes = new HashMap<>();
    HashMap<String, Double> differenceMap = new HashMap<>();

    public double compareWithPerson(Person p){

        HashMap<String, Double> routeScores = new HashMap<>();

        routeScores.put("s", p.s);
        routeScores.put("t", p.t);
        routeScores.put("b", p.b);
        routeScores.put("m", p.m);

        Object[] x = routeScores.entrySet().toArray();
             Arrays.sort(x, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Double>) o2).getValue()
                        .compareTo(((Map.Entry<String, Double>) o1).getValue());
            }
        });

        for (Object e : x) {
            String key = ((Map.Entry<String, Double>) e).getKey();
            double value = ((Map.Entry<String, Double>) e).getValue();

            double difference = Math.abs(ownRoutes.get(key) - value);

            differenceMap.put(key, difference);
        }

        double xTier = 1;
        double xresult = 0;
        for (Object e : y){
            xresult = xresult + (differenceMap.get(((Map.Entry<String, Double>) e).getKey()) * ((((Map.Entry<String, Double>) e).getValue() * 0.1)));
            xTier = xTier - 0.25;
        }

//        double yTier = 1;
//        double yresult = 0;
//        for (Object e : x){
//            yresult = yresult + (differenceMap.get(((Map.Entry<String, Double>) e).getKey()) * ownRoutes.get(((Map.Entry<String, Double>) e).getKey()) * 0.1);
//            yTier = yTier - 0.25;
//        }

        return Math.abs(xresult);

    }

    public Person(String naam, double s, double b, double t, double m) {
        this.naam = naam;
        this.s = s;
        this.b = b;
        this.t = t;
        this.m = m;

        ownRoutes.put("s", s);
        ownRoutes.put("t", t);
        ownRoutes.put("b", b);
        ownRoutes.put("m", m);

        y = ownRoutes.entrySet().toArray();
        Arrays.sort(y, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Double>) o2).getValue()
                        .compareTo(((Map.Entry<String, Double>) o1).getValue());
            }
        });
    }
    public String toString(){
        String result = naam;
        for(Object e : y){
            result = result + " " + ((Map.Entry<String, Double>) e).getKey() + ":" + ((Map.Entry<String, Double>) e).getValue();
        }
        return result;
    }

}
