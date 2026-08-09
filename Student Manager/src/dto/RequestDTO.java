package dto;

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
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}