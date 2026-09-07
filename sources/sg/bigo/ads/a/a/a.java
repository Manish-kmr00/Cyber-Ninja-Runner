package sg.bigo.ads.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CustomTabsClient f12465a;
    public CustomTabsServiceConnection b;
    public InterfaceC0806a c;
    public CustomTabsCallback d;
    private CustomTabsSession e;

    /* JADX INFO: renamed from: sg.bigo.ads.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0806a {
        void c();

        void d();
    }

    public interface b {
        void a(Context context, sg.bigo.ads.a.a.b.a aVar);

        void a(sg.bigo.ads.a.a.b.a aVar);
    }

    public final CustomTabsSession a() {
        CustomTabsSession customTabsSessionNewSession;
        CustomTabsClient customTabsClient = this.f12465a;
        if (customTabsClient != null) {
            customTabsSessionNewSession = this.e == null ? customTabsClient.newSession(new CustomTabsCallback() { // from class: sg.bigo.ads.a.a.a.1
                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void extraCallback(String str, Bundle bundle) {
                    super.extraCallback(str, bundle);
                }

                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void onMessageChannelReady(Bundle bundle) {
                    super.onMessageChannelReady(bundle);
                }

                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void onNavigationEvent(int i, Bundle bundle) {
                    super.onNavigationEvent(i, bundle);
                    if (a.this.d != null) {
                        a.this.d.onNavigationEvent(i, bundle);
                    }
                }

                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void onPostMessage(String str, Bundle bundle) {
                    super.onPostMessage(str, bundle);
                }

                @Override // androidx.browser.customtabs.CustomTabsCallback
                public final void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
                    super.onRelationshipValidationResult(i, uri, z, bundle);
                }
            }) : null;
            return this.e;
        }
        this.e = customTabsSessionNewSession;
        return this.e;
    }

    @Override // sg.bigo.ads.a.a.d
    public final void a(CustomTabsClient customTabsClient) {
        this.f12465a = customTabsClient;
        customTabsClient.warmup(0L);
        InterfaceC0806a interfaceC0806a = this.c;
        if (interfaceC0806a != null) {
            interfaceC0806a.c();
        }
    }

    @Override // sg.bigo.ads.a.a.d
    public final void b() {
        this.f12465a = null;
        this.e = null;
        InterfaceC0806a interfaceC0806a = this.c;
        if (interfaceC0806a != null) {
            interfaceC0806a.d();
        }
    }
}
