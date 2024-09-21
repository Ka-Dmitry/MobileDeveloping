package com.example.mobiledeveloping

import android.nfc.NfcAdapter.OnTagRemovedListener
import androidx.compose.animation.core.animateRectAsState

fun main() {
    /*println(task1(5))
    println(task1(6))*/

    /*println(task2(5))
    println(task2(6))*/

    //task3()

    //task4()
}

// Задание 1.
/*
2.	Написать функцию. Входящий параметр (number) – целочисленная переменная.
Действие функции – если number четное, вернуть number/2, иначе вернуть удвоенное число number.
*/
fun task1(number: Int) : Int{
    if (number % 2 == 0) {
        return number / 2
    }
    else {
        return number * 2
    }
}

// Задание 2.
/*
2.	Написать лямбда-выражение. Входящий параметр Int. Выходящий Boolean.
Действие лямбды – если входящий параметр четный, вернуть true, иначе вернуть false.
*/
val task2 = {
    param: Int ->
    if (param % 2 == 0)
        true
    else
        false
}

// Задание 3.
fun array_output(array: Array<Int>){
    for (n in 0..array.size - 1)
        print("${array[n]} ")
    println()
}

fun array_create(N: Int) : Array<Int>{
    var array = Array(N, {0})
    for (i in 0..N - 1)
        array[i] = (-100..500).random()
    return array
}

fun task3(){
    print("Введите количество элементов в массиве: ")
    val n = readln().toInt()

    val array = array_create(n)
    //print("Исходный массив: ${array_output(array)}")
    print("Исходный массив: ")
    array_output(array)

    val arrayTask1 = array.map(::task1)
    //print("Массив arrayTask1: ${array_output(arrayTask1)}")
    print("Массив arrayTask1: ")
    array_output(arrayTask1.toTypedArray())

    val arrayTask2 = array.filter(task2)
    //print("Массив arrayTask2: ${array_output(arrayTask2)}")
    print("Массив arrayTask2: ")
    array_output(arrayTask2.toTypedArray())

    //print("Отфильтрованный и преобразованный массив: ${array_output(arrayTask3)}")
    print("Отфильтрованный и преобразованный массив: ")
    array_output((array.filter(task2)).map(::task1).toTypedArray())

}

// Задание 4.
fun task4(){
    val array = array_create(10)

    print("Исходный массив: ")
    array_output(array)

    print("Отфильтрованный и преобразованный массив: ")
    array_output(array.filterAndMap(task2, ::task1))
}

fun Array<Int>.filterAndMap(filterFunc: (input: Int) -> Boolean, mapFunc: (input: Int) -> Int) : Array<Int>{
    return this.filter(filterFunc).map(mapFunc).toTypedArray()
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Задание 5.
/*
Например: «Тип данных для функции, принимающий Int, и ничего не возвращающий» это будет (Int) -> Unit.

1.	«Тип данных для функции, принимающий две Int, одну String переменные, и ничего не возвращающей.»
Это будет: (Int, Int, String) -> Unit

2.	«Тип данных для функции, не принимающей параметры, и возвращающей строку.»
Это будет: () -> String

3.	«Тип данных для функции, принимающей другую функцию (она ничего не принимает и ничего не возвращает), и ничего не возвращающей.»
Это будет: (fun: () -> Unit) -> Unit
*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////