package utils

import android.content.Context
import source.remote.RemoteDataSource
import source.remote.repository.movie.MovieRepository

object Injection {

    fun provideRepository(context: Context): MovieRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieRepository.getInstance(remoteDataSource)
    }
}