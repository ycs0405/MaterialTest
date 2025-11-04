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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlin.concurrent.thread

class MainActivity7 : BaseActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navView: NavigationView
    private lateinit var fab: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefresh:SwipeRefreshLayout

    val fruits = mutableListOf(Fruit("Apple", R.drawable.apple), Fruit("Banana",
        R.drawable.banana), Fruit("Orange", R.drawable.orange), Fruit("Watermelon",
        R.drawable.watermelon), Fruit("Pear", R.drawable.pear), Fruit("Grape",
        R.drawable.grape), Fruit("Pineapple", R.drawable.pineapple), Fruit("Strawberry",
        R.drawable.strawberry), Fruit("Cherry", R.drawable.cherry), Fruit("Mango",
        R.drawable.mango))

    val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

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
            Snackbar.make(view,"消息已发送", Snackbar.LENGTH_SHORT)
                .setAction("撤回"){
                    Toast.makeText(this,"消息已撤回", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        recyclerView = findViewById(R.id.recyclerView)
        initFruits()
        val layoutManager = GridLayoutManager(this,2) // 网格布局，每行2个Item
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(this,fruitList)
        recyclerView.adapter = adapter

        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary) // 设置刷新进度条
        swipeRefresh.setOnRefreshListener {
            refreshFruits(adapter)
        }
    }

    private fun refreshFruits(adapter:FruitAdapter){
        thread {
            Thread.sleep(2000)
            initFruits()
            runOnUiThread {
                adapter.notifyDataSetChanged() // 通知UI控件，数据集已发生改变
                swipeRefresh.isRefreshing = false // 刷新结束，隐藏进度条
            }
        }
    }


    private fun initFruits(){
        fruitList.clear()
        repeat(50){
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
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