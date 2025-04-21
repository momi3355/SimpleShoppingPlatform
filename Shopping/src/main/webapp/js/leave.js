$(function () {

  $('#reasonSelect').on('change', function () {
    $('#reasonNextBtn').prop('disabled', !$(this).val());
  });

  $('#reasonNextBtn').on('click', function () {
    location.href = 'leaveAgree.do';
  });


  $('#agreeChk').on('change', function () {
    $('#agreeNextBtn').prop('disabled', !$(this).is(':checked'));
  });

  $('#agreeNextBtn').on('click', function () {
    location.href = 'leave.do';
  });


  $('#leaveFinishBtn').on('click', function () {
    location.href = 'main.do';
  });

});
