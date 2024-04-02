package com.ferhatoguncer.myshoppinglist

fun readDouble(prompt: String): Double {
    while (true) {
        print(prompt)
        val input = readlnOrNull()
        val number = input?.toDoubleOrNull()
        if (number != null) {
            return number
        } else {
            println("Please enter a correct value! ")
        }
    }
}

fun addItemToShoppingList(shoppingList: ShoppingList) {

    while (true) {
        print("Enter the item type you want to add (1: Food, 2: Cloth): ")
        val type = readln()

        if (type == "1") {
            print("Enter the food name you want to add: ")
            val name = readln()
            val price = readDouble("Enter the food price you want to add: ")
            val weight = readDouble("Enter the foot weight you want to add: ").toString()
            shoppingList.addItem(Food(name, price, weight))
            break

        } else if (type == "2") {
            print("Enter the cloth name you want to add: ")
            val name = readln()
            val price = readDouble("Enter the cloth price you want to add: ")
            print("Enter the cloth type you want to add: ")
            val clothType = readln()
            shoppingList.addItem(Cloth(name, price, clothType))
            break
        }
        else {
            print("Incorrect item choice, try again.")
        }
    }
}

fun main() {
    val shoppingList = ShoppingList()
    while (true) {
        println("\n--- Shopping List Menu ---")
        println("1. Add item")
        println("2. Display items")
        println("3. Delete item")
        println("4. Exit")
        print("Make your choice (1,2,3,4): ")
        when (readln()) {
            "1" -> addItemToShoppingList(shoppingList)
            "2" -> shoppingList.displayItems()
            "3" -> {
                if (shoppingList.isEmpty()) {
                    println("The list is empty, there is no item to delete.")
                } else {
                    print("Please enter a number of item that you want to delete: ")
                    val index = readln().toIntOrNull() ?: 0
                    shoppingList.deleteItem(index)
                }
            }
            "4" -> return
            else -> println("Incorrect choice, please try again.")
        }
    }
}