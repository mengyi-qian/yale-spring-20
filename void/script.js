$(document).ready(function(){

  $('span').hide();
  $('.pp').hover(
    function() {
    $('span').show();
    $('.pp').css("word-break", "normal");
    $('.pp').css("letter-spacing", "4px");
  }, function() {
    $('span').hide();
    $('.pp').css("word-break", "break-all");
    $('.pp').css("letter-spacing", "15px");
  }
  );





});
