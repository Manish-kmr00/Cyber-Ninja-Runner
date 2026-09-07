package com.smaato.sdk.video.vast.tracking;

import android.util.SparseArray;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Sets;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Predicate;
import com.smaato.sdk.video.vast.model.Tracking;
import com.smaato.sdk.video.vast.model.VastEvent;
import com.smaato.sdk.video.vast.utils.VastVideoPlayerTimeConverterUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
final class OffsetEventsManager {
    private final SparseArray percentageTrackingSA;
    private final Set trackedTrackings = Collections.synchronizedSet(new HashSet());

    private OffsetEventsManager(SparseArray sparseArray) {
        this.percentageTrackingSA = sparseArray;
    }

    private static void appendTrackingPercentage(SparseArray sparseArray, Tracking tracking, int i) {
        Set set = (Set) sparseArray.get(i);
        if (set != null) {
            set.add(tracking);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(tracking);
        sparseArray.append(i, hashSet);
    }

    static OffsetEventsManager fromTrackingsMap(Map<VastEvent, List<Tracking>> map, final long j, final Logger logger) {
        final SparseArray sparseArray = new SparseArray();
        Iterator<VastEvent> it = VastEvent.EVENTS_WITH_OFFSET.iterator();
        while (it.hasNext()) {
            Objects.onNotNull(map.get(it.next()), new Consumer() { // from class: com.smaato.sdk.video.vast.tracking.OffsetEventsManager$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    OffsetEventsManager.lambda$fromTrackingsMap$0(j, logger, sparseArray, (List) obj);
                }
            });
        }
        return new OffsetEventsManager(sparseArray);
    }

    static /* synthetic */ void lambda$fromTrackingsMap$0(long j, Logger logger, SparseArray sparseArray, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Tracking tracking = (Tracking) it.next();
            int iConvertOffsetStringToPercentage = VastVideoPlayerTimeConverterUtils.convertOffsetStringToPercentage(tracking.offset, j, logger);
            if (iConvertOffsetStringToPercentage >= 0) {
                appendTrackingPercentage(sparseArray, tracking, iConvertOffsetStringToPercentage);
            }
        }
    }

    Set<Tracking> getOffsettedTrackingsToTrackNow(Logger logger, long j, long j2) {
        HashSet hashSet = new HashSet();
        if (j2 == 0) {
            logger.warning(LogDomain.VAST, "Video duration is 0", new Object[0]);
            return hashSet;
        }
        for (int i = 0; i < this.percentageTrackingSA.size(); i++) {
            if (this.percentageTrackingSA.keyAt(i) <= (100 * j) / j2) {
                hashSet.addAll(Sets.retainToSet((Collection) this.percentageTrackingSA.valueAt(i), new Predicate() { // from class: com.smaato.sdk.video.vast.tracking.OffsetEventsManager$$ExternalSyntheticLambda1
                    @Override // com.smaato.sdk.core.util.fi.Predicate
                    public final boolean test(Object obj) {
                        return this.f$0.m5721x30ccd157((Tracking) obj);
                    }
                }));
            }
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: lambda$getOffsettedTrackingsToTrackNow$1$com-smaato-sdk-video-vast-tracking-OffsetEventsManager, reason: not valid java name */
    /* synthetic */ boolean m5721x30ccd157(Tracking tracking) {
        return !this.trackedTrackings.contains(tracking);
    }

    void markAsTracked(Tracking tracking) {
        this.trackedTrackings.add(tracking);
    }
}
