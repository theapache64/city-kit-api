import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import models.City
import java.io.File

fun main() {
    val cities = mutableListOf<City>()
    val dataDir = File(System.getProperty("user.dir") + "/data")
    dataDir.listFiles()!!.forEach { file ->
        val dirName = file.name
        val city = City.create(dirName)
        cities.add(city)
    }

    val types = Types.newParameterizedType(List::class.java, City::class.java)
    val cityAdapter: JsonAdapter<List<City>> = moshi()
        .adapter(types)

    val citiesJson = cityAdapter.toJson(cities)
    val apiJsonFile = File(System.getProperty("user.dir") + "/api.json")
    apiJsonFile.writeText(citiesJson)
}

private fun moshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}