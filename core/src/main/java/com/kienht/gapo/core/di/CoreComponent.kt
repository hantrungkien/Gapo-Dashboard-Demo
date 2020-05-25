package com.kienht.gapo.core.di

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.kienht.gapo.core.di.module.ConstantsModule
import com.kienht.gapo.core.di.module.CoreModule
import com.kienht.gapo.core.di.module.ExecutorModule
import com.kienht.gapo.shared.qualifier.CoDispatcherDefaultQualifier
import com.kienht.gapo.shared.qualifier.CoDispatcherIOQualifier
import com.kienht.gapo.shared.qualifier.CoDispatcherMainQualifier
import com.kienht.gapo.shared.qualifier.DebugModeQualifier
import com.kienht.gapo.shared.qualifier.RxSchedulerComputation
import com.kienht.gapo.shared.qualifier.RxSchedulerIO
import com.kienht.gapo.shared.qualifier.RxSchedulerMain
import com.squareup.moshi.Moshi
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import io.reactivex.Scheduler
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient

/**
 * @author kienht
 */
interface CoreComponentProvider {
    fun provideCoreComponent(): CoreComponent
}

fun Activity.coreComponent() =
    (applicationContext as? CoreComponentProvider)?.provideCoreComponent()
        ?: throw IllegalStateException("CoreComponentProvider not implemented: $applicationContext")

fun Fragment.coreComponent() = requireActivity().coreComponent()

@Singleton
@Component(
    modules = [CoreModule::class, ConstantsModule::class, ExecutorModule::class]
)
interface CoreComponent : AndroidInjector<CoreApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            constantsModule: ConstantsModule,
            @BindsInstance coreApplication: CoreApplication
        ): CoreComponent
    }

    val application: Application

    val okHttpClient: OkHttpClient

    val moshi: Moshi

    @DebugModeQualifier
    fun provideDebugMode(): Boolean

    @RxSchedulerIO
    fun provideSchedulerIO(): Scheduler

    @RxSchedulerComputation
    fun provideRxSchedulerComputation(): Scheduler

    @RxSchedulerMain
    fun provideSchedulerMain(): Scheduler

    @CoDispatcherIOQualifier
    fun provideDispatcherIO(): CoroutineDispatcher

    @CoDispatcherDefaultQualifier
    fun provideDispatcherDefault(): CoroutineDispatcher

    @CoDispatcherMainQualifier
    fun provideDispatcherMain(): CoroutineDispatcher
}
