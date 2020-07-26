package com.techyourchance.mvc.screens.common;

public interface ObservableViewMvc<ListenerType> extends ViewMvc {
    void registerListener(ListenerType listenerType);

    void unregisterListener(ListenerType listenerType);
}
