package View;

/**
 *
 * @author QH
 */
public class ViewClassroom {
    
    // Hiển thị menu
    public void printMenu(){
        System.out.println("""
                       
                       -------------CLASSROOM MANAGEMENT---------------
                       1. List all available classrooms in the system
                       2. Search and display classroom by room id
                       3. Add information of a new classroom
                       4. Sort all classrooms by capacity as ascending
                       5. Update information of a specific classroom (by room id)
                       6. Exit
                       -------------------------
                       """);
    }
    
    // Hiển thị thông điệp
    public void displayMess(String mess){
        System.out.println(mess);
    }
}