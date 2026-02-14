package com.example.controlgastos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.controlgastos.R

class ReportsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reports, container, false)
        
        val btnPdf: Button = view.findViewById(R.id.btn_generate_pdf)
        val btnExcel: Button = view.findViewById(R.id.btn_generate_excel)
        
        btnPdf.setOnClickListener {
            Toast.makeText(requireContext(), "Generar PDF", Toast.LENGTH_SHORT).show()
        }
        
        btnExcel.setOnClickListener {
            Toast.makeText(requireContext(), "Generar Excel", Toast.LENGTH_SHORT).show()
        }
        
        return view
    }
}
