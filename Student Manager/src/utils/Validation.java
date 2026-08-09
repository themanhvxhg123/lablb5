package utils;

/**
 * Validation (Utility Layer)
 * ------------------------------------
 * Lớp tiện ích dùng để kiểm tra và xác thực dữ liệu đầu vào
 * - Được sử dụng tại Main trước khi gọi Controller
 * - Chỉ chứa các phương thức static, không tạo object
 * - Không thuộc View, Controller hay Model
 * - Khi dữ liệu sai sẽ ném Exception để ngăn luồng xử lý tiếp tục
 * 
 * Vai trò trong MVC:
 * -> Hỗ trợ kiểm tra dữ liệu trước khi chuyển vào Controller,
 *    giúp tách biệt phần Validation khỏi logic nghiệp vụ
 */

public final class Validation {
    
    private Validation() {
    }
    
    // Kiểm tra chuỗi không được null hoặc rỗng
    public static void checkString(String input) {
        
        // Nếu null hoặc chỉ chứa khoảng trắng -> không hợp lệ
        if ((input == null) || (input.trim().isEmpty())) {
            throw new IllegalArgumentException("Input must not be empty!");
        }
    }
    
    // Kiểm tra Course hợp lệ (Java, .Net, C/C++)
    public static void checkCourse(String course) {
        
        // Course chỉ hợp lệ khi là: Java, .Net, C/C++
        if ((!course.equalsIgnoreCase("Java"))
                && (!course.equalsIgnoreCase(".Net"))
                && (!course.equalsIgnoreCase("C/C++"))) {
            
            throw new IllegalArgumentException("Course must be Java, .Net, C/C++!");
        }
    }
    
    // Kiểm tra ID đúng format S + 2 số (Ví dụ: S01, S02, ...)
    public static void checkIdFormat(String id) {
        
        // Regex: S + đúng 2 chữ số
        if (!id.matches("S\\d{2}")) {
            throw new IllegalArgumentException("ID must follow format S01, S02, ...");
        }
    }
    
    // Kiểm tra lựa chọn Update/Delete hợp lệ
    public static void checkUpdateDeleteOption(String input) {
        
        // Option chỉ được phép là U (Update) hoặc D (Delete)
        if ((!input.equalsIgnoreCase("U")) && (!input.equalsIgnoreCase("D"))) {
            throw new IllegalArgumentException("Option must be U or D!");
        }
    }
}