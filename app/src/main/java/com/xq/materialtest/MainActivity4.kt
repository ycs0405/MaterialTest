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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity4 : BaseActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navView: NavigationView
    private lateinit var fab:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)
        navView = findViewById(R.id.navView)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 显示HOME按钮
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu) // 替换HOME按钮默认图标

        navView.setCheckedItem(R.id.navCall) // 设置默认菜单选项
        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers() // 关闭侧滑菜单
            true // 设置当前菜单项为默认选中
        }

        fab = findViewById(R.id.fab)
        fab.setOnClickListener { view->
            Snackbar.make(view,"消息已发送",Snackbar.LENGTH_SHORT)
                .setAction("撤回"){
                    Toast.makeText(this,"消息已撤回",Toast.LENGTH_SHORT)
                }
                .show()
        }

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