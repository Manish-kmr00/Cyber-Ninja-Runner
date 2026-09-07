package io.bidmachine;

import android.content.Context;
import com.explorestack.protobuf.Struct;
import io.bidmachine.protobuf.Extras;
import io.bidmachine.utils.data.StructDataRetriever;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes9.dex */
public class ExtraParamsManager {
    private static volatile ExtraParamsManager instance;
    private Struct privateExtras;
    private final AtomicBoolean isExtrasPrepared = new AtomicBoolean(false);
    private final AtomicBoolean needLoadFromStore = new AtomicBoolean(true);
    private final Object loadFromStoreLock = new Object();
    private final Object updateExtrasLock = new Object();
    private final StructDataRetriever publicDataRetriever = new StructDataRetriever();
    private final StructDataRetriever internalDataRetriever = new StructDataRetriever();

    public static ExtraParamsManager get() {
        ExtraParamsManager extraParamsManager = instance;
        if (extraParamsManager == null) {
            synchronized (ExtraParamsManager.class) {
                extraParamsManager = instance;
                if (extraParamsManager == null) {
                    extraParamsManager = new ExtraParamsManager();
                    instance = extraParamsManager;
                }
            }
        }
        return extraParamsManager;
    }

    private ExtraParamsManager() {
    }

    public Object getPublic(Context context, String str) {
        loadFromStore(context);
        return this.publicDataRetriever.getObjectOrNull(str);
    }

    public StructDataRetriever getInternalDataRetriever(Context context) {
        loadFromStore(context);
        return this.internalDataRetriever;
    }

    public Struct getPrivateStruct(Context context) {
        loadFromStore(context);
        return this.privateExtras;
    }

    boolean isExtrasPrepared() {
        return this.isExtrasPrepared.get();
    }

    void setExtras(Context context, Extras extras) {
        this.isExtrasPrepared.set(true);
        this.needLoadFromStore.set(false);
        synchronized (this.updateExtrasLock) {
            try {
                if (extras == null) {
                    this.publicDataRetriever.clear();
                    this.internalDataRetriever.clear();
                    this.privateExtras = null;
                    BidMachineSharedPreference.clearInitExtras(context);
                    return;
                }
                this.publicDataRetriever.setStruct(extras.getPublic());
                this.internalDataRetriever.setStruct(extras.getInternal());
                this.privateExtras = extras.getPrivate();
                BidMachineSharedPreference.storeInitExtras(context, extras);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void loadFromStore(Context context) {
        if (isExtrasPrepared()) {
            return;
        }
        synchronized (this.loadFromStoreLock) {
            if (this.needLoadFromStore.compareAndSet(true, false)) {
                checkAndPrepareExtras(context, BidMachineSharedPreference.getInitExtras(context));
            }
        }
    }

    private void checkAndPrepareExtras(Context context, Extras extras) {
        synchronized (this.updateExtrasLock) {
            if (isExtrasPrepared()) {
                return;
            }
            setExtras(context, extras);
        }
    }
}
