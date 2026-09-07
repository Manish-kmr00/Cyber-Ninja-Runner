package com.fyber.inneractive.sdk.player.exoplayer2;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.json.mediationsdk.logger.IronSourceError;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new n();
    public int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2116a;
    public final int b;
    public final String c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.b d;
    public final String e;
    public final String f;
    public final int g;
    public final List h;
    public final com.fyber.inneractive.sdk.player.exoplayer2.drm.d i;
    public final int j;
    public final int k;
    public final float l;
    public final int m;
    public final float n;
    public final int o;
    public final byte[] p;
    public final com.fyber.inneractive.sdk.player.exoplayer2.video.c q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final long w;
    public final int x;
    public final String y;
    public final int z;

    public o(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, com.fyber.inneractive.sdk.player.exoplayer2.video.c cVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List list, com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar, com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVar) {
        this.f2116a = str;
        this.e = str2;
        this.f = str3;
        this.c = str4;
        this.b = i;
        this.g = i2;
        this.j = i3;
        this.k = i4;
        this.l = f;
        this.m = i5;
        this.n = f2;
        this.p = bArr;
        this.o = i6;
        this.q = cVar;
        this.r = i7;
        this.s = i8;
        this.t = i9;
        this.u = i10;
        this.v = i11;
        this.x = i12;
        this.y = str5;
        this.z = i13;
        this.w = j;
        this.h = list == null ? Collections.emptyList() : list;
        this.i = dVar;
        this.d = bVar;
    }

    public static o a(String str, String str2, int i, int i2, int i3, List list, int i4, float f, byte[] bArr, int i5, com.fyber.inneractive.sdk.player.exoplayer2.video.c cVar, com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar) {
        return new o(str, null, str2, null, -1, i, i2, i3, -1.0f, i4, f, bArr, i5, cVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, dVar, null);
    }

    public final int b() {
        int i;
        int i2 = this.j;
        if (i2 == -1 || (i = this.k) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (this.b == oVar.b && this.g == oVar.g && this.j == oVar.j && this.k == oVar.k && this.l == oVar.l && this.m == oVar.m && this.n == oVar.n && this.o == oVar.o && this.r == oVar.r && this.s == oVar.s && this.t == oVar.t && this.u == oVar.u && this.v == oVar.v && this.w == oVar.w && this.x == oVar.x && z.a(this.f2116a, oVar.f2116a) && z.a(this.y, oVar.y) && this.z == oVar.z && z.a(this.e, oVar.e) && z.a(this.f, oVar.f) && z.a(this.c, oVar.c) && z.a(this.i, oVar.i) && z.a(this.d, oVar.d) && z.a(this.q, oVar.q) && Arrays.equals(this.p, oVar.p) && this.h.size() == oVar.h.size()) {
                for (int i = 0; i < this.h.size(); i++) {
                    if (!Arrays.equals((byte[]) this.h.get(i), (byte[]) oVar.h.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.A == 0) {
            String str = this.f2116a;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
            String str2 = this.e;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.c;
            int iHashCode4 = (((((((((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.b) * 31) + this.j) * 31) + this.k) * 31) + this.r) * 31) + this.s) * 31;
            String str5 = this.y;
            int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.z) * 31;
            com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar = this.i;
            int iHashCode6 = (iHashCode5 + (dVar == null ? 0 : dVar.hashCode())) * 31;
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVar = this.d;
            this.A = iHashCode6 + (bVar != null ? Arrays.hashCode(bVar.f2112a) : 0);
        }
        return this.A;
    }

    public final String toString() {
        return "Format(" + this.f2116a + ", " + this.e + ", " + this.f + ", " + this.b + ", " + this.y + ", [" + this.j + ", " + this.k + ", " + this.l + "], [" + this.r + ", " + this.s + "])";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2116a);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.c);
        parcel.writeInt(this.b);
        parcel.writeInt(this.g);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.p != null ? 1 : 0);
        byte[] bArr = this.p;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.o);
        parcel.writeParcelable(this.q, i);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeLong(this.w);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray((byte[]) this.h.get(i2));
        }
        parcel.writeParcelable(this.i, 0);
        parcel.writeParcelable(this.d, 0);
    }

    public static o a(String str, String str2, int i, int i2, int i3, int i4, List list, com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar, String str3) {
        return a(str, str2, i, i2, i3, i4, -1, -1, -1, list, dVar, 0, str3, null);
    }

    public static o a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, List list, com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar, int i8, String str3, com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVar) {
        return new o(str, null, str2, null, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str3, -1, Long.MAX_VALUE, list, dVar, bVar);
    }

    public static o a(String str, String str2, int i, String str3, int i2, com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar, long j, List list) {
        return new o(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, i2, j, list, dVar, null);
    }

    public static o a(String str, String str2, com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar) {
        return new o(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, dVar, null);
    }

    public final MediaFormat a() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f);
        String str = this.y;
        if (str != null) {
            mediaFormat.setString(POBConstants.KEY_LANGUAGE, str);
        }
        a(mediaFormat, "max-input-size", this.g);
        a(mediaFormat, "width", this.j);
        a(mediaFormat, "height", this.k);
        float f = this.l;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        a(mediaFormat, "rotation-degrees", this.m);
        a(mediaFormat, "channel-count", this.r);
        a(mediaFormat, "sample-rate", this.s);
        a(mediaFormat, "encoder-delay", this.u);
        a(mediaFormat, "encoder-padding", this.v);
        for (int i = 0; i < this.h.size(); i++) {
            mediaFormat.setByteBuffer(m.a("csd-", i), ByteBuffer.wrap((byte[]) this.h.get(i)));
        }
        com.fyber.inneractive.sdk.player.exoplayer2.video.c cVar = this.q;
        if (cVar != null) {
            a(mediaFormat, "color-transfer", cVar.c);
            a(mediaFormat, "color-standard", cVar.f2195a);
            a(mediaFormat, "color-range", cVar.b);
            byte[] bArr = cVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public o(Parcel parcel) {
        this.f2116a = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.c = parcel.readString();
        this.b = parcel.readInt();
        this.g = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.o = parcel.readInt();
        this.q = (com.fyber.inneractive.sdk.player.exoplayer2.video.c) parcel.readParcelable(com.fyber.inneractive.sdk.player.exoplayer2.video.c.class.getClassLoader());
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readLong();
        int i = parcel.readInt();
        this.h = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.h.add(parcel.createByteArray());
        }
        this.i = (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) parcel.readParcelable(com.fyber.inneractive.sdk.player.exoplayer2.drm.d.class.getClassLoader());
        this.d = (com.fyber.inneractive.sdk.player.exoplayer2.metadata.b) parcel.readParcelable(com.fyber.inneractive.sdk.player.exoplayer2.metadata.b.class.getClassLoader());
    }

    public static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }
}
