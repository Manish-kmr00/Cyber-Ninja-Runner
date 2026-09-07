package com.unity3d.player;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: renamed from: com.unity3d.player.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class C3811k implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerDownloadStatusCallback f8284a;
    private UnityPlayer b;
    private String[] c;

    public C3811k(UnityPlayer unityPlayer, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, String[] strArr) {
        this.b = unityPlayer;
        this.f8284a = iAssetPackManagerDownloadStatusCallback;
        this.c = strArr;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map mapPackStates = assetPackStates.packStates();
            if (mapPackStates.size() == 0) {
                return;
            }
            Vector vector = new Vector();
            for (AssetPackState assetPackState : mapPackStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                    String strName = assetPackState.name();
                    int iStatus = assetPackState.status();
                    int iErrorCode = assetPackState.errorCode();
                    long j = assetPackStates.totalBytes();
                    this.b.invokeOnMainThread(new RunnableC3799g(Collections.singleton(this.f8284a), strName, iStatus, j, iStatus == 4 ? j : 0L, 0, iErrorCode));
                } else {
                    vector.add(assetPackState.name());
                }
            }
            if (vector.size() > 0) {
                C3820n c3820n = C3820n.e;
                UnityPlayer unityPlayer = this.b;
                IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.f8284a;
                c3820n.getClass();
                synchronized (C3820n.e) {
                    Object obj = c3820n.d;
                    if (obj == null) {
                        C3802h c3802h = new C3802h(c3820n, unityPlayer, iAssetPackManagerDownloadStatusCallback);
                        c3820n.b.registerListener(c3802h);
                        c3820n.d = c3802h;
                    } else {
                        ((C3802h) obj).a(iAssetPackManagerDownloadStatusCallback);
                    }
                    c3820n.c.addAll(vector);
                    c3820n.b.fetch(vector);
                }
            }
        } catch (RuntimeExecutionException e) {
            e = e;
            String[] strArr = this.c;
            if (strArr.length == 1) {
                String str = strArr[0];
                while (true) {
                    if (e instanceof AssetPackException) {
                        errorCode = e.getErrorCode();
                        break;
                    }
                    e = e.getCause();
                    if (e == null) {
                        errorCode = -100;
                        break;
                    }
                }
                this.b.invokeOnMainThread(new RunnableC3799g(Collections.singleton(this.f8284a), str, 0, 0L, 0L, 0, errorCode));
                return;
            }
            C3820n c3820n2 = C3820n.e;
            IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback2 = this.f8284a;
            c3820n2.getClass();
            for (String str2 : strArr) {
                c3820n2.b.getPackStates(Collections.singletonList(str2)).addOnCompleteListener(new C3811k(c3820n2.f8291a, iAssetPackManagerDownloadStatusCallback2, new String[]{str2}));
            }
        }
    }
}
