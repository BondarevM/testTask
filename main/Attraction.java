public class Attraction {
    private final String name;
    private final double timeSpent;
    private final int priority;
    private final double priorityCoefficient;

    public Attraction(String name, double timeSpent, int priority) {
        if (timeSpent == 0){
            throw new InvalidArgumentException("Time spent on visiting cannot be 0");
        }

        this.name = name;
        this.timeSpent = timeSpent;
        this.priority = priority;
        this.priorityCoefficient = priority/timeSpent;
    }

    public String getName() {
        return name;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public int getPriority() {
        return priority;
    }

    public double getPriorityCoefficient() {
        return priorityCoefficient;
    }
}
