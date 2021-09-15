package com.oyelabs.grocerystore.model

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class GroceryItem(
    val image: Int,
    val title: String,
    val description: String,
): Parcelable