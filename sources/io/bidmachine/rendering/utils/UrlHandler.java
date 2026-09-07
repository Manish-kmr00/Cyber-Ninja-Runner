package io.bidmachine.rendering.utils;

import android.content.Context;
import android.net.Uri;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.mraid.MraidNativeFeatureUrlParser;
import io.bidmachine.rendering.Rendering;
import io.bidmachine.rendering.internal.deeplinkprocessor.a;
import io.bidmachine.rendering.internal.deeplinkprocessor.b;
import io.bidmachine.rendering.internal.deeplinkprocessor.c;
import io.bidmachine.rendering.internal.deeplinkprocessor.d;
import io.bidmachine.rendering.internal.j;
import io.bidmachine.rendering.internal.p;
import io.bidmachine.util.Executable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010$J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J(\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J(\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0019\u0010\u0013\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lio/bidmachine/rendering/utils/UrlHandler;", "", "Landroid/content/Context;", "context", "", "url", "Lio/bidmachine/util/Executable;", "", "postMethod", "", "openUrl", "Landroid/net/Uri;", "uri", "openBrowser", "openCalendar", "storePicture", "parseUrl", "track$bidmachine_android_rendering_d_2_4_0", "(Ljava/lang/String;)V", "track", "Lio/bidmachine/rendering/internal/j;", "a", "Lio/bidmachine/rendering/internal/j;", "INTENT_LAUNCHER", "Lio/bidmachine/rendering/internal/deeplinkprocessor/b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/internal/deeplinkprocessor/b;", "MRAID_CALENDAR_DEEPLINK_PROCESSOR", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "MRAID_STORE_PICTURE_DEEPLINK_PROCESSOR", "", "d", "Ljava/util/List;", "getSUPPORTED_DEEPLINK_PROCESSORS", "()Ljava/util/List;", "getSUPPORTED_DEEPLINK_PROCESSORS$annotations", "()V", "SUPPORTED_DEEPLINK_PROCESSORS", "<init>", "bidmachine-android-rendering_d_2_4_0"}, k = 1, mv = {1, 7, 1})
public final class UrlHandler {
    public static final UrlHandler INSTANCE = new UrlHandler();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final j INTENT_LAUNCHER;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final b MRAID_CALENDAR_DEEPLINK_PROCESSOR;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final b MRAID_STORE_PICTURE_DEEPLINK_PROCESSOR;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final List SUPPORTED_DEEPLINK_PROCESSORS;

    static {
        j jVar = new j();
        INTENT_LAUNCHER = jVar;
        MraidNativeFeatureUrlParser mraidNativeFeatureUrlParser = new MraidNativeFeatureUrlParser();
        p pVar = new p();
        c cVar = new c(mraidNativeFeatureUrlParser, jVar);
        MRAID_CALENDAR_DEEPLINK_PROCESSOR = cVar;
        d dVar = new d(mraidNativeFeatureUrlParser, pVar);
        MRAID_STORE_PICTURE_DEEPLINK_PROCESSOR = dVar;
        SUPPORTED_DEEPLINK_PROCESSORS = CollectionsKt.listOf((Object[]) new b[]{cVar, dVar, new a()});
    }

    private UrlHandler() {
    }

    public static /* synthetic */ void getSUPPORTED_DEEPLINK_PROCESSORS$annotations() {
    }

    @JvmStatic
    public static final void openBrowser(Context context, Uri uri, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        INTENT_LAUNCHER.a(context, uri, postMethod);
    }

    @JvmStatic
    public static final void openCalendar(Context context, String url, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        MRAID_CALENDAR_DEEPLINK_PROCESSOR.a(context, url, postMethod);
    }

    @JvmStatic
    public static final void openUrl(Context context, String url, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Uri url2 = parseUrl(url);
        for (b bVar : SUPPORTED_DEEPLINK_PROCESSORS) {
            if (bVar.a(url2)) {
                bVar.a(context, url2, postMethod);
                return;
            }
        }
        openBrowser(context, url2, postMethod);
    }

    @JvmStatic
    public static final Uri parseUrl(String url) {
        Uri validUri;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri uri = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(url)");
        String scheme = uri.getScheme();
        if ((scheme == null || scheme.length() == 0) && !StringsKt.startsWith$default(url, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null) && (validUri = io.bidmachine.util.Utils.getValidUri(url)) != null) {
            String scheme2 = validUri.getScheme();
            if (scheme2 == null || scheme2.length() <= 0) {
                String string = validUri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "newUri.toString()");
                if (StringsKt.startsWith$default(string, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                }
            }
            return validUri;
        }
        return uri;
    }

    @JvmStatic
    public static final void storePicture(Context context, String url, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        MRAID_STORE_PICTURE_DEEPLINK_PROCESSOR.a(context, url, postMethod);
    }

    @JvmStatic
    public static final void track$bidmachine_android_rendering_d_2_4_0(String url) {
        String validUrl = io.bidmachine.util.Utils.getValidUrl(url);
        if (validUrl == null || validUrl.length() <= 0) {
            return;
        }
        new NetworkRequest.Builder(validUrl, NetworkRequest.Method.Get).setUserAgent(Rendering.getUserAgent()).send();
    }

    public final List<b> getSUPPORTED_DEEPLINK_PROCESSORS() {
        return SUPPORTED_DEEPLINK_PROCESSORS;
    }
}
