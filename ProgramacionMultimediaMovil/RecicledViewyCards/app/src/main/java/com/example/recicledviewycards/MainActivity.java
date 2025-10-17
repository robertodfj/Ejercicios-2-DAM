package com.example.recicledviewycards;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ItemModel> itemList;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.reciclerview);

        // Datos de ejemplo
        itemList = new ArrayList<>();
        itemList.add(new ItemModel("Título 1", "Descripción 1"));
        itemList.add(new ItemModel("Título 2", "Descripción 2"));
        itemList.add(new ItemModel("Título 3", "Descripción 3"));
        itemList.add(new ItemModel("Título 4", "Descripción 4"));
        itemList.add(new ItemModel("Título 1", "Descripción 1"));
        itemList.add(new ItemModel("Título 2", "Descripción 2"));
        itemList.add(new ItemModel("Título 3", "Descripción 3"));
        itemList.add(new ItemModel("Título 4", "Descripción 4"));
        itemList.add(new ItemModel("Título 1", "Descripción 1"));
        itemList.add(new ItemModel("Título 2", "Descripción 2"));
        itemList.add(new ItemModel("Título 3", "Descripción 3"));
        itemList.add(new ItemModel("Título 4", "Descripción 4"));
        itemList.add(new ItemModel("Título 1", "Descripción 1"));
        itemList.add(new ItemModel("Título 2", "Descripción 2"));
        itemList.add(new ItemModel("Título 3", "Descripción 3"));
        itemList.add(new ItemModel("Título 4", "Descripción 4"));
        itemList.add(new ItemModel("Título 1", "Descripción 1"));
        itemList.add(new ItemModel("Título 2", "Descripción 2"));
        itemList.add(new ItemModel("Título 3", "Descripción 3"));
        itemList.add(new ItemModel("Título 4", "Descripción 4"));
        itemList.add(new ItemModel("Título 1", "Descripción 1"));
        itemList.add(new ItemModel("Título 2", "Descripción 2"));
        itemList.add(new ItemModel("Título 3", "Descripción 3"));
        itemList.add(new ItemModel("Título 4", "Descripción 4"));

        // Adapter
        adapter = new ItemAdapter(itemList);

        // RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

