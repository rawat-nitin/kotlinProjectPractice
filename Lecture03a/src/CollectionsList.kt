fun main() {
    val numbers1 = listOf("one", "two", "three", "four")
    println("Number of elements: ${numbers1.size}")
    println("Third element: ${numbers1.get(2)}")
    println("Fourth element: ${numbers1[3]}")
    println("Index of element \"two\" ${numbers1.indexOf("two")}")
//    numbers.add() // cannot add elements, the list is immutable
    println()

    val numbers2 = mutableListOf(1, 2, 3, 4)
    println(numbers2)
    numbers2.add(5)
    println(numbers2)
    numbers2.removeAt(1)
    println(numbers2)
    numbers2[0] = 0
    println(numbers2)
    // https://kotlinlang.org/docs/collections-overview.html#list
}