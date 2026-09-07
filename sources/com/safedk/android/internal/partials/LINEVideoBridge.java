package com.safedk.android.internal.partials;

import android.media.MediaPlayer;
import android.view.Surface;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import java.io.IOException;

/* JADX INFO: compiled from: LINESourceFile */
/* JADX INFO: loaded from: classes11.dex */
public class LINEVideoBridge {
    public static void MediaPlayerStart(MediaPlayer mp) throws IllegalStateException {
        Logger.d("LINEVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/LINEVideoBridge;->MediaPlayerStart(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerStart: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("com.five_corp.ad", mp);
                CreativeInfoManager.a("com.five_corp.ad", (String) null, false, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
            }
        }
        mp.start();
    }

    public static void MediaPlayerPause(MediaPlayer mp) throws IllegalStateException {
        Logger.d("LINEVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/LINEVideoBridge;->MediaPlayerPause(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerPause: " + mp + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("com.five_corp.ad", (String) null, true, "media-player");
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerPause: " + e.getMessage());
            }
        }
        mp.pause();
    }

    public static void MediaPlayerRelease(MediaPlayer mp) throws IllegalStateException {
        Logger.d("LINEVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/LINEVideoBridge;->MediaPlayerRelease(Landroid/media/MediaPlayer;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerRelease: " + mp + ", isOnUiThread = " + n.c());
                if (CreativeInfoManager.a("com.five_corp.ad", AdNetworkConfiguration.SUPPORTS_MEDIA_PLAYER_RELEASE_EOV, false)) {
                    CreativeInfoManager.a("com.five_corp.ad", (String) null, true, "media-player");
                }
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerStart: " + e.getMessage());
            }
        }
        mp.release();
    }

    public static void MediaPlayerSetDataSource(MediaPlayer mp, String path) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Logger.d("LINEVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/LINEVideoBridge;->MediaPlayerSetDataSource(Landroid/media/MediaPlayer;Ljava/lang/String;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerSetDataSource: player " + mp + ", path " + path + ", isOnUiThread = " + n.c());
                CreativeInfoManager.a("com.five_corp.ad", mp, path);
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerSetDataSource: " + e.getMessage());
            }
        }
        mp.setDataSource(path);
    }

    public static void MediaPlayerSetSurface(MediaPlayer mp, Surface surface) {
        Logger.d("LINEVideo|SafeDK: Partial-Video> Lcom/safedk/android/internal/partials/LINEVideoBridge;->MediaPlayerSetSurface(Landroid/media/MediaPlayer;Landroid/view/Surface;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("VideoBridge", "MediaPlayerSetSurface: player " + mp + ", surface " + surface + ", isOnUiThread = " + n.c());
            } catch (Exception e) {
                Logger.d("VideoBridge", "exception in MediaPlayerSetSurface: " + e.getMessage());
            }
        }
        mp.setSurface(surface);
    }
}
