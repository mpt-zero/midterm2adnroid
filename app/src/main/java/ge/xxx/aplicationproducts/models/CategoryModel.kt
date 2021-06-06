package ge.xxx.aplicationproducts.models


import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)