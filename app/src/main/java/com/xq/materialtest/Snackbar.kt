package com.xq.materialtest

import android.view.View
import com.google.android.material.snackbar.Snackbar

// Snackbar.make(view,"消息已发送", Snackbar.LENGTH_SHORT)
//                .setAction("撤回"){
//                    Toast.makeText(this,"消息已撤回", Toast.LENGTH_SHORT).show()
//                }
//                .show()

//fun View.showSnackbar(text: String, duration: Int = Snackbar.LENGTH_SHORT) {
//    Snackbar.make(this, text, duration).show()
//}
//fun View.showSnackbar(resId: Int, duration: Int = Snackbar.LENGTH_SHORT) {
//    Snackbar.make(this, resId, duration).show()
//}

//fun View.showSnackbar(text:String,duration:Int = Snackbar.LENGTH_SHORT){
//    Snackbar.make(this,text,duration).show()
//}
//fun View.showSnackbar(resId:Int,duration:Int = Snackbar.LENGTH_SHORT){
//    Snackbar.make(this,resId,duration).show()
//}

fun View.showSnackbar(text:String,actionText:String?=null,duration:Int = Snackbar.LENGTH_SHORT,block:(()->Unit)?=null){
    val snackbar = Snackbar.make(this,text,duration)
    if (actionText!=null && block!=null){
        snackbar.setAction(actionText){
            block()
        }
    }
    snackbar.show()
}

fun View.showSnackbar(resId:Int,actionResId:Int?=null,duration:Int = Snackbar.LENGTH_SHORT,block:(()->Unit)?=null){
    val snackbar = Snackbar.make(this,resId,duration)
    if (actionResId!=null && block!=null){
        snackbar.setAction(actionResId){
            block()
        }
    }
    snackbar.show()
}