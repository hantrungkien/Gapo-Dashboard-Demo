package com.kienht.gapo.core.di.module

import com.kienht.gapo.shared.qualifier.*
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * @author kienht
 * @company OICSoft
 * @since 25/09/2019
 */
@Module
class ExecutorModule {

    @Provides
    @Singleton
    @RxSchedulerIO
    internal fun provideSchedulerIO(): Scheduler = Schedulers.io()

    @Provides
    @Singleton
    @RxSchedulerComputation
    internal fun provideSchedulerComputation(): Scheduler = Schedulers.computation()

    @Provides
    @Singleton
    @RxSchedulerMain
    internal fun provideSchedulerMain(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    @CoDispatcherIOQualifier
    internal fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    @CoDispatcherDefaultQualifier
    internal fun provideDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Singleton
    @CoDispatcherMainQualifier
    internal fun provideDispatcherMain(): CoroutineDispatcher = Dispatchers.Main

}