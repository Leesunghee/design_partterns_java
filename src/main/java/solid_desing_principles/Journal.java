package solid_desing_principles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<String> enties = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        enties.add("" + (++count) + ": " + text);
    }

    public void removedEntry(int index) {
        enties.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), enties);
    }

    public void save(String filename) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

    public void load(String filename) {

    }

    public void laod(URL url) {

    }
}

class Persisitance {
    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(toString());
            }
        }
    }

//    public Journal load(String filename) {}
//    public Journal load(URL url) {}
}

class Demo {
    public static void main(String[] args) throws Exception {
        Journal journal = new Journal();
        journal.addEntry("I cried today");
        journal.addEntry("I ate a bug");
        System.out.println(journal);

        Persisitance p = new Persisitance();
        String filename = "/Users/sunghee/Development/Java_lecture_practice/design_partterns_java/journal.txt";
        p.saveToFile(journal, filename, true);

        Runtime.getRuntime().exec("TextWrangler.app " + filename);
    }
}
