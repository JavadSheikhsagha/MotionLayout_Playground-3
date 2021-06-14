package ir.rahcode.myanimation

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.Transition
import ir.rahcode.myanimation.databinding.ActivityMain2Binding
import ir.rahcode.myanimation.databinding.ActivityMainBinding


class MainActivity2 : AppCompatActivity() {

    lateinit var binding : ActivityMain2Binding

    lateinit var constraintLayout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){

//        val params = findViewById<ImageView>(R.id.imageView).layoutParams as ConstraintLayout.LayoutParams
//        params.bottomToBottom = R.id.imageView3
        constraintLayout = findViewById(R.id.constraintLayout)

        findViewById<ImageView>(R.id.imageView).setOnClickListener {

            val constraintSet = ConstraintSet()
            constraintSet.clone(constraintLayout)
            val transition = ChangeBounds()
            //constraintSet.connect(R.id.imageView,ConstraintSet.TOP,R.id.imageView3,ConstraintSet.BOTTOM)
            transition.interpolator = AnticipateOvershootInterpolator(2.0f)
            transition.duration = 1000

            TransitionManager.beginDelayedTransition(binding.root,transition)
            constraintSet.applyTo(binding.root)








            //addAnimationOperations()

//            var set = ConstraintSet()
//
//            set.clone(constraintLayout)
//            set.connect(R.id.imageView,ConstraintSet.TOP,R.id.imageView3,ConstraintSet.BOTTOM)
//            set.applyTo(constraintLayout)
        }

    }

    private fun addAnimationOperations() {
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(constraintLayout)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_main2)

        findViewById<ImageView>(R.id.imageView).setOnClickListener{
            TransitionManager.beginDelayedTransition(constraintLayout)
            val constraint = if(set) constraint1 else constraint2
            constraint.applyTo(constraintLayout)
            set = !set
        }

    }
}