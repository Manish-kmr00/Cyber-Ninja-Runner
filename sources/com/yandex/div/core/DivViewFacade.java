package com.yandex.div.core;

import android.content.res.Configuration;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.yandex.div.DivDataTag;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.DivViewState;
import com.yandex.div.internal.widget.menu.OverflowMenuSubscriber;
import com.yandex.div.json.expressions.ExpressionResolver;

/* JADX INFO: loaded from: classes7.dex */
public interface DivViewFacade {
    void addLoadReference(LoadReference loadReference, View view);

    default void cancelTooltips() {
    }

    void cleanup();

    void clearSubscriptions();

    void dismissPendingOverflowMenus();

    DivViewConfig getConfig();

    DivViewState getCurrentState();

    long getCurrentStateId();

    DivDataTag getDivTag();

    View getView();

    void handleUri(Uri uri);

    boolean hasScrollableViewUnder(MotionEvent motionEvent);

    default void hideTooltip(String str) {
    }

    void onConfigurationChangedOutside(Configuration configuration);

    void resetToInitialState();

    void setConfig(DivViewConfig divViewConfig);

    default void showTooltip(String str) {
    }

    void subscribe(OverflowMenuSubscriber.Listener listener);

    void switchToInitialState();

    void switchToState(long j, boolean z);

    default void switchToState(long j) {
        switchToState(j, true);
    }

    default void switchToState(DivStatePath divStatePath, boolean z) {
        switchToState(divStatePath.getTopLevelStateId(), z);
    }

    default ExpressionResolver getExpressionResolver() {
        return ExpressionResolver.EMPTY;
    }

    default void showTooltip(String str, boolean z) {
        showTooltip(str);
    }
}
