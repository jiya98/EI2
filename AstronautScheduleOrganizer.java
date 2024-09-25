import java.util.ArrayList;
import java.util.List;

// Singleton for Schedule Management
class ScheduleManager {
    private static ScheduleManager instance;
    private List<String> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
        System.out.println("Task removed: " + task);
    }

    public void viewTasks() {
        System.out.println("Astronaut Tasks:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }
}

// Factory for Task Creation
interface Task {
    String getDescription();
}

class ResearchTask implements Task {
    @Override
    public String getDescription() {
        return "Research Task";
    }
}

class MaintenanceTask implements Task {
    @Override
    public String getDescription() {
        return "Maintenance Task";
    }
}

class TaskFactory {
    public static Task createTask(String type) {
        if (type.equalsIgnoreCase("Research")) {
            return new ResearchTask();
        } else if (type.equalsIgnoreCase("Maintenance")) {
            return new MaintenanceTask();
        }
        return null;
    }
}

public class AstronautScheduleOrganizer {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();

        // Adding tasks
        Task research = TaskFactory.createTask("Research");
        manager.addTask(research.getDescription());

        Task maintenance = TaskFactory.createTask("Maintenance");
        manager.addTask(maintenance.getDescription());

        // Viewing tasks
        manager.viewTasks();

        // Removing task
        manager.removeTask(research.getDescription());

        // Viewing tasks again
        manager.viewTasks();
    }
}
