package controller;

import constants.Message;
import dto.RequestDTO;
import dto.ResponseDTO;
import service.StudentService;
import view.StudentView;

import java.util.List;

/**
 * StudentController (Controller Layer)
 * ------------------------------------
 * Thuộc tầng Controller trong mô hình MVC
 * - Nhận yêu cầu từ Main (người dùng)
 * - Gọi Service để xử lý nghiệp vụ
 * - Nhận kết quả và chuyển sang View để hiển thị
 * 
 * Vai trò trong MVC:
 * -> Là lớp điều phối trung gian giữa View và Service,
 *    giúp tách biệt giao diện và logic nghiệp vụ
 */

public class StudentController {
    
    // Service dùng để xử lý nghiệp vụ
    private StudentService service;
    
    // View dùng để hiển thị thông báo ra màn hình
    private StudentView view;

    /**
     * Constructor nhận Service (Dependency Injection)
     * Đồng thời khởi tạo View để hiển thị kết quả
     */
    public StudentController() {
        this.service = new StudentService();
        this.view = new StudentView();
    }
    
    // Tạo Sinh viên
    public void create(RequestDTO dto) {
        
        // Gọi Service để tạo Sinh viên
        boolean result = service.create(dto);
        
        // Nếu tạo Sinh viên thành công thì hiển thị thông báo thành công
        if (result) {
            view.showMessage(Message.ADD_SUCCESS);
        } else {
            
            // Nếu bị trùng dữ liệu thì duplicate
            view.showMessage(Message.DUPLICATE);
        }
    }
    
    // Tìm và hiển thị
    public void findAndSort(String name) {
        
        // Gọi Service để tìm kiếm và sắp xếp
        List<ResponseDTO> list = service.findAndSort(name);
        
        // Gửi dữ liệu sang View
        view.setStudent(list);
        
        // Yêu cầu View hiển thị danh sách
        view.showStudent();
    }
    
    // Cập nhật thông tin
    public void update(String id, RequestDTO dto) {
        
        // Gọi Service để cập nhật thông tin Sinh viên theo ID
        boolean result = service.update(id, dto);
        
        // Nếu cập nhật thành công thì thông báo thành công
        if (result) {
            view.showMessage(Message.UPDATE_SUCCESS);
        } else {
            
            // Nếu dữ liệu bị trùng thì duplicate
            view.showMessage(Message.DUPLICATE);
        }
    }
    
    // Xóa theo ID
    public void delete(String id) {
        
        // Gọi Service để xóa Sinh viên theo ID
        boolean result = service.delete(id);
        
        // Nếu xóa theo ID thành công thì thông báo thành công
        if (result) {
            view.showMessage(Message.DELETE_SUCCESS);
        } else {
            
            // Nếu không tìm thấy Sinh viên thì báo lỗi
            view.showMessage(Message.NOT_FOUND);
        }
    }
    
    // Xóa Semester
    public void deleteBySemester(String id, String semester) {
        
        // Gọi Service để xóa Semester theo ID Sinh viên
        boolean result = service.deleteBySemester(id, semester);
        
        // Nếu xóa Semester thành công thì thông báo thành công
        if (result) {
            view.showMessage(Message.DELETE_SEMESTER);
        } else {
            
            // Nếu không tìm thấy Sinh viên thì báo lỗi
            view.showMessage(Message.NOT_FOUND);
        }
    }
    
    // Hiển thị báo cáo
    public void report() {
        
        // Gọi Service để tạo báo cáo
        List<ResponseDTO> list = service.report();
        
        // Gửi dữ liệu sang View
        view.setStudent(list);
        
        // Yêu cầu View hiển thị báo cáo
        view.showReport();
    }
}