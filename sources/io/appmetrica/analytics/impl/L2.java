package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
public class L2 implements ExternalAttribution {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H9 f11235a;

    public L2(H9 h9) {
        this.f11235a = h9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.f11235a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + R9.a(this.f11235a.f11174a) + "`value=`" + new String(this.f11235a.b, Charsets.UTF_8) + "`)";
    }
}
