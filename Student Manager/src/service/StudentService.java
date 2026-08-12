package service;

import dto.RequestDTO;
import dto.ResponseDTO;
import model.Semester;
import model.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * StudentService (Bussiness Logic Layer)
 * --------------------------------------
 * Thuộc tầng Service trong mô hình MVC
 * - Nhận yêu cầu từ Controller
 * - Xử lý logic nghiệp vụ (create, update, delete, search, report)
 * - Giao tiếp với Repository để thao tác dữ liệu
 * - Chuyển đổi dữ liệu Model sang ResponseDTO để trả về View
 * 
 * Vai trò trong MVC:
 * -> Tách biệt logic nghiệp vụ khỏi Controller và View,
 *    giúp hệ thống rõ ràng, dễ bảo trì và mở rộng
 */

public class StudentService {
    
    // Repository thao tác dữ liệu
    private StudentRepository repository;
    
    // Constructor nhận Repository (Dependency Injection)
    public StudentService() {
        this.repository = new StudentRepository();
    }
    
    // Thêm Sinh viên mới (gọi Repository lưu dữ liệu)
    public boolean create(RequestDTO dto) {
        
        // Gọi Repository thêm Sinh viên mới và trả về kết quả
        return repository.add(dto);
    }
    
    // Cập nhật thông tin Sinh viên theo ID
    public boolean update(String id, RequestDTO dto) {
        
        // Gọi Repository cập nhật thông tin Sinh viên theo ID và trả về kết quả
        return repository.update(id, dto);
    }
    
    // Xóa Sinh viên theo ID
    public boolean delete(String id) {
        
        // Gọi Repository xóa Sinh viên theo ID và trả về kết quả
        return repository.delete(id);
    }
    
    // Xóa Semester theo ID Sinh viên
    public boolean deleteBySemester(String id, String semester) {
        
        // Gọi Repository xóa Semester theo ID và trả về kết quả
        return repository.deleteBySemester(id, semester);
    }
    
    // Tìm Sinh viên theo tên và sắp xếp theo alphabet
    public List<ResponseDTO> findAndSort(String keyword) {
        
        // Danh sách lưu kết quả tìm kiếm/báo cáo để trả về View
        List<ResponseDTO> result = new ArrayList<>();
        
        // Duyệt toàn bộ Sinh viên trong hệ thống
        for (Student s : repository.getAll()) {
            
            // Nếu id chứa từ khóa tìm kiếm
            if (s.getId().toLowerCase().contains(keyword.toLowerCase())) {
                
                // Lấy từng học kỳ của Sinh viên
                for (Semester sem : s.getSemesters()) {
                    
                    // Chuyển dữ liệu sang DTO để trả về View
                    result.add(new ResponseDTO(
                            s.getName(),
                            sem.getSemester() + "|" + sem.getCourse(),
                            0
                    ));
                }
            }
        }
        
        // Sắp xếp kết quả theo tên Sinh viên
        result.sort(Comparator.comparing(ResponseDTO::getStudentName));
            
        // Trả kết quả tìm kiếm đã sắp xếp
        return result;
    }
    
    // Tạo báo cáo: đếm số lần học từng Course của mỗi Sinh viên
    public List<ResponseDTO> report() {
        
        // Map dùng để lưu: "StudentName | Course" và số lần học (đếm số Course)
        Map<String, Integer> map = new LinkedHashMap<>();
        
        // Duyệt toàn bộ dữ liệu để đếm số Course
        for (Student s : repository.getAll()) {
            
            // Duyệt từng học kỳ của Sinh viên
            for (Semester sem : s.getSemesters()) {
                
                // Tạo key duy nhất theo dạng: "Tên | Course"
                String key = s.getName() + "|" + sem.getCourse();
                
                // Nếu tồn tại thì tăng +1, chưa có thì mặc định = 0 rồi +1
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        // Danh sách kết quả để trả về cho View
        List<ResponseDTO> result = new ArrayList<>();
        
        // Chuyển dữ liệu đã đếm sang danh sách DTO
        for (String key : map.keySet()) {
            
            // Tách key thành 2 phần: "Tên Sinh viên và Course"
            String[] parts = key.split("\\|");
            
            // Tạo ResponseDTO chứa: Tên, Course, tổng số lần học
            result.add(new ResponseDTO(parts[0], parts[1], map.get(key)));
        }
        
        // Trả danh sách báo cáo về Controller
        return result;
    }
}