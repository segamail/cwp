/*
* © 2011 D MALAM
* MIT License
* Responsly.js Slidy jQuery Plugin
* Edit as needed
*/

/*jshint
            browser:  true,
            eqeqeq:   true,
            eqnull:   true,
            immed:    false,
            newcap:   true,
            nomen:    false,
            onevar:   false,
            plusplus: true,
            regexp:    true,
            undef:    true,
            white:    false */
  /*global  window, document, jQuery, J */

(function( J ){

  J.fn.slidy = function( options ) {
    var settings = J.extend({}, J.fn.slidy.defaults, options);
    // Pureish Functions
    function moveOffScreenLeft(slide){
        slide.toggleClass('slidyLeft', true);
        slide.toggleClass('slidyCurrent slidyRight', false);
    }

    function moveOffScreenRight(slide){
        slide.toggleClass('slidyRight', true);
        slide.toggleClass('slidyCurrent slidyLeft', false);
    }

    function moveOnScreen(slide){
        slide.toggleClass('slidyCurrent', true);
        slide.toggleClass('slidyLeft slidyRight', false);
    }

    //Fix js mod of -ve number bug
    function mod(m, n) {
      return ((m%n)+n)%n;
    }

    return this.each(function(index, container) {

      if (settings.showArrows) {
        //Add the forwards/backwards buttons
        J(container).prepend('<div class = "'+settings.movePrev+'"/>');
        J(container).append('<div class = "'+settings.moveNext+'"/>');

        var slidesCount = J(container).find('.slidySlides').children().length;
        var current = 1;
        var start = current;

        var prev = function() {
           var next = mod((current - 2 ), slidesCount) + 1;

          if(current == start){
            for (i = start; i < slidesCount;  i++){
              moveOffScreenLeft(J(container).find('.slidySlides figure:nth-child('+i+')'));
            }
            moveOnScreen(J(container).find('.slidySlides figure:nth-child('+slidesCount+')'))
          }else{
            moveOffScreenRight(J(container).find('.slidySlides figure:nth-child('+current+')'));
            moveOnScreen(J(container).find('.slidySlides figure:nth-child('+(next)+')'));
          }
          current = next;
        }

        // Move center slide offscreen left, and move offscree right slide to center
        var next = function() {
           var next = (current % slidesCount) + 1

          if(current == slidesCount){
            for (i = slidesCount; i > next; i--){
              moveOffScreenRight(J(container).find('.slidySlides figure:nth-child('+i+')'));
            }
            moveOnScreen(J(container).find('.slidySlides figure:nth-child('+start+')'));
          }else{
            moveOffScreenLeft(J(container).find('.slidySlides figure:nth-child('+current+')'));
            moveOnScreen(J(container).find('.slidySlides figure:nth-child('+(next)+')'));
          }
          current = next;

        //   setTimeout( function() {
        //     J(container).find('figure.slidyCurrent figcaption').addClass('.transparent')}, 2000 );
         };

        J(container).find('.'+settings.movePrev).click(prev);
        J(container).find('.'+settings.moveNext).click(next);


        //show arrows on mouse enter
         J(container).mouseenter(function(){
           J(container).find('.'+settings.movePrev).addClass('opaque');
           J(container).find('.'+settings.moveNext).addClass('opaque');
         });
         //hide arrows on mouse leave
         J(container).mouseleave(function(){
           J(container).find('.'+settings.movePrev).removeClass('opaque');
           J(container).find('.'+settings.moveNext).removeClass('opaque');
         });
      }

      // Bind to keyboard
      if (settings.useKeybord){
        var bind = function(e){
            if (e.keyCode === 37){ //Left
              prev();
            }
            if (e.keyCode === 39){ //Right
              next();
            }
          };

        if(settings.throttle){
          J(document).keydown(J.throttle(settings.throttleTime, bind));
        }else{
          J(document).keydown(bind);
        }
      }

      // Auto slide show
       if (settings.auto){
         //wait initialInterval before starting slideshow
         setTimeout(function() {
           var intervalId = setInterval(next, settings.interval);
           //pause on mouse hover
           J(container).mouseenter(function(){
             clearInterval(intervalId);
           });
           //start again on mouse leave
           J(container).mouseleave(function(){
             intervalId = setInterval(next, settings.interval);
           });
         	}, settings.initialInterval );
       }
     });
  };

  J.fn.slidy.defaults = {
      throttle: false, // Set to true, and include jQuery throttle plugin (http://benalman.com/projects/jquery-throttle-debounce-plugin/)
      throttleTime: 500, // number of ms to wait for throttling
      showArrows: true, // Show arrows for next/prev image
      movePrev: 'movePrev', // Div id to use for previous button
      moveNext: 'moveNext', // Div id to use for next button
      useKeybord: true, // use keys defined below to expand / collapse sections
      auto: false,       // Start slideshow automatically
      interval: 6000,     // Time between each slide
      initialInterval: 10000  // Initial interval when page loads
      };

})( jQuery );
