package com.mzc.CreativeModel.PrototypePattern;

/**
 * @author MaZhiCheng
 * @date 2021/6/3 - 22:24
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

/**
 * 邮件类代码
 */
public class Mail {
    //收件人
    private String receiver;

    //邮件名称
    private String subject;

    //称谓
    private String appellation;

    //邮件内容
    private String context;

    //邮件尾部一般加上“XXX版权所有等信息”
    private String tail;

    //构造函数
    public Mail(AdvTemplate advTemplate) {
        this.context = advTemplate.getAdvContext();
        this.subject = advTemplate.getAdvSubject();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
