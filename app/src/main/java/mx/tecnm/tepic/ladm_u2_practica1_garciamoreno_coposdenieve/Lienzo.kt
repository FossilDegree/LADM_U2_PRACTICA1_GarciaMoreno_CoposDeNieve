package mx.tecnm.tepic.ladm_u2_practica1_garciamoreno_coposdenieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(activity_:MainActivity) : View(activity_) {
    val activity = activity_
    val copos = Array<Copo>(50,{Copo(this,0f,10f,1)})
    val copos2 = Array<Copo>(500,{Copo(this,8500f,25f,4)})
    val corrutina = GlobalScope.launch {
        while (true){
            activity.runOnUiThread{
                invalidate()
            }
            delay(20L)
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()
        val mitad = width/2
        val ancho = width+0f
        val alto = height+0f
        val altoEdificio = alto*0.25f





        c.drawRGB(4,32,54)

        //EDIFICIO CENTRO
        p.color= Color.BLACK
        c.drawRect(mitad-275f,altoEdificio,mitad+275f,alto,p)
        c.drawRect(mitad-250f,altoEdificio-40f,mitad+250f,altoEdificio,p)
        c.drawRect(mitad-20f,altoEdificio-400f,mitad+20f,altoEdificio,p)

        //VENTANAS
        p.color = Color.YELLOW
        c.drawRect(mitad-200f,altoEdificio+50f,mitad-100f,altoEdificio+200,p)
        c.drawRect(mitad-50f,altoEdificio+50f,mitad+50f,altoEdificio+200,p)
        c.drawRect(mitad+100f,altoEdificio+50f,mitad+200f,altoEdificio+200,p)

        c.drawRect(mitad-200f,altoEdificio+300f,mitad-100f,altoEdificio+450,p)
        c.drawRect(mitad-50f,altoEdificio+300f,mitad+50f,altoEdificio+450,p)
        c.drawRect(mitad+100f,altoEdificio+300f,mitad+200f,altoEdificio+450,p)

        c.drawRect(mitad-200f,altoEdificio+550f,mitad-100f,altoEdificio+700,p)
        c.drawRect(mitad-50f,altoEdificio+550f,mitad+50f,altoEdificio+700,p)
        c.drawRect(mitad+100f,altoEdificio+550f,mitad+200f,altoEdificio+700,p)

        c.drawRect(mitad-200f,altoEdificio+800f,mitad-100f,altoEdificio+950,p)
        c.drawRect(mitad-50f,altoEdificio+800f,mitad+50f,altoEdificio+950,p)
        c.drawRect(mitad+100f,altoEdificio+800f,mitad+200f,altoEdificio+950,p)

        c.drawRect(mitad-200f,altoEdificio+1050f,mitad-100f,altoEdificio+1200,p)
        c.drawRect(mitad-50f,altoEdificio+1050f,mitad+50f,altoEdificio+1200,p)
        c.drawRect(mitad+100f,altoEdificio+1050f,mitad+200f,altoEdificio+1200,p)

        c.drawRect(mitad-200f,altoEdificio+1300f,mitad-100f,altoEdificio+1450,p)
        c.drawRect(mitad-50f,altoEdificio+1300f,mitad+50f,altoEdificio+1450,p)
        c.drawRect(mitad+100f,altoEdificio+1300f,mitad+200f,altoEdificio+1450,p)

        //CAPA DE NIEVE
        p.color = Color.WHITE
        c.drawRect(mitad-275f,altoEdificio-10f,mitad+275f,altoEdificio,p)
        c.drawRect(mitad-250f,altoEdificio-50f,mitad+250f,altoEdificio-40,p)
        c.drawRect(mitad-20f,altoEdificio-410f,mitad+20f,altoEdificio-400,p)



        for(copo in copos){
            copo.mover()
            copo.pintar(c)
        }
        for(copo in copos2){
            copo.mover()
            copo.pintar(c)
        }

    }
}