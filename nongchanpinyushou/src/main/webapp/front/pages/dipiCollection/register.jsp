<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>注册</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script>
    addEventListener("load", function () {
      setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
      window.scrollTo(0, 1);
    }
  </script>
  <link rel="stylesheet" href="../../layui/css/layui.css">
  <link rel="stylesheet" href="../../xznstatic/css/style.css" type="text/css" media="all">
  <link href="../../xznstatic/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
  <div id="mian" class="main-bg">
    <h1 v-text="projectName"></h1>
    <div class="sub-main-w3">
            <div class="vertical-tab">
        <div id="section1" class="section-w3ls">
          <input type="radio" name="sections" id="option1" checked="checked">
            <article>
              <form class="layui-form login-form" lay-filter="register">
                <div class="layui-form-item" style="margin-bottom: 0;">
                  <div class="layui-input-block" style="margin-left: 0;">
                    <button class="layui-btn btn-submit btn submit" style="height: 50px;line-height: 25px;" lay-submit lay-filter="register">注册</button>
                  </div>
                </div>
                <a class="bottom-text-w3ls" href="javascript:window.location.href='../login/login.jsp'">已有账号？去登录</a>
              </form>
            </article>
          </div>
        </div>
        <div class="clear"></div>
      </div>
      <div class="copyright">
        <h2><a href="#"></a></h2>
      </div>
    </div>

  <script src="../../layui/layui.js"></script>
  <script src="../../js/vue.js"></script>
  <!-- 组件配置信息 -->
  <script src="../../js/config.js"></script>
  <!-- 扩展插件配置信息 -->
  <script src="../../modules/config.js"></script>
  <!-- 工具方法 -->
  <script src="../../js/utils.js"></script>
  <!-- 校验格式工具类 -->
  <script src="../../js/validate.js"></script>

  <script>
    var vue = new Vue({
      el: '#mian',
      data: {
        //字典表数据容器
        projectName: projectName,
        tablename:'dipiCollection'

      },
      updated: function() {
        layui.form.render(null, 'register');
      }
    });

    layui.use(['layer', 'element', 'carousel', 'form', 'http', 'jquery', 'laydate'], function() {
      var layer = layui.layer;
      var element = layui.element;
      var carousel = layui.carousel;
      var form = layui.form;
      var http = layui.http;
      var jquery = layui.jquery;
      var laydate = layui.laydate;



      // 查询字典表相关

        //字典表数据容器


      // 日期效验规则及格式
      dateTimePick();
      // 表单效验规则
      form.verify({
            // 正整数效验规则
            integer: [
                /^[1-9][0-9]*$/
                ,'必须是正整数'
            ]
            // 小数效验规则
            ,double: [
                /^[1-9][0-9]{0,5}(\.[0-9]{1,2})?$/
                ,'最大整数位为6为,小数最大两位'
            ]
      });


      // 注册
      form.on('submit(register)', function(data) {
        http.requestJson(vue.tablename + '/register', 'post', data.field, function(res) {
            if(res.code==0){
                layer.msg('注册成功', {
                    time: 2000,
                    icon: 6
                },function(){
                    // 路径访问设置
                    window.location.href = '../login/login.jsp';
                });
            }else{
                layer.msg(res.msg);
                return false
            }

        });
        return false
      });




      // 日期框初始化
      function dateTimePick(){
      };

});
  </script>
</body>
</html>
