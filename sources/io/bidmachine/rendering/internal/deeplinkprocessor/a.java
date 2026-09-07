package io.bidmachine.rendering.internal.deeplinkprocessor;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import io.bidmachine.iab.utils.CommonLog;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.util.Executable;
import io.bidmachine.util.Utils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements io.bidmachine.rendering.internal.deeplinkprocessor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0790a f12358a = new C0790a(null);

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.deeplinkprocessor.a$a, reason: collision with other inner class name */
    public static final class C0790a {
        private C0790a() {
        }

        public /* synthetic */ C0790a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b implements Executable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f12359a;
        private final Executable b;

        public b(Uri baseUri, Executable executable) {
            Intrinsics.checkNotNullParameter(baseUri, "baseUri");
            this.f12359a = baseUri;
            this.b = executable;
        }

        public void a(boolean z) {
            if (z) {
                UrlHandler.track$bidmachine_android_rendering_d_2_4_0(this.f12359a.getQueryParameter("fallbackTrackingUrl"));
            }
            UiUtils.onUiThreadWithArgSafely(Boolean.valueOf(z), this.b);
        }

        @Override // io.bidmachine.util.Executable
        public /* bridge */ /* synthetic */ void execute(Object obj) {
            a(((Boolean) obj).booleanValue());
        }
    }

    private static final class c implements Executable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f12360a;
        private final Executable b;
        private final Context c;

        public c(Context context, Uri baseUri, Executable executable) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(baseUri, "baseUri");
            this.f12360a = baseUri;
            this.b = executable;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            this.c = applicationContext;
        }

        public void a(boolean z) {
            if (z) {
                UrlHandler.track$bidmachine_android_rendering_d_2_4_0(this.f12360a.getQueryParameter("primaryTrackingUrl"));
                UiUtils.onUiThreadWithArgSafely(Boolean.TRUE, this.b);
                return;
            }
            String queryParameter = this.f12360a.getQueryParameter("fallbackUrl");
            if (queryParameter == null || queryParameter.length() == 0) {
                UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, this.b);
                return;
            }
            Uri validUri = Utils.getValidUri(queryParameter);
            if (validUri == null) {
                UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, this.b);
            } else {
                UrlHandler.openBrowser(this.c, validUri, new b(this.f12360a, this.b));
            }
        }

        @Override // io.bidmachine.util.Executable
        public /* bridge */ /* synthetic */ void execute(Object obj) {
            a(((Boolean) obj).booleanValue());
        }
    }

    @Override // io.bidmachine.rendering.internal.deeplinkprocessor.b
    public boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("bmlink", uri.getScheme());
    }

    @Override // io.bidmachine.rendering.internal.deeplinkprocessor.b
    public void a(Context context, Uri uri, Executable executable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter("primaryUrl");
        if (TextUtils.isEmpty(queryParameter)) {
            CommonLog.e("BMDeeplinkProcessor", "processUrl (primaryUrl is null or empty)", new Object[0]);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, executable);
            return;
        }
        Uri validUri = Utils.getValidUri(queryParameter);
        if (validUri != null) {
            UrlHandler.openBrowser(context, validUri, new c(context, uri, executable));
        } else {
            CommonLog.e("BMDeeplinkProcessor", "processUrl (primaryUri is null)", new Object[0]);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, executable);
        }
    }

    @Override // io.bidmachine.rendering.internal.deeplinkprocessor.b
    public void a(Context context, String str, Executable executable) {
        io.bidmachine.rendering.internal.deeplinkprocessor.b.a.a(this, context, str, executable);
    }
}
