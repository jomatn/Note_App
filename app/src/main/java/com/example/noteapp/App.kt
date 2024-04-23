package com.example.noteapp
import AppDatabase
import android.app.Application
import androidx.room.Room
import com.example.noteapp.data.Pref

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = Pref
        sharedPreferences.unit(this)
        appDatabase = getInstance()
    }

    private fun getInstance(): AppDatabase? {
        if (appDatabase === null){
            appDatabase = applicationContext.let{
                Room.databaseBuilder(
                    it,
                    AppDatabase:: class.java,
                    "note.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDatabase
    }

    companion object{
        var appDatabase:AppDatabase? = null
    }
}