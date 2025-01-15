package com.mega025.palabraroom;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

        LiveData<List<Palabra>> palabraEvent;
        private PalabraViewModel palabraViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView palabraRecycleView = findViewById(R.id.Palabra);

        final PalabraRVAdapter adapter = new PalabraRVAdapter(new PalabraRVAdapter.WordDiff());
        palabraRecycleView.setAdapter(adapter);
        palabraRecycleView.setLayoutManager(new LinearLayoutManager(this));

        palabraViewModel = new ViewModelProvider(this).get(PalabraViewModel.class);
        palabraViewModel.getPalabra().observe(this, palabras ->
                adapter.submitList(palabras));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NuevaPalabra.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Palabra word = new Palabra(data.getStringExtra(NuevaPalabra.EXTRA_REPLY));
            palabraViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                   " No se guardo",
                    Toast.LENGTH_LONG).show();
        }
    }
}