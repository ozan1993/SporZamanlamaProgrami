package com.sirius.roundtime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.NumberPicker
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {


    lateinit var number_picker_minute: NumberPicker
    lateinit var number_picker_second: NumberPicker

    lateinit var number_picker_dinlenme_minute: NumberPicker
    lateinit var number_picker_dinlenme_second: NumberPicker

    lateinit var number_picker_round: NumberPicker

    lateinit var basla_btn: Button


    private var resumeFromMillis: Long = 0

    var total_zaman_dinlenme: Long = 0
    var total_zaman_calisma: Long = 0
    private var dak_calisma: Long = 0
    private var dakika_calisma: Long = 0
    private var saniye_calisma: Long = 0
    var round_sayisi: Long = 1

    private var dak_dinlenme: Long = 0
    private var dakika_dinlenme: Long = 0
    private var saniye_dinlenme: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        number_picker_minute = findViewById(R.id.number_picker_minute)
        number_picker_second = findViewById(R.id.number_picker_second)
        number_picker_dinlenme_minute = findViewById(R.id.number_picker_dinlenme_minute)
        number_picker_dinlenme_second = findViewById(R.id.number_picker_dinlenme_second)
        number_picker_round = findViewById(R.id.number_picker_round)
        basla_btn = findViewById(R.id.basla_btn)


        number_picker_minute.minValue = 0
        number_picker_minute.maxValue = 59

        number_picker_second.minValue = 0
        number_picker_second.maxValue = 59


        number_picker_dinlenme_minute.minValue = 0
        number_picker_dinlenme_minute.maxValue = 59

        number_picker_dinlenme_second.minValue = 0
        number_picker_dinlenme_second.maxValue = 59


        number_picker_round.minValue = 1
        number_picker_round.maxValue = 5



        number_picker_minute.setOnValueChangedListener { picker, oldVal, newValmin ->
            dak_calisma = newValmin.toInt().toLong()
            dakika_calisma = dak_calisma * 60
        }

        number_picker_second.setOnValueChangedListener { picker, oldVal, newValsec ->
            saniye_calisma = newValsec.toInt().toLong()
        }


        number_picker_dinlenme_minute.setOnValueChangedListener { picker, oldVal, newValmin ->
            dak_dinlenme = newValmin.toInt().toLong()
            dakika_dinlenme = dak_dinlenme * 60
        }

        number_picker_dinlenme_second.setOnValueChangedListener { picker, oldVal, newValsec ->
            saniye_dinlenme = newValsec.toInt().toLong()
        }

        number_picker_round.setOnValueChangedListener { picker, oldVal, newValsec ->
            round_sayisi = newValsec.toInt().toLong()
        }





/*total_zaman_calisma.toString()
        total_zaman_dinlenme.toString()
        round_sayısı.toString() */





        basla_btn.setOnClickListener {

            total_zaman_calisma = dakika_calisma + saniye_calisma
            total_zaman_dinlenme = dakika_dinlenme + saniye_dinlenme

            var intent = Intent(this@MainActivity, Activity2::class.java)

            intent.putExtra("total_zaman_calisma", total_zaman_calisma)
            intent.putExtra("total_zaman_dinlenme", total_zaman_dinlenme)
            intent.putExtra("round_sayısı", round_sayisi)

            startActivity(intent)

        }
    }

}



