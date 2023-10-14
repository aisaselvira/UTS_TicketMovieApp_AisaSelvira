package com.example.ticketfilmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ticketfilmapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernamee = intent.getStringExtra(SecondActivity.EXTRA_USERNAME)

        with(binding) {
            getUsernameee.text = usernamee

            film1.setOnClickListener {
                val intentToFourth = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToFourth)
            }

            film2.setOnClickListener {
                val intentToFourth = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToFourth)
            }

            film3.setOnClickListener {
                val intentToFourth = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToFourth)
            }

            film4.setOnClickListener {
                val intentToFourth = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToFourth)
            }

            film5.setOnClickListener {
                val intentToFourth = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToFourth)
            }

            film6.setOnClickListener {
                val intentToFourth = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToFourth)
            }

            film7.setOnClickListener {
                val intentToFourth = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToFourth)
            }

            film8.setOnClickListener {
                val intentToFourth = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToFourth)
            }

            buttonBack.setOnClickListener {
                val intentToSecond = Intent(this@ThirdActivity, FourthActivity::class.java) // Ganti ke SecondActivity
                startActivity(intentToSecond)
            }
        }
    }
}
