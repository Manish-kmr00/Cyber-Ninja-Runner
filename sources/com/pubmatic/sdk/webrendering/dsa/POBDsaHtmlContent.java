package com.pubmatic.sdk.webrendering.dsa;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/pubmatic/sdk/webrendering/dsa/POBDsaHtmlContent;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/pubmatic/sdk/webrendering/dsa/POBDsaHtmlContent$OnContentListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "getHtmlContent", "(Landroid/content/Context;Lcom/pubmatic/sdk/webrendering/dsa/POBDsaHtmlContent$OnContentListener;)V", "", "a", "Ljava/lang/String;", "dsaInfoHtmlPageContent", "OnContentListener", "webrendering_release"}, k = 1, mv = {1, 7, 1})
public final class POBDsaHtmlContent {
    public static final POBDsaHtmlContent INSTANCE = new POBDsaHtmlContent();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String dsaInfoHtmlPageContent;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/pubmatic/sdk/webrendering/dsa/POBDsaHtmlContent$OnContentListener;", "", "onPageContentReceived", "", "dsaInfoHtmlPageContent", "", "webrendering_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnContentListener {
        void onPageContentReceived(String dsaInfoHtmlPageContent);
    }

    private POBDsaHtmlContent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, final POBDsaHtmlContent this_run, final OnContentListener listener) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        final String fromAssets = POBUtils.readFromAssets(context, POBCommonConstants.DSA_DETAIL_SCREEN_FILE_NAME);
        POBTaskHandler.INSTANCE.getInstance().runOnMainThread(new Runnable() { // from class: com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                POBDsaHtmlContent.a(fromAssets, this_run, listener);
            }
        });
    }

    @JvmStatic
    public static final void getHtmlContent(final Context context, final OnContentListener listener) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String str = dsaInfoHtmlPageContent;
        if (str != null) {
            listener.onPageContentReceived(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            final POBDsaHtmlContent pOBDsaHtmlContent = INSTANCE;
            POBTaskHandler.INSTANCE.getInstance().runOnBackgroundThread(new Runnable() { // from class: com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    POBDsaHtmlContent.a(context, pOBDsaHtmlContent, listener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(String str, POBDsaHtmlContent this_run, OnContentListener listener) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (str != null) {
            dsaInfoHtmlPageContent = str;
            listener.onPageContentReceived(str);
        }
    }
}
