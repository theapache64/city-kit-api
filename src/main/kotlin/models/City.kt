package models

import com.squareup.moshi.Json

data class City(
    @Json(name = "city_name")
    val cityName: String, // Amsterdam
    @Json(name = "day_photo_url")
    val dayPhotoUrl: String, // https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/amsterdam/day.jpg
    @Json(name = "sunset_photo_url")
    val sunsetPhotoUrl: String, // https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/amsterdam/sunset.jpg
    @Json(name = "night_photo_url")
    val nightPhotoUrl: String // https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/amsterdam/day.jpg
) {
    companion object {

        fun create(dirName: String): City {

            val photoUrlFormat =
                "https://raw.githubusercontent.com/theapache64/city-kit-api/master/data/{DIR_NAME}/{TIME}.jpg".replace(
                    "{DIR_NAME}",
                    dirName
                )

            val cityName = dirName.replace("-", " ").split(" ").joinToString(" ") { it.capitalize() }
            return City(
                cityName,
                photoUrlFormat.replace("{TIME}", "day"),
                photoUrlFormat.replace("{TIME}", "sunset"),
                photoUrlFormat.replace("{TIME}", "night")
            )
        }
    }
}