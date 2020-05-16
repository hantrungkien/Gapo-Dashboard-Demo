package com.kienht.gapo.dashboard.di

import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
import com.kienht.gapo.dashboard.DashboardActivity
import com.kienht.gapo.dashboard.data.di.DashboardDataModule
import com.kienht.gapo.shared.FeatureScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
@FeatureScope
@Component(
    modules = [DashboardModule::class, DashboardDataModule::class],
    dependencies = [CoreComponent::class]
)
interface DashboardComponent : AndroidInjector<DashboardActivity> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance dashboardActivity: DashboardActivity
        ): DashboardComponent
    }
}

fun DashboardActivity.inject() {
    DaggerDashboardComponent
        .factory()
        .create(coreComponent(), this)
        .inject(this)
}