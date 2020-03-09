package com.example.catchthekenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var score: Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        score = 0
        //ImageArray
        imageArray.add(imageView)

        imageArray.add(imageView1)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)



        hideImages()

        //CountDown Timer

        object : CountDownTimer(10000,1000){
            override fun onFinish() {

                timeText.text = "Time: 0"

                handler.removeCallbacks(runnable)

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

Toast.makeText(applicationContext,"Times OFF",Toast.LENGTH_LONG).show()


            }
            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time: " + millisUntilFinished/1000
            }

        }.start()

    }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random
                val index = random.nextInt(15-0)
                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable,200)
            }

        }

        handler.post(runnable)

    }

    fun increaseScore(view: View) {
        score++
        scoreText.text="Score: "+score
    }
    fun restart(view: View){
        val intent= Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }
    fun newgame(view: View){
        val intent= Intent(applicationContext,SplashActivity::class.java)
        startActivity(intent)
    }
}