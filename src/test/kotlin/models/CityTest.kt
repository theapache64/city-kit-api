package models

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CityTest {

    private lateinit var cityAdapter: JsonAdapter<City>

    @Before
    fun setup() {
        this.cityAdapter = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build().adapter(City::class.java)
    }

    @Test
    fun onSmallCityName() {
        val cityName = "amsterdam"
        val city = City.create(cityName)
        val actualOutput = cityAdapter.toJson(city)
        val expectedOutput =
            "{\"city_name\":\"Amsterdam\",\"day_photo_url\":\"https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/amsterdam/day.jpg\",\"sunset_photo_url\":\"https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/amsterdam/sunset.jpg\",\"night_photo_url\":\"https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/amsterdam/night.jpg\"}"

        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun onLengthyCityName() {
        val cityName = "los-angeles"
        val city = City.create(cityName)
        val actualOutput = cityAdapter.toJson(city)
        val expectedOutput =
            "{\"city_name\":\"Los Angeles\",\"day_photo_url\":\"https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/los-angeles/day.jpg\",\"sunset_photo_url\":\"https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/los-angeles/sunset.jpg\",\"night_photo_url\":\"https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/los-angeles/night.jpg\"}"

        assertEquals(expectedOutput, actualOutput)
    }
}