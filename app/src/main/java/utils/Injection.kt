package utils

import source.remote.RemoteDataSourceImpl
import source.remote.repository.movie.MovieRepositoryImpl
import source.remote.repository.tv.TvRepositoryImpl

object Injection {

    fun provideRepository(): MovieRepositoryImpl {

        val remoteDataSource = RemoteDataSourceImpl.getInstance()

        return MovieRepositoryImpl.getInstance(remoteDataSource)
    }

    fun provideTvRepository(): TvRepositoryImpl {
        val remoteDataSource = RemoteDataSourceImpl.getInstance()

        return TvRepositoryImpl.getInstance(remoteDataSource)
    }
}