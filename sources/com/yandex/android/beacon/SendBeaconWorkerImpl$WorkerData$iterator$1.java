package com.yandex.android.beacon;

import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: compiled from: SendBeaconWorkerImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\t\u0010\n\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"com/yandex/android/beacon/SendBeaconWorkerImpl$WorkerData$iterator$1", "", "Lcom/yandex/android/beacon/BeaconItem;", "last", "getLast", "()Lcom/yandex/android/beacon/BeaconItem;", "setLast", "(Lcom/yandex/android/beacon/BeaconItem;)V", "hasNext", "", "next", "remove", "", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SendBeaconWorkerImpl$WorkerData$iterator$1 implements Iterator<BeaconItem>, KMutableIterator {
    final /* synthetic */ Iterator<BeaconItem> $it;
    private BeaconItem last;
    final /* synthetic */ SendBeaconWorkerImpl.WorkerData this$0;

    /* JADX WARN: Multi-variable type inference failed */
    SendBeaconWorkerImpl$WorkerData$iterator$1(Iterator<? extends BeaconItem> it, SendBeaconWorkerImpl.WorkerData workerData) {
        this.$it = it;
        this.this$0 = workerData;
    }

    public final BeaconItem getLast() {
        return this.last;
    }

    public final void setLast(BeaconItem beaconItem) {
        this.last = beaconItem;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.$it.hasNext();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public BeaconItem next() {
        BeaconItem item = this.$it.next();
        this.last = item;
        Intrinsics.checkNotNullExpressionValue(item, "item");
        return item;
    }

    @Override // java.util.Iterator
    public void remove() throws IOException {
        this.$it.remove();
        SendBeaconDb sendBeaconDb = this.this$0.db;
        BeaconItem beaconItem = this.last;
        sendBeaconDb.remove(beaconItem != null ? beaconItem.asPersistent() : null);
        this.this$0.updateHasMoreWork();
    }
}
