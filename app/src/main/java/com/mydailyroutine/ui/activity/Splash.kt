package com.mydailyroutine.ui.activity

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mydailyroutine.R
import kotlinx.android.synthetic.main.activity_splash.*

class Splash : AppCompatActivity() {
    private var isRunning: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (!isRunning!!) {
            isRunning = true

            imgSplash.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(0)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animator: Animator) {

                    }

                    override fun onAnimationEnd(animator: Animator) {

                        imgSplash.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(2000)
                            .setListener(object :
                                Animator.AnimatorListener {
                                override fun onAnimationEnd(p0: Animator?) {

                                    val intent = Intent(this@Splash, Login::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    startActivity(intent)
                                    finish()
                                    overridePendingTransition(R.anim.slide_up, R.anim.slide_bottom)
                                }

                                override fun onAnimationStart(animator: Animator) {

                                }

                                override fun onAnimationCancel(animator: Animator) {

                                }

                                override fun onAnimationRepeat(animator: Animator) {

                                }
                            }).start()

                    }

                    override fun onAnimationCancel(animator: Animator) {

                    }

                    override fun onAnimationRepeat(animator: Animator) {

                    }
                }).start()

        }
    }
}