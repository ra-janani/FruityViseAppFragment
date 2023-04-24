package com.example.fruityviseapp.data

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize



@Keep
@Parcelize
data class FruityViceItemModel(
    @SerializedName("family")
    val family: String? = "",
    @SerializedName("genus")
    val genus: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("nutritions")
    val nutritions: NutritionsModel? = NutritionsModel(),
    @SerializedName("order")
    val order: String? = ""
):Parcelable


@Keep
@Parcelize
data class NutritionsModel(
    @SerializedName("calories")
    val calories: Int? = 0,
    @SerializedName("carbohydrates")
    val carbohydrates: Double? = 0.0,
    @SerializedName("fat")
    val fat: Double? = 0.0,
    @SerializedName("protein")
    val protein: Double? = 0.0,
    @SerializedName("sugar")
    val sugar: Double? = 0.0
) :Parcelable