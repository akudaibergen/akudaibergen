package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter (
    var list: List<Movie>? = null,
    val itemClickListener: RecyclerViewItemClick? = null
) : RecyclerView.Adapter<MovieAdapter.PostViewHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
            val view = LayoutInflater.from(p0.context).inflate(R.layout.item_post, p0, false)
            return PostViewHolder(view)
        }

        override fun getItemCount(): Int = list?.size ?: 0

        override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
            p0.bind(list?.get(p1))
        }

    fun clearAll(){
        (list as? ArrayList<Movie>)?.clear()
                notifyDataSetChanged()
    }

        inner class PostViewHolder(val view: View): RecyclerView.ViewHolder(view) {

            fun bind(post: Movie?) {
                val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
                val tvPostId = view.findViewById<TextView>(R.id.tvPostId)
                val tvUserId = view.findViewById<TextView>(R.id.tvUserId)

                tvTitle.text = post?.title
                tvPostId.text = post?.id.toString()

                view.setOnClickListener {
                    itemClickListener?.itemClick(adapterPosition, post!!)
                }
            }
        }

        interface RecyclerViewItemClick {

            fun itemClick(position: Int, item: Movie)
        }
    }