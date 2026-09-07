package io.appmetrica.analytics.impl;

import android.os.Parcel;
import android.os.Parcelable;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ca, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C4038ca implements Parcelable {
    public static final C4013ba CREATOR = new C4013ba();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f11492a;
    public final IdentifierStatus b;
    public final String c;

    public C4038ca(Boolean bool, IdentifierStatus identifierStatus, String str) {
        this.f11492a = bool;
        this.b = identifierStatus;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4038ca)) {
            return false;
        }
        C4038ca c4038ca = (C4038ca) obj;
        return Intrinsics.areEqual(this.f11492a, c4038ca.f11492a) && this.b == c4038ca.b && Intrinsics.areEqual(this.c, c4038ca.c);
    }

    public final int hashCode() {
        Boolean bool = this.f11492a;
        int iHashCode = (this.b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31;
        String str = this.c;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "FeaturesInternal(sslPinning=" + this.f11492a + ", status=" + this.b + ", errorExplanation=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f11492a);
        parcel.writeString(this.b.getValue());
        parcel.writeString(this.c);
    }

    public C4038ca() {
        this(null, IdentifierStatus.UNKNOWN, null);
    }
}
