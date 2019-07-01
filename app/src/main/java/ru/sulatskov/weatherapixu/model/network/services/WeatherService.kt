package ru.sulatskov.weatherapixu.model.network.services


class WeatherService private constructor() {

    companion object {

        private var INSTANCE: WeatherService? = null

        fun getInstance(): WeatherService {
            if (INSTANCE == null) {
                INSTANCE = WeatherService()
            }
            return INSTANCE!!
        }

    }

 /*   private var retrofit: ApiLogin = Retrofit.Builder()
        .baseUrl(AppConfig.GIT_HUB_API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                val newRequest = request
                    .newBuilder()
                    .header("Authorization", "Basic c3VsYXRza292MzRhbkBtYWlsLnJ1OlZvbHN1MjAwOCE=")
                    .header("Content-Type", "application/json")
                    .build()
                chain.proceed(newRequest)
            }
            .build())
        .build()
        .create(ApiLogin::class.java)


    fun login(scopes: Array<String>, note: Int): Call<Response<LoginData>> {
        return retrofit.login(LoginBody(scopes, note))
    }
*/

}