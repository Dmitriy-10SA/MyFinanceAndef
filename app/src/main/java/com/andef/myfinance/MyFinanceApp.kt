package com.andef.myfinance

import android.app.Application
import com.andef.myfinance.di.DaggerMyFinanceComponent

class MyFinanceApp : Application() {
    val component by lazy {
        DaggerMyFinanceComponent.factory().create(this)
    }
}