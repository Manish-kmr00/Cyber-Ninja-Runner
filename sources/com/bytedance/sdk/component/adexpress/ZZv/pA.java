package com.bytedance.sdk.component.adexpress.ZZv;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.bytedance.sdk.component.utils.WV;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x011b A[Catch: all -> 0x0136, DONT_GENERATE, TryCatch #4 {all -> 0x0136, blocks: (B:61:0x0111, B:63:0x011b, B:66:0x0123, B:68:0x0128, B:70:0x012d, B:72:0x0132), top: B:102:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0121 A[DONT_GENERATE, DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0123 A[Catch: all -> 0x0136, DONT_GENERATE, TryCatch #4 {all -> 0x0136, blocks: (B:61:0x0111, B:63:0x011b, B:66:0x0123, B:68:0x0128, B:70:0x012d, B:72:0x0132), top: B:102:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0128 A[Catch: all -> 0x0136, DONT_GENERATE, TryCatch #4 {all -> 0x0136, blocks: (B:61:0x0111, B:63:0x011b, B:66:0x0123, B:68:0x0128, B:70:0x012d, B:72:0x0132), top: B:102:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x012d A[Catch: all -> 0x0136, DONT_GENERATE, TryCatch #4 {all -> 0x0136, blocks: (B:61:0x0111, B:63:0x011b, B:66:0x0123, B:68:0x0128, B:70:0x012d, B:72:0x0132), top: B:102:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0132 A[Catch: all -> 0x0136, DONT_GENERATE, TRY_LEAVE, TryCatch #4 {all -> 0x0136, blocks: (B:61:0x0111, B:63:0x011b, B:66:0x0123, B:68:0x0128, B:70:0x012d, B:72:0x0132), top: B:102:0x0111 }] */
    public static Bitmap pA(Context context, Bitmap bitmap, int i) {
        RenderScript renderScript;
        Allocation allocation;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate;
        Allocation allocationCreateFromBitmap;
        com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx;
        boolean zABv;
        try {
            if (com.bytedance.sdk.component.adexpress.ZZv.Og() && Build.VERSION.SDK_INT < 26) {
                try {
                    com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx2 = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
                    if (KZx2 != null) {
                        KZx2.aBv();
                    }
                } catch (Throwable th) {
                    WV.pA("BlurUtils", "gaussianBlur destrot error: " + th.getMessage());
                }
                return null;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
            RenderScript renderScriptCreate = RenderScript.create(context);
            if (renderScriptCreate == null) {
                try {
                    com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx3 = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
                    if (KZx3 != null && KZx3.aBv() && renderScriptCreate != null) {
                        RenderScript.releaseAllContexts();
                    }
                } catch (Throwable th2) {
                    WV.pA("BlurUtils", "gaussianBlur destrot error: " + th2.getMessage());
                }
                return null;
            }
            try {
                scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                try {
                    Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                    try {
                        allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                        try {
                            scriptIntrinsicBlurCreate.setRadius(i);
                            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap2);
                            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap);
                            allocationCreateFromBitmap.copyTo(bitmapCreateBitmap);
                            try {
                                com.bytedance.sdk.component.adexpress.pA.pA.KZx KZx4 = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
                                if (KZx4 != null && KZx4.aBv()) {
                                    if (renderScriptCreate != null) {
                                        RenderScript.releaseAllContexts();
                                    }
                                    if (allocationCreateFromBitmap2 != null) {
                                        allocationCreateFromBitmap2.destroy();
                                    }
                                    if (allocationCreateFromBitmap != null) {
                                        allocationCreateFromBitmap.destroy();
                                    }
                                    if (scriptIntrinsicBlurCreate != null) {
                                        scriptIntrinsicBlurCreate.destroy();
                                    }
                                }
                            } catch (Throwable th3) {
                                WV.pA("BlurUtils", "gaussianBlur destrot error: " + th3.getMessage());
                            }
                            return bitmapCreateBitmap;
                        } catch (Throwable th4) {
                            th = th4;
                            renderScript = renderScriptCreate;
                            th = th;
                            allocation = allocationCreateFromBitmap2;
                            WV.pA("BlurUtils", "gaussianBlur error: " + th.getMessage());
                            if (KZx != null) {
                                return null;
                            }
                            if (zABv) {
                                return null;
                            }
                            if (scriptIntrinsicBlurCreate != null) {
                                return null;
                            }
                            return null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        allocationCreateFromBitmap = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    allocation = null;
                    allocationCreateFromBitmap = null;
                    Throwable th7 = th;
                    renderScript = renderScriptCreate;
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                allocation = null;
                scriptIntrinsicBlurCreate = null;
                allocationCreateFromBitmap = null;
            }
        } catch (Throwable th9) {
            th = th9;
            renderScript = null;
            allocation = null;
            scriptIntrinsicBlurCreate = null;
            allocationCreateFromBitmap = null;
        }
        try {
            WV.pA("BlurUtils", "gaussianBlur error: " + th.getMessage());
            try {
                if (KZx != null) {
                    return null;
                }
                if (zABv) {
                    return null;
                }
                if (scriptIntrinsicBlurCreate != null) {
                    return null;
                }
                return null;
            } catch (Throwable th10) {
                return null;
            }
        } finally {
            try {
                KZx = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx();
                if (KZx != null && KZx.aBv()) {
                    if (renderScript != null) {
                        RenderScript.releaseAllContexts();
                    }
                    if (allocation != null) {
                        allocation.destroy();
                    }
                    if (allocationCreateFromBitmap != null) {
                        allocationCreateFromBitmap.destroy();
                    }
                    if (scriptIntrinsicBlurCreate != null) {
                        scriptIntrinsicBlurCreate.destroy();
                    }
                }
            } catch (Throwable th11) {
                WV.pA("BlurUtils", "gaussianBlur destrot error: " + th11.getMessage());
            }
        }
    }
}
