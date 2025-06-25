package com.andef.myfinance.di

import android.app.Application
import com.andef.myfinance.MainActivity
import com.andef.myfinance.ViewModelFactory
import com.andef.myfinance.di.expense.ExpenseDaoModule
import com.andef.myfinance.di.expense.ExpenseRepositoryModule
import com.andef.myfinance.di.income.IncomeDaoModule
import com.andef.myfinance.di.income.IncomeRepositoryModule
import com.andef.myfinance.di.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        //viewmodel
        ViewModelModule::class,
        //expense
        ExpenseRepositoryModule::class,
        ExpenseDaoModule::class,
        //income
        IncomeRepositoryModule::class,
        IncomeDaoModule::class
    ]
)
interface MyFinanceComponent {
    fun inject(mainActivity: MainActivity)

    val viewModelFactory: ViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): MyFinanceComponent
    }
}