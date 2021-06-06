package ge.xxx.aplicationproducts.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ge.xxx.aplicationproducts.models.ProductModel

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<ProductModel>)
}