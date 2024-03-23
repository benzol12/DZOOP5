package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/*Задание 2. Реализуем хранилище типа hashmap c нужными типами и подключаем к нему интерфейс*/
public class ModelClassHash implements iGetModel{
        private Map<Integer, Student> hashmap;

        public ModelClassHash(List<Student> students) {
            this.hashmap = new HashMap<>();
            for (Student s : students) {
                /* при переборе добавляем ключ и значение*/
                this.hashmap.put(s.getId(), s);
            }
        }
/*После подключения переопределяем метод*/
        @Override
        public List<Student> getAllStudents() {
                    List<Student> students = new ArrayList<>();
                    /*перебираем hashmap и добавляем студента в лист*/
                    for (Student student : hashmap.values()){
                        students.add(student);
                    }
                    return students;
        }
        /*удаление студента*/
        @Override
        public void removeFromList(int num) {
            if (hashmap.containsKey(num)) {
            hashmap.remove(num);
            } else {
            System.out.println("Студент не найден");
            }

        }

}
