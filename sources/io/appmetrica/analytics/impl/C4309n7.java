package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.n7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4309n7 implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4234k7 f11681a;

    public C4309n7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ContentValues fromModel(C4284m7 c4284m7) {
        ContentValues contentValues = new ContentValues();
        Long l = c4284m7.f11666a;
        if (l != null) {
            contentValues.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, Long.valueOf(l.longValue()));
        }
        EnumC4621zk enumC4621zk = c4284m7.b;
        if (enumC4621zk != null) {
            contentValues.put("session_type", Integer.valueOf(enumC4621zk.f11882a));
        }
        Long l2 = c4284m7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC4164hb enumC4164hb = c4284m7.d;
        if (enumC4164hb != null) {
            contentValues.put("type", Integer.valueOf(enumC4164hb.f11583a));
        }
        Long l3 = c4284m7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c4284m7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C4234k7 c4234k7 = this.f11681a;
        contentValues.put("event_description", MessageNano.toByteArray(c4234k7.f11632a.fromModel(c4284m7.g)));
        return contentValues;
    }

    public C4309n7(C4234k7 c4234k7) {
        this.f11681a = c4234k7;
    }

    public /* synthetic */ C4309n7(C4234k7 c4234k7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4234k7(null, 1, 0 == true ? 1 : 0) : c4234k7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4284m7 toModel(ContentValues contentValues) {
        EnumC4621zk enumC4621zk;
        int iIntValue;
        Long asLong = contentValues.getAsLong(SDKAnalyticsEvents.PARAMETER_SESSION_ID);
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            Integer numValueOf = Integer.valueOf(asInteger.intValue());
            enumC4621zk = EnumC4621zk.FOREGROUND;
            if (numValueOf != null && (iIntValue = numValueOf.intValue()) != 0 && iIntValue == 1) {
                enumC4621zk = EnumC4621zk.BACKGROUND;
            }
        } else {
            enumC4621zk = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new C4284m7(asLong, enumC4621zk, asLong2, asInteger2 != null ? EnumC4164hb.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f11681a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
