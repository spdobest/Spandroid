package spandroid.dev.sqlcipher

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.sqlcipher.database.SQLiteDatabase
import spandroid.dev.R
import spandroid.dev.kotlin.weather_forecast.weatherApp.ui.activities.MainActivity
import spandroid.dev.sqlcipher.db.FeedReaderContract
import spandroid.dev.sqlcipher.db.FeedReaderDbHelper



class SqlCipherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_cipher)

        SQLiteDatabase.loadLibs(this)

        insertSthToDb()

    }

    private fun insertSthToDb() {
        val db = FeedReaderDbHelper.getInstance(this).getWritableDatabase("somePass")

        val values = ContentValues()
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, 1)
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "Easter Bunny has escaped!")
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "A thrilling story which proves how fragile our hearts are...")

        db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)

        val cursor = db.rawQuery("SELECT * FROM '" + FeedReaderContract.FeedEntry.TABLE_NAME + "';", null)
        Log.d(MainActivity::class.java.simpleName, "Rows count: " + cursor.count)
        cursor.close()
        db.close()

        // this will throw net.sqlcipher.database.SQLiteException: file is encrypted or is not a database: create locale table failed
        //db = FeedReaderDbHelper.getInstance(this).getWritableDatabase("");
    }

}
