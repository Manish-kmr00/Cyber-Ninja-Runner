package com.fyber.inneractive.sdk.player.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1994a;
    public final UUID b;
    public final String c;
    public final byte[] d;
    public final boolean e;

    public c(UUID uuid, String str, byte[] bArr) {
        uuid.getClass();
        this.b = uuid;
        this.c = str;
        bArr.getClass();
        this.d = bArr;
        this.e = false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        c cVar = (c) obj;
        return this.c.equals(cVar.c) && z.a(this.b, cVar.b) && Arrays.equals(this.d, cVar.d);
    }

    public final int hashCode() {
        if (this.f1994a == 0) {
            this.f1994a = Arrays.hashCode(this.d) + ((this.c.hashCode() + (this.b.hashCode() * 31)) * 31);
        }
        return this.f1994a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b.getMostSignificantBits());
        parcel.writeLong(this.b.getLeastSignificantBits());
        parcel.writeString(this.c);
        parcel.writeByteArray(this.d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
    }

    public c(Parcel parcel) {
        this.b = new UUID(parcel.readLong(), parcel.readLong());
        this.c = parcel.readString();
        this.d = parcel.createByteArray();
        this.e = parcel.readByte() != 0;
    }
}
