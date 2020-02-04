$(document).ready(function(){

  // $('span').show();
  $('div.comma').hide();
  $('div.period').hide();
  $('div.question').hide();
  $('div.dquote').hide();
  $('div.apostrophe').hide();
  $('div.dash').hide();



  $('.comma').click(function() {
    $(this).prev(".comma").show("slow");
    $(this).css("color", "black");
  });

  $('.period').click(function() {
    $(this).prev(".period").show("slow");
    $(this).css("color", "black");
  });

  $('.question').click(function() {
    $(this).prev(".question").show("slow");
    $(this).css("color", "black");
  });

  $('.lquote').click(function() {
    $(this).next(".dquote").show("slow");
    $(this).css("color", "black");
    $(this).nextUntil(".lquote").css("color", "black");
  });

  $('.rquote').click(function() {
    $(this).prev(".dquote").show("slow");
    $(this).css("color", "black");
    $(this).prevUntil(".rquote").css("color", "black");
  });

  $('.apostrophe').click(function() {
    $(this).prev(".apostrophe").show("slow");
    $(this).next(".apostrophe").show("slow");
    $(this).css("color", "black");
  });

  $('.ampersand').click(function() {
    $(this).css("color", "black");
  });

  $('.dash').click(function() {
    $(this).next(".dash").show("slow");
    $(this).css("color", "black");
  });



});
