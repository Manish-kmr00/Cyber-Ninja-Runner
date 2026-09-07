package com.google.android.exoplayer2.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.C1980Vn;
import com.facebook.ads.redexgen.core.C2447fq;
import com.facebook.ads.redexgen.core.C2461g4;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new C1980Vn();
    public final long A00;
    public final long A01;

    public TimeSignalCommand(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
    }

    public /* synthetic */ TimeSignalCommand(long j, long j2, C1980Vn c1980Vn) {
        this(j, j2);
    }

    public static long A00(C2447fq c2447fq, long j) {
        long jA0I = c2447fq.A0I();
        if ((128 & jA0I) == 0) {
            return -9223372036854775807L;
        }
        long ptsTime = 1 & jA0I;
        long firstByte = c2447fq.A0Q();
        return (((ptsTime << 32) | firstByte) + j) & 8589934591L;
    }

    public static TimeSignalCommand A01(C2447fq c2447fq, long j, C2461g4 c2461g4) {
        long jA00 = A00(c2447fq, j);
        return new TimeSignalCommand(jA00, c2461g4.A06(jA00));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
    }
}
