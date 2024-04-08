<%@ page language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/css/wst.css"/>
<link rel="stylesheet" href="${staticPath}/qtimages/hsgbanner.css">
<script type="text/javascript" src="${staticPath}/qtimages/jquery.js"></script>
<script type="text/javascript" src="${staticPath}/qtimages/inc.js"></script>
</head>
<div class="wban">
    <div class="gg" id="gg">
        <div class="ggLoading">
            <div class="ggLoading2"><em>精彩活动载入中</em></div>
        </div>
        <div class="ggs">
            <div class="ggBox" id="ggBox">
            </div>
        </div>
        <div class="ggb">
            <div class="ggBtns" id="ggBtns">
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $.get(basePath + '/lunboAll/', function (resp) {
        if (resp.success) {
            if (resp.data != null) {
                var list = resp.data;
                var ggBoxHtml = [];
                var ggBtnsHtml = [];
                for (var i = 0; i < list.length; i++) {
                    var info = list[i];
                    ggBoxHtml.push('<a target="_blank" href="${contextPath}/lunboDetailQian/' + info.id + '"');
                    ggBtnsHtml.push('<a href="javascript:void(0)"');
                    if (i == 0) {
                        ggBoxHtml.push(' style="z-index:3;opacity:4;"');
                        ggBtnsHtml.push(' class="current"');
                    }
                    ggBoxHtml.push('><img src="${contextPath}/' + info.image + '" height="400px" alt="' + info.biaoti + '" /></a>');
                    ggBtnsHtml.push('><em>');
                    ggBtnsHtml.push(i + 1);
                    ggBtnsHtml.push('</em></a>');
                }
                $("#ggBox").empty().html(ggBoxHtml.join(''));
                $("#ggBtns").empty().html(ggBtnsHtml.join(''));
                $(function () {

                    var $con = $('#gg'), $box = $con.find('#ggBox'), $btns = $con.find('#ggBtns'), i = 0, autoChange = function () {
                        i += 1;
                        if (i === 5) {
                            i = 0;
                        }
                        $btns.find('a:eq(' + i + ')').addClass('current').siblings().removeClass('current');
                        var curr = $box.find('a:eq(' + i + ')'), prev = curr.siblings();
                        prev.css('z-index', 2);
                        curr.css('z-index', 3).animate({
                            'opacity': 1
                        }, 150, function () {
                            prev.css({
                                'z-index': 1, 'opacity': 0.1
                            });
                        });
                    }, loop = setInterval(autoChange, 1500);

                    $con.hover(function () {
                        clearInterval(loop);
                    }, function () {
                        loop = setInterval(autoChange, 1500);
                    });

                    $btns.find('a').click(function () {
                        i = $(this).index() - 1;
                        autoChange();
                    });

                });
            }
        } else {
            alert(resp.message);
        }
    })
</script>