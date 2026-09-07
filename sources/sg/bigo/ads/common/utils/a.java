package sg.bigo.ads.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f13281a = null;
    private static boolean b = true;

    public static Drawable a(Context context, int i) {
        if (context != null) {
            try {
                return d(context, i);
            } catch (Exception unused) {
                a("Activity context getDrawable failed. the resId is " + Integer.toHexString(i));
                try {
                    return d(b(context), i);
                } catch (Exception unused2) {
                    a("Application context getDrawable failed. the resId is " + Integer.toHexString(i));
                }
            }
        }
        return null;
    }

    public static View a(Context context, int i, ViewGroup viewGroup, boolean z) {
        View viewB;
        if (context != null) {
            try {
                viewB = b(context, i, viewGroup, z);
            } catch (Exception unused) {
                a("Self context inflateView failed. the resId is " + Integer.toHexString(i));
                viewB = null;
            }
        } else {
            viewB = null;
        }
        if (viewB != null) {
            return viewB;
        }
        try {
            return b(b(context), i, viewGroup, z);
        } catch (Exception unused2) {
            a("Application context inflateView failed. the resId is " + Integer.toHexString(i));
            return viewB;
        }
    }

    public static String a(Context context, int i, Locale locale) {
        CharSequence charSequenceB = b(context, i, locale);
        if (charSequenceB != null) {
            return charSequenceB.toString();
        }
        return null;
    }

    public static String a(Context context, int i, Object... objArr) {
        try {
            return b(context, i, objArr);
        } catch (Exception unused) {
            a("Activity context getString failed. the resId is " + Integer.toHexString(i));
            try {
                return b(b(context), i, objArr);
            } catch (Exception unused2) {
                a("Application context getString failed. the resId is " + Integer.toHexString(i));
                return "";
            }
        }
    }

    private static void a(Context context) {
        if (b) {
            b = false;
            try {
                Context applicationContext = context.getApplicationContext();
                f13281a = applicationContext.createPackageContext(applicationContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    private static void a(String str) {
        sg.bigo.ads.common.t.a.a(0, "BigoAAB", String.valueOf(str));
    }

    public static int b(Context context, int i) {
        try {
            return e(context, i);
        } catch (Exception unused) {
            a("Activity context getDimensionPixelSize failed. the resId is " + Integer.toHexString(i));
            try {
                return e(b(context), i);
            } catch (Exception unused2) {
                a("Application context getDimensionPixelSize failed. the resId is " + Integer.toHexString(i));
                return 0;
            }
        }
    }

    private static Context b(Context context) {
        a(context);
        Context context2 = f13281a;
        return context2 != null ? context2 : context.getApplicationContext();
    }

    private static View b(Context context, int i, ViewGroup viewGroup, boolean z) {
        try {
            return LayoutInflater.from(context).inflate(i, viewGroup, z);
        } catch (Exception unused) {
            c(context);
            return LayoutInflater.from(context).inflate(i, viewGroup, z);
        }
    }

    public static CharSequence b(Context context, int i, Locale locale) {
        Resources resources = context != null ? context.getResources() : null;
        if (resources == null) {
            return null;
        }
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration).getResources().getText(i);
    }

    private static String b(Context context, int i, Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    return context.getString(i, objArr);
                }
            } catch (Exception unused) {
                c(context);
                return (objArr == null || objArr.length <= 0) ? context.getString(i) : context.getString(i, objArr);
            }
        }
        return context.getString(i);
    }

    public static int c(Context context, int i) {
        try {
            return f(context, i);
        } catch (Exception unused) {
            a("Activity context getColor failed. the resId is " + Integer.toHexString(i));
            try {
                return f(b(context), i);
            } catch (Exception unused2) {
                a("Application context getColor failed. the resId is " + Integer.toHexString(i));
                return 0;
            }
        }
    }

    private static void c(Context context) {
        try {
            SplitCompat.install(context);
        } catch (Throwable unused) {
            a("SplitCompact not found.");
        }
    }

    private static Drawable d(Context context, int i) {
        try {
            return context.getResources().getDrawable(i);
        } catch (Exception unused) {
            c(context);
            return context.getResources().getDrawable(i);
        }
    }

    private static int e(Context context, int i) {
        try {
            return context.getResources().getDimensionPixelSize(i);
        } catch (Exception unused) {
            c(context);
            return context.getResources().getDimensionPixelSize(i);
        }
    }

    private static int f(Context context, int i) {
        try {
            return context.getResources().getColor(i);
        } catch (Exception unused) {
            c(context);
            return context.getResources().getColor(i);
        }
    }
}
