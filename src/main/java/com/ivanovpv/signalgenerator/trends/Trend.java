package com.ivanovpv.signalgenerator.trends;

import java.util.Random;

public abstract class Trend { //вся работа трендов похожа на работу итератора
    protected static int length = 100; //длина тренда
    protected static int currentLine = 0; //текущая позиция
    protected static Random random = new Random(); //для генерации случайных чисел
    protected double currentValue; //текущее значение параметра
    public static void nextLine() { //перевод на следующую линию
        currentLine++;
    }
    public static void setCurrentLine(int curLine) { //задание текущей линии
        currentLine = curLine;
    }
    public static void setLength(int trendLength) { //задание длины
        length = trendLength;
    }
    public static int getLength() { //получение длины
        return length;
    }
    public abstract double getNextValue(); //получить следующее значение, метод абстрактный, т.к. у разных трендов сделан по-разному
}
