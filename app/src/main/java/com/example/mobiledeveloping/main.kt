package com.example.mobiledeveloping

import kotlin.random.Random

fun main(){
    main0()
}

fun main0() {
    println("hello")
}

// Задание 1. 6.	Пользователь вводит сторону квадрата. Найдите периметр и площадь квадрата.
fun main1() {
    print("Сторона квадрата = ")
    val side = readln().toInt()

    println("Периметр квадрата = ${side * 4}")
    println("Площадь квадрата = ${side * side}")
}

// Задание 2. 6.	Пользователь вводит три числа. Если все числа больше 10 и первые два числа делятся на 3, то вывести yes, иначе no

// if
fun main2_1() {
    print("Число 1 = ")
    val num1 = readln().toInt()
    print("Число 2 = ")
    val num2 = readln().toInt()
    print("Число 3 = ")
    val num3 = readln().toInt()

    if ((num1 > 10 && num2 > 10 && num3 > 10) && (num1 % 3 == 0 && num2 % 3 == 0))
        println("yes")
    else
        println("no")
}

// when
fun main2_2() {
    print("Число 1 = ")
    val num1 = readln().toInt()
    print("Число 2 = ")
    val num2 = readln().toInt()
    print("Число 3 = ")
    val num3 = readln().toInt()

    when{
        (num1 > 10 && num2 > 10 && num3 > 10) && (num1 % 3 == 0 && num2 % 3 == 0) -> println("yes")
        else -> println("no")
    }
}

/* Задание 3
 6.	Вывести на экран:
AAABBBAAABBBAAABBB
BBBAAABBBAAABBBAAA
AAABBBAAABBBAAABBB
(таких строк n, в каждой строке m троек AAA) */

fun main3() {
    print("Сколько строк? ")
    val n = readln().toInt()

    print("Сколько троек ААА в строке? ")
    val m = readln().toInt()
    var string: String

    for (i in 0..n - 1){
        if (i % 2 == 0)
            string = "AAABBB"
        else
            string = "BBBAAA"

        for (j in 0..m - 1) {
            print(string)
        }

        println()
    }
    println()
}

// Задание 4. 6.	Задана квадратная матрица целых чисел.
// Подсчитайте количество отрицательных и положительных элементов, а также выведите на печать координаты нулевых элементов (номер строки и номер столбца).

fun main4() {
    val matrix = Array<Array<Int>>(5) {Array<Int>(5, {Random.nextInt(-99, 100)}) }

    // Полный вывод матрицы
    for (i in 0..matrix.size - 1){
        for (j in 0..matrix[1].size - 1){
            print("${matrix[i][j]} ")
        }
        println()
    }

    // Подсчет +/- элементов
    var positive = 0
    var negative = 0

    for (i in 0..matrix.size - 1){
        for (j in 0..matrix[1].size - 1){
            if (matrix[i][j] < 0)
                negative++
            else if (matrix[i][j] > 0)
                positive++
        }
    }

    println("Положительных элементов: $positive")
    println("Отрицательных элементов: $negative")

    // Вывод "нулевых" элементов?
    for (i in 0..matrix.size - 1){
        print("${matrix[i][0]} ")
    }
    println()
    for (j in 0..matrix[1].size - 1){
        print("${matrix[0][j]} ")
    }
}

/*
Задание 5. ООП
	Реализовать иерархию классов, описывающую двухмерные фигуры.
	Базовый класс должен быть абстрактным, содержать хотя бы два свойства, и хотя бы одну функцию, которую будут наследовать дочерние классы.
	Приветствуется использование модификаторов доступа.
	Остальное на ваше усмотрение. Задание творческое. Списывание не приветствуется и будет замечено моментально
*/

abstract class Shapes(var type: String, var sides: Int){

    fun about(){
        println("I have $sides sides, because im a $type")
    }

}

class Square(var name: String):Shapes("square", 4)
class Circle(var name: String):Shapes("circle", 0)
class Triangle(var name: String):Shapes("triangle", 3)

fun main5(){
    val sq: Square = Square("Qwerty")
    val cir: Circle = Circle("Sun")
    val tri: Triangle = Triangle("Pyr")

    sq.about()
    cir.about()
    tri.about()
}
