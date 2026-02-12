/**
 * Driver program to test the TodoList class
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to My Todo List App!");
        System.out.println("=============================\n");
        
        // Create a new todo list
        TodoList list = new TodoList();
        
        // Add some tasks
        System.out.println("--- Adding Tasks ---");
        list.add("Buy milk");
        list.add("Buy eggs");
        list.add("Prepare a lesson for CSC 122");
        list.add("Sow beet seeds");
        
        // Try to add an invalid task
        list.add("");  // This should show an error
        list.add(null);  // This should show an error
        
        // Show all tasks
        list.all();
        
        // Complete a task
        System.out.println("--- Completing Tasks ---");
        list.complete("Buy eggs");
        
        // Try to complete a task that doesn't exist
        list.complete("Buy oranges");  // This should show an error
        
        // Show all tasks again
        list.all();
        
        // Show only completed tasks
        list.complete();
        
        // Show only incomplete tasks
        list.incomplete();
        
        // Complete another task
        System.out.println("--- Completing More Tasks ---");
        list.complete("Buy milk");
        list.complete("Sow beet seeds");
        
        // Show incomplete tasks
        list.incomplete();
        
        // Show completed tasks
        list.complete();
        
        // Clear the list
        System.out.println("--- Clearing List ---");
        list.clear();
        
        // Show all tasks (should be empty)
        list.all();
        
        // Add a new task after clearing
        System.out.println("--- Starting Fresh ---");
        list.add("Learn Java inheritance");
        list.all();
    }
}
