package com.bykv.vk.openvk.pA.pA.pA.JG;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class ZZv extends TextureView implements TextureView.SurfaceTextureListener, Og {
    private Og.pA Og;
    private pA pA;

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.Og
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.Og
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public ZZv(Context context) {
        this(context, null);
    }

    public ZZv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.Og
    public void pA(pA pAVar) {
        this.pA = pAVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.JG.Og
    public void pA(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        pA pAVar = this.pA;
        if (pAVar != null) {
            pAVar.pA(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pA pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.pA(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(Og.pA pAVar) {
        this.Og = pAVar;
    }
}
