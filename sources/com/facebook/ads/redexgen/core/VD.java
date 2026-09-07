package com.facebook.ads.redexgen.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.extractor.metadata.flac.PictureFrame;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class VD implements Parcelable.Creator<PictureFrame> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final PictureFrame createFromParcel(Parcel parcel) {
        return new PictureFrame(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final PictureFrame[] newArray(int i) {
        return new PictureFrame[i];
    }
}
