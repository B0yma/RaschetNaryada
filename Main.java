import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Main {


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");;

    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<Person>();

        Person p0 = new Person("Familliya1");
        p0.addNaryadDate("14.10.2017");
        p0.addNaryadDate("05.11.2017");

        Person p1 = new Person("Familliya2");
        p1.addNaryadDate("14.10.2017");
        p1.addNaryadDate("21.10.2017");

        Person p2 = new Person("Familliya3");
        p2.addNaryadDate("13.10.2017");
        p2.addNaryadDate("03.11.2017");

        Person p3 = new Person("Familliya4");
        p3.addNaryadDate("13.10.2017");
        p3.addNaryadDate("28.10.2017");

        Person p4 = new Person("Familliya4");
        p4.addNaryadDate("27.10.2017");

        Person p5 = new Person("Familliya5");
        p5.addNaryadDate("21.10.2017");
        p5.addNaryadDate("18.11.2017");

        Person p6 = new Person("Familliya6");
        p6.addNaryadDate("20.10.2017");
        p6.addNaryadDate("24.11.2017");

        Person p7 = new Person("Familliya7");
        p7.addNaryadDate("20.10.2017");
        p7.addNaryadDate("04.11.2017");
        p7.addNaryadDate("17.11.2017");

        persons.add(p0);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        persons.add(p7);

        ArrayList<Integer> groupskolvonaryadov = getGroupsByKolvoNaryadov(persons);

        ArrayList<ArrayList<Person>> groupsofpersons = getGroupsOfPersons(groupskolvonaryadov,persons);
        //printGroupsOfPersons(groupsofpersons);


        sortGroupsOfPersons(groupsofpersons);
        printGroupsOfPersons(groupsofpersons);


    }

    private static void sortGroupsOfPersons(ArrayList<ArrayList<Person>> groupsofpersons) {
        //System.out.println("sorting...");
        for(ArrayList<Person> grpersons:groupsofpersons){
            Collections.sort(grpersons, new Comparator<Person>() {
                public int compare(Person o1, Person o2) {
                    return o1.getLastNaryadDate().compareTo(o2.getLastNaryadDate());
                }
            });
        }
    }

    private static void printGroupsOfPersons(ArrayList<ArrayList<Person>> groupsofpersons) {
        for(ArrayList<Person> grpersons:groupsofpersons){
            System.out.println("group with kolvo:"+grpersons.get(0).getKolvoNaryadov());
            for (Person p:grpersons){
                System.out.println(p.getName()+"-"+sdf.format(p.getLastNaryadDate()));
            }
            System.out.println("----------");
        }
    }

    private static ArrayList<ArrayList<Person>> getGroupsOfPersons(ArrayList<Integer> groupskolvonaryadov, ArrayList<Person> persons) {
        ArrayList<ArrayList<Person>> groupsofpersons = new ArrayList<>();
        for (int k:groupskolvonaryadov){
            ArrayList<Person> grpersons = new ArrayList<>();
            for(Person p:persons){
                if(p.getKolvoNaryadov()==k){
                    grpersons.add(p);
                }
            }
            groupsofpersons.add(grpersons);
        }
        return groupsofpersons;
    }

    private static ArrayList<Integer> getGroupsByKolvoNaryadov(ArrayList<Person> persons) {
        ArrayList<Integer> groupskolvonaryadov = new ArrayList<>();
        for(Person p:persons){
            if(!groupskolvonaryadov.contains(p.getKolvoNaryadov())){
                groupskolvonaryadov.add(p.getKolvoNaryadov());
            }
        }
        Collections.sort(groupskolvonaryadov);

        /*System.out.println("groups");
        for(int k:groupskolvonaryadov){
            System.out.println(k);
        }*/
        return groupskolvonaryadov;
    }
}
