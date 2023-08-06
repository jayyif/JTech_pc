package com.example.jtech;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.List;

public class ProductShow extends AppCompatActivity {
    private ImageView btnBackToProductsList;
    private RecyclerView recyclerView;
    private ProductShowAdapter adapter;
    private List<CPU> cpuList;
    private DatabaseReference databaseRef; // Add this line

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_show);
        String choice = getIntent().getExtras().getString("categoryChosen").toLowerCase();
        btnBackToProductsList = findViewById(R.id.btnBackToProductsList);

        FirebaseApp.initializeApp(this);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        cpuList = new ArrayList<>();
        adapter = new ProductShowAdapter(cpuList);
        recyclerView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://sign-up-login-pcjayyif-default-rtdb.firebaseio.com/");
        databaseRef = database.getReference();

        databaseRef.child(choice).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cpuList.clear();
                for (DataSnapshot brandSnapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot modelSnapshot : brandSnapshot.getChildren()) {
                        for (DataSnapshot cpuSnapshot : modelSnapshot.getChildren()) {
                            String modelName = cpuSnapshot.child("Specs").child("Name").getValue(String.class);
                            Specs specs = cpuSnapshot.child("Specs").getValue(Specs.class);
                            CPU cpu = new CPU();
                            cpu.modelName = modelName;
                            cpu.specs = specs;
                            cpuList.add(cpu);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProductShow.this, "Error fetching data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnBackToProductsList.setOnClickListener(v -> {

        });

    }

}