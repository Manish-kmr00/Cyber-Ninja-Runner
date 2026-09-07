package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrash;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Gd implements NativeCrashHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lg f11161a;
    public final Function1 b;

    public Gd(Lg lg, Function1<? super String, Unit> function1) {
        this.f11161a = lg;
        this.b = function1;
    }

    public static final void a(Gd gd, NativeCrash nativeCrash, File file) {
        gd.b.invoke(nativeCrash.getUuid());
    }

    public static final void b(Gd gd, NativeCrash nativeCrash, File file) {
        gd.b.invoke(nativeCrash.getUuid());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        C4576y0 c4576y0;
        try {
            NativeCrashSource source = nativeCrash.getSource();
            String handlerVersion = nativeCrash.getHandlerVersion();
            String uuid = nativeCrash.getUuid();
            String dumpFile = nativeCrash.getDumpFile();
            long creationTime = nativeCrash.getCreationTime();
            C4601z0 c4601z0A = A0.a(nativeCrash.getMetadata());
            Intrinsics.checkNotNull(c4601z0A);
            c4576y0 = new C4576y0(source, handlerVersion, uuid, dumpFile, creationTime, c4601z0A);
        } catch (Throwable unused) {
            c4576y0 = null;
        }
        if (c4576y0 == null) {
            this.b.invoke(nativeCrash.getUuid());
            return;
        }
        Lg lg = this.f11161a;
        Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Gd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                Gd.a(this.f$0, nativeCrash, (File) obj);
            }
        };
        lg.getClass();
        lg.a(c4576y0, consumer, new Ig(c4576y0));
    }

    public final void a(List<NativeCrash> list) {
        C4576y0 c4576y0;
        for (final NativeCrash nativeCrash : list) {
            try {
                NativeCrashSource source = nativeCrash.getSource();
                String handlerVersion = nativeCrash.getHandlerVersion();
                String uuid = nativeCrash.getUuid();
                String dumpFile = nativeCrash.getDumpFile();
                long creationTime = nativeCrash.getCreationTime();
                C4601z0 c4601z0A = A0.a(nativeCrash.getMetadata());
                Intrinsics.checkNotNull(c4601z0A);
                c4576y0 = new C4576y0(source, handlerVersion, uuid, dumpFile, creationTime, c4601z0A);
            } catch (Throwable unused) {
                c4576y0 = null;
            }
            if (c4576y0 != null) {
                Lg lg = this.f11161a;
                Consumer consumer = new Consumer() { // from class: io.appmetrica.analytics.impl.Gd$$ExternalSyntheticLambda1
                    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                    public final void consume(Object obj) {
                        Gd.b(this.f$0, nativeCrash, (File) obj);
                    }
                };
                lg.getClass();
                lg.a(c4576y0, consumer, new Jg(c4576y0));
            } else {
                this.b.invoke(nativeCrash.getUuid());
            }
        }
    }
}
