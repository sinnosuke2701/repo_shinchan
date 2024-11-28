(function($) {
    "use strict";

    /* Cart search */
    $(".account-satting-active , .search-active").on("click", function(e) {
        e.preventDefault();
        $(this).parent().find('.account-dropdown , .search-content').slideToggle('medium');
    })
    
    /* Cart dropdown */
    var iconCart = $('.icon-cart');
    iconCart.on('click', function() {
        $('.shopping-cart-content').toggleClass('cart-visible');
    })
    
    /* Slider active */
    $('.slider-active').owlCarousel({
        loop: true,
        nav: true,
        autoplay: false,
        navText: ['<i class="fa fa-chevron-left"></i>', '<i class="fa fa-chevron-right"></i>'],
        autoplayTimeout: 5000,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        item: 1,
        responsive: {
            0: {
                items: 1
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            }
        }
    })
    
    
    /* Slider active 2 */
    $('.slider-active-2').owlCarousel({
        loop: true,
        nav: true,
        autoplay: false,
        navText: ['<i class="pe-7s-angle-left"></i>', '<i class="pe-7s-angle-right"></i>'],
        autoplayTimeout: 5000,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        item: 1,
        responsive: {
            0: {
                items: 1
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            }
        }
    })
    
    
    /* Slider active */
    $('.slider-active-3').owlCarousel({
        loop: true,
        nav: false,
        autoplay: false,
        autoplayTimeout: 5000,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        item: 1,
        responsive: {
            0: {
                items: 1
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            }
        }
    })
    
    
    /* Instagram active */
    $('.instagram-active').owlCarousel({
        loop: true,
        nav: false,
        autoplay: false,
        autoplayTimeout: 5000,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        item: 5,
        responsive: {
            0: {
                items: 2
            },
            768: {
                items: 4
            },
            1000: {
                items: 5
            }
        }
    })
    
    
    /* Collection slider active */
    $('.collection-active').owlCarousel({
        loop: true,
        nav: false,
        autoplay: true,
        autoplayTimeout: 5000,
        item: 4,
        margin: 30,
        responsive: {
            0: {
                items: 1
            },
            576: {
                items: 2
            },
            768: {
                items: 3
            },
            1000: {
                items: 4
            }
        }
    })
    
    
    /* Collection slider active 2 */
    $('.collection-active-2').owlCarousel({
        loop: true,
        nav: false,
        autoplay: false,
        autoplayTimeout: 5000,
        item: 3,
        margin: 30,
        responsive: {
            0: {
                items: 1
            },
            576: {
                items: 2
            },
            768: {
                items: 3
            },
            1000: {
                items: 3
            }
        }
    })
    
    
    /* product-slider active */
    $('.product-slider-active').owlCarousel({
        loop: true,
        nav: true,
        autoplay: false,
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        autoplayTimeout: 5000,
        item: 4,
        margin: 30,
        responsive: {
            0: {
                items: 1,
                autoplay: true,
            },
            576: {
                items: 2
            },
            768: {
                items: 2
            },
            992: {
                items: 3
            },
            1200: {
                items: 4
            }
        }
    })
    
    /* product-slider active 2 */
    $('.product-slider-active-2').owlCarousel({
        loop: true,
        nav: false,
        autoplay: false,
        autoplayTimeout: 5000,
        item: 4,
        margin: 30,
        responsive: {
            0: {
                items: 1,
                autoplay: true,
            },
            576: {
                items: 2
            },
            768: {
                items: 2
            },
            992: {
                items: 3
            },
            1200: {
                items: 4
            }
        }
    })
    
    /* product-slider active 3 */
    $('.product-slider-active-3').owlCarousel({
        loop: true,
        nav: true,
        autoplay: false,
        navText: ['<i class="fa fa-long-arrow-left"></i>', '<i class="fa fa-long-arrow-right"></i>'],
        autoplayTimeout: 5000,
        item: 4,
        margin: 30,
        responsive: {
            0: {
                items: 1,
                autoplay: true,
            },
            576: {
                items: 2
            },
            768: {
                items: 2
            },
            992: {
                items: 3
            },
            1200: {
                items: 4
            }
        }
    })
    
    /* Testimonial active */
    $('.testimonial-active').owlCarousel({
        loop: true,
        nav: true,
        autoplay: false,
        navText: ['<i class="pe-7s-angle-left"></i>', '<i class="pe-7s-angle-right"></i>'],
        autoplayTimeout: 5000,
        item: 1,
        margin: 30,
        responsive: {
            0: {
                items: 1,
                autoplay: true,
            },
            576: {
                items: 1
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            }
        }
    })
    /* Testimonial 2 active */
    $('.testimonial-active-2').owlCarousel({
        loop: true,
        nav: false,
        autoplay: false,
        navText: ['<i class="pe-7s-angle-left"></i>', '<i class="pe-7s-angle-right"></i>'],
        autoplayTimeout: 5000,
        item: 1,
        responsive: {
            0: {
                items: 1,
                autoplay: true,
            },
            576: {
                items: 1
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            }
        }
    })
    
    
    /* Brand logo active */
    $('.brand-logo-active').owlCarousel({
        loop: true,
        nav: false,
        autoplay: false,
        autoplayTimeout: 5000,
        item: 5,
        margin: 30,
        responsive: {
            0: {
                items: 2
            },
            576: {
                items: 3
            },
            768: {
                items: 4
            },
            992: {
                items: 5
            },
            1000: {
                items: 5
            }
        }
    })
    
    /* Brand logo active */
    $('.brand-logo-active-2').owlCarousel({
        loop: true,
        nav: false,
        autoplay: false,
        autoplayTimeout: 5000,
        item: 4,
        margin: 45,
        responsive: {
            0: {
                items: 1
            },
            576: {
                items: 3
            },
            768: {
                items: 3
            },
            992: {
                items: 4
            },
            1000: {
                items: 4
            }
        }
    })
    
    
    /* Related product active */
    $('.related-product-active').owlCarousel({
        loop: true,
        nav: false,
        autoplay: false,
        autoplayTimeout: 5000,
        item: 4,
        margin: 30,
        responsive: {
            0: {
                items: 1
            },
            576: {
                items: 2
            },
            768: {
                items: 2
            },
            992: {
                items: 3
            },
            1200: {
                items: 4
            }
        }
    })
    
    
    /*--- Quickview-slide-active ---*/
    $('.quickview-slide-active').owlCarousel({
        loop: true,
        navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
        margin: 15,
        smartSpeed: 1000,
        nav: true,
        dots: false,
        responsive: {
            0: {
                items: 3,
                autoplay: true,
                smartSpeed: 300
            },
            576: {
                items: 3
            },
            768: {
                items: 3
            },
            1000: {
                items: 3
            }
        }
    })
    
    
    $('.quickview-slide-active a').on('click', function() {
        $('.quickview-slide-active a').removeClass('active');
    })
    
    
    /*----------------------------
    	Cart Plus Minus Button
    ------------------------------ */
	
	$(document).ready(function() {
	    // 수량 증가/감소 버튼
	    var CartPlusMinus = $('.cart-plus-minus');
	    CartPlusMinus.prepend('<div class="dec qtybutton">-</div>');
	    CartPlusMinus.append('<div class="inc qtybutton">+</div>');

	    // 페이지 로드 시 기본값 설정
	    $('.cart-plus-minus-box').val(1);  // 수량 입력 필드에 1을 기본값으로 설정
	    $('#selectedQty').text(1);  // 개수 텍스트에 1을 기본값으로 설정

	    // 가격 초기화 (HTML에서 가져오기)
	    var prSalePriceText = document.getElementById("prSalePrice").innerText;
	    var prSalePrice = parseInt(prSalePriceText.replace('원', '').replace(/,/g, ''), 10);

	    // 수량 증가/감소 버튼 클릭 이벤트 처리
	    $(".qtybutton").on("click", function() {
	        var $button = $(this);
	        var $input = $button.parent().find("input");
	        var oldValue = parseInt($input.val(), 10);  // 문자열을 숫자로 변환

	        // 빈 칸이거나 잘못된 값이면 기본값으로 설정
	        if (isNaN(oldValue) || oldValue < 1) {
	            oldValue = 1;  // 잘못된 값이면 기본값 1로 설정
	        }

	        var newVal;
	        if ($button.text() === "+") {
	            newVal = oldValue + 1;
	        } else {
	            // 1 미만으로 감소하지 않도록 설정
	            newVal = (oldValue > 1) ? oldValue - 1 : 1;
	        }

	        // 새로 계산된 수량을 input 필드와 화면에 표시
	        $input.val(newVal);  // 숫자 값을 그대로 설정
	        $('#selectedQty').text(newVal);  // 개수 텍스트 업데이트
	        $(".your-order-middle .cart-plus-minus-box").text(newVal);  // 화면 상의 수량 업데이트

	        // 수량과 가격을 곱해서 총 가격 계산
	        var totalPrice = newVal * prSalePrice;
	        $('#totalPrice').text(totalPrice.toLocaleString() + '원');  // 가격을 원화로 표시 (천 단위 쉼표 추가)
			document.getElementById("pmToPrice").value = totalPrice;
	        console.log("totalPrice: ", totalPrice);  // 총 가격 출력
	    });

	    // 페이지 로드 시 초기 수량 상태 확인
	    var initialQty = document.getElementById("selectedQty").innerText.trim();
	    console.log("초기 수량: ", initialQty);  // 여기에서도 1이 출력되어야 함

	    // 페이지 로드 시 초기 총 가격 계산
	    var initialTotalPrice = prSalePrice * 1;  // 초기 수량이 1일 때의 총 가격
	    $('#totalPrice').text(initialTotalPrice.toLocaleString() + '원');  // 가격을 원화로 표시
	    console.log("초기 총 가격: ", initialTotalPrice);
	});

    
    /*--
    Menu Stick
    -----------------------------------*/
    var header = $('.sticky-bar');
    var win = $(window);
    win.on('scroll', function() {
        var scroll = win.scrollTop();
        if (scroll < 200) {
            header.removeClass('stick');
        } else {
            header.addClass('stick');
        }
    });
    
    
    /* jQuery MeanMenu */
    $('#mobile-menu-active').meanmenu({
        meanScreenWidth: "991",
        meanMenuContainer: ".mobile-menu-area .mobile-menu",
    });
    
    
    /*-----------------------------------
        Scroll zoom
    -------------------------------------- */
    window.sr = ScrollReveal({
        duration: 800,
        reset: false
    });
    sr.reveal('.scroll-zoom');
    
    
    /*-----------------------
        Shop filter active 
    ------------------------- */
    $('.filter-active a').on('click', function(e) {
        e.preventDefault();
        $('.product-filter-wrapper').slideToggle();
    })
    
    
    /*---------------------
        Price slider
    --------------------- */
    var sliderrange = $('#slider-range');
    var amountprice = $('#amount');
    $(function() {
        sliderrange.slider({
            range: true,
            max: 100000,
            values: [0, 300],
            slide: function(event, ui) {
                amountprice.val("₩" + ui.values[0] + " - ₩" + ui.values[1]);
            }
        });
        amountprice.val("₩" + sliderrange.slider("values", 0) +
            " - ₩" + sliderrange.slider("values", 1));
    });
    
    
    /* Language dropdown */
    $(".language-style a").on("click", function(e) {
        e.preventDefault();
        $(this).parent().find('.lang-car-dropdown').slideToggle('medium');
    })
    
    
    /* use style dropdown */
    $(".use-style a").on("click", function(e) {
        e.preventDefault();
        $(this).parent().find('.lang-car-dropdown').slideToggle('medium');
    })
    
    
    /*=========================
		Toggle Ativation
	===========================*/
    function itemToggler() {
        $(".toggle-item-active").slice(0, 8).show();
        $(".item-wrapper").find(".loadMore").on('click', function(e) {
            e.preventDefault();
            $(this).parents(".item-wrapper").find(".toggle-item-active:hidden").slice(0, 4).slideDown();
            if ($(".toggle-item-active:hidden").length == 0) {
                $(this).parent('.toggle-btn').fadeOut('slow');
            }
        });
    }
    itemToggler();
    
    
    function itemToggler2() {
        $(".toggle-item-active2").slice(0, 8).show();
        $(".item-wrapper2").find(".loadMore2").on('click', function(e) {
            e.preventDefault();
            $(this).parents(".item-wrapper2").find(".toggle-item-active2:hidden").slice(0, 4).slideDown();
            if ($(".toggle-item-active2:hidden").length == 0) {
                $(this).parent('.toggle-btn2').fadeOut('slow');
            }
        });
    }
    itemToggler2();
    
    function itemToggler3() {
        $(".toggle-item-active3").slice(0, 8).show();
        $(".item-wrapper3").find(".loadMore3").on('click', function(e) {
            e.preventDefault();
            $(this).parents(".item-wrapper3").find(".toggle-item-active3:hidden").slice(0, 4).slideDown();
            if ($(".toggle-item-active3:hidden").length == 0) {
                $(this).parent('.toggle-btn3').fadeOut('slow');
            }
        });
    }
    itemToggler3();
    
    
    /*--------------------------
        ScrollUp
    ---------------------------- */
    $.scrollUp({
        scrollText: '<i class="fa fa-angle-double-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade'
    });
    
    
    /*--------------------------
        Isotope
    ---------------------------- */
    
    $('.grid').imagesLoaded(function() {
        // init Isotope
        $('.grid').isotope({
            itemSelector: '.grid-item',
            percentPosition: true,
            layoutMode: 'masonry',
            masonry: {
                // use outer width of grid-sizer for columnWidth
                columnWidth: '.grid-sizer',
            }
        });
    });
    
    
    /*--- Clickable menu active ----*/
    const slinky = $('#menu').slinky()
    
    /*====== sidebarCart ======*/
    function sidebarMainmenu() {
        var menuTrigger = $('.clickable-mainmenu-active'),
            endTrigger = $('button.clickable-mainmenu-close'),
            container = $('.clickable-mainmenu');
        menuTrigger.on('click', function(e) {
            e.preventDefault();
            container.addClass('inside');
        });
        endTrigger.on('click', function() {
            container.removeClass('inside');
        });
    };
    sidebarMainmenu();
    
    
    /*=========================
		Toggle Ativation
	===========================*/
    function itemToggler4() {
        $(".toggle-item-active4").slice(0, 6).show();
        $(".item-wrapper4").find(".loadMore4").on('click', function(e) {
            e.preventDefault();
            $(this).parents(".item-wrapper4").find(".toggle-item-active4:hidden").slice(0, 3).slideDown();
            if ($(".toggle-item-active4:hidden").length == 0) {
                $(this).parent('.toggle-btn4').fadeOut('slow');
            }
        });
    }
    itemToggler4();

    function itemToggler5() {
        $(".toggle-item-active5").slice(0, 6).show();
        $(".item-wrapper5").find(".loadMore5").on('click', function(e) {
            e.preventDefault();
            $(this).parents(".item-wrapper5").find(".toggle-item-active5:hidden").slice(0, 3).slideDown();
            if ($(".toggle-item-active5:hidden").length == 0) {
                $(this).parent('.toggle-btn5').fadeOut('slow');
            }
        });
    }
    itemToggler5();

    function itemToggler6() {
        $(".toggle-item-active6").slice(0, 6).show();
        $(".item-wrapper6").find(".loadMore6").on('click', function(e) {
            e.preventDefault();
            $(this).parents(".item-wrapper6").find(".toggle-item-active6:hidden").slice(0, 3).slideDown();
            if ($(".toggle-item-active6:hidden").length == 0) {
                $(this).parent('.toggle-btn6').fadeOut('slow');
            }
        });
    }
    itemToggler6();
    
    
    /*---------------------
        Countdown
      --------------------- */
    $('[data-countdown]').each(function() {
        var $this = $(this),
            finalDate = $(this).data('countdown');
        $this.countdown(finalDate, function(event) {
            $this.html(event.strftime('<span class="cdown day">%-D <p>Days</p></span> <span class="cdown hour">%-H <p>Hours</p></span> <span class="cdown minutes">%M <p>Minutes</p></span class="cdown second"> <span>%S <p>Second</p></span>'));
        });
    });
    
    
    /*--------------------------
        Product Zoom
	---------------------------- */
    $(".zoompro").elevateZoom({
        gallery: "gallery",
        galleryActiveClass: "active",
        zoomWindowWidth: 300,
        zoomWindowHeight: 100,
        scrollZoom: false,
        zoomType: "inner",
        cursor: "crosshair"
    });
    
    
    /*---------------------
        Product dec slider
    --------------------- */
    $('.product-dec-slider-2').slick({
        infinite: true,
        slidesToShow: 4,
        vertical: true,
        slidesToScroll: 1,
        centerPadding: '60px',
        prevArrow: '<span class="product-dec-icon product-dec-prev"><i class="fa fa-angle-up"></i></span>',
        nextArrow: '<span class="product-dec-icon product-dec-next"><i class="fa fa-angle-down"></i></span>',
        responsive: [{
                breakpoint: 992,
                settings: {
                    slidesToShow: 4,
                    slidesToScroll: 1
                }
            },
            {
                breakpoint: 767,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                }
            },
            {
                breakpoint: 479,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                }
            }
        ]
    });
    
    
    /*---------------------
        Video popup
    --------------------- */
    $('.video-popup').magnificPopup({
        type: 'iframe',
        mainClass: 'mfp-fade',
        removalDelay: 160,
        preloader: false,
        zoom: {
            enabled: true,
        }
    });
    
    
    /*---------------------
        Sidebar active
    --------------------- */
    $('.sidebar-active').stickySidebar({
        topSpacing: 80,
        bottomSpacing: 30,
        minWidth: 767,
    });
    
    
    /* Product details slider */
    $('.product-details-slider-active').owlCarousel({
        loop: true,
        nav: true,
        autoplay: false,
        autoplayTimeout: 5000,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        navText: ['<i class="fa fa-chevron-left"></i>', '<i class="fa fa-chevron-right"></i>'],
        item: 3,
        margin: 30,
        responsive: {
            0: {
                items: 1
            },
            768: {
                items: 3
            },
            1000: {
                items: 3
            }
        }
    })
    
    
    /*--
    Magnific Popup
    ------------------------*/
    $('.img-popup').magnificPopup({
        type: 'image',
        gallery: {
            enabled: true
        }
    });
    
    
    /*-------------------------
    Create an account toggle
    --------------------------*/
    $('.checkout-toggle2').on('click', function() {
        $('.open-toggle2').slideToggle(1000);
    });
    
    $('.checkout-toggle').on('click', function() {
        $('.open-toggle').slideToggle(1000);
    });
    
    
    /*---- CounterUp ----*/
    $('.count').counterUp({
        delay: 10,
        time: 1000
    });
    
    
    /* Blog img slide active */
    $('.blog-img-slide').owlCarousel({
        loop: true,
        nav: true,
        dots: false,
        autoplay: false,
        autoplayTimeout: 5000,
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
        item: 1,
        margin: 30,
        responsive: {
            0: {
                items: 1
            },
            768: {
                items: 1
            },
            1000: {
                items: 1
            }
        }
    })
    
    
    /*====== fullpage slider active ======*/
   
    $('#fullpage').fullpage({
        sectionSelector : '.flone-fp-section',
        slideSelector : '.flone-fp-slide',
        navigation : true,
        responsiveWidth: 575
    });
    
    
    /*------ Wow Active ----*/
    new WOW().init();
    
    
    
    
    
    
    
    
    
    
    



})(jQuery);