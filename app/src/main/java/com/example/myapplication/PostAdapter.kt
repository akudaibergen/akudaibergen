package com.example.myapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Movie

class PostAdapter (
    val mContext: Context,
    var list: List<Movie>? = null,
    var itemClickListener:RecyclerViewItemClick
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
                val tvTitle = view.findViewById<TextView>(R.id.tvTitle)

                val  tvGenre = view.findViewById<TextView>(R.id.genreOfMovie)
                val tvReleaseDate = view.findViewById<TextView>(R.id.releaseDateOfMovie)
                val  tvImage = view.findViewById<TextView>(R.id.imageOfMovie)
                val  tvBody = view.findViewById<TextView>(R.id.bodyOfMovie)
                val  tvYearOfMovie = view.findViewById<TextView>(R.id.yearOfMovie)
                val   tvActors = view.findViewById<TextView>(R.id.actorsOfMovie)

                tvTitle.text = post?.title
                tvReleaseDate.text = post?.id.toString()
                tvImage.text = post?.image.toString()
                tvBody.text = post?.body.toString()
                tvYearOfMovie.text = post?.year.toString()
                tvActors.text = post?.actors.toString()


                view.setOnClickListener {
                    itemClickListener?.itemClick(adapterPosition, post!!)
                }
            }
        }

        interface RecyclerViewItemClick {

            fun itemClick(position: Int, item: Movie)
        }
    }