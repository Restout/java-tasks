package ru.mail.polis.homework.simple;

import java.util.function.ToDoubleFunction;

public class HomeworkTask {

    /**
     * Нужно численно посчитать интеграл от a до b с шагом delta от функции function
     * Для того, что бы получить значение по Y для точки X, надо просто написать function.applyAsDouble(t)
     * Считаем, что функция определена на всем пространстве от a до b
     */
    public static double calcIntegral(double a, double b, ToDoubleFunction<Double> function, double delta) {
//Используем формулу трапеции
        int steps = (int) (Math.abs(a - b) / delta);
        double integralValue = 0.0;
        for (int i = 1; i < steps; i++) {
            integralValue += function.applyAsDouble(a + delta * i);
        }
        integralValue += (function.applyAsDouble(a)) + function.applyAsDouble(a + delta * steps) / 2;
        integralValue *= (b - a) / steps;

        return integralValue;

    }

    /**
     * Вывести номер максимальной цифры. Счет начинается слева направо,
     * выводим номер первой максимальной цифры (если их несколько)
     */
    public static byte maxNumber(long a) {
        byte counter = 1;
        byte maxCounter = 0;
        byte max = Byte.MIN_VALUE;
        if (a == 0) {
            return counter;
        }
        while (a != 0) {
            double curentNumber = Math.abs(a % 10);
            if (max <= (byte) curentNumber) {
                max = (byte) curentNumber;
                maxCounter = counter;
            }
            counter++;
            a /= 10;
        }

        return (byte) (counter - maxCounter);
    }


    /**
     * Даны две точки в пространстве (x1, y1) и (x2, y2). Вам нужно найти Y координату третьей точки (x3, y3),
     * которая находится на той же прямой что и первые две.
     */
    public static double lineFunction(int x1, int y1, int x2, int y2, int x3) {
        double result;
        result = ((double) x3 - x1) * (y2 - y1) / (x2 - x1) + y1;
        return result;
    }

    /**
     * Даны 4 точки в пространстве A(x1, y1), B(x2, y2), C(x3, y3), D(x4, y4). Найдите площадь выпуклого
     * четырехуголька ABCD.
     */
    public static double square(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double result;
        result = Math.abs(((double) (x1 - x2) * (y1 + y2) + (x2 - x3) * (y2 + y3) + (x3 - x4) * (y3 + y4) + (x4 - x1) * (y4 + y1))) / 2;
        return result;
    }

}
