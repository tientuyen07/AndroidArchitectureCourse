package com.techyourchance.mvc;

import android.app.Application;

import com.techyourchance.mvc.common.DependencyInjection.CompositionRoot;

public class CustomApplication extends Application {
    private CompositionRoot compositionRoot;

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot = new CompositionRoot();
    }
}
