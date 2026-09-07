package androidx.browser.customtabs;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes13.dex */
public interface PostMessageBackend {
    void onDisconnectChannel(Context context);

    boolean onNotifyMessageChannelReady(Bundle bundle);

    boolean onPostMessage(String str, Bundle bundle);
}
