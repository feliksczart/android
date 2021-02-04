package com.example.roll

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GameActivity : AppCompatActivity() {

    private var gameView : GameView? = null
    private var point : Point? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        point = Point()
        windowManager.defaultDisplay.getSize(point)

        gameView = GameView(this, point!!.x, point!!.y)
    }
}