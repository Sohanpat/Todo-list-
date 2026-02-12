/**
 * Simple test class for the TodoList class 
 * 
 */
public class TodoListTest {
    private static int testsRun = 0;
    private static int testsPassed = 0;
    
    public static void main(String[] args) {
        System.out.println("Running TodoList Tests...");
        System.out.println("========================\n");
        
        testAddSingleTask();
        testAddMultipleTasks();
        testAddEmptyTask();
        testAddNullTask();
        testAddWhitespaceTask();
        testClearList();
        testClearEmptyList();
        testCompleteExistingTask();
        testCompleteNonExistentTask();
        testCompleteNullTask();
        testCompleteEmptyString();
        testMethodsOnEmptyList();
        
        System.out.println("\n========================");
        System.out.println("Tests Run: " + testsRun);
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + (testsRun - testsPassed));
        
        if (testsPassed == testsRun) {
            System.out.println("\n✓ All tests passed!");
        } else {
            System.out.println("\n✗ Some tests failed!");
        }
    }
    
    /**
     * Helper method to check if a condition is true
     */
    private static void assertTrue(String testName, boolean condition) {
        testsRun++;
        if (condition) {
            System.out.println("✓ PASS: " + testName);
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + testName);
        }
    }
    
    /**
     * Helper method to check if two values are equal
     */
    private static void assertEquals(String testName, int expected, int actual) {
        testsRun++;
        if (expected == actual) {
            System.out.println("✓ PASS: " + testName);
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + testName + " (expected: " + expected + ", got: " + actual + ")");
        }
    }
    
    /**
     * Test adding a single task
     */
    public static void testAddSingleTask() {
        TodoList list = new TodoList();
        list.add("Buy milk");
        assertEquals("Add single task", 1, list.size());
    }
    
    /**
     * Test adding multiple tasks
     */
    public static void testAddMultipleTasks() {
        TodoList list = new TodoList();
        list.add("Buy milk");
        list.add("Buy eggs");
        list.add("Study Java");
        assertEquals("Add multiple tasks", 3, list.size());
    }
    
    /**
     * Test adding an empty task (should not be added)
     */
    public static void testAddEmptyTask() {
        TodoList list = new TodoList();
        list.add("");
        assertEquals("Add empty task (should reject)", 0, list.size());
    }
    
    /**
     * Test adding a null task (should not be added)
     */
    public static void testAddNullTask() {
        TodoList list = new TodoList();
        list.add(null);
        assertEquals("Add null task (should reject)", 0, list.size());
    }
    
    /**
     * Test adding a task with only whitespace (should not be added)
     */
    public static void testAddWhitespaceTask() {
        TodoList list = new TodoList();
        list.add("   ");
        assertEquals("Add whitespace task (should reject)", 0, list.size());
    }
    
    /**
     * Test clearing the list
     */
    public static void testClearList() {
        TodoList list = new TodoList();
        list.add("Buy milk");
        list.add("Buy eggs");
        list.clear();
        assertEquals("Clear list", 0, list.size());
    }
    
    /**
     * Test clearing an empty list (should not crash)
     */
    public static void testClearEmptyList() {
        TodoList list = new TodoList();
        try {
            list.clear();
            assertTrue("Clear empty list (should not crash)", true);
        } catch (Exception e) {
            assertTrue("Clear empty list (should not crash)", false);
        }
    }
    
    /**
     * Test completing a task that exists
     */
    public static void testCompleteExistingTask() {
        TodoList list = new TodoList();
        list.add("Buy milk");
        try {
            list.complete("Buy milk");
            assertTrue("Complete existing task (should not crash)", true);
        } catch (Exception e) {
            assertTrue("Complete existing task (should not crash)", false);
        }
    }
    
    /**
     * Test completing a task that doesn't exist
     */
    public static void testCompleteNonExistentTask() {
        TodoList list = new TodoList();
        list.add("Buy milk");
        try {
            list.complete("Buy eggs");
            assertEquals("Complete non-existent task (should handle gracefully)", 1, list.size());
        } catch (Exception e) {
            assertTrue("Complete non-existent task (should not crash)", false);
        }
    }
    
    /**
     * Test completing with null input
     */
    public static void testCompleteNullTask() {
        TodoList list = new TodoList();
        list.add("Buy milk");
        try {
            list.complete(null);
            assertEquals("Complete null task (should handle gracefully)", 1, list.size());
        } catch (Exception e) {
            assertTrue("Complete null task (should not crash)", false);
        }
    }
    
    /**
     * Test completing with empty string
     */
    public static void testCompleteEmptyString() {
        TodoList list = new TodoList();
        list.add("Buy milk");
        try {
            list.complete("");
            assertEquals("Complete empty string (should handle gracefully)", 1, list.size());
        } catch (Exception e) {
            assertTrue("Complete empty string (should not crash)", false);
        }
    }
    
    /**
     * Test that methods work on empty list (should not crash)
     */
    public static void testMethodsOnEmptyList() {
        TodoList list = new TodoList();
        try {
            list.all();
            list.complete();
            list.incomplete();
            list.clear();
            assertTrue("Methods on empty list (should not crash)", true);
        } catch (Exception e) {
            assertTrue("Methods on empty list (should not crash)", false);
        }
    }
}
