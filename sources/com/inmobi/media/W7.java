package com.inmobi.media;

import android.media.MediaMetadataRetriever;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class W7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3227a;
    public final long b;
    public final String c;
    public final C3625x7 d;

    public W7(long j, long j2, String referencedAssetId, C3625x7 nativeDataModel) {
        Intrinsics.checkNotNullParameter(referencedAssetId, "referencedAssetId");
        Intrinsics.checkNotNullParameter(nativeDataModel, "nativeDataModel");
        this.f3227a = j;
        this.b = j2;
        this.c = referencedAssetId;
        this.d = nativeDataModel;
        Intrinsics.checkNotNullExpressionValue("X7", "getSimpleName(...)");
    }

    public final long a() {
        long j = this.f3227a;
        C3455l7 c3455l7M = this.d.m(this.c);
        try {
            if (c3455l7M instanceof C3426j8) {
                Rc rcD = ((C3426j8) c3455l7M).d();
                String strB = rcD != null ? ((Qc) rcD).b() : null;
                if (strB != null) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(strB);
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    j += (long) ((this.b / 100.0d) * ((strExtractMetadata != null ? Long.parseLong(strExtractMetadata) : 0L) / ((long) 1000)));
                    mediaMetadataRetriever.release();
                }
            }
        } catch (Exception unused) {
        }
        return Math.max(j, 0L);
    }
}
