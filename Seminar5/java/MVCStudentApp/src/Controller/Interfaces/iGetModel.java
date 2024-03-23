package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

public interface iGetModel {
    public List<Student> getAllStudents();
    //Добавляем в интерфейс метод для переопределения
    public void removeFromList(int num);
}
