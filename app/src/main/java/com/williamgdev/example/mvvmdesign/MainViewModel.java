package com.williamgdev.example.mvvmdesign;


import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.williamgdev.example.mvvmdesign.databinding.ActivityMainBinding;

public class MainViewModel extends BaseObservable {
    private ActivityMainBinding binding;
    public static ObservableField<String> message = new ObservableField<>("Do something");
    public static ObservableField<String> url = new ObservableField<>("OK");
    public static ObservableField<Boolean> hide = new ObservableField<>();

    public MainViewModel(ActivityMainBinding binding) {
        this.binding = binding;
        init();
    }

    private void init() {
        binding.button.setOnClickListener(v -> {
            message.set("hello");
            url.set("SHOW");
            hide.set(true);
        });
    }

    @BindingAdapter("ImageAdapter")
    public static void changeImage(ImageView imageView, ObservableField<String> url) {
        if(!url.get().equalsIgnoreCase("OK")) {
            imageView.setImageResource(R.mipmap.ic_launcher_round);
        }
    }
}
