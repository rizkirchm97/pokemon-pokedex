package com.rizkir.pokemon.common

sealed class NavRoute(var route: String) {
    object HomeScreen : NavRoute("home_screen")
    object DetailItem : NavRoute("detail_item")
}
