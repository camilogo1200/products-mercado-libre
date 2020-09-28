package com.mercadolibre.camilogo1200.products.util

/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.fragment.app.Fragment
import com.mercadolibre.camilogo1200.products.application.ProductsApplication
import com.mercadolibre.camilogo1200.products.ui.viewmodels.ViewModelFactory

/**
 * Extension functions for Fragment.
 * @since 1.0.0
 */
fun Fragment.getViewModelFactory(): ViewModelFactory {
    val application = (requireActivity().application) as ProductsApplication
    return ViewModelFactory(application)
}
