package com.qq.weixin.api;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseResponse extends JSONObject {
    /**
     * 返回码类型参考
     *
     * @link {https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318634&token=2dc40382b1879696f2d7c35d221d8844cae685fd&lang=}
     */
//    private String errcode;
//    private String errmsg;
    public String getErrcode() {
        return this.getString("errcode");
    }

    public void setErrcode(String errcode) {
        this.put("errcode", errcode);
    }


    public void setErrmsg(String errmsg) {
        this.put("errmsg", errmsg);
    }

    /**
     * 错误转换
     *
     * @return
     */
    public String getErrmsg() {
        return ErrorMsg.getDescByCode(getErrcode(), this.getString("errmsg"));
    }

    @Getter
    private enum ErrorMsg {
        ERR_DEFAULT("-1", "unknown error", "未知错误"),
        ERR_0("0","ok","成功"),
        ERR_40001("40001","invalid credential","不合法的调用凭证"),
        ERR_40002("40002","invalid grant_type","不合法的grant_type"),
        ERR_40003("40003","invalid openid","不合法的OpenID"),
        ERR_40004("40004","invalid media type","不合法的媒体文件类型"),
        ERR_40007("40007","invalid media_id","不合法的media_id"),
        ERR_40008("40008","invalid message type","不合法的message_type"),
        ERR_40009("40009","invalid image size","不合法的图片大小"),
        ERR_40010("40010","invalid voice size","不合法的语音大小"),
        ERR_40011("40011","invalid video size","不合法的视频大小"),
        ERR_40012("40012","invalid thumb size","不合法的缩略图大小"),
        ERR_40013("40013","invalid appid","不合法的AppID"),
        ERR_40014("40014","invalid access_token","不合法的access_token"),
        ERR_40015("40015","invalid menu type","不合法的菜单类型"),
        ERR_40016("40016","invalid button size","不合法的菜单按钮个数"),
        ERR_40017("40017","invalid button type","不合法的按钮类型"),
        ERR_40018("40018","invalid button name size","不合法的按钮名称长度"),
        ERR_40019("40019","invalid button key size","不合法的按钮KEY长度"),
        ERR_40020("40020","invalid button url size","不合法的url长度"),
        ERR_40023("40023","invalid sub button size","不合法的子菜单按钮个数"),
        ERR_40024("40024","invalid sub button type","不合法的子菜单类型"),
        ERR_40025("40025","invalid sub button name size","不合法的子菜单按钮名称长度"),
        ERR_40026("40026","invalid sub button key size","不合法的子菜单按钮KEY长度"),
        ERR_40027("40027","invalid sub button url size","不合法的子菜单按钮url长度"),
        ERR_40029("40029","invalid code","不合法或已过期的code"),
        ERR_40030("40030","invalid refresh_token","不合法的refresh_token"),
        ERR_40036("40036","invalid template_id size","不合法的template_id长度"),
        ERR_40037("40037","invalid template_id","不合法的template_id"),
        ERR_40039("40039","invalid url size","不合法的url长度"),
        ERR_40048("40048","invalid url domain","不合法的url域名"),
        ERR_40054("40054","invalid sub button url domain","不合法的子菜单按钮url域名"),
        ERR_40055("40055","invalid button url domain","不合法的菜单按钮url域名"),
        ERR_40066("40066","invalid url","不合法的url"),
        ERR_40097("40097","","参数错误"),
        ERR_41001("41001","access_token missing","缺失access_token参数"),
        ERR_41002("41002","appid missing","缺失appid参数"),
        ERR_41003("41003","refresh_token missing","缺失refresh_token参数"),
        ERR_41004("41004","appsecret missing","缺失secret参数"),
        ERR_41005("41005","media data missing","缺失二进制媒体文件"),
        ERR_41006("41006","media_id missing","缺失media_id参数"),
        ERR_41007("41007","sub_menu data missing","缺失子菜单数据"),
        ERR_41008("41008","missing code","缺失code参数"),
        ERR_41009("41009","missing openid","缺失openid参数"),
        ERR_41010("41010","missing url","缺失url参数"),
        ERR_42001("42001","access_token expired","access_token超时"),
        ERR_42002("42002","refresh_token expired","refresh_token超时"),
        ERR_42003("42003","code expired","code超时"),
        ERR_43001("43001","require GET method","需要使用GET方法请求"),
        ERR_43002("43002","require POST method","需要使用POST方法请求"),
        ERR_43003("43003","require https","需要使用HTTPS"),
        ERR_43004("43004","require subscribe","需要订阅关系"),
        ERR_44001("44001","empty media data","空白的二进制数据"),
        ERR_44002("44002","empty post data","空白的POST数据"),
        ERR_44003("44003","empty news data","空白的news数据"),
        ERR_44004("44004","empty content","空白的内容"),
        ERR_44005("44005","empty list size","空白的列表"),
        ERR_45001("45001","media size out of limit","二进制文件超过限制"),
        ERR_45002("45002","content size out of limit","content参数超过限制"),
        ERR_45003("45003","title size out of limit","title参数超过限制"),
        ERR_45004("45004","description size out of limit","description参数超过限制"),
        ERR_45005("45005","url size out of limit","url参数长度超过限制"),
        ERR_45006("45006","picurl size out of limit","picurl参数超过限制"),
        ERR_45007("45007","playtime out of limit","播放时间超过限制（语音为60s最大）"),
        ERR_45008("45008","article size out of limit","article参数超过限制"),
        ERR_45009("45009","api freq out of limit","接口调动频率超过限制"),
        ERR_45010("45010","create menu limit","建立菜单被限制"),
        ERR_45011("45011","api limit","频率限制"),
        ERR_45012("45012","template size out of limit","模板大小超过限制"),
        ERR_45016("45016","can't modify sys group","不能修改默认组"),
        ERR_45017("45017","can't set group name too long sys group","修改组名过长"),
        ERR_45018("45018","too many group now, no need to add new","组数量过多"),
        ERR_46001("46001","","media_id不存在"),
        ERR_50001("50001","api unauthorized","接口未授权"),
        ERR_53010("53010","","名称格式不合法"),
        ERR_53011("53011","","名称检测命中频率限制"),
        ERR_53012("53012","","禁止使用该名称"),
        ERR_53013("53013","","公众号：名称与已有公众号名称重复;小程序：该名称与已有小程序名称重复"),
        ERR_53014("53014","","公众号：公众号已有{名称A+}时，需与该帐号相同主体才可申请{名称A};小程序：小程序已有{名称A+}时，需与该帐号相同主体才可申请{名称A}"),
        ERR_53015("53015","","公众号：该名称与已有小程序名称重复，需与该小程序帐号相同主体才可申请;小程序：该名称与已有公众号名称重复，需与该公众号帐号相同主体才可申请"),
        ERR_53016("53016","","公众号：该名称与已有多个小程序名称重复，暂不支持申请;小程序：该名称与已有多个公众号名称重复，暂不支持申请"),
        ERR_53017("53017","","公众号：小程序已有{名称A+}时，需与该帐号相同主体才可申请{名称A};小程序：公众号已有{名称A+}时，需与该帐号相同主体才可申请{名称A}"),
        ERR_53018("53018","","名称命中微信号"),
        ERR_53019("53019","","名称在保护期内"),
        ERR_53200("53200","","本月功能介绍修改次数已用完"),
        ERR_53201("53201","","功能介绍内容命中黑名单关键字"),
        ERR_53202("53202","","本月头像修改次数已用完"),
        ERR_53300("53300","","超出每月次数限制"),
        ERR_53301("53301","","超出可配置类目总数限制"),
        ERR_53302("53302","","当前账号主体类型不允许设置此种类目"),
        ERR_53303("53303","","提交的参数不合法"),
        ERR_53304("53304","","与已有类目重复"),
        ERR_53305("53305","","包含未通过IPC校验的类目"),
        ERR_53306("53306","","修改类目只允许修改类目资质，不允许修改类目ID"),
        ERR_53307("53307","","只有审核失败的类目允许修改"),
        ERR_53308("53308","","审核中的类目不允许删除"),
        ERR_61007("61007","api is unauthorized to component","第三方不具备调用该接口的权限"),
        ERR_61070("61070","name, wechat name not in accordance","法人姓名与微信号不一致"),
        ERR_80066("80066","","非法的插件版本"),
        ERR_80067("80067","","找不到使用的插件"),
        ERR_80082("80082","","没有权限使用该插件"),
        ERR_85001("85001","","微信号不存在或微信号设置为不可搜索"),
        ERR_85002("85002","","小程序绑定的体验者数量达到上限"),
        ERR_85003("85003","","微信号绑定的小程序体验者达到上限"),
        ERR_85004("85004","","微信号已经绑定"),
        ERR_85006("85006","","标签格式错误"),
        ERR_85007("85007","","页面路径错误"),
        ERR_85008("85008","","类目填写错误"),
        ERR_85009("85009","","已经有正在审核的版本"),
        ERR_85010("85010","","item_list有项目为空"),
        ERR_85011("85011","","标题填写错误"),
        ERR_85012("85012","","无效的审核id"),
        ERR_85013("85013","","无效的自定义配置"),
        ERR_85014("85014","","无效的模版编号"),
        ERR_85015("85015","","该账号不是小程序账号"),
        ERR_85016("85016","","域名数量超过限制"),
        ERR_85017("85017","","没有新增域名，请确认小程序已经添加了域名或该域名是否没有在第三方平台添加"),
        ERR_85018("85018","","域名没有在第三方平台设置"),
        ERR_85019("85019","","没有审核版本"),
        ERR_85020("85020","","审核状态未满足发布"),
        ERR_85021("85021","","状态不可变"),
        ERR_85022("85022","","action非法"),
        ERR_85023("85023","","审核列表填写的项目数不在1-5以内"),
        ERR_85026("85026","","微信号绑定管理员名额达到上限"),
        ERR_85027("85027","","身份证绑定管理员名额达到上限"),
        ERR_85043("85043","","模版错误"),
        ERR_85044("85044","","代码包超过大小限制"),
        ERR_85045("85045","","ext_json有不存在的路径"),
        ERR_85046("85046","","tabBar中缺少path"),
        ERR_85047("85047","","pages字段为空"),
        ERR_85048("85048","","ext_json解析失败"),
        ERR_85060("85060","","无效的taskid"),
        ERR_85061("85061","","手机号绑定管理员名额达到上限"),
        ERR_85062("85062","","手机号黑名单"),
        ERR_85063("85063","","身份证黑名单"),
        ERR_85064("85064","","找不到草稿"),
        ERR_85066("85066","","链接错误"),
        ERR_85068("85068","","测试链接不是子链接"),
        ERR_85069("85069","","校验文件失败"),
        ERR_85070("85070","","链接为黑名单"),
        ERR_85071("85071","","已添加该链接，请勿重复添加"),
        ERR_85072("85072","","该链接已被占用"),
        ERR_85073("85073","","二维码规则已满"),
        ERR_85074("85074","","小程序未发布, 小程序必须先发布代码才可以发布二维码跳转规则"),
        ERR_85075("85075","","个人类型小程序无法设置二维码规则"),
        ERR_85076("85076","","链接没有ICP备案"),
        ERR_85077("85077","","小程序类目信息失效（类目中含有官方下架的类目，请重新选择类目）"),
        ERR_85079("85079","","小程序没有线上版本，不能进行灰度"),
        ERR_85080("85080","","小程序提交的审核未审核通过"),
        ERR_85081("85081","","无效的发布比例"),
        ERR_85082("85082","","当前的发布比例需要比之前设置的高"),
        ERR_85085("85085","","近7天提交审核的小程序数量过多，请耐心等待审核完毕后再次提交"),
        ERR_85086("85086","","提交代码审核之前需提前上传代码"),
        ERR_85087("85087","","小程序已使用api navigateToMiniProgram，请声明跳转appid列表后再次提交"),
        ERR_86000("86000","","不是由第三方代小程序进行调用"),
        ERR_86001("86001","","不存在第三方的已经提交的代码"),
        ERR_86002("86002","","小程序还未设置昵称、头像、简介。请先设置完后再重新提交"),
        ERR_86004("86004","invalid wechat","无效微信号"),
        ERR_87011("87011","","现网已经在灰度发布，不能进行版本回退"),
        ERR_87012("87012","","该版本不能回退，可能的原因：1:无上一个线上版用于回退 2:此版本为已回退版本，不能回退 3:此版本为回退功能上线之前的版本，不能回退"),
        ERR_87013("87013","","撤回次数达到上限（每天一次，每个月10次）"),
        ERR_89000("89000","account has bound open ，","该公众号 / 小程序 已经绑定了开放平台帐号"),
        ERR_89001("89001","","not same contractor，Authorizer与开放平台帐号主体不相同"),
        ERR_89002("89002","","没有绑定开放平台账号"),
        ERR_89003("89003","","该开放平台帐号并非通过api创建，不允许操作"),
        ERR_89004("89004","","该开放平台帐号所绑定的公众号/小程序已达上限（100个）"),
        ERR_89019("89019","","业务域名无更改，无需重复设置"),
        ERR_89020("89020","","尚未设置小程序业务域名，请先在第三方平台中设置小程序业务域名后在调用本接口"),
        ERR_89021("89021","","请求保存的域名不是第三方平台中已设置的小程序业务域名或子域名"),
        ERR_89029("89029","","业务域名数量超过限制"),
        ERR_89231("89231","","个人小程序不支持调用setwebviewdomain 接口"),
        ERR_89236("89236","","该插件不能申请"),
        ERR_89237("89237","","已经添加该插件"),
        ERR_89238("89238","","申请或使用的插件已经达到上限"),
        ERR_89239("89239","","该插件不存在"),
        ERR_89247("89247","inner error","内部错误"),
        ERR_89248("89248","invalid code type","企业代码类型无效，请选择正确类型填写"),
        ERR_89249("89249","task running","该主体已有任务执行中，距上次任务24h后再试"),
        ERR_89250("89250","task not found","未找到该任务"),
        ERR_89251("89251","legal person checking","模板消息已下发，待法人人脸核身校验"),
        ERR_89252("89252","front checking","法人&企业信息一致性校验中"),
        ERR_89253("89253","lack of some params","缺少参数"),
        ERR_89254("89254","lack of some component rights","第三方权限集不全，补全权限集全网发布后生效"),
        ERR_89256("89256","","token信息有误"),
        ERR_89257("89257","","该插件版本不支持快速更新"),
        ERR_89258("89258","","当前小程序帐号存在灰度发布中的版本，不可操作快速更新"),
        ERR_89300("89300","","订单无效"),
        ERR_91001("91001","","不是公众号快速创建的小程序"),
        ERR_91002("91002","","小程序发布后不可改名"),
        ERR_91003("91003","","改名状态不合法"),
        ERR_91004("91004","","昵称不合法"),
        ERR_91005("91005","","昵称15天主体保护"),
        ERR_91006("91006","","昵称命中微信号"),
        ERR_91007("91007","","昵称已被占用"),
        ERR_91008("91008","","昵称命中7天侵权保护期"),
        ERR_91009("91009","","需要提交材料"),
        ERR_91010("91010","","其他错误"),
        ERR_91011("91011","","查不到昵称修改审核单信息"),
        ERR_91012("91012","","其他错误"),
        ERR_91013("91013","","占用名字过多"),
        ERR_91014("91014","","+号规则 同一类型关联名主体不一致"),
        ERR_91015("91015","","原始名不同类型主体不一致"),
        ERR_91016("91016","","名称占用者≥2"),
        ERR_91017("91017","","+号规则 不同类型关联名主体不一致"),
        ;

        ErrorMsg(String errcode, String errmsg, String desc) {
            this.errcode = errcode;
            this.errmsg = errmsg;
            this.desc = desc;
        }

        private String errcode;
        private String errmsg;
        private String desc;

        private static String getDescByCode(String errcode, String errmsg) {
            ErrorMsg errorMsg;
            try {
                errorMsg = ErrorMsg.valueOf("ERR_" + errcode);
            } catch (Exception e) {
                errorMsg = ErrorMsg.ERR_DEFAULT;
                errorMsg.desc = errcode + ":" + errmsg;
            }
            return errorMsg.getDesc();
        }
    }

}