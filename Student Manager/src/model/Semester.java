package model;

import utils.Validation;

/**
 * Semester (Model Layer)
 * ---------------------------------
 * Đại diện thông tin học kỳ và khóa học của một Student
 * - Thuộc về Student (quan hệ N-1)
 * - Chỉ lưu dữ liệu, không xử lý logic
 */

public class Semester {
    
    // Thuộc tính
    private String semester;
    private String course;
    
    // Constructor
    public Semester(String semester, String course) {
        
        // Validate Semester: không rỗng
        Validation.checkString(semester);
        
        // Validate Course: không rỗng và đúng định dạng (Java, .Net, C/C++)
        Validation.checkString(course);
        Validation.checkCourse(course);
        
        this.semester = semester;
        this.course = course;
    }
    
    // Getter
    public String getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }
}
