package view;

import constants.Message;
import dto.ResponseDTO;

import java.util.List;

/**
 * StudentView (View Layer)
 * -----------------------------------
 * Thuộc mô hình MVC:
 * - Chịu trách nhiệm hiển thị dữ liệu ra màn hình (console)
 * - Nhận dữ liệu từ Controller dưới dạng ResponseDTO
 * - Không xử lý nghiệp vụ, không thao tác dữ liệu
 * - Chỉ tập trung vào việc trình bày (UI)
 */

public class StudentView {
    
    // Danh sách dữ liệu nhận từ Controller để hiển thị
    private List<ResponseDTO> listStudents;
    
    // Nhận danh sách từ Controller
    public void setStudent(List<ResponseDTO> listStudents) {
        this.listStudents = listStudents;
    }
    
    // Hiển thị danh sách Student khi Find & Sort
    public void showStudent() {
        
        // Nếu không có dữ liệu
        if ((listStudents == null) || (listStudents.isEmpty())) {
            System.out.println(Message.NO_DATA);
            return;
        }
        
        // In tiêu đề bảng
        System.out.printf("%-20s %-15s %-10s\n",
                "Student Name", "Semester", "Course");
        
        // Duyệt từng ResponseDTO
        for (ResponseDTO r : listStudents) {
            
            // Tách Semester và Course từ chuỗi "semester|course"
            String[] parts = r.getCourse().split("\\|");
            
            // In dữ liệu
            System.out.printf("%-20s %-15s %-10s\n",
                    r.getStudentName(),
                    parts[0],
                    parts[1]);
        }
    }
    
    // Hiển thị báo cáo tổng số khóa học theo Student
    public void showReport() {
        
        // Nếu không có dữ liệu
        if ((listStudents == null) || (listStudents.isEmpty())) {
            System.out.println(Message.NO_DATA);
            return;
        }
        
        // In tiêu đề Report
        System.out.printf("%-20s %-10s %-5s\n",
                "Student Name", "Course", "Total");
        
        // In từng dòng Report
        for (ResponseDTO r : listStudents) {
            
            // In dữ liệu theo dạng bảng (cột trái, cố định độ rộng cột)
            System.out.printf("%-20s %-10s %-5d\n",
                    r.getStudentName(),
                    r.getCourse(),
                    r.getNum());
        }
    }
    
    // Hiển thị thông báo (Add, Update, Delete...)
    public void showMessage(String message) {
        System.out.println(message);
    }
}