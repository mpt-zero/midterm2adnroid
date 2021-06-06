package ge.xxx.aplicationproducts.app

import android.app.Application
import androidx.room.Room
import ge.xxx.aplicationproducts.R
import ge.xxx.aplicationproducts.database.Database
import ge.xxx.aplicationproducts.network.GlobalDataProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    private lateinit var globalDataProvider: GlobalDataProvider
    private lateinit var database: Database

    override fun onCreate() {
        super.onCreate()
        initGlobalDataProvider()
        initDatabase()
    }

    private fun initDatabase() {
        database = Room.databaseBuilder(this, Database::class.java, "AppDB")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    private fun initGlobalDataProvider() {
        val client = OkHttpClient.Builder()
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(getString(R.string.base_url))
            .build()

        globalDataProvider = retrofit.create(GlobalDataProvider::class.java)
    }

    fun getDatabase(): Database {
        return database
    }

    fun getGlobalDataProvider(): GlobalDataProvider {
        return globalDataProvider
    }
}