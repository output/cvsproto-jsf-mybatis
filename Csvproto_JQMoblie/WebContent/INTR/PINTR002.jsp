<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="2; url=./PINTR001.faces">
<title>成功登录</title>
    <!-- JQMobile -->
    <link rel="stylesheet" type="text/css" href="../css/common/jquery.mobile-1.1.1.css">
    <script type="text/javascript" src="../script/common/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="../script/common/jquery.mobile-1.1.1.js"></script>
</head>
<body>
rigth!
<!-- Home -->
<div data-role="page" id="page1">
    <div data-role="content" style="padding: 15px">
        <div data-role="navbar" data-iconpos="top">
            <ul>
            </ul>
        </div>
        <div data-role="navbar" data-iconpos="top">
            <ul>
                <li>
                    <a href="#page1" data-theme="" data-icon="">
                        Go
                    </a>
                </li>
            </ul>
        </div>
        <img src="https://maps.googleapis.com/maps/api/staticmap?center=Madison, WI&amp;zoom=14&amp;size=288x200&amp;markers=Madison, WI&amp;sensor=false"
        width="288" height="200">
        <a data-role="button" data-transition="flip" href="#page1">
            确定
        </a>
    </div>
</div>
</body>
</html>