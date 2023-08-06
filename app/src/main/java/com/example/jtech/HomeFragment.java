package com.example.jtech;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements CategoryAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private List<CategoryItem> categoryItemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        categoryItemList = new ArrayList<>();
        // Add your category items to the list here, for example:
        categoryItemList.add(new CategoryItem(R.drawable.pc, "Prebuilt Pcs"));
        categoryItemList.add(new CategoryItem(R.drawable.laptop, "Laptops"));
        categoryItemList.add(new CategoryItem(R.drawable.compuyteracc, "Computer accessories"));
        categoryItemList.add(new CategoryItem(R.drawable.gpu, "Gpu"));
        categoryItemList.add(new CategoryItem(R.drawable.cpu, "Cpu"));
        categoryItemList.add(new CategoryItem(R.drawable.motherboard, "Motherboard"));
        categoryItemList.add(new CategoryItem(R.drawable.ram, "RAM"));
        categoryItemList.add(new CategoryItem(R.drawable.ssd, "SSD"));
        categoryItemList.add(new CategoryItem(R.drawable.hdd, "HDD"));
        categoryItemList.add(new CategoryItem(R.drawable.nvme, "NVME"));
        categoryItemList.add(new CategoryItem(R.drawable.psu, "Power Supply"));
        categoryItemList.add(new CategoryItem(R.drawable.casepc, "Case"));
        // Add more items as needed

        adapter = new CategoryAdapter(getActivity(), categoryItemList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        return rootView;

    }


    public void onItemClick(CategoryItem item) {
        Toast.makeText(getActivity(), item.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), ProductShow.class);
        String categoryChosen = item.getName();
        intent.putExtra("categoryChosen", categoryChosen);
        startActivity(intent);

    }
}
