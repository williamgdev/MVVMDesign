package com.williamgdev.example.mvvmdesign;


import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.williamgdev.example.mvvmdesign.databinding.ActivityMainBinding;

public class MainViewModel extends BaseObservable {
    private ActivityMainBinding binding;
    public static ObservableField<String> message = new ObservableField<>();

    public MainViewModel(ActivityMainBinding binding) {
        this.binding = binding;
        init();
    }

    private void init() {
        binding.button.setOnClickListener(v -> {
            message.set("hello");
        });
    }
}
