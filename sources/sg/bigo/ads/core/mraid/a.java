package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes11.dex */
final class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13628a;
    private final Context b;
    private final InterfaceC0897a c;

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.a$a, reason: collision with other inner class name */
    public interface InterfaceC0897a {
        void a(float f);
    }

    a(Handler handler, Context context, InterfaceC0897a interfaceC0897a) {
        super(handler);
        this.f13628a = -1.0f;
        this.b = context.getApplicationContext();
        this.c = interfaceC0897a;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
        float streamVolume = audioManager != null ? 100.0f * (audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3)) : 100.0f;
        if (streamVolume != this.f13628a) {
            this.f13628a = streamVolume;
            sg.bigo.ads.common.t.a.a(0, 3, "AudioVolumeContentObserver", String.format("Volume change, current value: %s", Float.valueOf(streamVolume)));
            InterfaceC0897a interfaceC0897a = this.c;
            if (interfaceC0897a != null) {
                interfaceC0897a.a(this.f13628a);
            }
        }
    }
}
