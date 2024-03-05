package com.example.practical2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.button_click)
        val name_value = findViewById<EditText>(R.id.name_value)
        val inputbyUser = findViewById<TextView>(R.id.gender)

        submitButton.setOnClickListener {
            var user_Input = name_value.text
            inputbyUser.setText(user_Input)
        }

        /*val Name = findViewById<EditText>(R.id.name)*/
        // val submitButton2 = findViewById<Button>(R.id.button)
        val dispMessage = findViewById<TextView>(R.id.textViewResponse)
        val radioGroup = findViewById<RadioGroup>(R.id.selectgender)
        val radioB1 = findViewById<RadioButton>(R.id.radioButton1)
        val radioB2 = findViewById<RadioButton>(R.id.radioButton2)
        val CheckB1 = findViewById<CheckBox>(R.id.checkBox1)
        val CheckB2 = findViewById<CheckBox>(R.id.checkBox2)
        val CodingLang = findViewById<TextView>(R.id.language)
        val Universityyear = findViewById<Spinner>(R.id.spinner)
        val myclass = findViewById<TextView>(R.id.myclass)
        val year = arrayOf("FYCS", "SYCS", "TYCS") // Dropdown list items for Spinner


        val arrayAdp = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            year
        )  //Simple dropdown layout selected for the spinner list
        Universityyear.adapter = arrayAdp
        Universityyear.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                myclass.text = "Your Class: " + year[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                myclass.text = "Please select Your Class"
            }
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButton1)
                dispMessage.text = "Gender: " + radioB1.text

            if (checkedId == R.id.radioButton2)
                dispMessage.setText("Gender: " + radioB2.text)
        }
        /*submitButton.setOnClickListener {
            dispMessage.setText("Welcome "+ name.text)

            //Putting all checkbox conditions
            if(CheckB1.isChecked && CheckB2.isChecked) {
                CodingLang.text= "You love both languages"
            }
            else if(CheckB1.isChecked) {
                CodingLang.text= "You love Python"
            }
            else if(CheckB2.isChecked) {
                CodingLang.text= "You love Kotlin"
            }
            else {
                CodingLang.text= "You don't like these languages" }
        }*/
    }

    override fun onResume() {
        super.onResume()
    }

}