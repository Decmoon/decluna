DECLUNA
-
[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/Decmoon/decluna) 

**customize your own science dictionary**

**Author**

> [<img width="30px" title="Decmoon" src="https://avatars3.githubusercontent.com/u/51840843?s=400&u=d909c885dc61d75a2ca60c6d52c2315714d8bdfe&v=4"/>
](https://github.com/Decmoon)

启
-
智能词典，为了帮助学习英语而困扰的人设计的专属词典。

> 这个项目是为了纪念我与TA的相遇，我们因为英语相识相认相知，一直走到现在，
然而这个程序员并不懂得如何浪漫，玫瑰与美酒貌似并不适合我们这个群体，不如来敲代码吧...

功能
-
基于目前：
+ 单词的记录与查询(不限制语言)
+ 页面精灵
+ 文件导入导出
+ etc

预计更新
-
+ notebook
+ 辅助记忆
+ 国际化
+ so on...

框架
-
Decluna的前端借鉴了很多优秀的框架，经作者改善覆写后，形成了现在的体系

主要运用的框架有

名称|简要|连接
:---:|:---|---|
**SpringBoot** |_Pivotal 开源框架_|*https://github.com/spring-projects/spring-boot*
**FastJson**|_Alibaba 开源框架_|*https://github.com/alibaba/fastjson*
**shortcut**|_Decmoon 便捷开源工具包_|*https://github.com/Decmoon/shortcut*

部署
-
> 如tomcat启动项**startup.bat**闪退，请在**setclasspath.bat**文件中设置**JAVA**与**JRE**路径
````
rem ---------------------------------------------------------------------------
rem Set JAVA_HOME or JRE_HOME if not already set, ensure any provided settings
rem are valid and consistent with the selected start-up options and set up the
rem endorsed directory.
rem ---------------------------------------------------------------------------
set JAVA_HOME=本地存储的java/bin路径
set JRE_HOME=本地存储的java/jre路径
rem Make sure prerequisite environment variables are set
....
...

````
> 如缓存空间不足造成**tomcat**启动失败<br/>
请在**tomcat/conf**目录下的**context.xml**文件中设置缓存大小
```
<Context>
    <WatchedResource>WEB-INF/web.xml</WatchedResource>
    <WatchedResource>WEB-INF/tomcat-web.xml</WatchedResource>
    <WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>
    
	<Resources cachingAllowed="true" cacheMaxSize="100000" />
</Context>
```

> 如页面需要进行中文操作，请在**tomcat**的**bin**目录下方的**catalina.bat**中修改如下：<br/>
在**setlocal**下方标注**set JAVA_OPTS=-Dfile.encoding=UTF8**<br/>
预防中文转义造成的页面乱码
````
setlocal

set JAVA_OPTS=-Dfile.encoding=UTF8

rem Suppress Terminate batch job on CTRL+C
if not ""%1"" == ""run"" goto mainEntry
if "%TEMP%" == "" goto mainEntry
....
...

````

拷贝项目
-
> 如果因为文件太大造成的克隆失败，请在**.gitconfig** 文件中设置以下字段
````
[core]
    compression = -1
````

版权
-
Decluna 项目版权归  © [Decmoon](https://github.com/Decmoon) 所有,仅用于学习参考,如有其他用途请与原作者联系

转载请标明原址

