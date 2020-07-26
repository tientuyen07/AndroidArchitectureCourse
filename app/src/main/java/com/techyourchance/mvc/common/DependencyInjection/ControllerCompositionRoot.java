package com.techyourchance.mvc.common.DependencyInjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.techyourchance.mvc.networking.StackoverflowApi;

public class ControllerCompositionRoot {
    private final CompositionRoot compositionRoot;
    private final Activity activity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        this.compositionRoot = compositionRoot;
        this.activity = activity;
    }

    public StackoverflowApi getStackoverflowApi() {
        return compositionRoot.getStackoverflowApi();
    }

    public LayoutInflater getLayoutInflater() {
        return activity.getLayoutInflater();
    }
}
