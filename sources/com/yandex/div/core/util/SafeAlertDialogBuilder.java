package com.yandex.div.core.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.m5;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeAlertDialogBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0018J\u001a\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u001c\u001a\u00020\rJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div/core/util/SafeAlertDialogBuilder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alertDialogBuilder", "Landroidx/appcompat/app/AlertDialog$Builder;", "create", "Lcom/yandex/div/core/util/SafeAlertDialog;", "setMessage", "message", "", "messageId", "", "setNegativeButton", "textId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/DialogInterface$OnClickListener;", "text", "", "setOnCancelListener", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "setOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "setPositiveButton", "setTitle", "title", "titleId", "setView", "view", "Landroid/view/View;", m5.v, "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SafeAlertDialogBuilder {
    private final AlertDialog.Builder alertDialogBuilder;

    public SafeAlertDialogBuilder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.alertDialogBuilder = new AlertDialog.Builder(context);
    }

    public final SafeAlertDialogBuilder setView(View view) {
        if (view != null) {
            view.setFilterTouchesWhenObscured(true);
        }
        this.alertDialogBuilder.setView(view);
        return this;
    }

    public final SafeAlertDialogBuilder setTitle(int titleId) {
        this.alertDialogBuilder.setTitle(titleId);
        return this;
    }

    public final SafeAlertDialogBuilder setTitle(CharSequence title) {
        this.alertDialogBuilder.setTitle(title);
        return this;
    }

    public final SafeAlertDialogBuilder setMessage(int messageId) {
        this.alertDialogBuilder.setMessage(messageId);
        return this;
    }

    public final SafeAlertDialogBuilder setMessage(CharSequence message) {
        this.alertDialogBuilder.setMessage(message);
        return this;
    }

    public final SafeAlertDialogBuilder setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
        this.alertDialogBuilder.setPositiveButton(textId, listener);
        return this;
    }

    public final SafeAlertDialogBuilder setPositiveButton(String text, DialogInterface.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.alertDialogBuilder.setPositiveButton(text, listener);
        return this;
    }

    public final SafeAlertDialogBuilder setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
        this.alertDialogBuilder.setNegativeButton(textId, listener);
        return this;
    }

    public final SafeAlertDialogBuilder setNegativeButton(String text, DialogInterface.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.alertDialogBuilder.setNegativeButton(text, listener);
        return this;
    }

    public final SafeAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.alertDialogBuilder.setOnCancelListener(onCancelListener);
        return this;
    }

    public final SafeAlertDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener listener) {
        this.alertDialogBuilder.setOnDismissListener(listener);
        return this;
    }

    public final SafeAlertDialog create() {
        AlertDialog alertDialogCreate = this.alertDialogBuilder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "alertDialogBuilder.create()");
        return new SafeAlertDialog(alertDialogCreate);
    }

    public final SafeAlertDialog show() {
        SafeAlertDialog safeAlertDialogCreate = create();
        safeAlertDialogCreate.show();
        return safeAlertDialogCreate;
    }
}
