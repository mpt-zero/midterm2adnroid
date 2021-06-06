package ge.xxx.aplicationproducts.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ge.xxx.aplicationproducts.models.CategoryModel


class AllTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromJsonToCategories(json: String): List<CategoryModel> {
        val type = object : TypeToken<List<CategoryModel>>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromCategoriesToJson(list: List<CategoryModel>): String {
        return gson.toJson(list)
    }


}