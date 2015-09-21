# my-tag-lib
Automatically exported from code.google.com/p/my-tag-lib
```xml
<%@ taglib prefix="navi"    uri="http://support.sanaes.com/navi" %>

 <navi:navigator  currentPage="1"
                  countPerPage="2"
                  pagePerBlock="10"
                  totalRecordCount="3"
                  firstButton="<img src='common/list_first.gif' alt='처음' align='absmiddle'>"
                  prevButton="<img src='common/list_prev.gif' alt='이전' align='absmiddle'>"
                  nextButton="<img src='common/list_next.gif' alt='다음' align='absmiddle'>"
                  lastButton="<img src='common/list_last.gif' alt='마지막' align='absmiddle'>"   
                  isStartFinishView="true"                        
                  href="goPage"/>
```                  
                  
                  
                  
```css                  
@CHARSET "UTF-8";
/* reset */
* {margin:0; padding:0; font-size:12px;}
* {scrollbar-face-color:#F7F7F7; scrollbar-highlight-color:#FFF; scrollbar-shadow-color:#E4E4E4; scrollbar-3dlight-color:#E7E7E7; scrollbar-arrow-color:#919FC3; scrollbar-track-color:#F5F5F5; scrollbar-darkshadow-color:#D9D9DF;}

html {filter:expression(document.execCommand('BackgroundImageCache', false, true));}
body {width:100%; height:100%; margin:0; padding:0; font-size:12px; font-family:돋움, Dotum, Arial, sans-serif; color:#444;}
a:link, a:active, a:visited {text-decoration:none; color:#444;}
a:hover {text-decoration:none; color:#003887;}

/*--------------------------------------------PAGING NAVIGATION--------------------------------------------*/
.pageNavigation                                         {display:block; padding:15px 0; font:bold 11px Tahoma; text-align:center;}
.pageNavigation img                                     {margin:6px 6px 0 2px; vertical-align:top;}
.pageNavigation a                                       {display:inline-block; margin-left:-4px; padding:3px 8px 4px 7px; color:#000; border-left:1px solid #DEDFDE; border-right:1px solid #DEDFDE; text-decoration:none; font:bold 11px Tahoma; line-height:100%;}
.pageNavigation .current                        {display:inline-block; margin-left:-4px; padding:3px 8px 4px 7px; color:#FF5500; border-left:1px solid #DEDFDE; border-right:1px solid #DEDFDE; font:bold 11px Tahoma; text-decoration:none; line-height:100%;}
.pageNavigation a:hover                         {background:#F7F7F7; text-decoration:none;}
.pageNavigation a.goToFirst,
.pageNavigation a.goToPrev,
.pageNavigation a.goToNext,
.pageNavigation a.goToLast                      {padding:0; border:none; vertical-align:top;}
.pageNavigation a.goToFirst img,
.pageNavigation a.goToPrev img,
.pageNavigation a.goToNext img,
.pageNavigation a.goToLast img          {margin:6px;}
.pageNavigation a.goToFirst:hover,
.pageNavigation a.goToPrev:hover,
.pageNavigation a.goToNext:hover,
.pageNavigation a.goToLast:hover        {background:none;}
.pageNavigation .pageJump                       {display:inline; margin:-4px 0 0 10px;}
.pageNavigation .pageJump .input        {height:12px; font:11px tahoma; font-weight:bold; text-align:right;}
.pageNavigation .pageJump img           {margin:0 0 0 5px; vertical-align:middle;}
/*--------------------------------------------PAGING NAVIGATION--------------------------------------------*/

```




```xml
<Resource name="jdbc/TestDB"
          factory="kr.co.killers.tomcat.EncryptedDataSourceFactoryDbcp"
          auth="Container"
          type="javax.sql.DataSource"
          maxActive="100"
          maxIdle="30"
          maxWait="10000"
          username="808233982b9c435fb8a3331634a3c48b"
          password="3b8dcdcf348d8b466915f66c30003e95"
          driverClassName="org.mariadb.jdbc.Driver"
          url="jdbc:mariadb://localhost:3306/db_harpy"/>


<Resource name="jdbc/TestDB"
          factory="kr.co.killers.tomcat.EncryptedDataSourceFactory"
          auth="Container"
          type="javax.sql.DataSource"
          maxActive="100"
          maxIdle="30"
          maxWait="10000"
          username="808233982b9c435fb8a3331634a3c48b"
          password="3b8dcdcf348d8b466915f66c30003e95"
          driverClassName="org.mariadb.jdbc.Driver"
          url="jdbc:mariadb://localhost:3306/db_harpy"/>
```



          
          
          
