package io.bidmachine.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.nativead.view.NativeMediaView;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public interface NativeContainer {
    View getProviderView(Context context);

    boolean isViewRegistered();

    void registerView(ViewGroup viewGroup, View view, NativeMediaView nativeMediaView, Set<View> set);

    void unregisterView();
}
