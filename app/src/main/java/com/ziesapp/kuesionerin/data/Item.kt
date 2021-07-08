package com.ziesapp.kuesionerin.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    var title: String,
    var description: String,
    var link: String
): Parcelable
