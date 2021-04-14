package com.tech.actvtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ArrayAdapter-to present the String type  of data.

        //CustomAdapter
        //cursorAdapter

        var values=resources.getStringArray(R.array.states)

        var myAdapter=ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,values)
        actv.threshold=1
        actv.setAdapter(myAdapter)

        actv.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"${values[position]}",Toast.LENGTH_LONG).show()
        }

        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

              Toast.makeText(this@MainActivity,"${values[position]}",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        list_view.adapter=myAdapter// to set the list of states to listview
        list_view.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"${values[position]}",Toast.LENGTH_LONG).show()
        }

    }
}