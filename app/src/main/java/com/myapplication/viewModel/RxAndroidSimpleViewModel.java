package com.myapplication.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import android.view.View;

import com.myapplication.R;
import com.myapplication.databinding.RxSimpleTestBinding;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by Adminidtrator on 2017/9/3.
 */

public class RxAndroidSimpleViewModel extends ViewModel implements View.OnClickListener{
    private Context context;
    private RxSimpleTestBinding binding;

    public RxAndroidSimpleViewModel(Context context, RxSimpleTestBinding binding) {
        this.context = context;
        this.binding = binding;
        onCreate();
    }

    private void onCreate() {
        binding.setEvent(this);
        myObservable.subscribe(myObserver);
    }
    Observable<String> myObservable=Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> e) throws Exception {
            e.onNext("onNext");
            e.onComplete();
        }
    });



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.simple_text:
                break;
            default:
                break;
        }
    }

    /**
     * 在异步任务重myObserver会一直监听MyObservable的内容变化
     */
    Observer<String> myObserver = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String value) {
             binding.simpleText.setText(value);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
}
