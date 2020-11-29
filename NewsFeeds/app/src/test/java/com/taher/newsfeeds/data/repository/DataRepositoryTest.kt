package com.taher.newsfeeds.data.repository

import com.taher.newsfeeds.data.model.Article
import org.junit.Test

import org.junit.Assert.*
//import org.kodein.di.Kodein
import java.util.*

class DataRepositoryTest {

//    private val testKodein = Kodein { }
//
//    private val associatedPressArticlesList = arrayListOf(
//        Article("1", "1", "1", "1", "1", Date()),
//        Article("2", "2", "2", "2", "2", Date()),
//        Article("3", "3", "3", "3", "3", Date())
//    )
//    private val theNextWebArticlesList = arrayListOf(
//        Article("4", "4", "4", "4", "4", Date()),
//        Article("5", "5", "5", "5", "5", Date()),
//        Article("6", "6", "6", "6", "6", Date())
//    )
//
//    @Test
//    fun combineArticlesTest1() {
//
//        val associatedPressArticlesData = DataWrapper.Loading<List<Article>>()
//        val theNextWebArticlesData = DataWrapper.Loading<List<Article>>()
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertNull(resultData)
//    }
//
//    @Test
//    fun combineArticlesTest2() {
//
//        val associatedPressArticlesData = DataWrapper.Success<List<Article>>(associatedPressArticlesList)
//        val theNextWebArticlesData = DataWrapper.Loading<List<Article>>()
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertNull(resultData)
//    }
//
//    @Test
//    fun combineArticlesTest3() {
//
//        val associatedPressArticlesData = DataWrapper.Loading<List<Article>>()
//        val theNextWebArticlesData = DataWrapper.Success<List<Article>>(theNextWebArticlesList)
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertNull(resultData)
//    }
//
//    @Test
//    fun combineArticlesTest4() {
//
//        val associatedPressArticlesData = DataWrapper.Success<List<Article>>(associatedPressArticlesList)
//        val theNextWebArticlesData = DataWrapper.Success<List<Article>>(theNextWebArticlesList)
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertEquals(resultData?.data?.count(), 6)
//    }
//
//    @Test
//    fun combineArticlesTest5() {
//
//        val associatedPressArticlesData = DataWrapper.Error<List<Article>>()
//        val theNextWebArticlesData = DataWrapper.Loading<List<Article>>()
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertNull(resultData)
//    }
//
//    @Test
//    fun combineArticlesTest6() {
//
//        val associatedPressArticlesData = DataWrapper.Loading<List<Article>>()
//        val theNextWebArticlesData = DataWrapper.Error<List<Article>>()
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertNull(resultData)
//    }
//
//    @Test
//    fun combineArticlesTest7() {
//
//        val associatedPressArticlesData = DataWrapper.Success<List<Article>>(associatedPressArticlesList)
//        val theNextWebArticlesData = DataWrapper.Error<List<Article>>()
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertTrue(resultData is DataWrapper.Error)
//    }
//
//    @Test
//    fun combineArticlesTest8() {
//
//        val associatedPressArticlesData = DataWrapper.Error<List<Article>>()
//        val theNextWebArticlesData = DataWrapper.Success<List<Article>>(theNextWebArticlesList)
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertTrue(resultData is DataWrapper.Error)
//    }
//
//    @Test
//    fun combineArticlesTest9() {
//
//        val associatedPressArticlesData = DataWrapper.Error<List<Article>>()
//        val theNextWebArticlesData = DataWrapper.Error<List<Article>>()
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertTrue(resultData is DataWrapper.Error)
//    }
//
//    @Test
//    fun combineArticlesTest10() {
//
//        val associatedPressArticlesData = DataWrapper.Success<List<Article>>(arrayListOf())
//        val theNextWebArticlesData = DataWrapper.Success<List<Article>>(arrayListOf())
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertEquals(resultData?.data?.count(), 0)
//    }
//
//    @Test
//    fun combineArticlesTest11() {
//
//        val associatedPressArticlesData = DataWrapper.Success<List<Article>>(associatedPressArticlesList)
//        val theNextWebArticlesData = DataWrapper.Success<List<Article>>(arrayListOf())
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertEquals(resultData?.data?.count(), 3)
//    }
//
//    @Test
//    fun combineArticlesTest12() {
//
//        val associatedPressArticlesData = DataWrapper.Success<List<Article>>(arrayListOf())
//        val theNextWebArticlesData = DataWrapper.Success<List<Article>>(theNextWebArticlesList)
//
//        val dataRepository = DataRepository(testKodein)
//        val resultData = dataRepository.combineArticles(associatedPressArticlesData, theNextWebArticlesData)
//
//        assertEquals(resultData?.data?.count(), 3)
//    }

}