package net.pubnative.lite.sdk.provider;

import android.content.Context;
import java.util.List;
import net.pubnative.lite.sdk.models.Topic;

/* JADX INFO: loaded from: classes9.dex */
public interface TopicProvider {

    public interface Callback {
        void onResult(List<Topic> list);
    }

    void getTopics(Context context, Callback callback);
}
