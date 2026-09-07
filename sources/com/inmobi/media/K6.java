package com.inmobi.media;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class K6 extends ContentObserver implements InterfaceC3624x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3113a;
    public final Context b;
    public int c;
    public final /* synthetic */ M6 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K6(M6 m6, String mJsCallbackNamespace, Context context, Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(mJsCallbackNamespace, "mJsCallbackNamespace");
        this.d = m6;
        this.f3113a = mJsCallbackNamespace;
        this.b = context;
        this.c = -1;
    }

    public static final void a(K6 this$0, M6 this$1, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        Context context = this$0.b;
        if (context != null) {
            Object systemService = context.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null) {
                try {
                    int streamVolume = audioManager.getStreamVolume(3);
                    if (streamVolume != this$0.c) {
                        this$0.c = streamVolume;
                        L4 l4 = this$1.b;
                        if (l4 != null) {
                            ((M4) l4).a("MraidMediaProcessor", "volume change detected - " + z);
                        }
                        String str = this$0.f3113a;
                        L4 l5 = this$1.b;
                        if (l5 != null) {
                            ((M4) l5).c("MraidMediaProcessor", "fireDeviceVolumeChangeEvent");
                        }
                        Ba ba = this$1.f3135a;
                        if (ba != null) {
                            ba.a(str, "fireDeviceVolumeChangeEvent(" + streamVolume + ");");
                        }
                    }
                } catch (Exception e) {
                    L4 l6 = this$1.b;
                    if (l6 != null) {
                        ((M4) l6).a("MraidMediaProcessor", "Unexpected error in volume listener", e);
                    }
                }
            }
        }
    }

    @Override // com.inmobi.media.InterfaceC3624x6
    public final void b() {
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return;
        }
        contextD.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    @Override // android.database.ContentObserver
    public final void onChange(final boolean z) {
        super.onChange(z);
        int i = S3.f3188a;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) S3.b.getValue();
        final M6 m6 = this.d;
        scheduledThreadPoolExecutor.execute(new Runnable() { // from class: com.inmobi.media.K6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                K6.a(this.f$0, m6, z);
            }
        });
    }

    @Override // com.inmobi.media.InterfaceC3624x6
    public final void a() {
        Context contextD = C3517pb.d();
        if (contextD == null) {
            return;
        }
        contextD.getContentResolver().unregisterContentObserver(this);
    }
}
