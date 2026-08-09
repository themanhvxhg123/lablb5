package dto;

/**
 * ResponseDTO (DTO - Output)
 * -----------------------------------
 * Dùng để trả dữ liệu từ Service -> Controller -> View
 * - Chứa dữ liệu đã xử lý để hiển thị (studentName, course, num)
 * - Không liên kết trực tiếp với Model
 * - Giúp tách dữ liệu hiển thị khỏi cấu trúc Model
 */

public class ResponseDTO {
    
    // Thuộc tính
    private String studentName;
    private String course;
    private int num;
    
    // Constructor
    public ResponseDTO(String studentName, String course, int num) {
        this.studentName = studentName;
        this.course = course;
        this.num = num;
    }

    // Getter
    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getNum() {
        return num;
    }
}