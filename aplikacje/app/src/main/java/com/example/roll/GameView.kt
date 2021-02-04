package com.example.roll

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.SurfaceView

class GameView : SurfaceView, Runnable {

    private var thread : Thread? = null
    private var isPlaying : Boolean? = null
    private var background1 : Background? = null
    private var background2 : Background? = null
    private var paint : Paint? = null
    private var screenX : Int? = null
    private var screenY : Int? = null

    constructor(context: Context, screenX : Int, screenY : Int) : super(context){

        this.screenX = screenX
        this.screenY = screenY

        background1 = Background(screenX, screenY, resources)
        background2 = Background(screenX, screenY, resources)

        background2!!.x = screenX

        paint = Paint()
    }

    override fun run() {
        while (isPlaying!!){
            update()
            draw()
            sleep()
        }
    }

    fun update(){

        background1!!.x -= 10
        background2!!.x -= 10

        if (background1!!.x + background1!!.background!!.width < 0){
            background1!!.x = screenX!!
        }

        if (background2!!.x + background2!!.background!!.width < 0){
            background2!!.x = screenX!!
        }
    }

    fun draw(){

        if (holder.surface.isValid){
            var canvas : Canvas = holder.lockCanvas()
            //canvas.drawBitmap(background1!!.background, background1!!.x, background1!!.y, paint)
            canvas.drawBitmap(background1!!.background!!, background1!!.x.toFloat(), background1!!.y.toFloat(), paint)
            canvas.drawBitmap(background2!!.background!!, background2!!.x.toFloat(), background2!!.y.toFloat(), paint)

            holder.unlockCanvasAndPost(canvas)
        }
    }

    fun sleep(){
        Thread.sleep(17)
    }

    fun resume(){

        isPlaying = true

        thread = Thread()
        thread!!.start() //!! - not null
    }

    fun pause(){
        isPlaying = false
        thread?.join()
    }
}