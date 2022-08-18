package dev.alinda.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.alinda.myposts.databinding.CommentsListItemBinding
import dev.alinda.myposts.databinding.PostrecyclerBinding

class CommentRvAdapter ( var commentList: List<Comment>): RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = CommentsListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentcomment = commentList.get(position)



        with(holder.binding) {
            holder.binding.tvPostidnumber.text = currentcomment.postId.toString()
            holder.binding.tvidnumber.text = currentcomment.id.toString()
            holder.binding.tvnamedetail.text = currentcomment.name
            holder.binding.tvemaildetail.text = currentcomment.body
            holder.binding.tvbodydetail.text = currentcomment.body
//            holder.binding.cvComments.setOnClickListener {
//                //add a holder for the card view you called it tvPost
//
//
//
//                val intent = Intent(holder.itemView.context, CommentsActivity::class.java)
//                intent.putExtra("COMMENT_ID", currentcomment.id)
//                context.startActivity(intent)
//            }


        }
    }
    override fun getItemCount(): Int {
        return commentList.size
    }
}
class CommentViewHolder(var binding: CommentsListItemBinding):RecyclerView.ViewHolder(binding.root){
}
