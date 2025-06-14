package com.andef.myfinance.data.expense.datasource

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andef.myfinance.data.expense.dbmodel.ExpenseDbModel

/**
 * БД с расходами
 */
@Database(entities = [ExpenseDbModel::class], version = 1, exportSchema = false)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract val dao: ExpenseDao

    companion object {
        private const val DB_NAME = "expense.db"

        private var instance: ExpenseDatabase? = null
        fun getInstance(application: Application): ExpenseDatabase {
            if (instance != null) return instance!!
            synchronized(this) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = application,
                        klass = ExpenseDatabase::class.java,
                        name = DB_NAME
                    ).build()
                }
                return instance!!
            }
        }
    }
}