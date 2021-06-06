package ge.xxx.aplicationproducts

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ge.xxx.aplicationproducts.app.App
import ge.xxx.aplicationproducts.models.ProductModel
import ge.xxx.aplicationproducts.models.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchProducts()
    }

    private fun fetchProducts() {
        getApp().getGlobalDataProvider().fetchProducts()
            .enqueue(object : Callback<ResponseModel<List<ProductModel>>> {
                override fun onResponse(
                    call: Call<ResponseModel<List<ProductModel>>>,
                    response: Response<ResponseModel<List<ProductModel>>>
                ) {
                    val response = response.body()!!
                    getApp().getDatabase().productsDao().insertAll(response.data)
                }

                override fun onFailure(
                    call: Call<ResponseModel<List<ProductModel>>>,
                    t: Throwable
                ) {
                    Log.d("zulufta", t.toString())
                }

            })
    }

    private fun getApp(): App {
        return application as App
    }
}