package dev.alinda.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.alinda.myposts.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId = 0
    lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
        getComments()

    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST_ID") ?: 0

    }

    fun fetchPost() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)

        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var post = response.body()
                if (post != null) {
                    binding.tvPosttitle.text = post.title
                    binding.tvPostBody.text = post.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }
        })
    }


    fun getComments() {
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getComments()

        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful) {//call back
                    val comment = response.body()//where the posts are held
                    if (comment != null) {
                        displayComments(comment)
                    }

                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {//call back func
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayComments(commentList: List<Comment>) {
        binding.Rvcomments.layoutManager = LinearLayoutManager(this)
        val commentsAdapter = CommentRvAdapter(commentList)
        binding.Rvcomments.adapter = commentsAdapter //called it
    }
}
