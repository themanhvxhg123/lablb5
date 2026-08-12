package dto;

import utils.Validation;

/**
 * RequestDTO (DTO - Input)
 * -----------------------------------
 * Dùng để truyền dữ liệu từ View -> Controller -> Service
 * - Chứa thông tin nhập vào: id, name, semester, course
 * - Không chứa logic xử lý
 * - Được Service sử dụng để tạo/cập nhật Student trong Repository
 */

public class RequestDTO {
    
    // Thuộc tính
    private String id;
    private String name;
    private String semester;
    private String course;
    
    // Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }

    // Setter
    public void setId(String id) {
        
        // Validate ID: không rỗng và đúng format S + 2 số
        Validation.checkString(id);
        Validation.checkIdFormat(id);
        
        this.id = id;
    }

    public void setName(String name) {
        
        // Validate Name: không rỗng
        Validation.checkString(name);
        
        this.name = name;
    }

    public void setSemester(String semester) {
        
        // Validate Semester: không rỗng
        Validation.checkString(semester);
        
        this.semester = semester;
    }

    public void setCourse(String course) {
        
        // Validate Course: không rỗng và đúng định dạng (Java, .Net, C/C++)
        Validation.checkString(course);
        Validation.checkCourse(course);
        
        this.course = course;
    }
}
