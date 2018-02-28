package com.williamgdev.example.mvvmdesign;


import android.databinding.BaseObservable;

import com.williamgdev.example.mvvmdesign.databinding.ActivityMainBinding;

public class MainViewModel extends BaseObservable {
    private ActivityMainBinding binding;

    public MainViewModel(ActivityMainBinding binding) {
        this.binding = binding;
        init();
    }

    private void init() {
        binding.button.setOnClickListener(v -> {
            binding.txt.setText("Hello");
        });
    }
}
