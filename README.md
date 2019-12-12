DECLUNA
-
**customize your own science dictionary**

**Author**： Decmoon 

```` 
      ___              
    く__,.ヘヽ.　　　　/　,ー､ 〉
    　　　　　＼ ', !-─‐-i　/　/´
    　　　 　 ／｀ｰ'　　　 L/／｀ヽ､
    　　 　 /　 ／,　 /|　 ,　 ,　 ',           DECLUNA
    　　　ｲ 　/ /-‐/　 i  L_ ﾊ ヽ!　 i
    　　　 ﾚ ﾍ 7ｲ｀ﾄ　 ﾚ'ｧ-ﾄ､!ハ|　 |                 Version 0.0.1
    　　　　 !,/7 '0'　　 ´0iソ| 　 |　　　
    　　　　 |.从"　　_　　 ,,,, / |./ 　 |
    　　　　 ﾚ'| i＞.､____　_,.イ / 　.i 　|           From   2019
    　　　　　 ﾚ'| | / k_7_/ﾚ'ヽ,　ﾊ.　|
    　　　　　　 | |/i 〈|/　 i　,.ﾍ |　i　|
    　　　　　　.|/ /　ｉ： 　 ﾍ!　　＼　|
    　　　 　 　 kヽ>､ﾊ 　 _,.ﾍ､ 　 /､!
    　　　　　　 !'〈//｀Ｔ´', ＼ ｀'7'ｰr'
    　　　　　　 ﾚ'ヽL__|___i,___,ンﾚ|ノ
    　　　　　 　　　ﾄ-,/　|___./
---------------- 　'ｰ'　　!_,.:------------------------------------------------------------------/
-------------------------------------------------------------------------------------
-------------------------------------------------------------
-------------------------------------------

````
启
-
这个项目是为了纪念我与TA的相遇，我们因为英语相识相认相知，一直走到现在，
然而这个程序员并不懂得如何浪漫，玫瑰与美酒貌似并不适合我们这个群体，不如来敲代码吧...

功能
-
基于目前：
+ 单词的记录与查询(不限制语言)
+ Luna精灵
+ so on...

预计更新
-
+ notebook
+ 辅助记忆
+ 文件导入导出
+ 国际化
+ so on...

框架
-
Decluna的前端借鉴了很多优秀的框架，经本人的一顿嚯嚯...改善之后，形成了现在的体系，
后端为本人独立完成，至于为什么独立....爱情都是自私的嘛~

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

版权
-
Decluna 项目版权归  © [Decmoon](https://github.com/Decmoon) 所有,仅用于学习参考,如有其他用途请与原作者联系

转载请标明原址

作者邮件：751229863@qq.com / decmoon@sina.com

其他
-
如果你想问网站内部有什么小惊喜嘛，既然是惊喜...那就不透露好了<br>

好了好了，我要为广大的外国友人机翻...翻译一下了~
<br/><br/><br/><br/>
愿已经有另一半得你，执子之手，与子偕老<br/>

祝福keep单身的你，马上就会遇到对的TA~
<br/><br/><br/><br/><br/>

##ENGLISH VERSION~~~~~~~~~~~~~~>

<br/><br/><br/><br/><br/>

Origination 
-
This project is to commemorate my meeting with her.
we have known each other by English learning . <br/>
We've known each other for a long time,and we're used to each other,
But in fact , a programmer don't know how to be romantic. 
Maybe roses and wine don't seem to be suitable for me. 
So..hah .code is a other romantic right?

Function
-
For now 
+ Record and query of words (unlimited language)
+ Luna Elf
+ so on...

Expected to update
-
+ notebook
+ recite 
+ import and export of files
+ internationalization
+ so on...

Framework
-
Decluna's website draws on many excellent frameworks. 
After my improvement, it has formed the current system,
The Java program is for me to finish independently. 
As for why I am independent... Love is selfish,right~?

The main frameworks used are

Name|brief|link
:---:|:---|---|
**SpringBoot** |_Pivotal open-source framework_|*https://github.com/spring-projects/spring-boot*
**FastJson**|_Alibaba open-source framework_|*https://github.com/alibaba/fastjson*
**Shortcut**|_Decmoon Easy open source toolkit_|*https://github.com/Decmoon/shortcut*

Deploy
-

> If the Tomcat startup item **startup.bat** is flashed back, please set the **JAVA** and **JRE** paths in the **setclasspath.bat** file
````
rem ---------------------------------------------------------------------------
rem Set JAVA_HOME or JRE_HOME if not already set, ensure any provided settings
rem are valid and consistent with the selected start-up options and set up the
rem endorsed directory.
rem ---------------------------------------------------------------------------
set JAVA_HOME=java/bin path of local storage
set JRE_HOME=java/jre path of local storage
rem Make sure prerequisite environment variables are set
....
...

````
> If Tomcat fails to start due to insufficient cache space<br/>
Please set the cache size in the **context.xml** file under the **tomcat/conf** directory
```
<Context>
    <WatchedResource>WEB-INF/web.xml</WatchedResource>
    <WatchedResource>WEB-INF/tomcat-web.xml</WatchedResource>
    <WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>
    
	<Resources cachingAllowed="true" cacheMaxSize="100000" />
</Context>
```

>If the page needs to be operated in Chinese, please modify it in **catalina.bat** under the **bin** directory of **tomcat** as follows:<br/>
 Under **setlocal**, write **set JAVA_OPTS=-Dfile.encoding=UTF8**<br/>
 Prevent page miscoding caused by Chinese escape
````
setlocal

set JAVA_OPTS=-Dfile.encoding=UTF8

rem Suppress Terminate batch job on CTRL+C
if not ""%1"" == ""run"" goto mainEntry
if "%TEMP%" == "" goto mainEntry
....
...

````


Copyright
-
Decluna project copyright is owned by  © [Decmoon](https://github.com/Decmoon) and project only for study and  reference.<br/>
Please contact the original author if you have other uses.<br/>

Please mark the original address if you wanna reprinted.

Email of author：751229863@qq.com / decmoon@sina.com

Other
-
If you want to ask what's the little surprise inside the website<br/>
emmmm... i don't know~<br/>
Maybe you can try it by yourself~

