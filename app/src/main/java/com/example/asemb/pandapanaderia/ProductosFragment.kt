package com.example.asemb.pandapanaderia


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var nombreProducto: EditText
lateinit var precioProducto: EditText
lateinit var cantidadProducto: EditText
lateinit var verProducto: EditText



class ProductosFragment : Fragment() {

    lateinit var NombreProducto:EditText
    lateinit var PrecioProducto:EditText
    lateinit var CantidadProducto:EditText
    lateinit var getProducto:EditText
    lateinit var ca: CustomAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productos, container, false)

        NombreProducto= view?.findViewById(R.id.etNombre) as EditText
        PrecioProducto=view?.findViewById(R.id.etPrecio) as EditText
        CantidadProducto=view?.findViewById(R.id.etCantidad) as EditText
        getProducto=view?.findViewById(R.id.etBuscarProducto) as EditText
        ca=CustomAdapter(DbHelper)

    }

    fun addProduct(){
        var producto:String=nombreProducto.text.toString()
        var precio:String=precioProducto.text.toString()
        var cantidad:String=cantidadProducto.text.toString()
        var id:Long = ca.insertData(producto,precio,cantidad)

        if (id<0){
            Message.message(DbHelper, "No se pudo insertar datos!")
        }
        else{
            Message.message(DbHelper, "Datos insertados!")
        }


    }

    fun viewProducts(view: View){
        var data:String=ca.getAllData()
        Message.message(DbHelper,data)
    }

    fun viewProduct(view: View){
        var data:String=ca.getData(verProducto.text.toString().trim())
        Message.message(DbHelper,data)
    }

    fun updateProduct(view: View){
        ca.updateProduct("test","mihir")
        Message.message(DbHelper, "Datos actualizados")
    }

    fun deleteProduct(view: View){
        var count:Int= ca.deleteProduct("prueba")
        Message.message(DbHelper,""+count)

    }


}
