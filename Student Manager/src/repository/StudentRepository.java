package repository;

import constants.Message;
import dto.RequestDTO;
import model.Student;
import model.Semester;

import java.util.ArrayList;
import java.util.List;


/**
 * StudentRepository (Data Access Layer)
 * -----------------------------------
 * Thuộc tầng Repository trong mô hình MVC.
 * - Quản lý và lưu trữ dữ liệu sinh viên trong bộ nhớ (ArrayList).
 * - Thực hiện các thao tác CRUD: add, update, delete, find.
 * - Không xử lý giao diện, không điều phối luồng chương trình.
 *
 * Vai trò trong MVC:
 * → Là tầng truy xuất dữ liệu, được Service gọi để thao tác
 *   và cung cấp dữ liệu cho hệ thống.
 */

public class StudentRepository {

    // Danh sách lưu toàn bộ sinh viên trong bộ nhớ
    private List<Student> studentList = new ArrayList<>();

    // Thêm sinh viên
    public boolean add(RequestDTO dto) {

        // Tìm sinh viên theo ID
        Student student = findById(dto.getId());

        // Nếu chưa tồn tại -> tạo mới
        if (student == null) {

            // Tạo đối tượng sinh viên mới từ dữ liệu nhập
            student = new Student(dto.getId(), dto.getName());

            // Thêm sinh viên vào danh sách quản lý
            studentList.add(student);
        } else {

            // Nếu ID tồn tại nhưng khác tên -> lỗi
            if (!student.getName().equalsIgnoreCase(dto.getName())) {
                throw new IllegalArgumentException(Message.ID_CONFLICT);
            }
        }

        // Kiểm tra trùng semester + course
        for (Semester s : student.getSemesters()) {

            // Kiểm tra trùng semester và course đã đăng ký
            if (s.getSemester().equalsIgnoreCase(dto.getSemester())
                    && s.getCourse().equalsIgnoreCase(dto.getCourse())) {
                return false;
            }
        }

        // Thêm semester mới
        student.addSemester(new Semester(dto.getSemester(), dto.getCourse()));
        return true;
    }

    // Cập nhật thông tin
    public boolean update(String id, RequestDTO dto) {

        // Tìm sinh viên theo ID
        Student student = findById(id);

        // Nếu không tồn tại thì không thể update
        if (student == null) {
            throw new IllegalArgumentException(Message.NOT_FOUND);
        }

        // Cập nhật tên
        student.setName(dto.getName());

        // Kiểm tra trùng semester + course
        for (Semester s : student.getSemesters()) {

            // Kiểm tra trùng semester + course khi update
            if (s.getSemester().equalsIgnoreCase(dto.getSemester())
                    && s.getCourse().equalsIgnoreCase(dto.getCourse())) {
                return false;
            }
        }

        // Thêm semester mới
        student.addSemester(new Semester(dto.getSemester(), dto.getCourse()));
        return true;
    }

    // Xóa sinh viên theo ID
    public boolean delete(String id) {

        // Xóa sinh viên có ID trùng (nếu có) khỏi danh sách
        return studentList.removeIf(s -> s.getId().equalsIgnoreCase(id));
    }

    // Lấy toàn bộ danh sách
    public List<Student> getAll() {

        // Trả toàn bộ danh sách sinh viên
        return studentList;
    }

    // Xóa semester theo ID và semester
    public boolean deleteBySemester(String id, String semester) {

        // Tìm sinh viên theo ID được truyền vào
        Student student = findById(id);

        // Nếu không tìm thấy sinh viên thì không thể xóa semester
        if (student == null) {
            throw new IllegalArgumentException(Message.NOT_FOUND);
        }

        /**
         * Xóa semester trùng với semester truyền vào (không phân biệt hoa thường)
         * Trả về true nếu xóa thành công, ngược lại false
         */
        return student.getSemesters().removeIf(s -> s.getSemester().equalsIgnoreCase(semester));
    }

    // Tìm sinh viên theo ID
    private Student findById(String id) {

        // Duyệt toàn bộ danh sách để tìm theo ID
        for (Student s : studentList) {

            // So sánh ID của sinh viên với ID cần tìm (không phân biệt hoa thường)
            if (s.getId().equalsIgnoreCase(id)) {

                // Trả về sinh viên nếu tìm thấy
                return s;
            }
        }
        return null;
    }
}