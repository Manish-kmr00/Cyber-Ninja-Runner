package com.bykv.vk.openvk.pA.pA.Og.ZZv;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes6.dex */
public class Og extends com.bykv.vk.openvk.pA.pA.Og.ZZv.pA {
    private final Object JG;
    private final pA KZx;
    private Surface ML;
    private final MediaPlayer Og;
    private volatile boolean SD;
    private com.bykv.vk.openvk.pA.pA.Og.pA.pA ZZv;

    public Og() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.JG = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.Og = mediaPlayer;
        }
        pA(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable unused) {
        }
        this.KZx = new pA(this);
        oX();
    }

    private void pA(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.pA.pA.pA.KZx.pA(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable unused) {
                declaredField.setAccessible(false);
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void pA(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.JG) {
            try {
                if (!this.SD && surfaceHolder != null && surfaceHolder.getSurface() != null && this.pA) {
                    this.Og.setDisplay(surfaceHolder);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void pA(Surface surface) {
        aBv();
        this.ML = surface;
        this.Og.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void pA(com.bykv.vk.openvk.pA.pA.pA.Og og) throws Throwable {
        this.Og.setPlaybackParams(this.Og.getPlaybackParams().setSpeed(og.pA()));
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void pA(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.Og.setDataSource(uri.getPath());
        } else {
            this.Og.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void pA(FileDescriptor fileDescriptor) throws Throwable {
        this.Og.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public synchronized void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        this.ZZv = com.bykv.vk.openvk.pA.pA.Og.pA.pA.pA(com.bykv.vk.openvk.pA.pA.pA.KZx.pA(), kZx);
        com.bykv.vk.openvk.pA.pA.Og.pA.Og.KZx.pA(kZx);
        this.Og.setDataSource(this.ZZv);
    }

    private void DX() {
        com.bykv.vk.openvk.pA.pA.Og.pA.pA pAVar = this.ZZv;
        if (pAVar != null) {
            try {
                pAVar.close();
            } catch (Throwable unused) {
            }
            this.ZZv = null;
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void ML() throws Throwable {
        this.Og.start();
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void JG() throws Throwable {
        this.Og.stop();
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void SD() throws Throwable {
        this.Og.pause();
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void omh() {
        MediaPlayer mediaPlayer = this.Og;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void Og(boolean z) throws Throwable {
        this.Og.setScreenOnWhilePlaying(z);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void pA(long j, int i) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.Og.seekTo((int) j);
            return;
        }
        if (i == 0) {
            this.Og.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.Og.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.Og.seekTo((int) j, 2);
        } else if (i == 3) {
            this.Og.seekTo((int) j, 3);
        } else {
            this.Og.seekTo((int) j);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public long Bzk() {
        try {
            return this.Og.getCurrentPosition();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public long SGo() {
        try {
            return this.Og.getDuration();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void BSW() throws Throwable {
        synchronized (this.JG) {
            if (!this.SD) {
                this.Og.release();
                this.SD = true;
                aBv();
                DX();
                pA();
                oX();
            }
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void WV() throws Throwable {
        try {
            this.Og.reset();
        } catch (Throwable unused) {
        }
        DX();
        pA();
        oX();
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void KZx(boolean z) throws Throwable {
        this.Og.setLooping(z);
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void ZZv(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.Og;
        if (mediaPlayer == null) {
            return;
        }
        if (z) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public int Wx() {
        MediaPlayer mediaPlayer = this.Og;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public int Sn() {
        MediaPlayer mediaPlayer = this.Og;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    private void oX() {
        this.Og.setOnPreparedListener(this.KZx);
        this.Og.setOnBufferingUpdateListener(this.KZx);
        this.Og.setOnCompletionListener(this.KZx);
        this.Og.setOnSeekCompleteListener(this.KZx);
        this.Og.setOnVideoSizeChangedListener(this.KZx);
        this.Og.setOnErrorListener(this.KZx);
        this.Og.setOnInfoListener(this.KZx);
    }

    private static class pA implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<Og> pA;

        public pA(Og og) {
            this.pA = new WeakReference<>(og);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                Og og = this.pA.get();
                return og != null && og.Og(i, i2);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                new Object[]{"onError: ", Integer.valueOf(i), Integer.valueOf(i2)};
                Og og = this.pA.get();
                return og != null && og.pA(i, i2);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                Og og = this.pA.get();
                if (og != null) {
                    og.pA(i, i2, 1, 1);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                Og og = this.pA.get();
                if (og != null) {
                    og.ZZv();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                Og og = this.pA.get();
                if (og != null) {
                    og.pA(i);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                Og og = this.pA.get();
                if (og != null) {
                    og.KZx();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                Og og = this.pA.get();
                if (og != null) {
                    og.Og();
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        aBv();
    }

    private void aBv() {
        try {
            Surface surface = this.ML;
            if (surface != null) {
                surface.release();
                this.ML = null;
            }
        } catch (Throwable unused) {
        }
    }
}
