package com.mbridge.msdk.foundation.buffer.sharedperference;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.o0;

/* JADX INFO: compiled from: SharedPerferenceManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static final String b = "a";
    private static a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    FastKV f4886a;

    private a() {
    }

    public static synchronized a b() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public String a(String str) {
        try {
            if (c.m().d() == null) {
                return null;
            }
            a();
            FastKV fastKV = this.f4886a;
            if (fastKV != null) {
                try {
                    return fastKV.getString(str, "");
                } catch (Exception unused) {
                    return "";
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.a(b, "get error: " + e.getMessage());
            }
        }
        return null;
    }

    public void c(String str) {
        if (c.m().d() == null) {
            return;
        }
        a();
        FastKV fastKV = this.f4886a;
        if (fastKV != null) {
            try {
                fastKV.remove(str);
            } catch (Exception unused) {
            }
        }
    }

    public Long b(String str) {
        try {
            if (c.m().d() == null) {
                o0.b(b, "context is null in get");
                return 0L;
            }
            a();
            FastKV fastKV = this.f4886a;
            if (fastKV != null) {
                try {
                    return Long.valueOf(fastKV.getLong(str, 0L));
                } catch (Exception unused) {
                    return 0L;
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.a(b, "getLong error: " + e.getMessage());
            }
        }
        return 0L;
    }

    public int a(String str, int i) {
        try {
            if (c.m().d() == null) {
                return i;
            }
            a();
            FastKV fastKV = this.f4886a;
            if (fastKV != null) {
                try {
                    return fastKV.getInt(str, i);
                } catch (Exception unused) {
                    return i;
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.a(b, "getInt error: " + e.getMessage());
            }
        }
        return i;
    }

    public void b(String str, int i) {
        try {
            if (c.m().d() == null) {
                return;
            }
            a();
            FastKV fastKV = this.f4886a;
            if (fastKV != null) {
                try {
                    fastKV.putInt(str, i);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            if (c.m().d() == null) {
                return;
            }
            a();
            FastKV fastKV = this.f4886a;
            if (fastKV != null) {
                try {
                    fastKV.putString(str, str2);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.a(b, "put error: " + e.getMessage());
            }
        }
    }

    public void a(String str, long j) {
        try {
            if (c.m().d() == null) {
                o0.b(b, "context is null in put");
                return;
            }
            a();
            FastKV fastKV = this.f4886a;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.a(b, "putLong error: " + e.getMessage());
            }
        }
    }

    private void a() {
        if (this.f4886a == null) {
            try {
                this.f4886a = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.f4886a = null;
            }
        }
    }
}
