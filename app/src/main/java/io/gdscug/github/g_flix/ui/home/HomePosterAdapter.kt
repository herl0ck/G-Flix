package io.gdscug.github.g_flix.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.gdscug.github.g_flix.R
import io.gdscug.github.g_flix.data.MovieEntity
import io.gdscug.github.g_flix.databinding.ItemsPosterBinding

class HomePosterAdapter : RecyclerView.Adapter<HomePosterAdapter.HomeForYouViewHolder>() {

    private lateinit var binding: ItemsPosterBinding

    var onItemClickCallback: OnItemClickCallback? = null

    private val listMovie = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies.isNullOrEmpty()) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeForYouViewHolder {
        binding = ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeForYouViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeForYouViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie) {
            onItemClickCallback?.onItemClicked(movie)
        }
    }

    override fun getItemCount(): Int = listMovie.size

    class HomeForYouViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity, onItemClicked: () -> Unit) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(movie.moviePoster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_broken_image)
                    .centerCrop()
                    .into(ivPoster)

                itemView.setOnClickListener { onItemClicked.invoke() }
            }
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(movie: MovieEntity)
    }
}