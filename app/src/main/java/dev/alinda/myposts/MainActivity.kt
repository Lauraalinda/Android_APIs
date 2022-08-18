package dev.alinda.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.alinda.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()

    }

    //bind frst
    fun getPosts() {
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getPosts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {//call back
                    val posts = response.body()//where the posts are held
                     if (posts != null) {
                        displayPosts(posts)
                    }

                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {//call back func
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayPosts(postsList: List<Post>) {
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        val postsAdapter = PostRvAdapter(postsList)
        binding.rvPosts.adapter = postsAdapter //called it
    }
}









// Call Back functions
//long running tasks(sending a req and getting a result,making a network call, or writing to a file / reading from a database locally)
// the app os xonstantly changing the ui so thats wat causes the application to stop
//for us to perform long running tasks we need to peform
//enqueue takes the request to another thread(input and output thread( where the request will be made to the server)
//we are requesting fr psots becauuse ww want to display them on the ui
//on response and on failure are our call back functions

//so retrofiit will call the response nad the failure on the ui thread or main function incase of a response or a failure o the ui

//assignmnet
//xml
//create recycler view
//constarain
//add linear layout (just makes them linear either horizontally or vertically)
//add margin left right bottom top to tv 8p
//text bold
//cardview wrap content
//add card elevation (4dp) to enhance
//card corner radius 4dp
//layout  margin 8dp
//font family yo san serif light
//create adapter for for ur posts
// fill in post recycler ciew adapter
//         post list item
//         post
//in adapter create a class called
//class POstsRvAdapter(potsLIsts: List<Post>):RecyclerViewADAPTER







