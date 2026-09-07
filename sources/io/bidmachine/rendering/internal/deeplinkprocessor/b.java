package io.bidmachine.rendering.internal.deeplinkprocessor;

import android.content.Context;
import android.net.Uri;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.util.Executable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface b {

    public static final class a {
        public static void a(b bVar, Context context, String url, Executable executable) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            bVar.a(context, UrlHandler.parseUrl(url), executable);
        }
    }

    void a(Context context, Uri uri, Executable executable);

    void a(Context context, String str, Executable executable);

    boolean a(Uri uri);
}
