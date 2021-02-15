package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.andikas.moviecatalogapp.FakeContent
import com.dicoding.andikas.moviecatalogapp.data.MovieRepository
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var tvShowViewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<TvShow>>

    @Before
    fun setup() {
        tvShowViewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = FakeContent.generateDummyTvShows()
        val tvShow = MutableLiveData<List<TvShow>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(movieRepository.getTvShow()).thenReturn(tvShow)
        val tvShowEntity = tvShowViewModel.getTvShow().value
        verify(movieRepository).getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(20, tvShowEntity?.size)

        movieRepository.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}