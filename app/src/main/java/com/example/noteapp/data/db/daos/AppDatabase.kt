import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.data.db.daos.daos.NoteDao

@Database(entities = [NoteModel:: class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun noteDao(): NoteDao
}