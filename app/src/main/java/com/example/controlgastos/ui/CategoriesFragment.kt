package com.example.controlgastos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.controlgastos.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        val fab: FloatingActionButton = view.findViewById(R.id.fab_add)
        fab.setOnClickListener {
            Toast.makeText(requireContext(), "Agregar Categoría", Toast.LENGTH_SHORT).show()
        }
        
        return view
    }
}
