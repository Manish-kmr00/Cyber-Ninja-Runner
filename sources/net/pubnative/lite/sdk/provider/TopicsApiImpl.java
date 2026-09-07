package net.pubnative.lite.sdk.provider;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.os.Build;
import android.os.OutcomeReceiver;
import android.os.ext.SdkExtensions;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class TopicsApiImpl implements TopicProvider {
    private final String TAG = "TopicsApiImpl";

    @Override // net.pubnative.lite.sdk.provider.TopicProvider
    public void getTopics(Context context, final TopicProvider.Callback callback) {
        if (context == null || callback == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 34 && SdkExtensions.getExtensionVersion(1000000) >= 4) {
            TopicsManager topicsManager = (TopicsManager) context.getSystemService(TopicsManager.class);
            ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
            GetTopicsRequest.Builder builder = new GetTopicsRequest.Builder();
            builder.setAdsSdkName(context.getPackageName());
            if (SdkExtensions.getExtensionVersion(1000000) >= 5) {
                builder.setShouldRecordObservation(true);
            }
            if (topicsManager != null) {
                try {
                    topicsManager.getTopics(builder.build(), executorServiceNewCachedThreadPool, new OutcomeReceiver<GetTopicsResponse, Exception>() { // from class: net.pubnative.lite.sdk.provider.TopicsApiImpl.1
                        @Override // android.os.OutcomeReceiver
                        public void onResult(GetTopicsResponse getTopicsResponse) {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < getTopicsResponse.getTopics().size(); i++) {
                                Topic topic = getTopicsResponse.getTopics().get(i);
                                net.pubnative.lite.sdk.models.Topic topic2 = new net.pubnative.lite.sdk.models.Topic(topic.getTopicId(), topic.getTaxonomyVersion(), "Chromium Topics API taxonomy");
                                if (!arrayList.contains(topic2)) {
                                    arrayList.add(topic2);
                                }
                            }
                            callback.onResult(arrayList);
                        }

                        @Override // android.os.OutcomeReceiver
                        public void onError(Exception exc) {
                            Logger.e(TopicsApiImpl.this.TAG, exc.getMessage());
                            callback.onResult(null);
                            super.onError(exc);
                        }
                    });
                    return;
                } catch (Exception e) {
                    Logger.e(this.TAG, e.getMessage());
                    callback.onResult(null);
                    return;
                }
            }
            callback.onResult(null);
            return;
        }
        callback.onResult(null);
    }
}
