<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
<script>
  let json = JSON.parse(`${datas}`);
  console.log(json);
  requestPayment();
  async function requestPayment() {
    const response = await PortOne.requestPayment({
      // Store ID 설정
      storeId: "store-e4038486-8d83-41a5-acf1-844a009e0d94",
      channelKey: "channel-key-ebe7daa6-4fe4-41bd-b17d-3495264399b5",
      // 채널 키 설정
      paymentId: `payment-${crypto.randomUUID()}`,
      orderName: "나이키 와플 트레이너 2 SD",
      totalAmount: 1000,
      currency: "CURRENCY_KRW",
      payMethod: "CARD",
    });

    if (response.code !== undefined) {
      // 오류 발생
      return alert(response.message);
    }

    alert("성공!");
    // /payment/complete 엔드포인트를 구현해야 합니다. 다음 목차에서 설명합니다.
    // const notified = await fetch(`${SERVER_BASE_URL}/payment/complete`, {
    //   method: "POST",
    //   headers: { "Content-Type": "application/json" },
    //   // paymentId와 주문 정보를 서버에 전달합니다
    //   body: JSON.stringify({
    //     paymentId: paymentId,
    //     // 주문 정보...
    //   }),
    // });
  }
</script>