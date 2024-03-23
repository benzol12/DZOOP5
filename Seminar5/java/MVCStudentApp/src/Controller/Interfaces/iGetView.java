package Controller.Interfaces;

import java.util.HashMap;
import java.util.List;

import Model.Domain.Student;

public interface iGetView {
     public void printAllStudents(List<Student> students);
     public String prompt(String msg);
     // private HashMap<String, iGetView> hashMap = new HashMap<>();
}
