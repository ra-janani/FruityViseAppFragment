package com.example.fruityviseapp.repository

import com.example.fruityvice.remote.ApiRequest
import com.example.fruityvice.repository.RepositoryImpl
import com.example.fruityviseapp.data.FruityViceItemModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RepositoryImplTest {

    @Mock
    lateinit var apiRequest: ApiRequest

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetFruits_EmptyList() = runTest {
        Mockito.`when`(apiRequest.getFruits()).thenReturn(arrayListOf())

        val repo = RepositoryImpl(apiRequest)
        val result = repo.getFruits()
        assertEquals(0, result.size)
    }

    @Test
    fun testGetFruits_expectedFruitsList() = runTest {
        val fruitList: ArrayList<FruityViceItemModel> = arrayListOf()
        fruitList.add(
            FruityViceItemModel(
                "Ebenaceae",
                "Diospyros",
                52,
                "Persimmon",
                null,
                "Rosales"
            )
        )
        fruitList.add(FruityViceItemModel("Rosaceae", "Fragaria", 3, "Strawberry", null, "Rosales"))


        Mockito.`when`(apiRequest.getFruits()).thenReturn(fruitList)

        val repo = RepositoryImpl(apiRequest)
        val result = repo.getFruits()
        assertEquals(2, result.size)
        assertEquals("Diospyros", result[0].genus)
    }

    @Test
    fun testGetFruits_expectedFruitsList_not_match() = runTest {
        val fruitList: ArrayList<FruityViceItemModel> = arrayListOf()
        fruitList.add(
            FruityViceItemModel(
                "testFailed",
                "Diospyros",
                52,
                "Persimmon",
                null,
                "Rosales"
            )
        )
        fruitList.add(FruityViceItemModel("Rosaceae", "Fragaria", 3, "Strawberry", null, "Rosales"))


        Mockito.`when`(apiRequest.getFruits()).thenReturn(fruitList)

        val repo = RepositoryImpl(apiRequest)
        val result = repo.getFruits()
        assertNotEquals(3, result.size)
        //Assert.assertNotEquals("Diospyros", result[0].family)

    }


}