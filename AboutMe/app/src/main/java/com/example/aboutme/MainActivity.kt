package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        done_btn.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view :View){
        val nicknameEditText:EditText=findViewById(R.id.enter_nick_name)
        val nicknameText:TextView=findViewById(R.id.nick_name)
        nicknameText.text=nicknameEditText.text
        nicknameEditText.visibility=View.GONE
        nicknameText.visibility=View.VISIBLE
        done_btn.visibility=View.GONE

        //Hide keyboard
        val hideKeyboard=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboard.hideSoftInputFromWindow(view.windowToken,0)
    }
}
