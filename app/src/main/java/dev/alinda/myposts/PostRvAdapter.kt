package dev.alinda.myposts

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.alinda.myposts.databinding.ActivityMainBinding
import dev.alinda.myposts.databinding.PostrecyclerBinding
import retrofit2.http.Body

class PostRvAdapter( var postList: List<Post>):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = PostrecyclerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = postList.get(position)

        var context= holder.itemView.context

            with(holder.binding) {
            holder.binding.tvUserid2.text = currentPost.userId.toString()
            holder.binding.tvId2.text = currentPost.id.toString()
            holder.binding.tvTitle2.text = currentPost.title
            holder.binding.tvBody2.text = currentPost.body
            holder.binding.tvPost.setOnClickListener {
             //add a holder for the card view you called it tvPost
                val intent = Intent(holder.itemView.context, CommentsActivity::class.java)
                intent.putExtra("POST_ID", currentPost.id)
                context.startActivity(intent)
            }


        }
    }
        override fun getItemCount(): Int {
            return postList.size
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
