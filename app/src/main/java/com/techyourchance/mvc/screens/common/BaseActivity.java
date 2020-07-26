package com.techyourchance.mvc.screens.common;

import android.support.v7.app.AppCompatActivity;

import com.techyourchance.mvc.CustomApplication;
import com.techyourchance.mvc.common.DependencyInjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {
    private ControllerCompositionRoot controllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (controllerCompositionRoot == null) {
            controllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(),
                    this);
        }
        return controllerCompositionRoot;
    }
}
