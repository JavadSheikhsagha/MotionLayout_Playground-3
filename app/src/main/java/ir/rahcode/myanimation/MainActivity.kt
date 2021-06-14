package ir.rahcode.myanimation

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionManager
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


    }

    private fun init(){

        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)

        findViewById<ImageView>(R.id.imageView).setOnClickListener {
            motionLayout.setTransition(R.id.tran_bigMove)
            motionLayout.transitionToEnd()
        }

        val params = findViewById<ImageView>(R.id.imageView).layoutParams as ConstraintLayout.LayoutParams
//        params.bottomToBottom = R.id.imageView3
//        params.topToTop = ConstraintLayout.LayoutParams.UNSET

        findViewById<ImageView>(R.id.imageView3).setOnClickListener {

            var set = ConstraintSet()

            set.getConstraint(R.id.small_move)

            set.connect(R.id.imageView3, ConstraintSet.BOTTOM,R.id.imageView, ConstraintSet.BOTTOM)
            set.applyToLayoutParams(R.id.small_move,params)

            ConstraintSet().getConstraint(R.id.small_move)



            motionLayout.setTransition(R.id.tran_smallMove)
            motionLayout.transitionToEnd()
        }

    }


}