package ms.p2p.networkexample

import com.google.gson.annotations.SerializedName

class Todo {
    @SerializedName("userId")
    var userId: Int = 0
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("title")
    var title: String? = null
    @SerializedName("completed")
    var completed: Boolean? = null
}