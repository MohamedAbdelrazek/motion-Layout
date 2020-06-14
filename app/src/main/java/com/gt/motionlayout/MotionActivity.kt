package com.gt.motionlayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_motion.*


class MotionActivity : AppCompatActivity(), MotionLayout.TransitionListener {
    lateinit var motionLayout: MotionLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)
        motionLayout = findViewById(R.id.motion)
        motionLayout.setTransitionListener(this);

        motion_trigger_layout.setOnClickListener {
            if (motion.progress == 0.0.toFloat()) {
                motionLayout.transitionToEnd()
            } else {
                motionLayout.transitionToStart()
            }
        }
        download.setOnClickListener {
            Toast.makeText(this, "download ", Toast.LENGTH_SHORT).show()
            motionLayout.transitionToStart()
        }

        edit.setOnClickListener {
            Toast.makeText(this, "edit ", Toast.LENGTH_SHORT).show()
            motionLayout.transitionToStart()
        }
        share.setOnClickListener {
            Toast.makeText(this, "share ", Toast.LENGTH_SHORT).show()
            motionLayout.transitionToStart()
        }
        wall_paper.setOnClickListener {
            Toast.makeText(this, "wall paper ", Toast.LENGTH_SHORT).show()
            motionLayout.transitionToStart()
        }

    }

    private fun closeMotion() {
        motionLayout.transitionToStart()
        //isOpened = false
    }

    private fun openMotion() {
        motionLayout.transitionToEnd()
        // isOpened = true

    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
        if (p1 == R.layout.start) {
            hideViews()
        }
    }

    private fun hideViews() {
        tv_download.text = ""
        tv_edit.text = ""
        tv_share.text = ""
        tv_w_paper.text = ""
        trigger_iv.setImageResource(R.drawable.ic_dots)
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
        if (p1 != R.layout.start) {
            showViews()
        }

    }

    private fun showViews() {
        tv_download.text = "Download"
        tv_edit.text = "Edit"
        tv_share.text = "Share"
        tv_w_paper.text = "Set as wallpaper"
        trigger_iv.setImageResource(R.drawable.ic_close)
    }
}