package com.example.asemb.pandapanaderia

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var menuinicio=0

    val manager = this.supportFragmentManager




    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                createFragmenteHome()
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_ventas -> {
                createFragmenteRegistro()
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_productos -> {
                createFragmenteAjustes()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if (menuinicio ===0) {
            createFragmenteHome()
            menuinicio=1
        }

        main_nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }




    override fun onBackPressed() {
        super.onBackPressed()
        createFragmenteHome()
        if(main_nav.getMenu().findItem(R.id.nav_home).isChecked()){
            //finish();
            moveTaskToBack(true);
        }else{
            main_nav.selectedItemId=R.id.nav_home
        }
    }
    fun createFragmenteHome()
    {
        val trans = manager.beginTransaction()
        val fragment = HomeFragment()
        trans.replace(R.id.fragmentholder,fragment)
        trans.addToBackStack(null)
        trans.commit()
    }

    fun createFragmenteRegistro()
    {
        val trans = manager.beginTransaction()
        val fragment = VentasFragment()
        trans.replace(R.id.fragmentholder,fragment)
        trans.addToBackStack(null)
        trans.commit()
    }

    fun createFragmenteAjustes()
    {
        val trans = manager.beginTransaction()
        val fragment = ProductosFragment()
        trans.replace(R.id.fragmentholder,fragment)
        trans.addToBackStack(null)
        trans.commit()
    }

}
