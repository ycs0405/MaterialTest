package com.xq.materialtest

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

class FruitActivity : BaseActivity() {
    private lateinit var appBar:AppBarLayout
    private lateinit var collapsingToolbar:CollapsingToolbarLayout
    private lateinit var fruitImageView:ImageView
    private lateinit var toolbar:Toolbar
    private lateinit var fruitContentText:TextView
    companion object{
        const val FRUIT_NAME = "fruit_name"
        const val FRUIT_IMAGE_ID = "fruit_image_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        appBar = findViewById(R.id.appBar)
        collapsingToolbar = findViewById(R.id.collapsingToolbar)
        fruitImageView = findViewById(R.id.fruitImageView)
        toolbar = findViewById(R.id.toolbar)
        fruitContentText = findViewById(R.id.fruitContentText)

        val fruitName = intent.getStringExtra(FRUIT_NAME) ?: ""
        val fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID,0)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolbar.title = fruitName

        Glide.with(this).load(fruitImageId).into(fruitImageView)
        fruitContentText.text = generateFruitContent(fruitName)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

   private fun generateFruitContent(fruitName:String) = fruitName.repeat(500)
}