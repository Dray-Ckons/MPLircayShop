package com.example.mplircayshop.oneapp


object Productos2Provider {

    private val productos2List1 = mutableListOf(
        Productos2(
            nombre = "Coca-Cola",
            tipo_cantidad = "Botella Retornable 1Lt",
            cantidad = 2
        ),
        Productos2(
            nombre = "Coca-Cola",
            tipo_cantidad = "Botella Retornable 2Lt",
            cantidad = 1
        )
    )

    private val productos2List2 = mutableListOf(
        Productos2(
            nombre = "Otro Producto",
            tipo_cantidad = "Tipo de Cantidad",
            cantidad = 0
        )
        // Agrega más elementos según sea necesario
    )

    val productos2List: List<List<Productos2>> = listOf(
        productos2List1,
        productos2List2
        // Agrega más listas de productos según sea necesario
    )

    fun getProductos2ListForItem(numLista: Int): List<Productos2> {
        return productos2List.getOrNull(numLista - 1) ?: emptyList()
    }
}
