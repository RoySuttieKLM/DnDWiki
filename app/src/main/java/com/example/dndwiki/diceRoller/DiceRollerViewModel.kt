package com.example.dndwiki.diceRoller

import androidx.lifecycle.ViewModel

class DiceRollerViewModel : ViewModel() {

    fun rollD20(): String {
        return roll(20).toString()
    }

    fun rollD100(): String {
        val roll = (10 * roll(10))
        return if (roll == 100) {
            "00"
        } else {
            roll.toString()
        }
    }

    fun rollD10(): String {
        return roll(10).toString()
    }

    fun rollD8(): String {
        return roll(8).toString()
    }

    fun rollD6(): String {
        return roll(6).toString()
    }

    fun rollD12(): String {
        return roll(12).toString()
    }

    fun rollD4(): String {
        return roll(4).toString()
    }

    private fun roll(size: Int): Int {
        return (1..size).random()
    }

}