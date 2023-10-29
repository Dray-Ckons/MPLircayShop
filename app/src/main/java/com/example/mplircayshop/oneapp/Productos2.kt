package com.example.mplircayshop.oneapp

data class Productos2(
    val nombre: String,
    val tipo_cantidad: String,
    var cantidad: Int
) {
    fun aumentarCantidad() {
        cantidad++
    }

    fun disminuirCantidad() {
        if (cantidad > 0) {
            cantidad--
        }
    }
}
