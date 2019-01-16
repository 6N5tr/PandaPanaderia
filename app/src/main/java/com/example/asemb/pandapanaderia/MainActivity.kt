package com.example.asemb.pandapanaderia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


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
        main_nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
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
