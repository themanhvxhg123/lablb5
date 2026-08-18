/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Course;
import Common.Constant;


import View.InputData;
import View.ViewCourse;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nangnth
 */
public class CourseController {

    CourseManager courseList = new CourseManager();
    ViewCourse viewCourse = new ViewCourse();
    InputData inp = new InputData();

    // Hàm thêm 1 khóa học
    public void addCourse() {
        String courseId = inp.inputString("Course id: ", Constant.REGCOURSEID);
        String courseName = inp.inputString("Course Name: ", Constant.REGCOURSENAME);
        int credit = inp.inputInteger("credit: ", "[1-4]{1}");
        try {
            courseList.addCourse(new Course(courseId, courseName, credit));
            viewCourse.displayMess("add new Course successfully");
        } catch (Exception ex) {
            viewCourse.displayMess(ex.getMessage());
        }

    }

    // Hiển thị danh sách khóa học
    public void displayListOfCourse() {
        ArrayList<Course> lst = courseList.getCourseList();
        viewCourse.displayMess(String.format("%5s %5s %10s  %5s\n", "No", "courseID", "CourseName", "Credit"));
        for (int i = 0; i < lst.size(); i++) {
            viewCourse.displayMess(String.format("%5d", (i + 1)) + lst.get(i).toString());
        }
    }
    // Hiển thị danh sách khóa học

    public void displayCourse() {
        viewCourse.displayMess("Course id:");
        String courseID = new Scanner(System.in).nextLine().trim();
        Course c = courseList.findById(courseID);
        if (c != null) {
            viewCourse.displayMess("CourseID      CourseName    Credit");
            viewCourse.displayMess(c.toString());
        }
        else
          viewCourse.displayMess("no course found");  
    }

    // Hiển thị list đã sắp xếp
    public void displayListOfCourseSorted() {
        ArrayList<Course> lst = courseList.sort();
        viewCourse.displayMess("No      courseID      CourseName    Credit");
        for (int i = 0; i < lst.size(); i++) {
            viewCourse.displayMess((i + 1) + lst.get(i).toString());
        }

    }

    public void updateCourse() {
        try {
            String courseId = inp.inputString("Course id: ", Constant.REGCOURSEID);
            int credit = inp.inputInteger("credit: ", "[1-4]{1}");
            courseList.updateCourse(courseId, credit);
        } catch (Exception ex) {
            viewCourse.displayMess(ex.getMessage());
        }
    }
}
