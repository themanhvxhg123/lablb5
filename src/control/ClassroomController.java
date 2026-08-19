package Control;

import Model.Classroom;
import Common.Constant;
import View.InputData;
import View.ViewClassroom;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nangnth
 */
public class ClassroomController {

    ClassroomManager classroomList = new ClassroomManager();
    ViewClassroom viewClassroom = new ViewClassroom();
    InputData inp = new InputData();

    // Hàm thêm 1 phòng học
    public void addClassroom() {
        String roomId = inp.inputString("Room id: ", Constant.REGROOMID);
        String building = inp.inputString("Building (alpha, beta, delta, epsilon): ", Constant.REGBUILDING);
        int capacity = inp.inputInteger("Capacity: ", Constant.REGCAPACITY);
        try {
            classroomList.addClassroom(new Classroom(roomId, building, capacity));
            viewClassroom.displayMess("Add new Classroom successfully");
        } catch (Exception ex) {
            viewClassroom.displayMess(ex.getMessage());
        }
    }

    // Hiển thị danh sách phòng học
    public void displayListOfClassroom() {
        ArrayList<Classroom> lst = classroomList.getClassroomList();
        if (lst.isEmpty()) {
            viewClassroom.displayMess("No classrooms in the system");
            return;
        }
        viewClassroom.displayMess(String.format("%5s %5s %10s  %5s\n", "No", "RoomID", "Building", "Capacity"));
        for (int i = 0; i < lst.size(); i++) {
            viewClassroom.displayMess(String.format("%5d", (i + 1)) + lst.get(i).toString());
        }
    }

    // Tìm kiếm và hiển thị phòng học theo mã phòng
    public void displayClassroom() {
        viewClassroom.displayMess("Room id:");
        String roomID = new Scanner(System.in).nextLine().trim();
        Classroom c = classroomList.findById(roomID);
        if (c != null) {
            viewClassroom.displayMess("RoomID      Building      Capacity");
            viewClassroom.displayMess(c.toString());
        }
        else
            viewClassroom.displayMess("No classroom found");  
    }
    
    // Tìm kiếm và hiển thị danh sách phòng theo tòa nhà
    public void displayClassroomByBuilding() {
        String building = inp.inputString("Building (alpha, beta, delta, epsilon): ", Constant.REGBUILDING);
        ArrayList<Classroom> lst = classroomList.findByBuilding(building);
        if (lst.isEmpty()) {
            viewClassroom.displayMess("No classrooms found in building " + building);
            return;
        }
        viewClassroom.displayMess(String.format("%5s %5s %10s  %5s\n", "No", "RoomID", "Building", "Capacity"));
        for (int i = 0; i < lst.size(); i++) {
            viewClassroom.displayMess(String.format("%5d", (i + 1)) + lst.get(i).toString());
        }
    }

    // Hiển thị danh sách đã sắp xếp theo sức chứa
    public void displayListOfClassroomSorted() {
        ArrayList<Classroom> lst = classroomList.sort();
        if (lst.isEmpty()) {
            viewClassroom.displayMess("No classrooms in the system");
            return;
        }
        viewClassroom.displayMess("No      RoomID      Building      Capacity");
        for (int i = 0; i < lst.size(); i++) {
            viewClassroom.displayMess((i + 1) + lst.get(i).toString());
        }
    }

    // Cập nhật thông tin phòng học
    public void updateClassroom() {
        try {
            String roomId = inp.inputString("Room id: ", Constant.REGROOMID);
            Classroom classroom = classroomList.findById(roomId);
            if (classroom == null) {
                viewClassroom.displayMess("Room Id not exist");
                return;
            }
            
            viewClassroom.displayMess("Current information:");
            viewClassroom.displayMess(classroom.toString());
            
            // Cho phép cập nhật cả tòa nhà và sức chứa
            String building = inp.inputString("New building (alpha, beta, delta, epsilon): ", Constant.REGBUILDING);
            int capacity = inp.inputInteger("New capacity: ", Constant.REGCAPACITY);
            
            classroomList.updateClassroom(roomId, building, capacity);
            viewClassroom.displayMess("Update successfully");
        } catch (Exception ex) {
            viewClassroom.displayMess(ex.getMessage());
        }
    }
}