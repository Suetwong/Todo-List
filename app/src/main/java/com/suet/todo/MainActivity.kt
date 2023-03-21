package com.suet.todo
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckedTextView
import androidx.appcompat.app.AppCompatActivity
import com.suet.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    AdapterView.OnItemClickListener, View.OnClickListener{
    lateinit var binding: ActivityMainBinding
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // using binding to connect to xml id
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding the todo list view in this code
        val todoList= binding.todoListview
        // an array adapter with multiple choices
        arrayAdapter = ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice)
        todoList.adapter= arrayAdapter

        // adding the "+" to add new task
        binding.addItemButton.setOnClickListener(this)
        todoList.onItemClickListener=this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.i("View: ", view.toString())
        // once the check box is check, toggle the check box
        if(view is CheckedTextView){
            val checkbox: CheckedTextView = view
            checkbox.toggle()
        }
    }

    override fun onClick(p0: View?) {
        Log.i("onClick", "A button was pressed")
        // add the new item to the array adapter
        arrayAdapter.add(binding.newItemEt.text.toString())
        // clear the text view once added new task
        binding.newItemEt.text.clear()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //TODO("Not yet implemented")
    }
}