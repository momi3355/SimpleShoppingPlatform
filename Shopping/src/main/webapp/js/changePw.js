/**
 * changePw.js
 */
document.addEventListener("DOMContentLoaded", function () {
  const checkBtn = document.getElementById("checkBtn");
  const completeBtn = document.getElementById("completeBtn");

  const currentPwInput = document.getElementById("currentPassword");
  const newPwInput = document.getElementById("newPassword");
  const confirmPwInput = document.getElementById("confirmPassword");

  const checkMessage = document.getElementById("checkMessage");
  const matchMessage = document.getElementById("matchMessage");

  //현재 비밀번호 확인
  checkBtn.addEventListener("click", function () {
    const currentPw = currentPwInput.value.trim();
    if (!currentPw) {
      checkMessage.textContent = "비밀번호를 입력해주세요.";
      return;
    }

    fetch("checkPw.do", {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: "password=" + encodeURIComponent(currentPw)
    })
      .then(res => res.json())
      .then(data => {
        if (data.status === "success") {
          document.getElementById("pw-check").style.display = "none";
          document.getElementById("pw-reset").style.display = "block";
        } else {
          checkMessage.textContent = "비밀번호가 일치하지 않습니다.";
        }
      })
      .catch(() => {
        checkMessage.textContent = "오류가 발생했습니다. 다시 시도해주세요.";
      });
  });

  //새 비밀번호 확인
  confirmPwInput.addEventListener("input", checkPwMatch);
  newPwInput.addEventListener("input", checkPwMatch);

  function checkPwMatch() {
    const pw = newPwInput.value.trim();
    const confirmPw = confirmPwInput.value.trim();

    if (!pw || !confirmPw) {
      matchMessage.textContent = "";
      completeBtn.disabled = true;
      return;
    }

    if (pw !== confirmPw) {
      matchMessage.textContent = "비밀번호가 일치하지 않습니다.";
      completeBtn.disabled = true;
    } else {
      matchMessage.textContent = "";
      completeBtn.disabled = false;
    }
  }

  // 완료 버튼 클릭 → 비밀번호 변경 요청
  completeBtn.addEventListener("click", function () {
    const newPw = newPwInput.value.trim();

    fetch("changePw.do", {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: "newPassword=" + encodeURIComponent(newPw)
    })
      .then(res => res.json())
      .then(data => {
        if (data.status === "success") {
          alert("비밀번호 변경이 완료되었습니다. 다시 로그인해주세요.");
          location.href = "logout.do";
        } else {
          alert("비밀번호 변경에 실패했습니다.");
        }
      })
      .catch(() => {
        alert("오류가 발생했습니다.");
      });
  });
});
