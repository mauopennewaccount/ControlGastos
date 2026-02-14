package com.example.controlgastos

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.controlgastos.ui.category.CategoryFragment
import com.example.controlgastos.ui.expense.ExpenseFragment
import com.example.controlgastos.ui.income.IncomeFragment
import com.example.controlgastos.ui.period.PeriodFragment
import com.example.controlgastos.ui.reports.ReportsFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: MaterialToolbar
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setupToolbar()
        setupDrawer()
        
        if (savedInstanceState == null) {
            loadFragment(DashboardFragment())
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }
    
    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
    
    private fun setupDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.nav_home,
            R.string.nav_home
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
    
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> loadFragment(DashboardFragment())
            R.id.nav_income -> loadFragment(IncomeFragment())
            R.id.nav_expenses -> loadFragment(ExpenseFragment())
            R.id.nav_categories -> loadFragment(CategoryFragment())
            R.id.nav_periods -> loadFragment(PeriodFragment())
            R.id.nav_reports -> loadFragment(ReportsFragment())
        }
        
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
    
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
