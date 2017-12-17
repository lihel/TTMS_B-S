<%--
  Created by IntelliJ IDEA.
  User: lmy
  Date: 17-11-19
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>studio</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="view/CSS/bs.css">
    <link rel="stylesheet" href="view/CSS/index.css">
    <link href="view/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<script src="view/JS/jquery.min.js"></script>
<script src="view/JS/bootstrap.min.js"></script>

<script type="text/javascript" src="view/JS/studio.js"></script>


<div class="header">
    <div class="row">
        <div class="font col-md-9">TTMS</div>
        <div class="signState col-md-3">
            <i class="fa fa-user-circle"></i>
            <a href="#">管理员 |</a>
            <a href="index.jsp">登出</a>
        </div>
    </div>
</div>

<br>

<div class="container-fluid">

    <div class="row">
        <div class="col-md-3">
            <jsp:include page="/nav.jsp"></jsp:include>
        </div>

        <div class="col-md-9">
            <input type="text" class="select" placeholder="    请输入演出厅名称">
            <a href="#"><big><i class="fa fa-search"></i></big></a>
            <div class="tableLoaction">


                <table class="table table-hover" id="studioTable" onclick="studioRow()">
                    <thead>
                    <tr>
                        <th>演出厅名称</th>
                        <th>座位行数</th>
                        <th>座位列数</th>
                        <th>座位总数</th>
                        <th>演出厅类型</th>
                        <th>演出厅状态</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1号厅</td>
                        <td>10</td>
                        <td>14</td>
                        <td>120</td>
                        <td>3D厅</td>
                        <td>正常使用</td>

                    </tr>
                    <tr>
                        <td>2号厅</td>
                        <td>11</td>
                        <td>10</td>
                        <td>110</td>
                        <td>普通厅</td>
                        <td>正常使用</td>
                    </tr>
                    <tr>
                        <td>3号厅</td>
                        <td>12</td>
                        <td>10</td>
                        <td>120</td>
                        <td>3D厅</td>
                        <td>禁用</td>
                    </tr>
                    <tr>
                        <td>4号厅</td>
                        <td>11</td>
                        <td>10</td>
                        <td>110</td>
                        <td>普通厅</td>
                        <td>正常使用</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <button data-show-layer="hw-layer" role="button"
                    class="btn btn-primary btn-lg show-layer" id="addUser">
                <span class="glyphicon glyphicon-plus"></span> 添加演出厅
            </button>
            <input type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"
                   value="编辑演出厅" onclick="editStudio()">

            <input type="button" class="btn btn-danger btn-lg" onclick="del()"
                   value="删除演出厅">

        </div>
    </div>

</div>

<div class="hw-overlay" id="hw-layer">
    <div class="hw-layer-wrap">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close hwLayer-close" data-dismiss="modal">×</button>
                <h4 class="modal-title">增加演出厅</h4>
            </div>

            <div class="modal-body">
                <div class="form-group">
                    <label for="studioName">演出厅名称</label>
                    <input type="text" class="form-control" placeholder="演出厅名称" id="studioName">
                </div>
                <div class="pointOut">(行列值为1到100之间的整数)</div>
                <div class="form-group">
                    <label for="row">座位行数</label>
                    <input type="text" class="form-control" placeholder="座位行数" id="row" required="required">
                </div>
                <div class="form-group">
                    <label for="col">座位列数</label>
                    <input type="text" class="form-control" placeholder="座位列数" id="col">
                </div>
                <div class="form-group">
                    <label>演出厅类型</label>
                </div>

                <select class="form-control" id="studioType">
                    <option> 普通厅</option>
                    <option>3D厅</option>
                    <option>VIP厅</option>
                </select>

                <br>

                <select class="form-control" id="studioStatus">
                    <option>正常使用</option>
                    <option>禁用</option>
                </select>

            </div>


            <div class="modal-footer">
                <button type="button" class="btn btn-default hwLayer-cancel" data-dismiss="modal"><i
                        class="fa fa-remove "></i>关闭
                </button>
                <button type="submit" class="btn btn-primary" data-dismiss="modal" onclick="check()"><i
                        class="fa fa-save"></i> 保存
                </button>
            </div>
        </div>
    </div>
</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close hwLayer-close" data-dismiss="modal">×</button>
                <h4 class="modal-title">编辑演出厅</h4>
            </div>

            <form action="studio.jsp">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="sName">演出厅名称</label>
                        <input type="text" class="form-control" placeholder="演出厅名称" id="sName">
                    </div>
                    <div class="pointOut">(行列值为1到100之间的整数)</div>

                    <div class="form-group">
                        <label for="srow">座位行数</label>
                        <input type="text" class="form-control" placeholder="座位行数" id="srow">
                    </div>
                    <div class="form-group">
                        <label for="scol">座位列数</label>
                        <input type="text" class="form-control" placeholder="座位列数" id="scol">
                    </div>
                    <div class="form-group">
                        <label>演出厅类型</label>
                    </div>

                    <select class="form-control" id="select">
                        <option> 普通厅</option>
                        <option>3D厅</option>
                        <option>VIP厅</option>
                    </select>

                    <br>

                    <select class="form-control">
                        <option>正常使用</option>
                        <option>禁用</option>
                    </select>

                </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default hwLayer-cancel" data-dismiss="modal"><i
                        class="fa fa-remove "></i>关闭
                </button>
                <button type="submit" class="btn btn-primary hwLayer-ok" data-dismiss="modal"><i
                        class="fa fa-save"></i> 保存
                </button>
            </div>
        </div>
    </div>

</div>
</body>
</html>
