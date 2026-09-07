package com.smaato.sdk.richmedia.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import com.smaato.sdk.core.lifecycle.ActivityProvider;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.richmedia.util.ViewUtils;
import com.smaato.sdk.richmedia_light.R;

/* JADX INFO: loaded from: classes2.dex */
final class ExpandManager {
    private Dialog dialog;

    interface Listener {
        void onCloseClicked(ImageButton imageButton);

        void onExpanded(ImageButton imageButton);

        void onFailedToExpand();
    }

    ExpandManager() {
    }

    void expand(View view, final Listener listener) {
        Activity currentActivity = ActivityProvider.get().getCurrentActivity();
        if (currentActivity == null) {
            listener.onFailedToExpand();
            return;
        }
        final ClosableView closableView = new ClosableView(currentActivity);
        closableView.setOnCloseClickListener(new ClosableView.OnCloseClickListener() { // from class: com.smaato.sdk.richmedia.widget.ExpandManager$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.richmedia.widget.ClosableView.OnCloseClickListener
            public final void onCloseClick() {
                this.f$0.m5686lambda$expand$0$comsmaatosdkrichmediawidgetExpandManager(listener, closableView);
            }
        });
        ViewUtils.removeFromParent(view);
        closableView.addContent(view);
        Dialog dialog = new Dialog(currentActivity, R.style.smaato_sdk_richmedia_expandable_dialog);
        this.dialog = dialog;
        dialog.setContentView(closableView);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.smaato.sdk.richmedia.widget.ExpandManager$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                listener.onExpanded(closableView.getCloseButton());
            }
        });
        this.dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.smaato.sdk.richmedia.widget.ExpandManager$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f$0.m5687lambda$expand$2$comsmaatosdkrichmediawidgetExpandManager(listener, closableView, dialogInterface, i, keyEvent);
            }
        });
        this.dialog.show();
    }

    /* JADX INFO: renamed from: lambda$expand$2$com-smaato-sdk-richmedia-widget-ExpandManager, reason: not valid java name */
    /* synthetic */ boolean m5687lambda$expand$2$comsmaatosdkrichmediawidgetExpandManager(Listener listener, ClosableView closableView, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        m5686lambda$expand$0$comsmaatosdkrichmediawidgetExpandManager(listener, closableView);
        return false;
    }

    void collapse() {
        Objects.onNotNull(this.dialog, new Consumer() { // from class: com.smaato.sdk.richmedia.widget.ExpandManager$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5685lambda$collapse$3$comsmaatosdkrichmediawidgetExpandManager((Dialog) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$collapse$3$com-smaato-sdk-richmedia-widget-ExpandManager, reason: not valid java name */
    /* synthetic */ void m5685lambda$collapse$3$comsmaatosdkrichmediawidgetExpandManager(Dialog dialog) {
        dialog.dismiss();
        this.dialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: notifyAboutClose, reason: merged with bridge method [inline-methods] */
    public void m5686lambda$expand$0$comsmaatosdkrichmediawidgetExpandManager(Listener listener, ClosableView closableView) {
        listener.onCloseClicked(closableView.getCloseButton());
    }
}
