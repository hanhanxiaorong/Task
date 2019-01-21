<!DOCTYPE html>
<html>
<head>
    <#import "../common/common.macro.ftl" as netCommon>
    <@netCommon.commonStyle />
    <title>${I18n.admin_name}</title>
</head>
<body class="hold-transition skin-blue layout-top-nav">

<div class="wrapper">



    <div class="content-wrapper" >
        <section class="content">
            <pre style="font-size:12px;position:relative;" >
                <div id="logConsole"></div>
                <li class="fa fa-refresh fa-spin" style="font-size: 20px;float: left;" id="logConsoleRunning" ></li>
                <div><hr><hr></div>
            </pre>
        </section>
    </div>

</div>

<@netCommon.commonScript />
<script>
    // 参数
    var triggerCode = '${triggerCode}';
    var handleCode = '${handleCode}';
    var executorAddress = '${executorAddress!}';
    var triggerTime = '${triggerTime?c}';
    var logId = '${logId}';
</script>
<script src="${request.contextPath}/static/js/joblog.detail.1.js"></script>

</body>
</html>