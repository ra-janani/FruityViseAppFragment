package com.example.fruityviseapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.fruityvice.repository.Repository
import com.example.fruityviseapp.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import org.junit.Rule
import org.mockito.Mock
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class FruitsViewModelTest{

     private val testDispatcher = StandardTestDispatcher()

     @get:Rule
     val instantTaskExecutorRule = InstantTaskExecutorRule()//it will define coroutine for testing

     @Mock
     lateinit var repository: Repository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)//context of the corouitne we are using for testing
    }


    @Test
    fun test_GetFruits_EmptyList() = runTest{
        Mockito.`when`(repository.getFruits()).thenReturn(arrayListOf())  //we call this fun in repository mockito will return an empty list

        val vm = FruitsViewModel(repository) //creatin an object of viewmodel
        vm.getFruitsData()  //calling the function in viewmodel
        testDispatcher.scheduler.advanceUntilIdle() //it will wait until every coroutine is closed
        val result = vm.fruits.getOrAwaitValue() // getiing data from Livedata after particular time
        Assert.assertEquals(0, result.size) //
    }

    @Test
    fun test_GetFruits_expectedError(): Unit = runTest{
        Mockito.`when`(repository.getFruits()).thenReturn(null)
       // val i=5

        val vm = FruitsViewModel(repository)
        vm.getFruitsData()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = vm.fruits.getOrAwaitValue()
        //val res2=i
        //Assert.assertEquals(true, result )
        Assert.assertEquals(null, result)
    }




    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
 }