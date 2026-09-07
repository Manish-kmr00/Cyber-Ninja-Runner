package io.bidmachine.media3.extractor.metadata.scte35;

import io.bidmachine.media3.common.Metadata;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SpliceCommand implements Metadata.Entry {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
