package ge.xxx.aplicationproducts.network

import ge.xxx.aplicationproducts.models.ProductModel
import ge.xxx.aplicationproducts.models.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface GlobalDataProvider {

    @GET("products")
    fun fetchProducts(): Call<ResponseModel<List<ProductModel>>>
}