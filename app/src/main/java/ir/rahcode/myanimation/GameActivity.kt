package ir.rahcode.myanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat

class GameActivity : AppCompatActivity() {

    lateinit var motionLayout1: MotionLayout
    lateinit var motionLayout2: MotionLayout
    lateinit var motionLayout3: MotionLayout
    lateinit var motionLayout4: MotionLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        motionLayout1 = findViewById(R.id.motion_gameActivity_motion1)
        motionLayout2 = findViewById(R.id.motion_gameActivity_motion2)
        motionLayout3 = findViewById(R.id.motion_gameActivity_motion3)
        motionLayout4 = findViewById(R.id.motion_gameActivity_motion4)



        findViewById<CardView>(R.id.card_gameActivity_card1Top).setOnClickListener {
            motionLayout1.setTransition(R.id.tran_gameActivity_motion1_to_1_1)
            motionLayout1.transitionToEnd()



        }

        findViewById<CardView>(R.id.card_gameActivity_card2Top).setOnClickListener {
            motionLayout4.setTransition(R.id.tran_gameActivity_motion4_to_1_1)
            motionLayout4.transitionToEnd()

            findViewById<ImageView>(R.id.imageView6).setColorFilter(ContextCompat.getColor(this,R.color.black))



        }
    }
}