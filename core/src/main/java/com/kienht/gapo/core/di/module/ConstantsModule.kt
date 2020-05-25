package com.kienht.gapo.core.di.module

import com.kienht.gapo.shared.qualifier.ApplicationIdQualifier
import com.kienht.gapo.shared.qualifier.DebugModeQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import org.jetbrains.annotations.NotNull

/**
 * @author kienht
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
