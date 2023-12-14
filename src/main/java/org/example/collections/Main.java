package org.example.collections;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.collections.Months.JAN;
import static org.example.collections.Months.MAR;

public class Main {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>(100);
        names.add("Gica");
        names.add("Petre");
        names.add("Ion");
        names.add("Andrei");

//        for (int i = 0; i < names.size(); i++) {
//            if (i == 0) {
//                names.remove(2);
//            }
//            String name = names.get(i);
//            System.out.println(i + ":" + name);
//        }

//        boolean done = false;
//        for (String name : names) {
//            if(!done) {
//                names.remove(2);
//                done = true;
//            }
//            System.out.println(name);
//        }

        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
            if (name.equals("Ion")) {
                iterator.remove();
            }
        }
        System.out.println(names.size());

        List<String> ion = names.parallelStream()
                .filter(s -> !s.equals("Ion"))
                .toList();

        names.add("Ioana");
        names.add("Maria");
        names.add("Sofia");

        names.parallelStream()
                .forEach(name -> System.out.println(Thread.currentThread().getName() + " : " + name));

        EnumSet<Months> jan = EnumSet.of(JAN, MAR);

        Map<String, Integer> nameToStudentCount = new HashMap<>();

        Set<String> strings = nameToStudentCount.keySet();
        Collection<Integer> values = nameToStudentCount.values();
        Set<Map.Entry<String, Integer>> entries = nameToStudentCount.entrySet();

        Integer i = nameToStudentCount.get("Ion");

        nameToStudentCount.putIfAbsent("John", 4);

        Map<Months, List<String>> studentListByMonth = new HashMap<>();
        for (String name : names) {
            Months month = getRandomMonth();
            studentListByMonth.computeIfAbsent(month, k -> new ArrayList<>()).add(name);
        }

        Map<Months, List<String>> collect = names.stream()
                .collect(Collectors.groupingBy(student -> getRandomMonth()));

        System.out.println("---------");


        Student s1 = new Student("Ion", 45, true);
        Student s2 = new Student("Maria", 25, true);
        Student s3 = new Student("Ion", 45, true);

        Set<Student> set1 = new HashSet<>();
        set1.add(s1);
        set1.add(s2);
        set1.add(s3);

        System.out.println(set1.size());


        List<String> strings1 = Collections.synchronizedList(names);

        List<String> ion1 = new ArrayList<>(List.of("Ion", "Maria"));
        ion1.add("Bula");

        String [] names2 = new String[4];
        names2[0] = "Ion";
        List<String> namesFromArray = Arrays.asList(names2);
        namesFromArray.remove(0);

        List<String> ion13 = new ArrayList<>(List.of(names2));
        
    }

    private static Months getRandomMonth() {
        return Months.values()[new Random().nextInt(Months.values().length)];
    }
}
