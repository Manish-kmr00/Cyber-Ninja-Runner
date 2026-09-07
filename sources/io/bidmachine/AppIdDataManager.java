package io.bidmachine;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import io.bidmachine.internal.utils.LogSafeRunnable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
class AppIdDataManager {
    private volatile String ifv;
    private final AtomicBoolean isUpdateExecuted = new AtomicBoolean(false);

    AppIdDataManager() {
    }

    public String getIfv() {
        return this.ifv;
    }

    public void updateIfv(final Context context) {
        if (this.isUpdateExecuted.compareAndSet(false, true)) {
            CommonBackgroundTaskManager.get().execute(new LogSafeRunnable() { // from class: io.bidmachine.AppIdDataManager$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.SafeRunnable
                public final void onRun() throws Throwable {
                    this.f$0.m7350lambda$updateIfv$0$iobidmachineAppIdDataManager(context);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$updateIfv$0$io-bidmachine-AppIdDataManager, reason: not valid java name */
    /* synthetic */ void m7350lambda$updateIfv$0$iobidmachineAppIdDataManager(Context context) throws Throwable {
        AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: io.bidmachine.AppIdDataManager.1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(AppSetIdInfo appSetIdInfo) {
                if (appSetIdInfo.getScope() == 2) {
                    AppIdDataManager.this.ifv = appSetIdInfo.getId();
                }
            }
        });
    }
}
