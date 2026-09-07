package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackManagerFactory;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: renamed from: com.unity3d.player.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
final class C3820n {
    private static C3820n e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnityPlayer f8291a;
    private AssetPackManager b;
    private HashSet c;
    private Object d;

    private C3820n(UnityPlayer unityPlayer, Context context) {
        if (e != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        this.f8291a = unityPlayer;
        this.b = AssetPackManagerFactory.getInstance(context);
        this.c = new HashSet();
    }

    public static C3820n a(UnityPlayer unityPlayer, Context context) {
        if (e == null) {
            e = new C3820n(unityPlayer, context);
        }
        return e;
    }

    public final Object a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        C3802h c3802h = new C3802h(this, this.f8291a, iAssetPackManagerDownloadStatusCallback);
        this.b.registerListener(c3802h);
        return c3802h;
    }

    public final String a(String str) {
        AssetPackLocation packLocation = this.b.getPackLocation(str);
        return packLocation == null ? "" : packLocation.assetsPath();
    }

    public final void a(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.b.showCellularDataConfirmation(activity).addOnSuccessListener(new C3808j(this.f8291a, iAssetPackManagerMobileDataConfirmationCallback));
    }

    public final void a(Object obj) {
        if (obj instanceof C3802h) {
            this.b.unregisterListener((C3802h) obj);
        }
    }

    public final void a(String[] strArr) {
        this.b.cancel(Arrays.asList(strArr));
    }

    public final void a(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        this.b.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C3811k(this.f8291a, iAssetPackManagerDownloadStatusCallback, strArr));
    }

    public final void a(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.b.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C3817m(this.f8291a, iAssetPackManagerStatusQueryCallback, strArr));
    }

    public final void b(String str) {
        this.b.removePack(str);
    }
}
