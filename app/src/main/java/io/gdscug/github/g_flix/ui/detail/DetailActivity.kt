package io.gdscug.github.g_flix.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import io.gdscug.github.g_flix.R
import io.gdscug.github.g_flix.data.MovieEntity
import io.gdscug.github.g_flix.databinding.ActivityDetailBinding
import io.gdscug.github.g_flix.databinding.ContentDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var contentDetail: ContentDetailBinding

    private var data: MovieEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        contentDetail = binding.contentDetail

        val movies = intent.extras
        if (movies != null) {
            data = intent.getParcelableExtra(EXTRA_DETAIL)
            data?.let { populatedMovie(it) }
        }
    }

    private fun populatedMovie(movieEntity: MovieEntity) {
        supportActionBar?.title = movieEntity.movieTitle

        contentDetail.tvRate.text = resources.getString(R.string.rate)
        contentDetail.tvGenre.text = resources.getString(R.string.genre)
        contentDetail.tvRateAge.text = resources.getString(R.string.rate_age)
        contentDetail.tvDesc.text = movieEntity.movieDescription


        Glide.with(this)
            .load(movieEntity.moviePoster)
            .into(binding.ivPosterDetail)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }
}