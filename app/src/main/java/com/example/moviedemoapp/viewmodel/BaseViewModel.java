package com.example.moviedemoapp.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class BaseViewModel extends ViewModel {

    private MutableLiveData<Boolean> progressDialog = new MutableLiveData<>();
    private MutableLiveData<String> errorMsg = new MutableLiveData<>();

    public MutableLiveData<Boolean> getProgressDialog() {
        return progressDialog;
    }

    public MutableLiveData<String> getErrorMsg() {
        return errorMsg;
    }
}
