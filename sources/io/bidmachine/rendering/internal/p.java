package io.bidmachine.rendering.internal;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Executable;
import io.bidmachine.util.Utils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p {

    public static final class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executable f12369a;

        a(Executable executable) {
            this.f12369a = executable;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            context.unregisterReceiver(this);
            UiUtils.onUiThreadWithArgSafely(Boolean.TRUE, this.f12369a);
        }
    }

    public final void a(Context context, Uri uri, Executable executable) {
        long jA;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Context applicationContext = context.getApplicationContext();
        try {
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            jA = a(applicationContext, uri);
        } catch (Exception e) {
            m.b(e);
            jA = -1;
        }
        if (jA == -1) {
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, executable);
            return;
        }
        a aVar = new a(executable);
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        Utils.registerBroadcastReceiver(aVar, applicationContext, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    }

    private final long a(Context context, Uri uri) {
        DownloadManager downloadManager = Utils.getDownloadManager(context);
        if (downloadManager != null) {
            return downloadManager.enqueue(new DownloadManager.Request(uri).setNotificationVisibility(1));
        }
        return -1L;
    }
}
