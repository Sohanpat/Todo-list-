import java.util.ArrayList;

/**
 * A simple TodoList class that manages tasks.
 * Two parallel ArrayLists
 * to track task descriptions and their completion status.
 */
public class TodoList {
    // ArrayList to store task descriptions
    private ArrayList<String> tasks;
    
    // ArrayList to store whether each task is complete (true) or not (false)
    private ArrayList<Boolean> completed;
    
    /**
     * Constructor - creates a new empty todo list
     */
    public TodoList() {
        tasks = new ArrayList<>();
        completed = new ArrayList<>();
    }
    
    /**
     * Adds a new task to the todo list
     * @param description the description of the task
     */
    public void add(String description) {
        // Handle invalid input
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Error: Cannot add an empty task!");
            return;
        }
        
        // Add the task description and mark it as not complete
        tasks.add(description.trim());
        completed.add(false);
        System.out.println("Added: \"" + description.trim() + "\"");
    }
    
    /**
     * Marks a task as complete
     * @param description the description of the task to complete
     */
    public void complete(String description) {
        // Handle invalid input
        if (description == null || description.trim().isEmpty()) {
            System.out.println("Error: Please provide a task description!");
            return;
        }
        
        // Search for the task
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).equalsIgnoreCase(description.trim())) {
                completed.set(i, true);
                System.out.println("Completed: \"" + description.trim() + "\"");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Error: Task \"" + description.trim() + "\" not found!");
        }
    }
    
    /**
     * Shows all tasks (both complete and incomplete)
     */
    public void all() {
        System.out.println("\n=== ALL TASKS ===");
        
        if (tasks.isEmpty()) {
            System.out.println("Your todo list is empty!");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                String status = completed.get(i) ? "[X]" : "[ ]";
                System.out.println((i + 1) + ". " + status + " " + tasks.get(i));
            }
        }
        System.out.println();
    }
    
    /**
     * Shows only completed tasks
     */
    public void complete() {
        System.out.println("\n=== COMPLETED TASKS ===");
        
        boolean hasCompleted = false;
        int count = 1;
        
        for (int i = 0; i < tasks.size(); i++) {
            if (completed.get(i)) {
                System.out.println(count + ". [X] " + tasks.get(i));
                count++;
                hasCompleted = true;
            }
        }
        
        if (!hasCompleted) {
            System.out.println("No completed tasks yet!");
        }
        System.out.println();
    }
    
    /**
     * Shows only incomplete tasks
     */
    public void incomplete() {
        System.out.println("\n=== INCOMPLETE TASKS ===");
        
        boolean hasIncomplete = false;
        int count = 1;
        
        for (int i = 0; i < tasks.size(); i++) {
            if (!completed.get(i)) {
                System.out.println(count + ". [ ] " + tasks.get(i));
                count++;
                hasIncomplete = true;
            }
        }
        
        if (!hasIncomplete) {
            System.out.println("All tasks are complete! Great job!");
        }
        System.out.println();
    }
    
    /**
     * Clears all tasks from the todo list
     */
    public void clear() {
        tasks.clear();
        completed.clear();
        System.out.println("Todo list has been cleared!");
    }
    
    /**
     * Gets the number of tasks in the list
     * @return the total number of tasks
     */
    public int size() {
        return tasks.size();
    }
}
