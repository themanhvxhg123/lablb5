/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


/**
 *
 * @author QH
 */
public class ViewCourse {
      
    
    // Hiển thị menu
    public void printMenu(){
    System.out.println("""
                       
                       -------------MENU---------------
                       1. A list of all available courses in the system
                       2. Search and display information of a course by course id
                       3. Record/Add information of course
                       4. Sort all courses by number of credit as ascending
                       5. Update information of a specific course (by course id)
                       6. exit
                       -------------------------
                       """);
    }
   // Hiển thị thông điệp
    public void displayMess(String mess){
        System.out.println(mess);
    }
    
}
