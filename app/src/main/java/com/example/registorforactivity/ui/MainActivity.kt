package com.example.registorforactivity.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.registorforactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launcherC()
        initListener()
    }

    private fun launcherC() {
        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val textUser = it.data?.getStringExtra(KEY_FOR_LAUNCH)
                    binding.etText.setText(textUser)
                }
            }
    }

    private fun initListener() {
        binding.btnSend.setOnClickListener {
            if (binding.etText.text?.isEmpty() == true) {
                Toast.makeText(this, "Едит текст не может быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                val txt = binding.etText.text.toString()
                intent.putExtra(KEY_FOR_LAUNCH, txt)
                setResult(RESULT_OK, intent.putExtra(KEY_FOR_LAUNCH, txt))
                activityResultLauncher.launch(intent)
            }
        }
    }

    companion object {
        const val KEY_FOR_LAUNCH = "key1"
    }
}