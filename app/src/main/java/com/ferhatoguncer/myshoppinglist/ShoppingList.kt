package com.ferhatoguncer.myshoppinglist

class ShoppingList {
    private val items = mutableListOf<Item>()

    fun addItem(item: Item) {
        items.add(item)
    }

    fun displayItems() {
        var count = 1
        items.forEach { item ->
            var extraInfo = ""
            when (item) {
                is Food -> extraInfo = ", Weight: ${item.weight}"
                is Cloth -> extraInfo = ", Type: ${item.type}"
            }
            println(" $count.Item name: ${item.name}, Price: ${item.price}$extraInfo")
            count++
        }

        if (items.isEmpty()) {
            println("The list is empty.")
        }
    }

    fun deleteItem(index: Int) {
        if (index > 0 && index <= items.size) {
            items.removeAt(index - 1)
            println("The item is deleted.")
        } else {
            println("Incorrect index.")
        }
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }
}