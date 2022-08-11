package com.example.dndwiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.dndwiki.databinding.ActivityMainBinding
import com.example.dndwiki.diceRoller.DiceRollerFragment
import com.example.dndwiki.spellFinder.SpellFinderFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Thread.sleep


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        bottomNav = binding.bottomNav

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dice_roller_item -> {
                    loadFragment(DiceRollerFragment())
                    true
                }
                R.id.spell_finder_item -> {
                    loadFragment(SpellFinderFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
            sleep(100)
            commit()
        }
    }
}