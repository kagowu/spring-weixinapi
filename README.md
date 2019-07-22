##1.功能介绍
weixin-feignclient 包含的功能如下：
####1.1 主动调用微信公众号平台、小程序、开放平台的接口API
####1.2 需要做redirect的参数拼接
####1.3 被微信回调的API的bean（包括公众平台、开放平台）
####1.4 微信回调的加密签名方式

##2.主动使用方式
引入jar
```xml
<dependency>
    <groupId>com.qq.weixin</groupId>
    <artifactId>weixin-feignclient</artifactId>
    <packaging>jar</packaging>
    <version>1.0.2.2</version>
</dependency>
```
加入feign依赖
```java_holder_method_tree
@EnableFeignClients(value = {"com.qq.weixin.api"})


```
具体调用地方
```java_holder_method_tree
    @Autowired
    private WxaClient wxaClient;
    @Test
    public void getAuditstatus() {
        GetAuditstatusRequest getAuditstatusRequest = new GetAuditstatusRequest();
        getAuditstatusRequest.setAuditid(440795332);
        GetAuditstatusResopnse getAuditstatusResopnse = wxaClient.getAuditstatus("21_L3a5UXe8Tem9bzGW_Ghw_TEdhTlnwI9j5UvnOdbyHTYvn95hMdwNWFFzHJKMkWjFjfk2hhVKCRWqUTPNgM56_cs6wvi9rQn0uSen1wyeO-tuPYQR8EM_oKvie7NY06-5dsjPwmnYrQDUYFRIWSTaAIDMIJ", getAuditstatusRequest);
        System.out.println(JSON.toJSONString(getAuditstatusResopnse));
    }
```








