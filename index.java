import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleSearchEngine {
    public static void main(String[] args) {
        List<String> database = new ArrayList<>();
        database.add("Java programming tutorial");
        database.add("How to learn Python");
        database.add("Introduction to web development");
        database.add("Top 10 programming languages");
        database.add("Learn data structures and algorithms");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your search query:");
        String query = scanner.nextLine().toLowerCase();
        
        List<String> results = search(database, query);
        
        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Search Results:");
            for (String result : results) {
                System.out.println("- " + result);
            }
        }
        
        scanner.close();
    }

    public static List<String> search(List<String> database, String query) {
        List<String> results = new ArrayList<>();
        for (String item : database) {
            if (item.toLowerCase().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }
}
