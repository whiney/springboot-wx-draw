$(function(){

    var currurl = decodeURIComponent(location.href.split('#')[0]);
    console.log(currurl)
    //ajax注入权限验证
    $.ajax({
        url : "/initWXJSInterface",
        dataType : 'json',
        data : {
            'url' : encodeURIComponent(currurl)
        },
        complete : function(XMLHttpRequest, textStatus) {},
        error : function(XMLHttpRequest, textStatus, errorThrown) {
        },
        success : function(res) {
            var appId = res.appId;
            var nonceStr = res.nonceStr;
            var timestamp = res.timestamp;
            var signature = res.signature;
            wx.config({
                debug : false, //开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId : appId, //必填，公众号的唯一标识
                timestamp : timestamp, // 必填，生成签名的时间戳
                nonceStr : nonceStr, //必填，生成签名的随机串
                signature : signature, // 必填，签名，见附录1
                jsApiList : [ 'onMenuShareAppMessage'] //必填，需要使用的JS接口列表，所有JS接口列表 见附录2
            });

            wx.ready(function() {
                wx.onMenuShareAppMessage({
                    title: '11', // 分享标题
                    desc: '11', // 分享描述
                    link: decodeURIComponent(currurl), // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                    imgUrl: 'imgs/share.png', // 分享图标
                    success: function () {
                        console.log('-----------')
                        // 用户点击了分享后执行的回调函数
                    }
                });
            });

            wx.error(function(res) {
                console.log(res)
            });
        } // end success
    }); // end ajax

})
