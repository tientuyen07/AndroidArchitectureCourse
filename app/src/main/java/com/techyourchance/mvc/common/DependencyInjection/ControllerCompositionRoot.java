package com.techyourchance.mvc.common.DependencyInjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;

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

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }
}
