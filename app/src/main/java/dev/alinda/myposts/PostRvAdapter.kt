package dev.alinda.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.alinda.myposts.databinding.ActivityMainBinding
import dev.alinda.myposts.databinding.PostrecyclerBinding
import retrofit2.http.Body

class PostRvAdapter(var context: Context, var post: List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       var binding =PostrecyclerBinding
           .inflate(LayoutInflater.from(context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = post.get(position)
        with(holder.binding){
            tvUserid2.text = currentPost.userId.toString()
            tvId2.text = currentPost.id.toString()
            tvTitle2.text = currentPost.title
            tvBody2.text= currentPost.body

        }
    }
    override fun getItemCount(): Int {
      return post.size
    }
}
class PostViewHolder(var binding: PostrecyclerBinding):RecyclerView.ViewHolder(binding.root){
//    var tvUserid= itemView.findViewById<TextView>(R.id.tvUserid)
//    var tvUserid2= itemView.findViewById<TextView>(R.id.tvUserid2)
//    var tvId= itemView.findViewById<TextView>(R.id.tvId2)
//    var tvId2= itemView.findViewById<TextView>(R.id.tvId2)
//    var tvTitle= itemView.findViewById<TextView>(R.id.tvTitle)
//    var tvTitle2= itemView.findViewById<TextView>(R.id.tvTitle2)
//    var Body=  itemView.findViewById<TextView>(R.id.tvBody)
//    var Body2= itemView.findViewById<TextView>(R.id.tvBody2)
}
