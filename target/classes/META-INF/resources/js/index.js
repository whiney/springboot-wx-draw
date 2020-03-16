    $(function () {
        var inputName = "";
        var inputType = "";
        /*点击生成按钮*/
        $(".gene_btn").click(function () {
            inputName = $.trim($("#input_name").val());
            inputType = $.trim($("#input_type").val());
            if (inputName.length < 1   ) {
                $(".error.name").show();
                return;
            }
            $(".error.name").hide();
            if (inputType.length < 1   ) {
                $(".error.type").show();
                return;
            }
            $(".error.type").hide();
            $(".page1").hide();
            $(".spinner").show();
            $.post("/createPic",{
                name : inputName,
                title: inputType
              },
              function(data,status){
                $(".spinner").hide();
                $(".back").hide();
                $(".result").attr("src", "/data/"+data+".png");
                $(".tip").show();
              });
        });
    });
