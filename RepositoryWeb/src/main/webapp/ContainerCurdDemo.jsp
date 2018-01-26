<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello, world</title>
    <link href="http://39.108.109.226/css/general/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .tTd {
            padding-top: 30px;
            padding-bottom: 30px;
            border: 1px green
        }
    </style>

</head>
<body>
<div class="modal fade" tabindex="-1" role="dialog" id = "addModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">增加货柜</h4>
            </div>
            <div class="modal-body">
                <form id="addForm">
                    <div class="form-group">
                        <label>货柜名</label>
                        <input type="text" class="form-control" name="containerName">
                    </div>
                    <div class="form-group">
                        <label>容量</label>
                        <input type="text" class="form-control" name="containerCapacity">
                    </div>
                    <div class="form-group">
                        <label>备注</label>
                        <input type="text" class="form-control" name="containerNote">
                    </div>
                    <div class="form-group">
                        <select class="form-control" id="env_sel" name="containerEnvironment">

                        </select>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="submitAdd">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" tabindex="-1" role="dialog" id = "updateModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改货柜信息</h4>
            </div>
            <div class="modal-body">
                <form id="updateForm">
                    <div class="form-group">
                        <label>货柜ID</label>
                        <label id = "containerIdTxt"></label>
                    </div>
                    <div class="form-group">
                        <label>货柜名</label>
                        <input type="text" class="form-control" name="containerName">
                    </div>
                    <div class="form-group">
                        <label>备注</label>
                        <input type="text" class="form-control" name="containerNote">
                    </div>
                    <div class="form-group">
                        <select class="form-control" id="env_sel_up" name="containerEnvironment">

                        </select>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="submitUp">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <h2 style="text-align:center"> 货柜Demo </h2>
                </div>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <button class="btn btn-primary" id="addBtn">增加货柜</button>
        </div>
    </div>

    <hr>
    <div id="containersDiv">

    </div>
</div>

    <script src="http://39.108.109.226/js/general/jquery.min.js"></script>
    <script src="http://39.108.109.226/js/general/bootstrap.min.js"></script>
    <script>
        function delA(id) {
            var msg = "您真的确定要删除这个货柜吗？";
            if (confirm(msg)==true) {
               $.ajax({
                   url:"manager/container/delete/"+id,
                   type:"GET",
                   success:function (result) {
                       if(result.code == 100){
                           alert("操作成功")
                           window.location.reload();
                       }
                       else{
                           alert("操作失败")
                       }

                   }
               })
            }
        }

        function updateA(id){
            // var id = $(this).attr("upId");
            var container;
            $.ajax({
                url:"manager/container/get/"+id,
                type:"GET",
                success:function (result) {
                    container = result.extend.container;
                    console.log(container);
                    $("#containerIdTxt").text(container.containerId);
                    $("#updateModal input[name='containerName']").val(container.containerName);
                    $("#updateModal input[name='containerNote']").val(container.containerNote);

                    $.ajax({
                        url:"manager/container/environments",
                        type:"GET",
                        success:function (result) {
                            $("#env_sel_up").empty();
                            var environments = result.extend.environments;
                            $.each(environments,function() {
                                var opt = $("<option></option>").attr({"value": this.environmentId}).append(this.environmentName + " （ 温度：" + this.temperature + "℃ 湿度：" + this.humidity + "% ）");
                                if(this.environmentId == container.containerEnvironment){
                                    opt.prop("selected",true);
                                }
                                $("#env_sel_up").append(opt);
                            });
                        }
                    })
                }
            });


            $("#updateModal").modal('show');
        };

        $("#submitUp").click(function(){
            $.ajax({
                url:"manager/container/update",
                type:"POST",
                data:$("#updateForm").serialize()+"&containerId="+$("#containerIdTxt").text(),
                success:function(result){
                    if(result.code == 100){
                        alert("操作成功.");
                        window.location.reload();
                    }else{
                        alert("操作失败.");
                    }

                }

            })
        });


        function buildEnvironment(environments) {
            $("#env_sel").empty();
            $.each(environments,function(){
               var opt = $("<option></option>").attr({"value":this.environmentId}).append(this.environmentName+" （ 温度："+this.temperature+"℃ 湿度："+this.humidity+"% ）");
               $("#env_sel").append(opt);
            });
        }

        $("#addBtn").click(function(){
            $.ajax({
               url:"manager/container/environments",
                type:"GET",
                success:function(result){
                   // console.log(result);
                    buildEnvironment(result.extend.environments);
                    $("#addModal").modal('show');
                }
            });
        });

        $("#submitAdd").click(function(){
            $.ajax({
                url:"manager/container/add",
                type:"POST",
                data:$("#addForm").serialize(),
                success:function(result){
                    if(result.code == 100){
                        alert("操作成功.");
                        window.location.reload();
                    }else{
                        alert("操作失败.");
                    }

                }

            })
        });



        function buildContainer(containers) {

            $.each(containers, function () {
                var title = $("<div></div>").addClass("row")
                    .append($("<div></div>").addClass("col-md-12")
                        .append($("<div></div>").addClass("panel panel-default")
                            .append($("<div></div>").addClass("panel-heading").css({"text-align": "center"})
                                .append(this.containerName)
                                .append(" <a href='#' class='upContainerA' onclick='updateA("+this.containerId+")'>修改</a>")
                                .append(" <a href='#' class='delContainerA' onclick='delA("+this.containerId+")'+>删除</a>"))
                            .append($("<div></div>").addClass("panel-body")
                                .append("货柜ID："+this.containerId)
                                .append("<br/>已使用：" + this.containerUsed)
                                .append("<br/>容量：" + this.containerCapacity)
                                .append("<br/>备注：" + this.containerNote)
                                .append("<br>当前环境：" + this.containerEnvironment)
                                .append(" 温度：" + this.environment.temperature + "℃ 湿度：" + this.environment.humidity + " %"))));
                var tdsObj = JSON.parse(this.tds);
                var table = $("<table></table>");
                var tds = new Array() ;
                var trs = new Array();
                var i = 0;
                var j = 0;

                $.each(tdsObj,function(){
                    if(this.status == false){
                        var td = $("<td></td>").css({"text-align":"center","border":"1px red solid","padding":"30px"}).append(this.id+"<br>空");
                    }else{
                        var td = $("<td></td>").css({"text-align":"center","border":"1px green solid","padding":"30px"}).append(this.id+"<br>"+this.goodsName);
                    }
                    tds[i] = td;
                    i++;

                    if(i % 10 == 0){
                        var tr = $("<tr></tr>");
                        $.each(tds,function(){
                            tr.append(this);
                        });
                        trs[j] = tr;
                        i = 0;
                        j++;
                    }


                });

                if(i>0){
                    var tr = $("<tr></tr>");
                    for (var t=0;t<i;t++)
                    {
                        tr.append(tds[t]);
                    }
                    trs[j] = tr;
                    j++;
                }

                $.each(trs,function () {
                   table.append(this);
                });

                var body = $("<div></div>").addClass("row").append($("<div></div>").addClass("col-md-offset-1 col-md-10").append(table));
                $("#containersDiv").append(title);
                $("#containersDiv").append(body);
                $("#containersDiv").append("<br>")
            });

        }

        $.ajax({
            url: "manager/container/all",
            type: "GET",
            success: function (result) {
                // console.log(result);
                buildContainer(result.extend.containers);
            }
        })
    </script>
</body>
</html>
