package com.maintain.utcwh.viewmodel

import android.content.Context
import android.os.Looper
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.maintain.utcwh.api.FakeApiService
import com.maintain.utcwh.data.bodies.User
import com.maintain.utcwh.data.repository.ApiRepository
import com.maintain.utcwh.domain.SampleUseCase
import com.maintain.utcwh.presentation.State
import com.maintain.utcwh.presentation.mainUi.MainActivityViewModel
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import junit.framework.Assert.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import javax.inject.Inject


@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [25], application = HiltTestApplication::class)
@ExperimentalCoroutinesApi
@LooperMode(LooperMode.Mode.PAUSED)
class HomeViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiRepository: ApiRepository

    @BindValue
    @JvmField
    val fakeApiService: FakeApiService = FakeApiService(InstrumentationRegistry.getInstrumentation().context)

    lateinit var instrumentationContext: Context

    @Mock
    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
        mainActivityViewModel = MainActivityViewModel(apiRepository)
    }

    @Test
    fun `test User data success`() = runBlockingTest {
        mainActivityViewModel.loadUserData()
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val value = mainActivityViewModel.userFlow.value
        assertTrue(value is State.Success)
        assertNotNull(value.data)
        val propertiesJson = value.data?.get(0)
        assertEquals(1, propertiesJson?.id)
        assertEquals("Leanne Graham", propertiesJson?.name)
    }

    @Test
    fun `test User data api failure`() = runBlockingTest {
        fakeApiService.failUserApi = true
        mainActivityViewModel.loadUserData()
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val value = mainActivityViewModel.userFlow.value
        assertTrue(value is State.Error)
        assertNull(value.data)
    }

    @Test
    fun `test User wrong data`() = runBlockingTest {
        fakeApiService.wrongResponse = true
        mainActivityViewModel.loadUserData()
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val value = mainActivityViewModel.userFlow.value
        assertTrue(value is State.Success)
        assertNotNull(value.data)
        assertEquals(ArrayList<User>(), value.data)
    }

}