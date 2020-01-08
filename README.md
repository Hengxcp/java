# java
## sso_father1
同父域下实现单点登录

注意事项如下：  
**An invalid domain [] was specified for this cookie问题解决方案**  
修改配置 ${tomcat_home}\conf\context.xml文件
```<?xml version="1.0" encoding="UTF-8”?>
<!-- The contents of this file will be loaded for each web application -->
<Context>
<!-- Default set of monitored resources. If one of these changes, the    -->
<!-- web application will be reloaded.                                   -->
<WatchedResource>WEB-INF/web.xml</WatchedResource>
<WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>
<!-- Uncomment this to disable session persistence across Tomcat restarts -->
<!-- <Manager pathname="" /> -->
<!-- 添加代码 将cookie处理的手工设置为LegacyCookieProcessor即可 -->
<CookieProcessor className="org.apache.tomcat.util.http.LegacyCookieProcessor"/>
</Context>
```

