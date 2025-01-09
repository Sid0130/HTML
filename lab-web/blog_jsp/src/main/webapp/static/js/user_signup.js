/**
 * 회원가입 삽입 기능.
 */

document.addEventListener("DOMContentLoaded", () => {
    const birthdayInput = document.querySelector("input#birthday");
    const birthdayMsg = document.querySelector("div#birthdayMsg");
    const phoneInput = document.querySelector("input#phone");
    const phoneMsg = document.querySelector("div#phoneMsg");
    

        // 생년월일 입력 실시간 검증 및 형식화
        birthdayInput.addEventListener("input", (e) => {
            let value = e.target.value.replace(/\D/g, ""); // 숫자만 남김

            // YYYY-MM-DD 형식으로 변환
            if (value.length > 4) {
                value = value.slice(0, 4) + "." + value.slice(4);
            }
            if (value.length > 7) {
                value = value.slice(0, 7) + "." + value.slice(7);
            }

            e.target.value = value; // 값 업데이트
        });

        // 생년월일 포커스 해제 시 검증
        birthdayInput.addEventListener("blur", () => {
            const value = birthdayInput.value.trim();
            const parts = value.split(".");
            const year = parseInt(parts[0]);
            const month = parseInt(parts[1]);
            const day = parseInt(parts[2]);

            if (
                parts.length === 3 &&
                year >= 1900 && year <= 2025 &&
                month >= 1 && month <= 12 &&
                day >= 1 && day <= 31
            ) {
                birthdayMsg.style.display = "none"; // 에러 메시지 숨김
                birthdayInput.classList.remove("error"); // 빨간 테두리 제거
            } else {
                birthdayMsg.style.display = "block"; // 에러 메시지 표시
                birthdayMsg.textContent = "생년월일: 생년월일이 정확한지 확인해 주세요.";
                birthdayInput.classList.add("error"); // 빨간 테두리 추가
            }
        });

        // 전화번호 입력 실시간 검증 및 형식화
        phoneInput.addEventListener("input", (e) => {
            let value = e.target.value.replace(/\D/g, ""); // 숫자만 남김

            // 010-XXXX-XXXX 형식으로 변환
            if (value.length > 3) {
                value = value.slice(0, 3) + "-" + value.slice(3);
            }
            if (value.length > 8) {
                value = value.slice(0, 8) + "-" + value.slice(8, 12);
            }

            e.target.value = value; // 값 업데이트
        });

        // 전화번호 포커스 해제 시 검증
        phoneInput.addEventListener("blur", () => {
            const value = phoneInput.value.trim();

            if (/^010-\d{4}-\d{4}$/.test(value)) {
                phoneMsg.style.display = "none"; // 에러 메시지 숨김
                phoneInput.classList.remove("error"); // 빨간 테두리 제거
            } else {
                phoneMsg.style.display = "block"; // 에러 메시지 표시
                phoneMsg.textContent = "휴대전화번호: 휴대전화번호가 정확한지 확인해 주세요.";
                phoneInput.classList.add("error"); // 빨간 테두리 추가
            }
        });
    });