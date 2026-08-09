package constants;

/**
 * Message (Constants Layer)
 * ------------------------------------------
 * Lưu trữ các thông báo (message) dùng chung trong hệ thống
 * - Tránh hard-code chuỗi trong nhiều class
 * - Giúp dễ quản lý, chỉnh sửa và tái sử dụng
 * - Được Controller và Repository sử dụng để hiển thị thông báo
 */

public final class Message {
    
    private Message() {
    }
    
    // Thông báo thêm Student thành công
    public static final String ADD_SUCCESS = "Add student successfully!";
    
    // Thông báo Student bị trùng
    public static final String DUPLICATE = "Duplicate student!";
    
    // Thông báo không tìm thấy Student
    public static final String NOT_FOUND = "Student not found!";
    
    // Thông báo cập nhật thành công
    public static final String UPDATE_SUCCESS = "Update successfully!";
    
    // Thông báo xóa thành công
    public static final String DELETE_SUCCESS = "Delete successfully!";
    
    // Thông báo không có dữ liệu
    public static final String NO_DATA = "No data to display!";
    
    // Thông báo ID đã tồn tại nhưng khác tên
    public static final String ID_CONFLICT = "ID already exists with different student!";
    
    // Thông báo xóa Semester thành công
    public static final String DELETE_SEMESTER = "Delete semester successfully!";
}