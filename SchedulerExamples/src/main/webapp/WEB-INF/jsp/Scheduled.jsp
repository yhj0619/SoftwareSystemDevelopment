<%@ page contentType="text/html; charset=utf-8"  %>
<head>
<title>task scheduler example</title>
</head>
<body>
Closing Time이 ${closeTime}으로 설정된 새로운 레코드가 EVENTS 테이블에 저장되었습니다.
<br><br>
Oracle 서버의 계정에 접속하여 EVENTS 테이블을 조회하세요.<br>
<br>
select ID, TO_CHAR(CLOSING_TIME, 'YYYY-MM-DD HH:MI'), STATUS from EVENTS;<br>
<br>
지정된 Closing Time이 되면 TaskScheduler가 지정된 작업을 실행합니다.<br>
<br>
Console 창에 메시지가 출력되는지 확인하고, 
EVENTS 테이블을 조회하여 해당 레코드의 상태가 'OPEN'에서 'CLOSE'로 변경되었는지 확인하세요.<br>
<br>
</body>
</html>