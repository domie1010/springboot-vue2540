<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <!-- bootstrap样式，地图插件使用 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
</head>
<body style="background: #EEEEEE; ">


<div id="app">

    <!-- 轮播图 -->
    <div class="layui-carousel" id="swiper">
        <div carousel-item id="swiper-item">
            <div v-for="(item,index) in swiperList" v-bind:key="index">
                <img class="swiper-item" :src="item.img">
            </div>
        </div>
    </div>
    <!-- 轮播图 -->

    <div class="data-add-container">

        <form class="layui-form layui-form-pane" lay-filter="myForm">
            <!-- 级联表的 -->
            <div class="layui-form-item" pane>
                <label class="layui-form-label">地皮名称：</label>
                <div class="layui-input-block">
                    <input v-model="dipi.dipiName" type="text"  readonly="readonly" name="dipiName" id="dipiName" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" pane>
                <label class="layui-form-label">地皮位置：</label>
                <div class="layui-input-block">
                    <input v-model="dipi.dipiWeizhi" type="text"  readonly="readonly" name="dipiWeizhi" id="dipiWeizhi" autocomplete="off"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item" pane>
                <label class="layui-form-label">地皮缩略图：</label>
                <div v-if="dipi.dipiPhoto" class="layui-input-block">
                    <img id="dipiPhotoImg"
                         style="width: 100px;height: 100px;border-radius: 50%;border: 2px solid #EEEEEE;"
                         :src="dipi.dipiPhoto">
                    <input type="hidden" :value="detail.dipiPhoto" readonly="readonly" id="dipiPhoto" name="dipiPhoto"/>
                </div>
            </div>
                                <div class="layui-form-item" pane>
                <label class="layui-form-label">是否被使用</label>
                <div class="layui-input-inline">
                    <input v-model="dipi.dipiValue" type="text" readonly="readonly" placeholder="是否被使用" autocomplete="off" class="layui-input">
                </div>
            </div>


            <!-- 当前表的 -->
            <!-- 级联表的表id -->
            <input type="hidden" :value="dipi.id" id="dipiId" name="dipiId"/>


            <div class="layui-form-item" pane>
                <label class="layui-form-label">作物名称：</label>
                <div class="layui-input-block">
                    <input v-model="detail.zuowuName" type="text" name="zuowuName" id="zuowuName" placeholder="作物名称" lay-verify="required" autocomplete="off"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item" pane>
                <label class="layui-form-label">作物类型：</label>
                <div class="layui-input-block">
                    <select name="zuowuTypes" id="zuowuTypes" lay-filter="zuowuTypes">
                        <option v-for="item in zuowuTypesList" :value="item.codeIndex" :key="item.codeIndex">{{ item.indexName }}</option>
                    </select>
                </div>
            </div>

            <%--<div class="layui-form-item" pane>--%>
                <%--<label class="layui-form-label">是否同意：</label>--%>
                <%--<div class="layui-input-block">--%>
                    <%--<select name="dipiOrderYesnoTypes" id="dipiOrderYesnoTypes" lay-filter="dipiOrderYesnoTypes">--%>
                        <%--<option v-for="item in dipiOrderYesnoTypesList" :value="item.codeIndex" :key="item.codeIndex">{{ item.indexName }}</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="layui-form-item">
                <div class="layui-input-block" style="text-align: right;margin-right: 30px;">
                    <button class="layui-btn btn-submit" lay-submit lay-filter="thisSubmit">提交</button>
                </div>
            </div>
        </form>
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
<!-- 地图 -->
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=ca04cee7ac952691aa67a131e6f0cee0"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.AMapPositionPicker.js"></script>

<script>
    var jquery = $;

    var vue = new Vue({
        el: '#app',
        data: {
            // 轮播图
            swiperList: [{
                img: '../../img/banner.jpg'
            }],
            // 当前表数据
            detail: {
                dipiId: '',
                kehuId: '',
                zuowuName: '',
                zuowuTypes: '',
                insertTime: '',
                dipiOrderYesnoTypes: '',
                createTime: '',
            },

            // 级联表的
            dipi: {},

            // 下拉框
            zuowuTypesList: [],
            dipiOrderYesnoTypesList: [],
            centerMenu: centerMenu
        },
        updated: function () {
            layui.form.render('select', 'myForm');
        },
        computed: {},
        methods: {
            jump(url) {
                jump(url)
            }
        }
    })


    layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload', 'laydate', 'tinymce'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        var form = layui.form;
        var upload = layui.upload;
        var laydate = layui.laydate;
        var tinymce = layui.tinymce

        // 获取轮播图 数据
        http.request('config/list', 'get', {
            page: 1,
            limit: 5
        }, function(res) {
            if (res.data.list.length > 0) {
                var swiperItemHtml = '';
                for (let item of res.data.list) {
                    if (item.value != "" && item.value != null) {
                        swiperItemHtml +=
                                '<div>' +
                                '<img class="swiper-item" src="' + item.value + '">' +
                                '</div>';
                    }
                }
                jquery('#swiper-item').html(swiperItemHtml);
                // 轮播图
                carousel.render({
                    elem: '#swiper',
                    width: swiper.width,height:swiper.height,
                    arrow: swiper.arrow,
                    anim: swiper.anim,
                    interval: swiper.interval,
                    indicator: "none"
                });
            }
        });


        // 级联表数据查询
        var id = http.getParam('id');
        initializationdipi(id);
        // 下拉框
        // 作物类型的查询和初始化
       zuowuTypesSelect();
        // 是否同意的查询和初始化
       dipiOrderYesnoTypesSelect();

        // 上传文件
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

        // session独取
        let table = localStorage.getItem("userTable");
        http.request(table+"/session", 'get', {}, function (data) {
            // 表单赋值
            //form.val("myForm", data.data);
            // data = data.data;
            for (var key in data) {
                vue.detail[table+"Id"] = data.id
            }
        });


        // 提交
        form.on('submit(thisSubmit)', function (data) {
            data = data.field;
            data["kehuId"]= localStorage.getItem("userid");
            // 提交数据
            http.requestJson('dipiOrder' + '/add', 'post', data, function (res) {
                layer.msg('提交成功', {
                    time: 2000,
                    icon: 6
                }, function () {
                    back();
                });
            });
            return false
        });


        // 日期框初始化
        function dateTimePick(){
            var myDate = new Date();  //获取当前时间
            /*
                ,change: function(value, date, endDate){
                    value       得到日期生成的值，如：2017-08-18
                    date        得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                    endDate     得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
            */
        }




       // 作物类型的查询
       function zuowuTypesSelect() {
           //填充下拉框选项
           http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=zuowu_types", "GET", {}, (res) => {
               if(res.code == 0){
                   vue.zuowuTypesList = res.data.list;
               }
           });
       }


       // 是否同意的查询
       function dipiOrderYesnoTypesSelect() {
           //填充下拉框选项
           http.request("dictionary/page?page=1&limit=100&sort=&order=&dicCode=dipi_order_yesno_types", "GET", {}, (res) => {
               if(res.code == 0){
                   vue.dipiOrderYesnoTypesList = res.data.list;
               }
           });
       }




        function initializationdipi(id){
            // 详情赋值
            http.request("dipi/detail/" + id, 'get', {}, function (res) {
                if(res.code ==0){
                    vue.dipi = res.data;
                }
            });
        }
    });
</script>
</body>
</html>