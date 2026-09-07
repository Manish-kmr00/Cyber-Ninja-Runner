package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.eb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4089eb implements Parcelable {
    public static final Parcelable.Creator<C4089eb> CREATOR = new C4064db();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResultReceiver f11530a;
    public final List b;
    public final HashMap c;

    public C4089eb(I6 i6, List list, Map map) {
        this.b = list;
        this.f11530a = i6;
        this.c = map == null ? new HashMap() : new HashMap(map);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver", this.f11530a);
        if (this.b != null) {
            bundle.putStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList", new ArrayList<>(this.b));
        }
        HashMap map = this.c;
        if (map != null) {
            bundle.putString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification", AbstractC4199im.a((Map) map));
        }
        parcel.writeBundle(bundle);
    }

    public C4089eb(Parcel parcel) {
        Bundle bundle = parcel.readBundle(I6.class.getClassLoader());
        if (bundle != null) {
            this.f11530a = (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver");
            this.b = bundle.getStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList");
            this.c = AbstractC4199im.a(bundle.getString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification"));
            return;
        }
        this.c = new HashMap();
    }
}
