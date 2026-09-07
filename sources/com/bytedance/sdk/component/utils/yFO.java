package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes13.dex */
public final class yFO {
    private static boolean JG;
    private static Resources KZx;
    private static boolean ML;
    private static String Og;
    private static String ZZv;
    private static Context pA;

    public static void pA(Context context) {
        pA = context;
    }

    public static void pA(String str) {
        ZZv = str;
    }

    private static String ZZv(Context context) {
        if (ZZv == null) {
            ZZv = context.getPackageName();
        }
        return ZZv;
    }

    private static int pA(Context context, String str, String str2) {
        int identifier = Og(context).getIdentifier(str, str2, ZZv(context));
        if (identifier != 0) {
            return identifier;
        }
        if (!ML) {
            KZx(context);
            return Og(context).getIdentifier(str, str2, ZZv(context));
        }
        return context.getResources().getIdentifier(str, str2, ZZv(context));
    }

    public static String pA(Context context, String str) {
        return Og(context).getString(Og(context, str));
    }

    public static int Og(Context context, String str) {
        return pA(context, str, "string");
    }

    public static Drawable KZx(Context context, String str) {
        try {
            return Og(context).getDrawable(ZZv(context, str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static int ZZv(Context context, String str) {
        try {
            return pA(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int ML(Context context, String str) {
        return pA(context, str, "id");
    }

    public static int JG(Context context, String str) {
        return pA(context, str, "style");
    }

    public static int SD(Context context, String str) {
        return Og(context).getColor(omh(context, str));
    }

    public static int omh(Context context, String str) {
        return pA(context, str, "color");
    }

    public static int Bzk(Context context, String str) {
        return pA(context, str, "anim");
    }

    public static Resources Og(Context context) {
        Resources resources = KZx;
        if (resources == null) {
            resources = null;
        }
        Context context2 = pA;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static synchronized void KZx(Context context) {
        try {
            if (TextUtils.isEmpty(Og)) {
                return;
            }
            Resources resources = context.getResources();
            KZx = new Resources(Og(resources.getAssets(), Og + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
            ZZv = context.getPackageName();
            ML = true;
        } catch (Throwable th) {
            Log.e("ResourceHelp", "makePluginResources failed", th);
        }
    }

    private static AssetManager Og(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            pA(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            pA(assetManager, str);
        }
        try {
            du.pA(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static boolean pA(AssetManager assetManager, String str) {
        Method methodPA = du.pA((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (methodPA == null) {
            methodPA = du.pA((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (methodPA != null) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i < 0) {
                    break;
                }
                try {
                    if (((Integer) methodPA.invoke(assetManager, str)).intValue() != 0) {
                        return true;
                    }
                    i = i2;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }
}
