package com.yandex.div.core.util;

import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.json.m5;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.yandex.div.core.timer.TimerController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeAlertDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0006J#\u0010\f\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r*\u0004\u0018\u00010\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0006J%\u0010\u0013\u001a\u00020\u00062\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\u0015\"\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/util/SafeAlertDialog;", "", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "(Landroidx/appcompat/app/AlertDialog;)V", TimerController.CANCEL_COMMAND, "", "checkEqualReference", "", "dialog", "Landroid/content/DialogInterface;", "dismiss", "findViewById", "T", "Landroid/view/View;", "id", "", "(I)Landroid/view/View;", "hide", "setupTapjackingProtection", AdUnitActivity.EXTRA_VIEWS, "", "([Landroid/view/View;)V", m5.v, "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SafeAlertDialog {
    private final AlertDialog alertDialog;

    public SafeAlertDialog(AlertDialog alertDialog) {
        Intrinsics.checkNotNullParameter(alertDialog, "alertDialog");
        this.alertDialog = alertDialog;
    }

    public final boolean checkEqualReference(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        return this.alertDialog == dialog;
    }

    private final void setupTapjackingProtection(View... views) {
        for (View view : views) {
            if (view != null) {
                view.setFilterTouchesWhenObscured(true);
            }
        }
    }

    public final <T extends View> T findViewById(int id) {
        return (T) this.alertDialog.findViewById(id);
    }

    public final void hide() {
        this.alertDialog.hide();
    }

    public final void dismiss() {
        this.alertDialog.dismiss();
    }

    public final void cancel() {
        this.alertDialog.cancel();
    }

    public final void show() {
        this.alertDialog.show();
        setupTapjackingProtection(this.alertDialog.getListView(), this.alertDialog.getButton(-1), this.alertDialog.getButton(-2), this.alertDialog.getButton(-3));
    }
}
