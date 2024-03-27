package com.softlas.catchthekenny

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop
import com.softlas.catchthekenny.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityMainBinding
    var runnable = Runnable{}
    var handler = Handler(Looper.getMainLooper())

    var imageArray = ArrayList<ImageView>()
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.cartman1)
        imageArray.add(binding.cartman2)
        imageArray.add(binding.cartman3)
        imageArray.add(binding.cartman4)
        imageArray.add(binding.cartman5)
        imageArray.add(binding.cartman6)
        imageArray.add(binding.cartman7)
        imageArray.add(binding.cartman8)
        imageArray.add(binding.cartman9)

        hideImages()

        object : CountDownTimer(10000,1000) {
            override fun onFinish() {
                binding.timeText.text = "Left: 0"

                handler.removeCallbacks(runnable)

                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over!")
                alert.setMessage("Score: $score \nWould you like to start again?")

                alert.setPositiveButton("Yes") {dialog, which ->
                    val intent = Intent(applicationContext,MainActivity::class.java)
                    finish()
                    startActivity(intent)

                }
                alert.setNegativeButton("No") {dialog, which ->
                    Toast.makeText(this@MainActivity, "Game over!", Toast.LENGTH_LONG).show()
                }
                alert.show()
                score = 0
            }

            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "Left: ${millisUntilFinished/1000}"
            }

        }.start()

    }

    fun hideImages(){

        runnable = object : Runnable {
            override fun run() {
                val randomImage = Random.nextInt(8)
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                imageArray[randomImage].visibility = View.VISIBLE
                handler.postDelayed(runnable, 500)
            }
        }
        handler.post(runnable)
    }

    fun imageClick(view: View){
        score++
        binding.scoreText.text = "Score : $score"
    }


}