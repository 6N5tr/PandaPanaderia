package com.example.asemb.pandapanaderia

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class CustomAdapter {
    lateinit var dbHelper:DbHelper

    constructor(context: DbHelper.Companion){

        dbHelper= DbHelper(context)

    }

    fun insertData (nombre:String,precio:String,cantidad:String):Long{

        var db: SQLiteDatabase=dbHelper.writableDatabase
        var cv: ContentValues= ContentValues()
        cv.put(DbHelper.NOMBRE,nombre)
        cv.put(DbHelper.PRECIO,precio)
        cv.put(DbHelper.CANTIDAD,cantidad)

        var id:Long=db.insert(DbHelper.TABLE_NAME,null,cv)
        return id

    }

    fun getAllData():String{

        var db:SQLiteDatabase=dbHelper.writableDatabase
        var columns:Array<String> = arrayOf(DbHelper.UID,DbHelper.NOMBRE,DbHelper.PRECIO,DbHelper.CANTIDAD)
        var cursor:Cursor = db.query(DbHelper.TABLE_NAME,columns,null,null,null,null,null)
        var sb:StringBuffer= StringBuffer()
        while(cursor.moveToNext()){
            var cid:Int=cursor.getInt(0)
            var name:String=cursor.getString(1)
            var price:String=cursor.getString(2)
            var quantity:String=cursor.getString(3)
            sb.append("$cid $name $price $quantity \n")
        }
        return sb.toString()
    }

    fun getData(name:String):String{
        var db:SQLiteDatabase=dbHelper.writableDatabase
        var columns:Array<String> = arrayOf(DbHelper.NOMBRE,DbHelper.PRECIO,DbHelper.CANTIDAD)
        var cursor:Cursor=db.query(DbHelper.TABLE_NAME,columns,DbHelper.NOMBRE+"='"+name+"'",null,null,null,null)
        var sb:StringBuffer= StringBuffer()
        while(cursor.moveToNext()){
            var index1:Int=cursor.getColumnIndex(DbHelper.NOMBRE)
            var index2:Int=cursor.getColumnIndex(DbHelper.PRECIO)
            var index3:Int=cursor.getColumnIndex(DbHelper.CANTIDAD)
            var name:String=cursor.getString(index1)
            var price:String=cursor.getString(index2)
            var quantity:String=cursor.getString(index3)
            sb.append("$name $price $quantity \n")

        }
        return sb.toString()
    }

    fun updateProduct(oldName:String,newName:String):Int{
        var db:SQLiteDatabase=dbHelper.writableDatabase
        var cv:ContentValues= ContentValues()
        cv.put(DbHelper.NOMBRE,newName)
        var whereargs:Array<String> = arrayOf(oldName)
        var count:Int= db.update(DbHelper.TABLE_NAME,cv,DbHelper.NOMBRE+"=?",whereargs)
        return count
    }

    fun deleteProduct(name: String):Int{
        var db:SQLiteDatabase=dbHelper.writableDatabase
        var whereargs:Array<String> = arrayOf(name)
        var count:Int= db.delete(DbHelper.TABLE_NAME,DbHelper.NOMBRE+"=?",whereargs)
        return count
    }

}