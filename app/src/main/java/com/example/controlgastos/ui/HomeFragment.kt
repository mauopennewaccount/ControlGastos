package com.example.controlgastos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.controlgastos.R

class HomeFragment : Fragment() {
    
    private lateinit var textTotalIncome: TextView
    private lateinit var textTotalExpenses: TextView
    private lateinit var textBalance: TextView
    private lateinit var textCurrentPeriod: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        
        textTotalIncome = view.findViewById(R.id.text_total_income)
        textTotalExpenses = view.findViewById(R.id.text_total_expenses)
        textBalance = view.findViewById(R.id.text_balance)
        textCurrentPeriod = view.findViewById(R.id.text_current_period)
        
        // TODO: Load actual data from database
        updateSummary()
        
        return view
    }
    
    private fun updateSummary() {
        // Placeholder data
        val totalIncome = 0.0
        val totalExpenses = 0.0
        val balance = totalIncome - totalExpenses
        
        textTotalIncome.text = String.format("$%.2f", totalIncome)
        textTotalExpenses.text = String.format("$%.2f", totalExpenses)
        textBalance.text = String.format("$%.2f", balance)
    }
}
