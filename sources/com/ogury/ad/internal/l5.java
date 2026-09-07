package com.ogury.ad.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.DownloadListener;
import android.widget.Toast;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes2.dex */
public final class l5 implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7344a;

    public l5(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7344a = context;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long j) {
        String string;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        Intrinsics.checkNotNullParameter(contentDisposition, "contentDisposition");
        Intrinsics.checkNotNullParameter(mimetype, "mimetype");
        Context context = this.f7344a;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter("android.permission.WRITE_EXTERNAL_STORAGE", "permission");
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            u3.f7411a.getClass();
            return;
        }
        Uri uri = Uri.parse(url);
        String path = uri.getPath();
        List<String> listSplit = path != null ? new Regex(RemoteSettings.FORWARD_SLASH_STRING).split(path, 0) : null;
        if (listSplit == null || !(!listSplit.isEmpty())) {
            string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else {
            string = (String) CollectionsKt.last((List) listSplit);
        }
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle(string);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "download");
        Object systemService = this.f7344a.getSystemService("download");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
        ((DownloadManager) systemService).enqueue(request);
        Context context2 = this.f7344a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("Start downloading %s", Arrays.copyOf(new Object[]{string}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(context2, str, 0).show();
    }
}
