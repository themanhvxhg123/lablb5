package demo_ClassroomManager;

import Control.ClassroomController;
import View.InputData;
import View.ViewClassroom;

/**
 *
 * @author QH
 */
public class App_Classroom_Manager {

    public static void main(String[] args) {
        
        ViewClassroom view = new ViewClassroom();
        ClassroomController controller = new ClassroomController();
        InputData inp = new InputData();
        int choose;
        
        while(true){
            // Hiển thị menu
            view.printMenu();
            // Cho người dùng chọn chức năng 1-6
            choose = inp.inputInteger("Your choice: ", "[1-6]{1}");
            
            switch (choose) {
                case 1:
                    controller.displayListOfClassroom();                    
                    break;
                case 2:
                    controller.displayClassroom();                    
                    break;
                case 3:
                    controller.addClassroom();                    
                    break;
                case 4:
                    controller.displayListOfClassroomSorted();
                    break;
                case 5:
                    controller.updateClassroom();                    
                    break;
                default:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
}