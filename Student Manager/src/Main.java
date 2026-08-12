import controller.StudentController;
import dto.RequestDTO;
import utils.Validation;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        // Controller dùng để điều phối luồng xử lý chương trình
        StudentController controller = new StudentController();
        
        // Scanner chỉ sử dụng tại Main
        Scanner sc = new Scanner(System.in);
        
        // Vòng lặp menu chính
        while (true) {
            
            // Hiển thị menu chức năng
            System.out.println("\n========== STUDENT MANAGEMENT ==========");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            
            try {
                
                // Nhập lựa chọn và ép kiểu sang số
                int choice = Integer.parseInt(sc.nextLine());
                
                // Kiểm tra lựa chọn hợp lệ
                if ((choice < 1) || choice > 5) {
                    throw new IllegalArgumentException("Please choose between 1 and 5!");
                }
                
                // Xử lý theo từng chức năng
                switch (choice) {
                    
                    // ========== CREATE ==========
                    case 1:
                        
                        // Tạo DTO chứa dữ liệu nhập
                        RequestDTO dto = new RequestDTO();
                        
                        // Nhập ID
                        System.out.print("ID: ");
                        String idInput = sc.nextLine();
                        
                        // Validate ID
                        Validation.checkString(idInput);
                        
                        // Validate định dạng ID
                        Validation.checkIdFormat(idInput);
                        
                        // Gán ID vào DTO
                        dto.setId(idInput);
                        
                        // Nhập Name
                        System.out.print("Name: ");
                        String nameInput = sc.nextLine();
                        
                        // Validate Name
                        Validation.checkString(nameInput);
                        
                        // Gán Name vào DTO
                        dto.setName(nameInput);
                        
                        // Nhập Semester
                        System.out.print("Semester: ");
                        String semInput = sc.nextLine();
                        
                        // Validate Semester
                        Validation.checkString(semInput);
                        
                        // Gán Semester vào DTO
                        dto.setSemester(semInput);
                        
                        // Nhập Course
                        System.out.print("Course: ");
                        String courseInput = sc.nextLine();
                        
                        // Validate Course
                        Validation.checkString(courseInput);
                        
                        // Validate đúng Course
                        Validation.checkCourse(courseInput);
                        
                        // Gán Course vào DTO
                        dto.setCourse(courseInput);
                        
                        // Gửi yêu cầu tạo Sinh viên mới đến Controller
                        controller.create(dto);
                        break;
                        
                    // ========== FIND & SORT ==========
                    case 2:
                        
                        // Nhập keyword cần search
                        System.out.print("Enter id to search: ");
                        String keyword = sc.nextLine();
                        
                        // Validate keyword
                        Validation.checkString(keyword);
                        
                        // Gửi yêu cầu tìm kiếm và sắp xếp đến Controller
                        controller.findAndSort(keyword);
                        break;
                    
                    // ========== UPDATE/DELETE ==========
                    case 3:
                        
                        // Nhập ID cần CẬP NHẬT/XÓA
                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();
                        
                        // Validate ID
                        Validation.checkString(id);
                        
                        // Validate định dạng ID
                        Validation.checkIdFormat(id);
                        
                        // Hiển thị menu lựa chọn (U-D)
                        System.out.println("U. Update");
                        System.out.println("D. Delete Student");
                        System.out.print("Choose: ");
                        
                        // Nhập Option (U-D)
                        String option = sc.nextLine();
                        
                        // Validate Option
                        Validation.checkUpdateDeleteOption(option);
                        
                        // Nếu người dùng chọn update
                        if (option.equalsIgnoreCase("U")) {
                            
                            // Hiển thị menu lựa chọn khi update
                            System.out.println("1. Add Semester");
                            System.out.println("2. Delete Semester");
                            System.out.print("Choose: ");
                            
                            // Nhập lựa chọn từ người dùng
                            String updateOption = sc.nextLine();
                            
                            // ----- ADD SEMESTER -----
                            if ("1".equals(updateOption)) {
                                
                                // Tạo DTO chứa dữ liệu cập nhật
                                RequestDTO updateDTO = new RequestDTO();
                                
                                // Gán ID Sinh viên cần cập nhật
                                updateDTO.setId(id);
                                
                                // Nhập Name cập nhật
                                System.out.print("Name: ");
                                String nameUpdate = sc.nextLine();
                                
                                // Validate Name cập nhật
                                Validation.checkString(nameUpdate);
                                
                                // Gán Name cập nhật vào DTO
                                updateDTO.setName(nameUpdate);
                                
                                // Nhập Semester cập nhật
                                System.out.print("Semester: ");
                                String semUpdate = sc.nextLine();
                                
                                // Validate Semester cập nhật
                                Validation.checkString(semUpdate);
                                
                                // Gán Semester cập nhật vào DTO
                                updateDTO.setSemester(semUpdate);
                                
                                // Nhập Course cập nhật
                                System.out.print("Course: ");
                                String courseUpdate = sc.nextLine();
                                
                                // Validate Course cập nhật
                                Validation.checkString(courseUpdate);
                                
                                // Validate đúng Course cập nhật
                                Validation.checkCourse(courseUpdate);
                                
                                // Gán Course cập nhật vào DTO
                                updateDTO.setCourse(courseUpdate);
                                
                                // Gửi yêu cầu cập nhật đến Controller
                                controller.update(id, updateDTO);
                            }
                            
                            // ----- DELETE SEMESTER -----
                            else if ("2".equals(updateOption)) {
                                
                                // Nhập Semester cần xóa
                                System.out.print("Enter Semester to delete: ");
                                String semDelete = sc.nextLine();
                                
                                // Validate Semester cần xóa
                                Validation.checkString(semDelete);
                                
                                // Gửi yêu cầu xóa Semester đến Controller
                                controller.deleteBySemester(id, semDelete);
                            }
                            
                            else {
                                
                                // Nếu người dùng nhập lựa chọn không hợp lệ
                                System.err.println("Invalid choice!");
                            }
                            
                        } else {
                            
                            // Nếu chọn Delete thì gửi yêu cầu xóa đến Controller
                            controller.delete(id);
                        }
                        
                        break;
                        
                    // ========== REPORT ==========
                    case 4:
                        
                        // Gửi yêu cầu tạo báo cáo đến Controller
                        controller.report();
                        break;
                        
                    // ========== EXIT ==========
                    case 5:
                        
                        // Thoát chương trình
                        System.out.println("Exiting program...");
                        return;
                }
                
            } catch (NumberFormatException e) {
                
                // Lỗi nhập sai kiểu số
                System.err.println("Ivalid input. Please try again!");
            } catch (IllegalArgumentException e) {
                
                // Lỗi nghiệp vụ (Validaiton và nhập sai lựa chọn)
                System.err.println(e.getMessage());
            } catch (Exception e) {
                
                // Lỗi ngoài mong muốn
                System.err.println("Unexpected error occured!");
            }
        }
    }
}