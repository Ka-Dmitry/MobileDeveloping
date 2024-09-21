package com.example.mobiledeveloping

import kotlin.math.sqrt

fun main() {

    //println(task1(null))
    // Будет выведено: null

    //task1(1)
    //  Будет выведено: 1

    /*println(getFullName(null, null))
    println(getFullName(null, "Фамилия"))
    println(getFullName("Имя", null))
    println(getFullName("Имя", "Фамилия"))*/

    /*println(calculateSquareRoot(4.5))
    println(calculateSquareRoot(null))*/

    println(getStringLength(null))
    println(getStringLength(123))
    println(getStringLength("String"))
}

// Задание 1
fun task1(newInt: Int?) : Int? {
    var nullTry: Int? = null

    if (newInt != null){
        nullTry = newInt // Следующим шагом присвойте переменной любое значение, отличное от null
        var text: String = nullTry.toString() // Следующей строкой создайте переменную text типа String, и попробуйте присвоить ей свою переменную, вызвав у нее функцию toString()
        // Не забудьте использовать безопасный вызов? 'nullTry?.toString() -> Type mismatch. Required: String. Found: String?'
        println(text) // Далее выведите text в консоль
        //  Будет выведено: 1

        /*
        var text: String? = nullTry?.toString()
        println(text)
        Также будет выведено: 1
         */
    }

    return nullTry
}

//Задание 2
fun getFullName(firstName: String?, lastName: String?) : String {
    return "${firstName ?: "Unknown"} ${lastName ?: "Unknown"}"
}

// Задание 3
fun calculateSquareRoot(num: Double?) : Double {
    num ?: throw Exception("Тип null не может быть возведен в квадрат")
    return num*num
}

// Задание 4
fun getStringLength(smth: Any?) : Int{
    val anotherSmth = smth as? String
    anotherSmth ?: return -1
    return anotherSmth.length
}