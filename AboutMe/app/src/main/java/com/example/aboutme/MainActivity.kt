package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.doneBtn.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view :View){
        binding.apply {
            nickNameText.text=nickNameEditText.text
            invalidateAll()
            nickNameEditText.visibility=View.GONE
            nickNameText.visibility=View.VISIBLE
            doneBtn.visibility=View.GONE
        }

        //Hide keyboard
        val hideKeyboard=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboard.hideSoftInputFromWindow(view.windowToken,0)
    }
}
