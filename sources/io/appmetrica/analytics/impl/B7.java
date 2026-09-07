package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
public final class B7 implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4583y7 f11073a;

    public B7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ContentValues fromModel(A7 a7) {
        ContentValues contentValues = new ContentValues();
        Long l = a7.f11055a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        EnumC4621zk enumC4621zk = a7.b;
        if (enumC4621zk != null) {
            contentValues.put("type", Integer.valueOf(enumC4621zk.f11882a));
        }
        String str = a7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        C4583y7 c4583y7 = this.f11073a;
        contentValues.put("session_description", MessageNano.toByteArray(c4583y7.f11855a.fromModel(a7.d)));
        return contentValues;
    }

    public B7(C4583y7 c4583y7) {
        this.f11073a = c4583y7;
    }

    public /* synthetic */ B7(C4583y7 c4583y7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C4583y7(null, 1, 0 == true ? 1 : 0) : c4583y7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final A7 toModel(ContentValues contentValues) {
        EnumC4621zk enumC4621zk;
        int iIntValue;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            Integer numValueOf = Integer.valueOf(asInteger.intValue());
            enumC4621zk = EnumC4621zk.FOREGROUND;
            if (numValueOf != null && (iIntValue = numValueOf.intValue()) != 0 && iIntValue == 1) {
                enumC4621zk = EnumC4621zk.BACKGROUND;
            }
        } else {
            enumC4621zk = null;
        }
        return new A7(asLong, enumC4621zk, contentValues.getAsString("report_request_parameters"), this.f11073a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
