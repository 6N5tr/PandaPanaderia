package com.example.asemb.pandapanaderia

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

class DbHelper:SQLiteOpenHelper {


    companion object {
        internal val DATABASE_NAME:String="ProductosDataBase"
        internal val TABLE_NAME:String="ProductosTabla"
        internal val DATABASE_VERSION:Int=1
        internal val UID:String="_id"
        internal val NOMBRE:String="Nombre"
        internal val PRECIO:String="Precio"
        internal val CANTIDAD:String="Cantidad"

        internal val CREATE_TABLE:String="CREATE TABLE "+ TABLE_NAME+" " +
                "("+UID+"INTEGER PRIMARY KEY AUTOINCREMENT, "+ NOMBRE+"VARCHAR(255)," +
                " "+ PRECIO+"VARCHAR(255), "+ CANTIDAD+"VARCHAR(255)):"
        internal val DROP_TABLE:String="DROP TABLE IF EXISTS"+ TABLE_NAME
    }
    internal lateinit var context: Context

    constructor(context: Context):super(context,DATABASE_NAME,null,DATABASE_VERSION){
        this.context=context
        Message.message(context,"Constructor LLamado")
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            Message.message(context,"onCreate")
            db!!.execSQL(CREATE_TABLE)

        }catch (e: SQLException){
            Message.message(context, ""+e)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        try {
            Message.message(context,"onUpgrade")
            db!!.execSQL(DROP_TABLE)
            onCreate(db)

        }catch (e: SQLException){
            Message.message(context, ""+e)
        }

    }
}