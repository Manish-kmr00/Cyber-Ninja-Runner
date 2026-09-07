package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.do, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
public final class Cdo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11523a = new ArrayList();
    public PublicLogger b;

    public final synchronized void a(Consumer consumer) {
        PublicLogger publicLogger = this.b;
        if (publicLogger == null) {
            this.f11523a.add(consumer);
        } else {
            consumer.consume(publicLogger);
        }
    }
}
