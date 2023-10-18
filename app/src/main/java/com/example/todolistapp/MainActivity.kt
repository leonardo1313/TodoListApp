package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        binding.fabAddTask.setOnClickListener {
            NewTaskSheetFragment().show(supportFragmentManager, "newTaskTag")
        }

        taskViewModel.name.observe(this) {
            binding.tvTaskName.text = String.format("Task name: %s", it)
        }

        taskViewModel.description.observe(this) {
            binding.tvTaskDescription.text = String.format("Task description: %s", it)
        }
    }
}