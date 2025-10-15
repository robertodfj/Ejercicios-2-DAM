package com.example.navegacion;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.navegacion.databinding.ActivityMainBinding;

import com.example.navegacion.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ejemplo de uso
        binding.navegador.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.fragmentHome:
                    replaceFragment(new FragmentHome());
                    break;
                case R.id.fragmentProfile:
                    replaceFragment(new FragmentProfile());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor, fragment)
                .commit();
    }
}