package com.example.dndwiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dndwiki.databinding.ActivityMainBinding
import com.example.dndwiki.diModule.DnDModule
import com.example.dndwiki.diModule.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupNavigation()
    }

    override fun onSupportNavigateUp() =
        navigateUp(findNavController(R.id.nav_host_fragment), binding.drawerLayout)

    private fun setupNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)

        setupActionBarWithNavController(navController, binding.drawerLayout)

        binding.navigationView.setupWithNavController(navController)
    }
}