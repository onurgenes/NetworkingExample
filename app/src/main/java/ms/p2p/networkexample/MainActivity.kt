package ms.p2p.networkexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create<PlaceHolderService>(PlaceHolderService::class.java)

        val repos = service.listRepos("2")

        repos.enqueue(object : Callback<Todo> {
            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                if (response.code() == 200) {
                    Log.d("***", "************************************************************")
                    Log.d("response", response.body()?.title.toString())
                    val tv = findViewById<TextView>(R.id.hello_text)
                    tv.text = response.body()?.title.toString()
                }
            }

            override fun onFailure(call: Call<Todo>, t: Throwable) {
                Log.e("FUCKED UP", t.localizedMessage)
                Log.e("FUCKED UP", "SHIT FUCK")
            }
        })



    }
}
