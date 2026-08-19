package Control;

import Common.Constant;
import Model.Classroom;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author QH
 */
public class ClassroomManager {

    private ArrayList<Classroom> lstClassroom;

    public ClassroomManager() {
        lstClassroom = new ArrayList<Classroom>();
    }
    
    // Lấy về danh sách các phòng học có trong hệ thống
    public ArrayList<Classroom> getClassroomList() {
        return new ArrayList<>(lstClassroom);
    }
    
    // Trả về phòng học có roomID
    public Classroom findById(String roomID) {
        Classroom classroom;
        roomID = roomID.toLowerCase().trim();
        for (int i = 0; i < lstClassroom.size(); i++) {
            classroom = lstClassroom.get(i);
            if (classroom.getRoomId().toLowerCase().equals(roomID)) {
                return classroom;
            }
        }
        return null;
    }
    
    // Tìm danh sách phòng theo tòa nhà
    public ArrayList<Classroom> findByBuilding(String building) {
        ArrayList<Classroom> result = new ArrayList<>();
        building = building.toLowerCase().trim();
        for (Classroom classroom : lstClassroom) {
            if (classroom.getBuilding().toLowerCase().equals(building)) {
                result.add(classroom);
            }
        }
        return result;
    }
    
    // Thêm phòng học
    public void addClassroom(Classroom classroom) throws Exception {
        if (findById(classroom.getRoomId()) == null) {
            lstClassroom.add(classroom);
        } else {
            throw new Exception("roomID is existed");
        }
    }
    
    // Sắp xếp danh sách phòng học
    public ArrayList sort() {
        ArrayList<Classroom> lst = new ArrayList<>(lstClassroom);
        Collections.sort(lst);
        return lst;
    }
    
    // Cập nhật thông tin phòng học
    public void updateClassroom(String roomID, int capacity) throws Exception {
        Classroom classroom = findById(roomID);
        if (classroom == null) {
            throw new Exception("Room Id not exist");
        } else {
            classroom.setCapacity(capacity);
        }
    }
    
    // Cập nhật thông tin phòng học bao gồm cả tòa nhà
    public void updateClassroom(String roomID, String building, int capacity) throws Exception {
        Classroom classroom = findById(roomID);
        if (classroom == null) {
            throw new Exception("Room Id not exist");
        } else {
            classroom.setBuilding(building);
            classroom.setCapacity(capacity);
        }
    }
}