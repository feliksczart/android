package com.example.roll

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class Background {

    var x : Int = 0
    var y : Int = 0
    var background : Bitmap? = null

    constructor(screenX : Int, screenY : Int, res : Resources){
        background = BitmapFactory.decodeResource(res, R.drawable.background)
        background = Bitmap.createScaledBitmap(background!!, screenX, screenY, false)
    }
}