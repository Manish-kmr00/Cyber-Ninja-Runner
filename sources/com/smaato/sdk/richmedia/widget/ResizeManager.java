package com.smaato.sdk.richmedia.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.richmedia.mraid.Views;
import com.smaato.sdk.richmedia.util.ViewUtils;

/* JADX INFO: loaded from: classes8.dex */
final class ResizeManager {
    private final ClosableView closableView;
    private Listener listener;
    private final Logger logger;
    private final Rect maxSizeInPx;
    private final View viewToResize;

    public interface Listener {
        void onCloseClicked(ImageButton imageButton);

        void onResizeFailed(String str);

        void onResized(ImageButton imageButton);
    }

    ResizeManager(Logger logger, View view, Rect rect) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.viewToResize = (View) Objects.requireNonNull(view);
        this.maxSizeInPx = (Rect) Objects.requireNonNull(rect);
        ClosableView closableView = new ClosableView(view.getContext());
        this.closableView = closableView;
        closableView.setOnCloseClickListener(new ClosableView.OnCloseClickListener() { // from class: com.smaato.sdk.richmedia.widget.ResizeManager$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.richmedia.widget.ClosableView.OnCloseClickListener
            public final void onCloseClick() {
                this.f$0.m5691lambda$new$1$comsmaatosdkrichmediawidgetResizeManager();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-richmedia-widget-ResizeManager, reason: not valid java name */
    /* synthetic */ void m5690lambda$new$0$comsmaatosdkrichmediawidgetResizeManager(Listener listener) {
        listener.onCloseClicked(this.closableView.getCloseButton());
    }

    /* JADX INFO: renamed from: lambda$new$1$com-smaato-sdk-richmedia-widget-ResizeManager, reason: not valid java name */
    /* synthetic */ void m5691lambda$new$1$comsmaatosdkrichmediawidgetResizeManager() {
        Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.ResizeManager$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5690lambda$new$0$comsmaatosdkrichmediawidgetResizeManager((ResizeManager.Listener) obj);
            }
        });
    }

    void resize(Rect rect) {
        View rootView = ViewUtils.getRootView(this.viewToResize);
        if (!(rootView instanceof ViewGroup)) {
            onFailedToResize("Cannot find a root view for a resizable-view");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) rootView;
        if (!this.closableView.isCloseRegionVisible(this.maxSizeInPx, rect)) {
            onFailedToResize("The close region cannot appear within the maximum allowed size");
            return;
        }
        if (!this.closableView.hasContent()) {
            ViewUtils.removeFromParent(this.viewToResize);
            this.closableView.addContent(this.viewToResize);
            viewGroup.addView(this.closableView);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.closableView.getLayoutParams();
        marginLayoutParams.width = rect.width();
        marginLayoutParams.height = rect.height();
        marginLayoutParams.topMargin = rect.top;
        marginLayoutParams.leftMargin = rect.left;
        this.closableView.setLayoutParams(marginLayoutParams);
        Views.addOnPreDrawListener(this.closableView, new Runnable() { // from class: com.smaato.sdk.richmedia.widget.ResizeManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5693lambda$resize$3$comsmaatosdkrichmediawidgetResizeManager();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$resize$2$com-smaato-sdk-richmedia-widget-ResizeManager, reason: not valid java name */
    /* synthetic */ void m5692lambda$resize$2$comsmaatosdkrichmediawidgetResizeManager(Listener listener) {
        listener.onResized(this.closableView.getCloseButton());
    }

    /* JADX INFO: renamed from: lambda$resize$3$com-smaato-sdk-richmedia-widget-ResizeManager, reason: not valid java name */
    /* synthetic */ void m5693lambda$resize$3$comsmaatosdkrichmediawidgetResizeManager() {
        Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.ResizeManager$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5692lambda$resize$2$comsmaatosdkrichmediawidgetResizeManager((ResizeManager.Listener) obj);
            }
        });
    }

    private void onFailedToResize(final String str) {
        this.logger.error(LogDomain.RICH_MEDIA, str, new Object[0]);
        Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.ResizeManager$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ResizeManager.Listener) obj).onResizeFailed(str);
            }
        });
    }

    void collapse() {
        Threads.runOnNextUiFrame(new Runnable() { // from class: com.smaato.sdk.richmedia.widget.ResizeManager$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5689lambda$collapse$5$comsmaatosdkrichmediawidgetResizeManager();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$collapse$5$com-smaato-sdk-richmedia-widget-ResizeManager, reason: not valid java name */
    /* synthetic */ void m5689lambda$collapse$5$comsmaatosdkrichmediawidgetResizeManager() {
        ViewUtils.removeFromParent(this.closableView);
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }
}
