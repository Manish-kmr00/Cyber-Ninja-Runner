package com.yandex.mobile.ads.impl;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.webkit.internal.AssetHelper;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.yandex.mobile.ads.R;
import com.yandex.mobile.ads.features.debugpanel.ui.IntegrationInspectorActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
public final class cy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntegrationInspectorActivity f8650a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            h11.f9051a.b();
            cy cyVar = cy.this;
            String string = cyVar.f8650a.getString(R.string.logging_is_enabled);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            cy.a(cyVar, string);
            return Unit.INSTANCE;
        }
    }

    public cy(IntegrationInspectorActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f8650a = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i) {
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.y);
        p0.startActivity(p1);
    }

    public static final void a(cy cyVar, String str) {
        Toast.makeText(cyVar.f8650a, str, 0).show();
    }

    public final void a(ay event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ay.c) {
            Toast.makeText(this.f8650a, ((ay.c) event).a(), 0).show();
            return;
        }
        if (event instanceof ay.e) {
            a(((ay.e) event).a());
            return;
        }
        if (event instanceof ay.d) {
            Uri uriA = ((ay.d) event).a();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", uriA);
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.f8650a, intent);
            return;
        }
        if (event instanceof ay.b) {
            String string = this.f8650a.getString(R.string.logging_is_disabled);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = this.f8650a.getString(R.string.do_you_want_to_enable_logging);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            a(string, string2, new a());
            return;
        }
        if (event instanceof ay.a) {
            this.f8650a.finishAfterTransition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function0 function0, DialogInterface dialogInterface, int i) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void a(String str) {
        new AlertDialog.Builder(this.f8650a).setMessage(str).setPositiveButton(this.f8650a.getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.yandex.mobile.ads.impl.cy$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                cy.b(dialogInterface, i);
            }
        }).show();
    }

    private final void a(String str, String str2, final Function0<Unit> function0) {
        new AlertDialog.Builder(this.f8650a).setTitle(str).setMessage(str2).setPositiveButton(this.f8650a.getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.yandex.mobile.ads.impl.cy$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                cy.a(function0, dialogInterface, i);
            }
        }).setNegativeButton(this.f8650a.getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.yandex.mobile.ads.impl.cy$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                cy.a(dialogInterface, i);
            }
        }).show();
    }
}
