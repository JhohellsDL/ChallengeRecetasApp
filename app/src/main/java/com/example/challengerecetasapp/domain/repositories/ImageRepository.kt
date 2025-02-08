package com.example.challengerecetasapp.domain.repositories

import com.example.challengerecetasapp.R

private val imageMap = mapOf(
    1 to R.drawable.chocolate_avena,
    2 to R.drawable.arroz_con_huevo_platano_verde,
    3 to R.drawable.arroz_con_huevo,
    4 to R.drawable.costillas_bbq_a_la_parrilla,
    5 to R.drawable.ternera_sichuan_fideos,
    6 to R.drawable.aji_de_gallina,
    7 to R.drawable.rotini_pasta,
    8 to R.drawable.pasta_cremosa_pollo_arrebosado,
    9 to R.drawable.pasta_vino_tinto_carne,
    10 to R.drawable.pasta_pesto_albaca,
    11 to R.drawable.lomo_saltado,
    12 to R.drawable.cafe_capuchino,
    13 to R.drawable.galletas_con_chips,
    14 to R.drawable.musse_mango_yogurt,
)

fun getImageById(recipeId: Int): Int {
    return imageMap[recipeId] ?: R.drawable.food_vegetable
}