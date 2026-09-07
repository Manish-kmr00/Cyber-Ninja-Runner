package com.pubmatic.sdk.webrendering.mraid;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.pubmatic.sdk.common.log.POBLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public class POBAudioVolumeObserver {
    private static volatile POBAudioVolumeObserver c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f7884a = new HashSet();
    private b b;

    interface a {
        void a(Double d);
    }

    class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AudioManager f7885a;
        private int b;

        b(Handler handler, AudioManager audioManager) {
            super(handler);
            this.f7885a = audioManager;
            this.b = audioManager.getStreamVolume(3);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            AudioManager audioManager = this.f7885a;
            if (audioManager != null) {
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = this.f7885a.getStreamVolume(3);
                if (streamVolume != this.b) {
                    this.b = streamVolume;
                    POBAudioVolumeObserver.this.a(streamVolume, streamMaxVolume);
                }
            }
        }
    }

    private POBAudioVolumeObserver() {
    }

    private void b(Context context) {
        if (this.b != null) {
            context.getContentResolver().unregisterContentObserver(this.b);
            this.b = null;
        }
    }

    private void c(Context context) {
        b(context);
        c = null;
    }

    protected static Double getAudioVolumePercentage(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return Double.valueOf((((double) audioManager.getStreamVolume(3)) * 100.0d) / ((double) audioManager.getStreamMaxVolume(3)));
        } catch (Exception e) {
            POBLog.error("POBAudioVolumeObserver", "Error in getting audio manager. Error: %s", e.getMessage());
            return null;
        }
    }

    protected void registerListener(Context context, a aVar) {
        if (this.f7884a.contains(aVar)) {
            return;
        }
        if (this.b == null) {
            a(context);
        }
        this.f7884a.add(aVar);
    }

    protected void unregisterListener(Context context, a aVar) {
        this.f7884a.remove(aVar);
        if (this.f7884a.isEmpty()) {
            c(context);
        }
    }

    static POBAudioVolumeObserver a() {
        if (c == null) {
            synchronized (POBAudioVolumeObserver.class) {
                if (c == null) {
                    c = new POBAudioVolumeObserver();
                }
            }
        }
        return c;
    }

    private void a(Context context) {
        if (this.b == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager != null) {
                    this.b = new b(handler, audioManager);
                    context.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.b);
                }
            } catch (Exception e) {
                POBLog.warn("POBAudioVolumeObserver", "Error in getting audio manager. Error: %s", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        Double dValueOf = Double.valueOf((((double) i) * 100.0d) / ((double) i2));
        Iterator it = this.f7884a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(dValueOf);
        }
    }
}
