package com.mega025.palabraroom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Palabra.class}, version = 1, exportSchema = false)
public abstract class PalabraDB extends RoomDatabase{

    // Declaración de DAO (contiene los metodos  para realizar operaciones  en las tablas de base de datos (insertar,eliminar,actualizar,etc))
    public abstract PalabraDAO palabraDAO();
    //Los cambios que se hacen son visibles para todos los hilos
    private static  volatile  PalabraDB INSTANCE;
    // cuantos hilos tendra para trabajar
    private  static  final  int NUMBER_OF_THREADS = 4;
    // Asegurar que va a ver los 4 hilos que se predetermino
    static  final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    //Metodo que asegura que solo se crea una instancia  de palabraDB
    static  PalabraDB getDatabase ( final Context context){
        //si es null  se sincronizan para que solo 1 hilo cree la isntancia
        if (INSTANCE == null){
            synchronized (PalabraDB.class){
                if (INSTANCE == null){
                    // databaseBuilder para crear la base de datos y se pasa el contexto para ser independiente  de otro actividad
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            // name es el nombre de la base de datos
                            PalabraDB.class, "palabras_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
