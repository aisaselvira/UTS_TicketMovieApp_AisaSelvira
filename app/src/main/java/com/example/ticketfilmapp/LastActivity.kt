package com.example.ticketfilmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ticketfilmapp.databinding.ActivityLastBinding
import java.text.SimpleDateFormat
import java.util.Locale

class LastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val place=intent.getStringExtra(FifthhActivity.EXTRA_PLACE)
        val date=intent.getStringExtra(FifthhActivity.EXTRA_DATE)
        val time=intent.getStringExtra(FifthhActivity.EXTRA_TIME)
        val countseat=intent.getStringExtra(FifthhActivity.EXTRA_JUMLAHKURSI)
        val typeseat=intent.getStringExtra(FifthhActivity.EXTRA_JENISKURSI)
        val metodebayar=intent.getStringExtra(FifthhActivity.EXTRA_METODEPEMBAYARAN)
        val pilihpembayaran = intent.getStringExtra(FifthhActivity.EXTRA_PILIHANPEMBAYARAN)
        val totalamount = intent.getStringExtra(FifthhActivity.EXTRA_TOTALBAYAR)

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateObj = sdf.parse(date)
        val formattedDate = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(dateObj)

        with(binding){
            MoviePlace.text = place
            MovieDate.text = formattedDate
            MovieTime.text = time
            jenisKursi.text = typeseat
            TicketPaymentMethod.text = metodebayar
            TicketCaraBayar.text = pilihpembayaran
            TicketTotalAmount.text = totalamount

            buttonBack.setOnClickListener{
                val intentToFourthActivity = Intent (this@LastActivity, FifthhActivity::class.java)
                startActivity(intentToFourthActivity)
            }
        }
    }


}