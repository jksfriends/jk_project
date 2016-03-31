<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function userlist() {
		var form = document.postForm;
		form.action = 'user/userlist.do';
		form.submit();
	}
</script>
</head>
<body>
Hello Jsp World!
<form name="getForm" action="helloNewServlet.do" method="get">
<input type="hidden" id="hello" name="hello" value="welcome to the get world" />
<input type="button" value="doGet" onclick="javascript:submit();">
</form>
<form name="postForm" action="helloNewServlet.do" method="post">
<input type="hidden" id="hello" name="hello" value="welcome to the post world!" />
<input type="button" value="doPost" onclick="javascript:submit();">
<input type="button" value="userlist" onclick="javascript:userlist();">
</form>
<xmp>
GET, POST 방식 차이점(퍼옴)

웹 어플리케이션을 작성하다보면 누구나 한번쯤 GET/POST 요청(request)의 차이점에 대해 궁금해했을것이다. 기술적으로 조금씩 다른점은 금방 비교가 되지만, 그것만으로는 “뭔가 다르긴 다른데 POST를 쓸곳에도 GET을써도 상관없지않을까?” 라는 질문이 계속 머릿속에서 떠나지를 않는다. 그렇다면 근본적으로 뭐가 달라서 이 두가지 요청 방식이 구분되어있는지 한번 살펴보도록 하자.


근본적인 의미 차이

GET, POST의 근본적인 특성 차이는 GET은 idempotent, POST는 non-idempotent 하다는 점이다.
멱등(idempotent)이라는 말이 좀 어려운데, 아래와 같이 풀어서 설명하면 좀 이해가 쉬울것이다.
멱등 연산(idempotent operation)은 수학 용어로 해당 연산을 해도 결과에 변화가 없다는 특성을 표현하는 말이다.
 (예: 100 x 1 = 100 이므로, 곱셈에대해 1을 멱등원 이라고 부르며 이러한 1을곱하는 연산이 멱등 연산이다.)
이러한 뜻을 HTTP요청 메서드를 해석하는데 적용해보면,
GET은 해당 요청을 몇번을 수행해도 해당 요청에 대한 결과가 계속 동일하게 돌아오는 것을 의미하며,
POST는 해당 요청이 수행되면 서버에서 무언가 바뀌고, 동일한 결과가 돌아오는 것을 보장할 수 없다는 것을 의미한다.
즉 GET을 이용하여 게시판에 글을 쓴다면(글을 쓴다는 동작은 서버에 데이터가 바뀌고 다른 결과가 돌아 올 수 있다는 것을 의미) 이것은 GET의 idempotent 특성을 무시하는 것이며 문제 발생의 여지가 있다.


GET/POST의 부수적인 차이점

POST의 경우 GET과는 달리 쿼리스트링(query string)의 글자 수 제약이 없으며, 파일업로드 등의 동작이 가능하다.
그리고 POST의 경우 쿼리스트링이 URL에 포함되지 않기때문에 user에게 파라메터 값 등을 덜 노출한 상태로 요청이 가능하다. 하지만 결국 HTTP 요청은 SSL을 이용하는 https가 아닌경우 plain text로 이루어게되고, 그러다보니 요청을 열어보면 쿼리스트링이 동일하게 보이는것은 마찬가지라 특별히 보안상 더 뛰어나다고는 말하기 힘들다.
결국 이런 차이들은 사용상에있어서의 부수적인 차이점인데, 그렇다면 실제로 근본적인 차이를 구분하지 않고 GET/POST를 잘못 사용한 경우 어떤문제가 일어날 수있을까?


그렇다면 진짜로 다른점은 무엇?

GET 요청은 브라우저에서 캐시를 할 수 있다.
글을 작성하는 요청인데 GET 방식으로 글내용과 제목을 받아서 서버로 전송한다면, 해당 GET 요청과 그에 대한 응답이 브라우저에 의해 캐쉬가 되었다가 다시 사용될 우려가 있다. 이 경우 캐쉬에의해 자동으로 동일한 글을 또 작성하는 동작이 서버에서 발생될 수 있는데 이것은 심각한 오류이다.


검색봇(크롤러)으로 인한 문제 발생

구글이나 네이버의 검색봇(bot 혹은 crawler)들이 웹페이지 수집을 위해 해당 웹서버에 GET 요청을 할 수 있다. 이때 이러한 봇의 요청에 의해 게시판에 엉뚱한 데이터로 글이 작성되어 올라간다던지, 서버쪽의 데이터가 바뀐다면 당황스러운 일들이 발생할 가능성이 크다.
이러한 문제들을 막으려면 결국 근본적인 특성차이를 잘 인지하고 꼭 상황에 맞게 사용해야 한다.
</xmp>
</body>
</html>