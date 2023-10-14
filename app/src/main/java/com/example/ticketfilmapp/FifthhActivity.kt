package com.example.ticketfilmapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.ticketfilmapp.databinding.ActivityFifthhBinding
import java.util.Calendar

class FifthhActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthhBinding
    companion object{
        const val EXTRA_PLACE = "extra_place"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_TIME = "extra_time"
        const val EXTRA_JUMLAHKURSI = "extra_jumlahkursi"
        const val EXTRA_JENISKURSI = "extra_jeniskursi"
        const val EXTRA_METODEPEMBAYARAN = "extre_metodepembayaran"
        const val EXTRA_PILIHANPEMBAYARAN = "extra_pilihanpembayaran"
        const val EXTRA_TOTALBAYAR = "extra_totalbayar"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ListBioskop = resources.getStringArray(R.array.bioskop)
        val ListKursi = resources.getStringArray(R.array.kursi)
        val MetodeBayar = resources.getStringArray(R.array.metode_bayar)
        val ListBank = resources.getStringArray(R.array.Bank)
        val ListWallet = resources.getStringArray(R.array.E_wallet)

        with(binding) {
            var num = 0
            val BioskopAdaptor = ArrayAdapter(
                this@FifthhActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                ListBioskop
            )
            val KursiAdaptor = ArrayAdapter(
                this@FifthhActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                ListKursi
            )
            val BayarAdaptor = ArrayAdapter(
                this@FifthhActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                MetodeBayar
            )

            BioskopAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            pilihanBioskop.adapter = BioskopAdaptor
            KursiAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            pilihanSeat.adapter = KursiAdaptor
            BayarAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            methodePembayaran.adapter = BayarAdaptor

            buttonTgl.setOnClickListener {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(
                    this@FifthhActivity,
                    DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                        mdy.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
                    }, year, month, day
                )
                dpd.show()
            }

            buttonTime.setOnClickListener {
                val c = Calendar.getInstance()
                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minute = c.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(
                    this@FifthhActivity,
                    TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                        time.text = String.format("%02d:%02d", selectedHour, selectedMinute)
                    }, hour, minute,
                    false
                )
                timePickerDialog.show()
            }

            buttonPlus.setOnClickListener {
                num++
                jumlahKursiReal.text = num.toString()
                jumlahKursiReal2.text = num.toString()
            }
            buttonMinus.setOnClickListener {
                num--
                if (num < 0) num = 0
                jumlahKursiReal.text = num.toString()
                jumlahKursiReal2.text = num.toString()
            }
            val pilihanSeatSpinner = binding.pilihanSeat
            val hargaKursiTextView = binding.hargaKursi
            val totalHargaTextView = binding.totalHarga

            pilihanSeatSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selectedSeat = ListKursi[position]
                        val harga: Int = when (selectedSeat) {
                            "Reguler" -> 35000
                            "Dobly Atmos" -> 50000
                            "Imax" -> 75000
                            "The Premiere" -> 120000
                            else -> 0
                        }
                        val hargaString = String.format("Rp%,d", harga)
                        hargaKursiTextView.text = hargaString
                        val harga_total = harga * num
                        val hargaTotalString = String.format("Rp%,d", harga_total)
                        totalHargaTextView.text = hargaTotalString

                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                    }
                }
            val pilihanMethodSpinner = binding.methodePembayaran

            pilihanMethodSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selectedMethod = MetodeBayar[position]
                        if (selectedMethod == "Transfer Bank") {
                            val BankAdaptor = ArrayAdapter(
                                this@FifthhActivity,
                                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                                ListBank
                            )
                            BankAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            bankPilihan.adapter = BankAdaptor
                        } else {
                            val WalletAdaptor = ArrayAdapter(
                                this@FifthhActivity,
                                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                                ListWallet
                            )
                            WalletAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            bankPilihan.adapter = WalletAdaptor
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                    }
                }
            btnOrderSummary.setOnClickListener {
                val intentToFifthActivity = Intent(this@FifthhActivity, LastActivity::class.java)
                intentToFifthActivity.putExtra(
                    FifthhActivity.EXTRA_PLACE,
                    pilihanBioskop.selectedItem.toString()
                )
                intentToFifthActivity.putExtra(FifthhActivity.EXTRA_DATE, mdy.text.toString())
                intentToFifthActivity.putExtra(FifthhActivity.EXTRA_TIME, time.text.toString())
                intentToFifthActivity.putExtra(
                    FifthhActivity.EXTRA_JUMLAHKURSI,
                    jumlahKursiReal.text.toString()
                )
                intentToFifthActivity.putExtra(
                    FifthhActivity.EXTRA_JENISKURSI,
                    pilihanSeat.selectedItem.toString()
                )
                intentToFifthActivity.putExtra(
                    FifthhActivity.EXTRA_METODEPEMBAYARAN,
                    methodePembayaran.selectedItem.toString()
                )
                intentToFifthActivity.putExtra(
                    FifthhActivity.EXTRA_PILIHANPEMBAYARAN,
                    bankPilihan.selectedItem.toString()
                )
                intentToFifthActivity.putExtra(
                    FifthhActivity.EXTRA_TOTALBAYAR,
                    totalHarga.text.toString()
                )
                startActivity(intentToFifthActivity)
            }
            buttonBack.setOnClickListener {
                val intentToThirdActivity = Intent(this@FifthhActivity, FourthActivity::class.java)
                startActivity(intentToThirdActivity)
            }

        }
    }
}