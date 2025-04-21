<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="${pageContext.request.contextPath}/js/kakao-config.js"></script>
<script>
  Kakao.init(KAKAO_JS_KEY);

  if (Kakao.Auth.getAccessToken()) {
    Kakao.Auth.logout(function () {
      window.location.href = "${pageContext.request.contextPath}/loginForm.do";
    });
  } else {
    window.location.href = "${pageContext.request.contextPath}/loginForm.do";
  }
</script>
