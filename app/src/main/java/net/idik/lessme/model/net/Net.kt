package net.idik.lessme.model.net

import com.github.simonpercic.oklog3.OkLogInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit


/**
 * Created by linshuaibin on 11/03/2017.
 */
object Net {

    val httpClient = OkHttpClient.Builder()
            .addInterceptor(OkLogInterceptor.builder().build())
            .build()

    private val retrofit = Retrofit.Builder().client(httpClient).build()

    val api = retrofit.create(Api::class.java)
}
