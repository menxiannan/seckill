var saveSeckill = {
    URL: {
        now: function () {
            return '/seckill/time/now';
        },
        saveSeckillUrl: function () {
            return '/seckill/saveSeckills';
        },
        listUrl: function () {
            return '/seckill/list';
        }
    },
    checkParams: function (name, number, startTime, endTime) {
        if (name.length == '') {
            $('#killPhoneMessage').hide().html('<label class="label label-danger">请填写秒杀单名称！</label>').show(300);
            return false;
        }
        if (!number || number.length < 0 || isNaN(number)) {
            $('#killPhoneMessage').hide().html('<label class="label label-danger">请填写秒杀数量！</label>').show(300);
            return false;
        }
        if (!startTime || startTime.length == '') {
            $('#killPhoneMessage').hide().html('<label class="label label-danger">请填写开始时间！</label>').show(300);
            return false;
        }
        if (!endTime || endTime.length == '') {
            $('#killPhoneMessage').hide().html('<label class="label label-danger">请填写结束时间！</label>').show(300);
            return false;
        }

        return true;
    },
    detail: {
        init: function () {

            $('#addSeckillBtn').click(function () {
                var name = $('#name').val();
                var number = $('#number').val();
                var startTime = $('#startTime').val();
                var endTime = $('#endTime').val();
                var state = saveSeckill.checkParams(name, number, startTime, endTime);
                if (state) {
                    var formKey = $('#formKey');
                    formKey.submit();

                    // $.post(saveSeckill.URL.saveSeckillUrl(),
                    //     {
                    //         name: name,
                    //         number: number,
                    //         startTime: startTime,
                    //         endTime: endTime
                    //     },
                    //     function (result) {
                    //         if (result && result['success']) {
                    //             alert(result);
                    //             // $.get(saveSeckill.URL.listUrl(),{},function () {});
                    //         } else {
                    //             console.log(result);
                    //         }
                    //     });
                }
            });

            /*$.get(saveSeckill.URL.now(), {}, function (result) {
                if (result && result['success']) {

                }
            });*/
        }
    }
}