$(function(){
  $('.m_header button').on('click',function(){
          $(this).toggleClass('active');
        })
  var mySwiper1 = new Swiper('#swiper1', {
    autoplay: 3000,//可选选项，自动滑动
    speed:300,
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
    loop:true,
    paginationClickable :true,
})


var w =$(window).width()
    var swiper = new Swiper('#swiper2', {
      slidesPerView: w>768?4:2,
      spaceBetween: 20,
      slidesPerGroup: w>768?3:1,
      loopFillGroupWithBlank: true,
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });





     var actForm = function(){
              $('.dom_1').on('focus',function(event) {

                  /* Act on the event */
                 $(this).siblings('span').hide()
              }).on('blur',function(){
                  if($(this).val()==''){
                       $(this).siblings('span').show()
                  }

              });
              $('.dom_2').on('focus',function(event) {

                  /* Act on the event */
                 $(this).siblings('span').hide()
              }).on('blur',function(){
                  if($(this).val()==''){
                       $(this).siblings('span').show()
                  }

              });
            }

          actForm()

            $('.tittle_banner').addClass('animated fadeInDown slow')
})