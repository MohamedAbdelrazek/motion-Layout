package com.gt.motionlayout

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MotionLayout.TransitionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        motion_layout.setTransitionListener(this);

        close.setOnClickListener {
            if (motion_layout.progress == 0.0.toFloat()) {
                motion_layout.transitionToEnd()
            } else {
                motion_layout.transitionToStart()
            }
        }


        download.setOnClickListener {
            Toast.makeText(this, "download ", Toast.LENGTH_SHORT).show()
            motion_layout.transitionToStart()
        }

        edit.setOnClickListener {
            Toast.makeText(this, "edit ", Toast.LENGTH_SHORT).show()
            motion_layout.transitionToStart()
        }
        share.setOnClickListener {
            Toast.makeText(this, "share ", Toast.LENGTH_SHORT).show()
            motion_layout.transitionToStart()
        }
        wall_paper.setOnClickListener {
            Toast.makeText(this, "wall paper ", Toast.LENGTH_SHORT).show()
            motion_layout.transitionToStart()
        }

    }

    private fun closeMotion() {
        motion_layout.transitionToStart()
        //isOpened = false
    }

    private fun openMotion() {
        motion_layout.transitionToEnd()
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

    }
}