package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class b02 implements g01.b {
    public static final Parcelable.Creator<b02> CREATOR = new a();
    public final List<b> b;

    final class a implements Parcelable.Creator<b02> {
        @Override // android.os.Parcelable.Creator
        public final b02 createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, b.class.getClassLoader());
            return new b02(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final b02[] newArray(int i) {
            return new b02[i];
        }

        a() {
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR;
        public final long b;
        public final long c;
        public final int d;

        final class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i) {
                return new b[i];
            }

            a() {
            }
        }

        static {
            new Comparator() { // from class: com.yandex.mobile.ads.impl.b02$b$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return b02.b.a((b02.b) obj, (b02.b) obj2);
                }
            };
            CREATOR = new a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(b bVar, b bVar2) {
            return wq.b().a(bVar.b, bVar2.b).a(bVar.c, bVar2.c).a(bVar.d, bVar2.d).a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public b(int i, long j, long j2) {
            hg.a(j < j2);
            this.b = j;
            this.c = j2;
            this.d = i;
        }

        public final String toString() {
            long j = this.b;
            long j2 = this.c;
            int i = this.d;
            int i2 = x82.f10629a;
            Locale locale = Locale.US;
            return "Segment: startTimeMs=" + j + ", endTimeMs=" + j2 + ", speedDivisor=" + i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.c == bVar.c && this.d == bVar.d;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.d)});
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
            parcel.writeInt(this.d);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.b;
    }

    public b02(ArrayList arrayList) {
        this.b = arrayList;
        hg.a(!a(arrayList));
    }

    private static boolean a(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return false;
        }
        long j = ((b) arrayList.get(0)).c;
        for (int i = 1; i < arrayList.size(); i++) {
            if (((b) arrayList.get(i)).b < j) {
                return true;
            }
            j = ((b) arrayList.get(i)).c;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b02.class != obj.getClass()) {
            return false;
        }
        return this.b.equals(((b02) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.b);
    }
}
