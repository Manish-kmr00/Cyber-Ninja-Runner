package com.smaato.sdk.video.vast.buildlight.compare;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.model.MediaFile;
import java.util.Comparator;

/* JADX INFO: loaded from: classes14.dex */
public class MediaFileComparator implements Comparator<MediaFile> {
    private final BitrateComparator bitrateComparator;
    private final SizeComparator sizeComparator;

    public MediaFileComparator(SizeComparator<MediaFile> sizeComparator, BitrateComparator bitrateComparator) {
        this.sizeComparator = (SizeComparator) Objects.requireNonNull(sizeComparator, "sizeComparator can not be null in MediaFileComparator");
        this.bitrateComparator = (BitrateComparator) Objects.requireNonNull(bitrateComparator, "bitrateComparator cannot be null in MediaFileComparator");
    }

    @Override // java.util.Comparator
    public int compare(MediaFile mediaFile, MediaFile mediaFile2) {
        int iCompare = this.sizeComparator.compare(mediaFile, mediaFile2);
        return iCompare == 0 ? this.bitrateComparator.compare(mediaFile, mediaFile2) : iCompare;
    }
}
