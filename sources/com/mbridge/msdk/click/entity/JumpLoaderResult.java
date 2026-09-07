package com.mbridge.msdk.click.entity;

import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class JumpLoaderResult implements Serializable, NoProGuard {
    public static final int CODE_DOWNLOAD = 3;
    public static final int CODE_LINK = 2;
    public static final int CODE_MARKET = 1;
    public static final int CODE_NULL = 4;
    private static final long serialVersionUID = 1;
    private int code;
    private String content;
    private String exceptionMsg;
    private String header;
    private boolean is302Jump;
    private boolean jumpDone;
    private String msg;
    private String noticeurl;
    private int statusCode;
    private boolean success;
    private int type;
    private String url;

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public String getHeader() {
        return this.header;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getNoticeurl() {
        return this.noticeurl;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isIs302Jump() {
        return this.is302Jump;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean isjumpDone() {
        return this.jumpDone;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setExceptionMsg(String str) {
        this.exceptionMsg = str;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public void setIs302Jump(boolean z) {
        this.is302Jump = z;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setNoticeurl(String str) {
        this.noticeurl = str;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setjumpDone(boolean z) {
        this.jumpDone = z;
    }
}
