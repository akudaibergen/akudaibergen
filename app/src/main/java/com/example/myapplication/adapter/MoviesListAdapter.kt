package com.example.myapplication.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Movie

class MoviesListAdapter(
    internal var moviesList: MutableList<Movie>,
    private val listener: ItemClickListener?,
    private val fragmentButtonListener: FragmentButtonListener?,
    private val fragmentLikeListener: FragmentLikeListener?
) : RecyclerView.Adapter<MoviesListAdapter.MoviesViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, null, false)
        val params = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.setLayoutParams(params)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {


        val movies = moviesList[getItemViewType(position)]
        holder.author.setText(movies.actors)
//        val s = "<b>" + news.getAuthor() + "</b>" + " " + news.getData()
//        holder.data.text = Html.fromHtml(s)
//
//        Glide.with(holder.image.context).load(news.getImage()).into(holder.image)
//        Glide.with(holder.logo.context).load(news.getLogo()).into(holder.logo)
//        holder.likeCnt.text = "Нравится: " + news.getLikesCnt()
//        holder.comment.text = "Посмотреть все (30)"
//
//        if (news.getHeart() === true)
//            holder.likeBtn.setImageResource(R.drawable.hearted)
//        else
//            holder.likeBtn.setImageResource(R.drawable.heart)

//        holder.likeBtn.setOnClickListener { v ->
//            Toast.makeText(v.context, "Like", Toast.LENGTH_SHORT).show()

//            if (fragmentButtonListener != null) {
//                if (!movies.getHeart()) {
//                    holder.likeBtn.setImageResource(R.drawable.hearted)
//                    fragmentButtonListener.myClick(news, 1)
//                    movies.setheart(true)
//
//                } else {
//                    holder.likeBtn.setImageResource(R.drawable.heart)
//
//                    fragmentLikeListener!!.removeItemLike(news)
//                    movies.setheart(false)
//                }
//            }
//        }


//        holder.itemView.setOnClickListener {
//            listener?.itemClick(position, movies)
//        }

    }

    override fun getItemCount(): Int {
        return 100
    }

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // internal var logo: ImageView
        internal var author: TextView
//        internal var image: ImageView
//        internal var data: TextView
//        internal var likeCnt: TextView
//        internal var comment: TextView
        internal var likeBtn: ImageButton

        init {
           // logo = itemView.findViewById(R.id.logo)
            author = itemView.findViewById(R.id.tvUserId)
//            image = itemView.findViewById(R.id.image)
//            data = itemView.findViewById(R.id.data)
//            likeCnt = itemView.findViewById(R.id.likes)
//            comment = itemView.findViewById(R.id.comments)
            likeBtn = itemView.findViewById(R.id.tvPostId)
        }
    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: Movie)

    }

    interface FragmentLikeListener {
        fun removeItemLike(news: Movie)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun removeLike(news: Movie) {
        //        val n = News.newsList.indexOf(news)
//        news.setHeart(false)
//        news.setLikeBtn(R.drawable.heart)
//        News.newsList.set(n, news)
//        newsList[n] = news
//
//        this.notifyItemChanged(n)
    }

    interface FragmentButtonListener {
        fun myClick(news: Movie, option: Int)
    }

}
