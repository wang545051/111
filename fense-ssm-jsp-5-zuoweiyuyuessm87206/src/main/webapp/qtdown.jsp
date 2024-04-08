<%@ page language="java" pageEncoding="UTF-8" %>
<div class="wbottom">
    <!--上面的开始-->
    <div class="wbm1">
        <div class="wbmal" id="yqlj">
        </div>
        <!--上面的结束-->
        <div class="wbm2">
            <p>Copyright@xxxx 版权所有 备案号：豫ICP备09034319-2号 </p>
        </div>
    </div>
</div>
<script type="text/javascript">
  $.get(basePath + '/lianjieAll/', function(resp) {
    if (resp.success) {
      if(resp.data!=null){
        var list = resp.data;
        var yqljHtml = [];
        yqljHtml.push('<h3>友情链接</h3>');
        for(var i=0; i<list.length; i++){
          var info = list[i];
          yqljHtml.push('<a target="_blank" href="'+info.url+'">'+info.name+'</a>');
        }
        yqljHtml.push('<div class="clear"></div>');
        $("#yqlj").empty().html(yqljHtml.join(''));
      }
    }else {
      alert(resp.message);
    }
  })
</script>
