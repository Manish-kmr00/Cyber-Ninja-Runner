package com.fyber.inneractive.sdk.topics;

import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.os.OutcomeReceiver;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements OutcomeReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f2326a;

    public a(b bVar) {
        this.f2326a = bVar;
    }

    @Override // android.os.OutcomeReceiver
    public final void onError(Throwable th) {
        IAlog.a("%sTopic Experienced an error, and did not return successfully: %s", IAlog.a(b.class), ((Exception) th).getMessage());
    }

    @Override // android.os.OutcomeReceiver
    public final void onResult(Object obj) {
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        b bVar = this.f2326a;
        if (bVar.f2327a) {
            List<Topic> topics = getTopicsResponse.getTopics();
            if (topics.isEmpty()) {
                IAlog.a("Topic results returned empty", new Object[0]);
            } else {
                bVar.f = new ArrayList();
                for (int i = 0; i < topics.size(); i++) {
                    IAlog.a("Topic returned %s", topics.get(i).toString());
                    bVar.f.add(topics.get(i));
                }
            }
        }
        if (this.f2326a.b && IAConfigManager.c()) {
            b bVar2 = this.f2326a;
            List encryptedTopics = getTopicsResponse.getEncryptedTopics();
            bVar2.getClass();
            if (encryptedTopics.isEmpty()) {
                IAlog.a("EncryptedTopic results returned empty", new Object[0]);
                return;
            }
            bVar2.e = new ArrayList();
            for (int i2 = 0; i2 < encryptedTopics.size(); i2++) {
                IAlog.a("EncryptedTopic returned %s", ((EncryptedTopic) encryptedTopics.get(i2)).toString());
                bVar2.e.add((EncryptedTopic) encryptedTopics.get(i2));
            }
        }
    }
}
