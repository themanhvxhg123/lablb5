package model;

import utils.Validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Student (Model) --------------------------- Đại diện thực thể Sinh viên trong
 * hệ thống - Quan hệ: 1 Student chứa nhiều Semester (1-N) - Được Repository
 * quản lý lưu trữ - Được Service lý nghiệp vụ trước khi thao tác dữ liệu
 */
public class Student {

    // Thuộc tính
    private String id;
    private String name;
    private List<Semester> semesters;

    // Constructor
    public Student(String id, String name) {

        // Validate ID: không rỗng và đúng format S + 2 số
        Validation.checkString(id);
        Validation.checkIdFormat(id);

        // Validate Name: không rỗng
        Validation.checkString(name);

        this.id = id;
        this.name = name;
        this.semesters = new ArrayList<>();
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    // Setter
    public void setName(String name) {

        // Validate Name: không rỗng
        Validation.checkString(name);

        this.name = name;
    }

    // Thêm học kỳ mới
    public void addSemester(Semester semester) {
        semesters.add(semester);
    }
}
