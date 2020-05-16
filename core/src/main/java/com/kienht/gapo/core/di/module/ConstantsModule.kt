package com.kienht.gapo.core.di.module

import com.kienht.gapo.shared.qualifier.ApplicationIdQualifier
import com.kienht.gapo.shared.qualifier.DebugModeQualifier
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

/**
 * @author kienht
 * @company OICSoft
 * @since 25/09/2019
 */
@Module
class ConstantsModule(
    private val applicationId: String,
    private val isDebug: Boolean
) {

    @Provides
    @Singleton
    @ApplicationIdQualifier
    internal fun provideApplicationId(): String = applicationId

    @Provides
    @Singleton
    @DebugModeQualifier
    @NotNull
    internal fun provideIsDebug(): Boolean = isDebug
}