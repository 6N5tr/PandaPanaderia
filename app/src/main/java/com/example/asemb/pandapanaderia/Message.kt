package com.example.asemb.pandapanaderia

import android.widget.Toast

class Message {

    companion object {
        fun message(con: DbHelper.Companion, msg:String){
            Toast.makeText(con,msg,Toast.LENGTH_SHORT).show()
        }
    }
}