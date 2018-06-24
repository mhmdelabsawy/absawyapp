
import com.sun.corba.se.spi.presentation.rmi.StubAdapter.request
import java.io.IOException
import com.sun.net.httpserver.Filter.Chain
import org.omg.PortableInterceptor.Interceptor

 fun main(args: Array<String>) {

     val httpClient = OkHttpClient.Builder()
     httpClient.addInterceptor(object : Interceptor {
         @Throws(IOException::class)
         fun intercept(chain: Chain): Response {
             val original = chain.request()
             val originalHttpUrl = original.url()

             val url = originalHttpUrl.newBuilder()
                     .addQueryParameter("apikey", "your-actual-api-key")
                     .build()

             // Request customization: add request headers
             val requestBuilder = original.newBuilder()
                     .url(url)

             val request = requestBuilder.build()
             return chain.proceed(request)
         }
     })
}