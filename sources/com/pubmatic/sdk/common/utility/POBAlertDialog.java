package com.pubmatic.sdk.common.utility;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public class POBAlertDialog {

    public interface POBDialogListener {
        void onCancel(DialogInterface dialogInterface, int i);

        void onSuccess(DialogInterface dialogInterface, int i);
    }

    class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBDialogListener f7627a;

        a(POBDialogListener pOBDialogListener) {
            this.f7627a = pOBDialogListener;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f7627a.onCancel(dialogInterface, 0);
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBDialogListener f7628a;

        b(POBDialogListener pOBDialogListener) {
            this.f7628a = pOBDialogListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7628a.onCancel(dialogInterface, i);
        }
    }

    class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBDialogListener f7629a;

        c(POBDialogListener pOBDialogListener) {
            this.f7629a = pOBDialogListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7629a.onSuccess(dialogInterface, i);
        }
    }

    public static AlertDialog.Builder build(Context context, String str, String str2, POBDialogListener pOBDialogListener) {
        boolean z;
        try {
            z = !((Activity) context).isFinishing();
        } catch (Exception unused) {
            z = true;
        }
        if (context == null || !z) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Theme.Material.Dialog.Alert);
        builder.setTitle(str).setMessage(str2).setCancelable(true).setPositiveButton("YES", new c(pOBDialogListener)).setNegativeButton("NO", new b(pOBDialogListener)).setOnCancelListener(new a(pOBDialogListener)).create();
        return builder;
    }
}
