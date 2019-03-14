package com.qq.weixin.xml.mp.accept;

import com.qq.weixin.xml.mp.BaseAcceptMsg;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

/**
 * 事件消息
 *
 * @author gong.hua
 */
@Data
public class BasicEvent extends BaseAcceptMsg {
    /**
     * 关注事件
     */
    public static final String SUBSCRIBE_EVENT = "subscribe";
    /**
     * 取消关注事件
     */
    public static final String UNSUBSCRIBE_EVENT = "unsubscribe";
    /**
     * 上报地理位置事件
     */
    public static final String LOCATION_EVENT = "LOCATION";
    /**
     * 已关注（扫描带参数二维码）
     **/
    public static final String SCAN_EVENT = "SCAN";
    /**
     * 点击菜单拉取消息时的事件推送
     **/
    public static final String CLICK_EVENT = "CLICK";
    /**
     * 点击菜单跳转链接时的事件推送
     **/
    public static final String VIEW_EVENT = "VIEW";
    /**
     * 小程序名称设置回调
     **/
    public static final String WXA_NICKNAME_AUDIT_EVENT = "wxa_nickname_audit";
    /**
     * 代码管理-审核通过
     **/
    public static final String WEAPP_AUDIT_SUCCESS_EVENT = "weapp_audit_success";
    /**
     * 代码管理-审核不通过
     **/
    public static final String WEAPP_AUDIT_FAIL_EVENT = "weapp_audit_fail";
    /**
     * 资质认证成功
     **/
    public static final String QUALIFICATION_VERIFY_SUCCESS_EVENT = "qualification_verify_success";
    /**
     * 资质认证失败
     **/
    public static final String QUALIFICATION_VERIFY_FAIL_EVENT = "qualification_verify_fail";
    /**
     * 名称认证成功
     **/
    public static final String NAMING_VERIFY_SUCCESS_EVENT = "naming_verify_success";
    /**
     * 名称认证失败
     */
    public static final String NAMING_VERIFY_FAIL_EVENT = "naming_verify_fail";
    /**
     * 年审通知
     */
    public static final String ANNUAL_RENEW_EVENT = "annual_renew";
    /**
     * 扫码推事件
     **/
    public static final String SCANCODE_PUSH_EVENT = "scancode_push";
    /**
     * 扫码推事件且弹出“消息接收中”
     **/
    public static final String SCANCODE_WAITMSG_EVENT = "scancode_waitmsg";
    /**
     * 弹出系统拍照发图的事件推送
     **/
    public static final String PIC_SYSPHOTO_EVENT = "pic_sysphoto";
    /**
     * 弹出拍照或者相册发图的事件推送
     **/
    public static final String PIC_PHOTO_OR_ALBUM_EVENT = "pic_photo_or_album";
    /**
     * 弹出微信相册发图器的事件推送
     **/
    public static final String PIC_WEIXIN_EVENT = "pic_weixin";
    /**
     * 弹出地理位置选择器的事件推送
     **/
    public static final String LOCATION_SELECT_EVENT = "location_select";
    /**
     * 点击菜单跳转小程序的事件推送
     **/
    public static final String VIEW_MINIPROGRAM_EVENT = "view_miniprogram";

    /**
     * 事件类型
     */
    @XmlElement(name = "Event")
    private String event;
    /**
     * 事件KEY值
     */
    @XmlElement(name = "EventKey")
    private String eventKey;

    protected BasicEvent(String event) {
        super("event");
        this.event = event;
    }
}
