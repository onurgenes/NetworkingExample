package ms.p2p.networkexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceHolderService {
    @GET("todos/{number}")
    fun listRepos(@Path("number") number: String): Call<Todo>
}