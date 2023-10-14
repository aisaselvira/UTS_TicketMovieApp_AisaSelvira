package com.example.ticketfilmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ticketfilmapp.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnBuyTicket.setOnClickListener {
                val intentToFifth = Intent(this@FourthActivity, FifthhActivity::class.java)
                startActivity(intentToFifth)
            }

            buttonBack.setOnClickListener {
                val intentToThird = Intent(this@FourthActivity, ThirdActivity::class.java)
                startActivity(intentToThird)
            }
        }
    }
}
