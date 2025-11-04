package com.xq.materialtest

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import java.util.zip.Inflater

class MainActivity2 : BaseActivity() {
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var toolbar:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)  // 设置ActionBar为toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // 显示Home按钮
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu) // 替换Home按钮图标
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.backup->{
                Log.d("YCS", "备份...")
            }
            R.id.delete->{
                Log.d("YCS", "删除...")
            }
            R.id.setting->{
                Log.d("YCS", "设置...")
            }
            android.R.id.home->{
                drawerLayout.openDrawer(GravityCompat.START)  // 从左侧打开侧滑菜单
            }
            else -> super.onOptionsItemSelected(item)

        }
        return true
    }
}