package upeu.edu.pe.Conn;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dante Cunurana M on 27/04/2015.
 */
public abstract class DBConn extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbupeu.db";

    public DBConn(Context context, String name, SQLiteDatabase.CursorFactory factory,DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, factory, 2);
    }

}
