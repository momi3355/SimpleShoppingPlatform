Kakao.init(KAKAO_JS_KEY);

function kakaoLogin() {
  Kakao.Auth.login({
    scope: "profile_nickname",
    success: function () {
      Kakao.API.request({
        url: '/v2/user/me',
        success: function (res) {
          const kakaoAccount = res.kakao_account || {};

          fetch(`${contextPath}/kakaoLogin.do`, {
            method: "POST",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify({
              kakaoId: res.id,
              email: kakaoAccount.email || "", // email이 없을 경우 빈 문자열
              userName: kakaoAccount.profile?.nickname || "" // 닉네임
            })
          })
          .then(res => res.json())
          .then(data => {
            if (data.result === "success") {
              location.href = `${contextPath}/main.do`;
            } else {
              alert("카카오 로그인에 실패했습니다. 다시 시도해주세요.");
            }
          });
        },
        fail: function () {
          alert("카카오 로그인에 실패했습니다. 다시 시도해주세요.");
        }
      });
    },
    fail: function () {
      alert("카카오 로그인에 실패했습니다. 다시 시도해주세요.");
    }
  });
}
