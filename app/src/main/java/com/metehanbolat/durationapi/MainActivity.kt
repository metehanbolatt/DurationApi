package com.metehanbolat.durationapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.metehanbolat.durationapi.databinding.ActivityMainBinding
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

@ExperimentalTime
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val daysNumber = 1.5.days
        val daysInMillis = 1.days.inWholeMilliseconds
        val daysMinusHours = (1.5.days - 2.hours).inWholeHours
        val convertDaysToHours = Duration.convert(
            value = 1.0,
            sourceUnit = DurationUnit.DAYS,
            targetUnit = DurationUnit.HOURS
        )
        val isoToDuration = Duration.parse(value = "P1DT2H3M4.058S")
        val durationToIso = (3.days + 6.hours + 12.minutes).toIsoString()
        val isoToDuration2 = Duration.parse(value = "P1DT2H3M4.058S")
        isoToDuration2.toComponents { days, hours, minutes, seconds, nanoseconds ->
            println("$days + $hours + $minutes + $seconds + $nanoseconds")
        }


        println(daysNumber)
        println(daysInMillis)
        println(daysMinusHours)
        println(convertDaysToHours)
        println(isoToDuration)
        println(durationToIso)
    }
}