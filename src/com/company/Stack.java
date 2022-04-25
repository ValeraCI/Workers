package com.company;

import java.util.ArrayDeque;

public class Stack {
    private ArrayDeque<Worker> values = new ArrayDeque<>(); //создаём двусвязаный список, на основе которого будет работать стек

    public void push(Worker worker){
        values.push(worker); //элемент добавляется в начало очереди
    }

    public void pop(){
        if(values.isEmpty()){ //проверка на то, не пуст ли список
            System.out.println("Стек пустой");
            return;
        }
        values.pop();  // удаление первого элемента из списка
    }

    public boolean contains(Worker worker){ //проверка содержания элемента в стеке
        for(Worker w: values){
            if(w.equals(worker)) return true;
        }
        return false;
    }

    public void show(){  //выводим все элементы начиная с первого
        for(Worker w: values){
            System.out.println(w);
            System.out.println();
        }
    }
}
