package com.example.myapplication.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Movie


class LikedListAdapter internal constructor(
     val moviesList: List<Movie>, listener: ItemClickListener?,
     val fragmentLikeListener: FragmentLikeListener?
) : RecyclerView.Adapter<LikedListAdapter.LikedNewsViewHolder>() {
    private val hearted = false
    private val listener: LikedListAdapter.ItemClickListener?

    init {
        this.listener = listener


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedNewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, null, false)
        val params = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.setLayoutParams(params)
        return LikedNewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: LikedNewsViewHolder, position: Int) {

        val movies = moviesList[getItemViewType(position)]
        holder.author.setText(movies.actors)

        holder.likeBtn.setOnClickListener {
            fragmentLikeListener?.removeItemLike(movies)
        }

        holder.itemView.setOnClickListener {
            listener?.itemClick(position, movies)
        }
    }


    override fun getItemCount(): Int {
        return moviesList.size
    }

    inner class LikedNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        internal var logo: ImageView
        internal var author: TextView
//        internal var image: ImageView
//        internal var data: TextView
//        internal var likeCnt: TextView
//        internal var comment: TextView
       internal var likeBtn: ImageButton

        init {
//            logo = itemView.findViewById(R.id.logo)
            author = itemView.findViewById(R.id.tvPostId)
//            image = itemView.findViewById(R.id.image)
//            data = itemView.findViewById(R.id.data)
//            likeCnt = itemView.findViewById(R.id.likes)
//            comment = itemView.findViewById(R.id.comments)
            likeBtn = itemView.findViewById(R.id.tvUserId)
        }
    }

    internal interface ItemClickListener {
        fun itemClick(position: Int, item: Movie)

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface FragmentLikeListener {
        fun removeItemLike(movies: Movie)
    }


}