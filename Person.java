import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Person {



    private String name = "";
    private ArrayList<Date> naryaddates = new ArrayList<Date>();

    public Person(String name) {
        this.name = name;
    }

    public void addNaryadDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        naryaddates.add(date);

        Collections.sort(naryaddates, new Comparator<Date>() {
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public String getName() {
        return name;
    }

    public ArrayList<Date> getNaryaddates() {
        return naryaddates;
    }

    public Date getLastNaryadDate() {
        return naryaddates.get(naryaddates.size()-1);
    }

    public int getKolvoNaryadov() {
        return naryaddates.size();
    }
}
