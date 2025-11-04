package com.xq.materialtest

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

object ActivityCollector {
    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }

    fun currentActivity(): Activity? {
        return if (activities.isNotEmpty()) activities.last() else null
    }

    fun activityCount(): Int = activities.size

}

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("YCS", "BaseActivity onCreate:${javaClass.simpleName}")
        ActivityCollector.addActivity(this)
    }


    override fun onStart() {
        super.onStart()
        Log.d("YCS", "BaseActivity onStart:${javaClass.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("YCS", "BaseActivity onResume:${javaClass.simpleName}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("YCS", "BaseActivity onRestart:${javaClass.simpleName}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("YCS", "BaseActivity onPause:${javaClass.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("YCS", "BaseActivity onStop:${javaClass.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
        Log.d("YCS", "BaseActivity onDestroy:${javaClass.simpleName}")
    }
}