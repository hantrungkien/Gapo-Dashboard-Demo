# Gapo-Dashboard-Demo

An app which attempts to use the latest cutting edge libraries and tools.

![gapo-demo](https://github.com/hantrungkien/Gapo-Dashboard-Demo/blob/master/images/gapo_demo.png?raw=true)

![architecture](https://github.com/hantrungkien/Gapo-Dashboard-Demo/blob/master/images/architecture.png?raw=true)

## Architecture

* Modularization by feature.
* Clean Architecture + MVVM.
* Dependency injection with Dagger. It is configured to use for both Library & Dynamic Feature Module.
* Navigating between modules with Deeplink.

## Android Development

* [Kotlin](https://github.com/JetBrains/kotlin)
* [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
* [Dagger2](https://github.com/google/dagger)
* [Jetpack Foundation & UI](https://developer.android.com/jetpack): AndroidX, Material Design, ConstrainsLayout,...
* [JetPack Architecture](https://developer.android.com/jetpack): DataBinding, ViewModel, LiveData, Lifecycle, Navigation
* [Retrofit2](https://github.com/square/retrofit)
* [Moshi](https://github.com/square/moshi/)
* [Glide4](https://github.com/bumptech/glide)
* [Brightcove ExoPlayer2](https://sdks.support.brightcove.com/android/)
* [Deeplink Dispatch](https://github.com/airbnb/DeepLinkDispatch)
* [Auto Dimension](https://github.com/hantrungkien/AutoDimension)

## Use Case

* Instagram/Youtube style navigation using Navigation Component to create [multiple fragment stacks](https://github.com/hantrungkien/Gapo-Dashboard-Demo/blob/master/dashboard/src/main/java/com/kienht/gapo/dashboard/DashboardActivity.kt).

* Login session will be cached [one week](https://github.com/hantrungkien/Gapo-Dashboard-Demo/blob/master/auth-data/src/main/java/com/kienht/gapo/auth/data/source/cache/AuthCacheImpl.kt). Exceeding this time is considered stale.]

* News feeds with multiple types (Stories & Friend Requests & Posts with only text, text + one image, text + one video) is smooth scroll.

* Using [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) to [load News Feeds](https://github.com/hantrungkien/Gapo-Dashboard-Demo/blob/master/dashboard-data/src/main/java/com/kienht/gapo/dashboard/data/repository/DashboardRepositoryImpl.kt). Each time data is successfully loaded from the remote then it will be saved in [local cache](https://github.com/hantrungkien/Gapo-Dashboard-Demo/blob/master/dashboard-data/src/main/java/com/kienht/gapo/dashboard/data/repository/source/cache/DashboardCacheImpl.kt). It is limited to 1 hour.

### LICENCE

    Copyright 2020 Kien Han Trung

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
