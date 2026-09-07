package io.bidmachine.rendering.measurer;

import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.rendering.model.Error;
import java.io.Serializable;

/* JADX INFO: loaded from: classes8.dex */
public interface Measurer<ViewType extends View> extends Serializable {
    void destroy(Runnable postback);

    void onClicked();

    void onError(Error error);

    void onShown();

    void onViewAddedToContainer(ViewType viewType, ViewGroup container);

    void onViewCreated(ViewType viewType);

    void onViewReady(ViewType viewType);
}
