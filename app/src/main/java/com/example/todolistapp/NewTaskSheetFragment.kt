package com.example.todolistapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.todolistapp.databinding.ActivityMainBinding
import com.example.todolistapp.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NewTaskSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var taskViewModel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)
        binding.btnAddTask.setOnClickListener {
            saveTask()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTaskSheetBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun saveTask() {
        taskViewModel.name.value = binding.etTaskNameInput.text.toString()
        taskViewModel.description.value = binding.etTaskDescriptionInput.text.toString()
        binding.etTaskNameInput.setText("")
        binding.etTaskDescriptionInput.setText("")
        dismiss()
    }

}