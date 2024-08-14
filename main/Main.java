import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int totalTime = 16;
    public static void main(String[] args) {

        List<Attraction> list = new ArrayList<>();

        list.add(new Attraction("St. Isaac's Cathedral", 5, 10));
        list.add(new Attraction("Hermitage", 8, 11));
        list.add(new Attraction("Kunstkamera", 3.5, 4));
        list.add(new Attraction("Peter and Paul Fortress", 10, 7));
        list.add(new Attraction("Leningrad Zoo", 9, 15));
        list.add(new Attraction("Leningrad Zoo", 9, 15));
        list.add(new Attraction("Bronze Horseman", 1, 17));
        list.add(new Attraction("Kazan Cathedral", 4, 3));
        list.add(new Attraction("Savior on Spilled Blood", 2, 9));
        list.add(new Attraction("Winter Palace of Peter I", 7, 12));
        list.add(new Attraction("Zoological Museum", 5.5, 6));
        list.add(new Attraction("Museum of the Defense and Siege of Leningrad", 2, 19));
        list.add(new Attraction("Russian Museum", 5, 8));
        list.add(new Attraction("Visit friends", 12, 20));
        list.add(new Attraction("Wax Museum", 2, 13));
        list.add(new Attraction("Literary and Memorial Museum of F.M. Dostoevsky", 4, 2));
        list.add(new Attraction("Catherine Palace", 1.5, 5));
        list.add(new Attraction("St. Petersburg Puppet Museum", 1, 14));
        list.add(new Attraction("Museum of Microminiatures \"Russian Lefty\"", 3, 18));
        list.add(new Attraction("All-Russian Museum of A.S. Pushkin and branches", 6, 1));
        list.add(new Attraction("Музей современного искусства Эрарта", 7, 16));

        list.sort(Comparator.comparingDouble(Attraction::getPriorityCoefficient).reversed());

        List<Attraction> optimalRoute = new ArrayList<>();
        List<Attraction> visitedAttractions = new ArrayList<>();

        makeRoute(list, optimalRoute, visitedAttractions);

        // Наступил второй день
        totalTime = 16;
        list.removeAll(visitedAttractions);

        makeRoute(list, optimalRoute, visitedAttractions);

        for (Attraction attraction : optimalRoute){
            System.out.println(attraction.getName());
        }

    }

    private static void makeRoute(List<Attraction> list, List<Attraction> optimalRoute, List<Attraction> visitedAttractions) {
        for (Attraction attraction : list){
            double timeSpent = attraction.getTimeSpent();

            if ((totalTime - timeSpent) < 0){
                continue;
            }
            optimalRoute.add(attraction);
            visitedAttractions.add(attraction);
            totalTime -= timeSpent;
        }
    }
}
