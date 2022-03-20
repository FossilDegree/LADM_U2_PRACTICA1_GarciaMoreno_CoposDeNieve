package mx.tecnm.tepic.ladm_u2_practica1_garciamoreno_coposdenieve

import android.graphics.*
import kotlin.random.Random

class Copo(l_:Lienzo,alturaReaparece_:Float,tamaño:Float,vel_:Int) {
    val l = l_
    var ancho = tamaño
    var alto = tamaño
    var vel=vel_
    var supIzq = PointF(0f,0f)
    var infDer = PointF(ancho,alto)
    var alturaReaparece = alturaReaparece_

    var copo = RectF2(supIzq,infDer)

    var movX = 0f
    var movY = 0f

    init {
        //ancho = 10f
        //alto = 10f
        var alt =  alturaReaparece.toInt()
        var y2 = (alt..(alt+1000)).random()
        supIzq = PointF(rand(1000),y2*-1f)
        infDer = PointF(supIzq.x+ancho,supIzq.y+alto)
        copo = RectF2(supIzq,infDer)
        movY = (vel..(vel+2)).random().toFloat()
        movX = 0f


    }
    private fun rand(hasta:Int) : Float{
        return Random.nextInt(hasta).toFloat()
    }
    private fun azar():Boolean{
        var r = (1..50).random()
        return (r==3)
    }
    fun mover(){
        if(movY>0 && movX==0f)movX+=0.2f
        if(azar()) movX*=-1
        copo.offset(movX,movY)
        if(copo.top>l.height){
            var alt =  alturaReaparece.toInt()
            var y2 = (alt..(alt+1000)).random()
            //movY = (vel..(vel+2)).random().toFloat()
           /* if(azar()){
                y2 = (1000..1500).random()
            }else{
                y2 = (1..500).random()
            }*/

            supIzq = PointF(rand(1000),y2*-1f)
            infDer = PointF(supIzq.x+ancho,supIzq.y+alto)
            copo.set(supIzq.x,supIzq.y,infDer.x,infDer.y)
        }
    }

    fun pintar(canvas:Canvas){
        var p = Paint()
        p.color = Color.WHITE
        canvas.drawRect(copo,p)
    }
    //var copo2 = RectF()


}