package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int intInput(){ //функция приёма числовых значений и проверка на правильность ввода
        while (true){
            try {
                return new Scanner(System.in).nextInt();
            }
            catch (Exception e){
                System.out.println("Введите целое число");
            }
        }
    }

    static void dismiss(List<Worker> list){ //удаление работника из списка
        System.out.println("Введите индекс увольняеемого рабочего");
        int index;
        do {
            index = intInput(); //проверяем корректность индекса
            if(index < 0 || index > list.size()) System.out.println("Неверный индекс");
        }while (index < 0 || index > list.size());
        list.remove(index);
    }

    static void add(List<Worker> list){ //добавление работника в список
        Scanner scanner = new Scanner(System.in);
        String lastName, firstName, patronymic, street;
        int house, apartment, month, year;
        System.out.print("Введите фамилию нового рабочего: ");
        lastName = scanner.nextLine();
        System.out.print("Введите имя нового рабочего: ");
        firstName = scanner.nextLine();
        System.out.print("Введите отчество нового рабочего: ");
        patronymic = scanner.nextLine();
        System.out.print("Введите улицу, где живёт рабочий: ");
        street = scanner.nextLine();
        System.out.print("Введите номер дома: ");
        house = intInput();
        System.out.print("Введите номер квартиры: ");
        apartment = intInput();
        System.out.print("Введите месяц трудоустройства: ");
        do {
             month = intInput();
            if(month < 1 || month > 12) System.out.println("Неверный месяц");
        }while (month < 1 || month > 12);
        System.out.print("Введите год трудоустройства: ");
        do {
            year = intInput();
            if(year < 1950 || year > 2022) System.out.println("Это невозможно");
        }while (year < 1950 || year > 2022);
        list.add(new Worker(lastName, firstName, patronymic, street, house, apartment, month, year));
        System.out.println("\nДобавление произведено успешно\n");
    }

    static void sort(List<Worker> list){ //сортировка пузырьком по дате трудоустройства(если год одинаковый, смотрим по месяцу)
        Worker buffer;
        for(int i = 0; i < list.size(); i++){
            for(int j = 1; j < list.size(); j++){
                if(list.get(j).getDateOfEmployment().getYear() < list.get(j-1).getDateOfEmployment().getYear()){
                    buffer = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, buffer);
                }
                if(list.get(j).getDateOfEmployment().getYear() == list.get(j-1).getDateOfEmployment().getYear() && list.get(j).getDateOfEmployment().getMonth() < list.get(j-1).getDateOfEmployment().getMonth()){
                    buffer = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, buffer);
                }
            }
        }
        System.out.println("\nСортировка прошла успешно\n");
    }

    static void show(List<Worker> list){ //вывод на экран всех работников
        int i = 0;
        for(Worker worker: list){
            System.out.println("Индекс рабочего: " + i + "\n" + worker);
            i++;
            System.out.println("----------------------------------------------------------------");
        }
    }

    static void SearchAndAddForPetrov(List<Worker> list, Stack stack){ //ищем всех петровых и добавляем в стек
        for(Worker worker: list){
           if(worker.getWorkerLFP().getLastName().equals("Петров") || worker.getWorkerLFP().getLastName().equals("Петрова")){
               if(!stack.contains(worker))stack.push(worker); //добавляем, если такой элемент в стеке не содержался
           }
        }
    }

    public static void main(String[] args) {
        List<Worker> worker = new ArrayList(); //список всех работников
        worker.add(new Worker("Петёрик", "Валерий", "Радионович", "Огинского", 7, 18, 1, 2003));
        worker.add(new Worker("Конец", "Лидия", "Ивановна", "Восходящая", 18, 7, 10, 2001));
        worker.add(new Worker("Гуськов", "Андрей", "Афонасьевич", "Строителей", 4, 38, 12, 2010));
        worker.add(new Worker("Петров", "Иосиф", "Павлович", "Огинского", 3, 6, 7, 2015));
        worker.add(new Worker("Петёрик", "Анатолий", "Иванович", "БЛК", 22, 8, 6, 2013));
        worker.add(new Worker("Заходнева", "Анастасия", "Генадьевна", "Огинского", 10, 78, 11, 2011));
        worker.add(new Worker("Петёрик", "Анатолий", "Иванович", "Ожешко", 20, 8, 11, 2017));
        worker.add(new Worker("Икрус", "Анатолий", "Иванович", "Заходящая", 7, 8, 11, 2001));
        worker.add(new Worker("Петёрик", "Анатолий", "Иванович", "Девятовка", 2, 11, 5, 2008));
        worker.add(new Worker("Петров", "Анатолий", "Иванович", "Огинского", 3, 7, 1, 2007));
        worker.add(new Worker("Трёскин", "Анатолий", "Иванович", "Весенняя", 4, 8, 8, 2006));
        worker.add(new Worker("Попаев", "Игорь", "Валерьевич", "Огинского", 13, 8, 2, 2005));
        worker.add(new Worker("Петёрик", "Анатолий", "Иванович", "Янки Купала", 14, 8, 11, 2003));
        worker.add(new Worker("Петёрик", "Кузя", "Иванович", "Победителей", 23, 8, 10, 2003));
        worker.add(new Worker("Петрова", "Алина", "Павловна", "Карла Маркса", 27, 8, 12, 2003));
        System.out.println("Изначально список работников выглядит так:\n");
        show(worker);

        boolean work = true; //отвечает за работу цикла для работы с пользователем
        Stack stack = new Stack(); //самописный стек

        while (work){
            System.out.println("\n1.Показать всех рабочих\n2.Отсовртировать\n3.Добавить нового рабочего\n4.Уволить рабочего\n5.Найти всех Петровых и добавить в стек\n6.Вывести стек на экран\n7.Удалить из стека элемент\n0.Завершить работу");
            switch (intInput()){
                case 0->work = false;
                case 1 ->show(worker);
                case 2->sort(worker);
                case 3->add(worker);
                case 4->dismiss(worker);
                case 5->SearchAndAddForPetrov(worker, stack);
                case 6->{
                    System.out.println("-----------------------------------\nСтек имеет вид:");
                    stack.show();
                }
                case 7-> stack.pop();
                default -> System.out.println("Неверный индекс");
            }
        }

    }
}
