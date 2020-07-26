package com.techyourchance.mvc.screens.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableViewMvc<ListenerType>
        extends BaseViewMvc implements ObservableViewMvc<ListenerType> {
    private Set<ListenerType> mListenerTypes = new HashSet<>();

    @Override
    public void registerListener(ListenerType listenerType) {
        mListenerTypes.add(listenerType);
    }

    @Override
    public void unregisterListener(ListenerType listenerType) {
        mListenerTypes.remove(listenerType);
    }

    protected Set<ListenerType> getListener() {
        return Collections.unmodifiableSet(mListenerTypes);
    }
}
