package com.google.android.gms.internal.ads;

import com.yandex.div.core.timer.TimerController;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbjg implements zzbjj {
    zzbjg() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcel zzcelVar = (zzcel) obj;
        if (map.keySet().contains("start")) {
            zzcelVar.zzN().zzp();
        } else if (map.keySet().contains(TimerController.STOP_COMMAND)) {
            zzcelVar.zzN().zzq();
        } else if (map.keySet().contains(TimerController.CANCEL_COMMAND)) {
            zzcelVar.zzN().zzo();
        }
    }
}
