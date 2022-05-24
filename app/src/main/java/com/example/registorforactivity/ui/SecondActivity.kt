package com.example.registorforactivity.ui


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registorforactivity.databinding.ActivitySecondBinding

/*Дз: На первой активити добавить EditText + Button, при вводе если значения в editText пустое и
 вы нажали на button, то отобразить Toast, что EditText не может быть пустым, иначе Перейти на
 вторую активити и отобразить значение в EditText, также добавить Button, если EditText не пуст,
то вернуться на 1 активити и отобразить текст из 2 активити.(использовать registerForActivity)*/

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var textUser: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getEditText()
        initListener()
    }

    private fun initListener() {
        binding.btnSend.setOnClickListener {
            if (binding.etText.text?.isEmpty() == true) {
                Toast.makeText(this, "Едит текст не может быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                textUser = binding.etText.text.toString()
                setResult(RESULT_OK, intent.putExtra(MainActivity.KEY_FOR_LAUNCH, textUser))
                finish()
            }
        }
    }

    private fun getEditText() {
        textUser = intent.getStringExtra(MainActivity.KEY_FOR_LAUNCH)
        binding.etText.setText(textUser)
    }
}