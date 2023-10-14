package com.example.ticketfilmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ticketfilmapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    private val usernameMasuk = "Aisa"
    private val passwordMasuk = "492559"

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            loginBtn.setOnClickListener {
                val Username2 = username.text.toString()
                val Password2 = pass.text.toString()

                if (Username2 == usernameMasuk && Password2 == passwordMasuk) {
                    val intentThird = Intent(this@SecondActivity, ThirdActivity::class.java)
                    intentThird.putExtra(SecondActivity.EXTRA_USERNAME, Username2)
                    startActivity(intentThird)
                    Toast.makeText(this@SecondActivity, "Login Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SecondActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
