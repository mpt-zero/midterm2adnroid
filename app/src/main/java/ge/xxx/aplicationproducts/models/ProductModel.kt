package ge.xxx.aplicationproducts.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class ProductModel(
    @PrimaryKey
    @SerializedName("id")
    val id: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("discount_amount")
    val discountAmount: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("categories")
    val categories: List<CategoryModel>
)