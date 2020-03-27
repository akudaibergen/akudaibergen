package com.example.myapplication.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Movie

class PostAdapter (
    val mContext: Context,
    var list: List<Movie>? = null
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
            val view = LayoutInflater.from(p0.context).inflate(R.layout.item_post, p0, false)
            return PostViewHolder(view)
        }

        override fun getItemCount(): Int = list?.size ?: 0

        override fun onBindViewHolder(viewHolder: PostViewHolder, i: Int) {
            viewHolder.bind(list?.get(i))
        }

    fun clearAll(){
        (list as? ArrayList<Movie>)?.clear()
                notifyDataSetChanged()
    }

        inner class PostViewHolder(val view: View): RecyclerView.ViewHolder(view) {

            fun bind(post: Movie?) {
//                val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
//                val tvPostId = view.findViewById<TextView>(R.id.tvPostId)
//                val tvUserId = view.findViewById<TextView>(R.id.tvUserId)
//
//                tvTitle.text = post?.title
//                tvPostId.text = post?.id.toString()
//                tvUserId.text = post?.userId.toString()

//                view.setOnClickListener {
//                    itemClickListener?.itemClick(adapterPosition, post!!)
//                }
            }
        }

        interface RecyclerViewItemClick {

            fun itemClick(position: Int, item: Movie)
        }
    }