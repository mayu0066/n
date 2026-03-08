$(function () {

  //ページ内スクロール
  var navHeight = $(".header").outerHeight();

  $('a[href^="#"]').on("click", function () {
    var href = $(this).attr("href");
    var target = $(href == "#" || href == "" ? "html" : href);
    var position = target.offset().top - navHeight;
    $("html, body").animate({ scrollTop: position, }, 300, "swing");
    return false;
  });

  //ページトップ
  $("#js-page-top").on("click", function () {
    $("body,html").animate({ scrollTop: 0, }, 300);
    return false;
  });

});

// オプション設定
// 条件：要素の30% 画面に入ったら発火
const itemOption = {
  root: null,
  rootMargin: "0px",
  threshold: 0.2,
}

const titleOption = {
  root: null,
  rootMargin: "0px",
  threshold: 0.1,
}

// インスタンス生成　コールバック関数とオプションを渡す
const observerItem = new IntersectionObserver(doWhenIntersect, itemOption);
const observerTitle = new IntersectionObserver(doWhenIntersect, titleOption);

// 監視対象にしたい要素を渡す
document.querySelectorAll('.js--fade-item').forEach((el) => {
  observerItem.observe(el);
});

document.querySelectorAll('.js--fade-title').forEach((el) => {
  observerTitle.observe(el);
});

function doWhenIntersect(entries) {
  entries.forEach(entry => {

    if (entry.isIntersecting) {
      // 画面に入ったらクラスを付ける
      entry.target.classList.add('is-intersecting');
    } else {
      // 画面から出たらクラスを外す
      entry.target.classList.remove('is-intersecting');
    }

  });
}
