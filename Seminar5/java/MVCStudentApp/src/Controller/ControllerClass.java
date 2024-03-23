package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClass;
/*импортируем ModelClassHash*/
import Model.ModelClassHash;
import Model.Domain.Student;
import View.ViewClass;
/*импортируем View.ViewClassENG*/
import View.ViewClassENG;

public class ControllerClass {

    private iGetModel model;
    private iGetView view;
    private List<Student> buffer = new ArrayList<>();
    /* Добавляем ViewClassENG и hashMap*/
    private ViewClassENG vieweng;
    private HashMap<String, iGetView> hashMap = new HashMap<>();



    /*добавляем в конструктор vieweng*/
    public ControllerClass(iGetModel model, iGetView view,ViewClassENG vieweng) {
        this.model = model;
        this.view = view;
        this.vieweng = vieweng;

    }

    private boolean testData(List<Student> students)
    {
        if(students.size()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void update()
    {
        //MVC
        //view.printAllStudents(model.getAllStudents());

        //MVP
        buffer = model.getAllStudents();

        if(testData(buffer))
        {
            view.printAllStudents(buffer);
        }
        else{
            System.out.println("Список студентов пуст!");
        }
    }

    public void run() {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    //MVC
                    view.printAllStudents(model.getAllStudents());
                    break;
                    /* Добавляем команду*/
                case DELETE:
                    Scanner scanner = new Scanner(System.in);
                    //запрос номера
                    int number = scanner.nextInt();
                    //удаление
                    model.removeFromList(number);
                    // .remove(number - 1);

            }
        }
    }
    
}
