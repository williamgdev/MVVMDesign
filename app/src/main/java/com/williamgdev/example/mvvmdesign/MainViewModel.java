package com.williamgdev.example.mvvmdesign;


import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.williamgdev.example.mvvmdesign.databinding.ActivityMainBinding;

import io.reactivex.Observable;

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
//        Observable.timer(3, TimeUnit.SECONDS)
//                .subscribe(aLong -> {
//                    hide.set(true);
//                }, throwable -> {}, () -> {});
        binding.button.setOnClickListener(v -> {
            url.set("SHOW");
            hide.set(true);
            getText()
                    .subscribe(text -> {
                message.set(text);
            });
        });
    }

    @BindingAdapter("ImageAdapter")
    public static void changeImage(ImageView imageView, ObservableField<String> url) {
        if(!url.get().equalsIgnoreCase("OK")) {
            imageView.setImageResource(R.mipmap.ic_launcher_round);
        }
    }

    private Observable<String> getText() {
        return Observable.create(emitter -> {
            // write your code
            emitter.onNext("Welcome");
            // more logic if needed
            emitter.onNext("Welcome Again");
            //handle the exceptions
//            emitter.onError(new Throwable("Error loading the message"));
            //Notify the logic is done
            emitter.onComplete();
        });
    }
}
