package ge.xxx.aplicationproducts.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ge.xxx.aplicationproducts.database.converters.AllTypeConverters
import ge.xxx.aplicationproducts.database.daos.ProductsDao
import ge.xxx.aplicationproducts.models.ProductModel

@Database(
    entities = [
        ProductModel::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(AllTypeConverters::class)
abstract class Database : RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}