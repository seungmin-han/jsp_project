/**
 * 
 */

function getList(iftmSeq) {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            iftmSeq: iftmSeq
            , process:"getList"
        },
        success: function (data) {
			console.log(data);
			//console.log(JSON.stringify(data));
            //return JSON.stringify(data);
			result = data;
        },
        error: function (request, status, error) {
            console.log('code: '+request.status+"\n"+'message: '+request.responseText+"\n"+'error: '+error +"\n"+'status: '+status);
        }
    });
	return result;
};

function getOne(ifptSeq) {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            ifptSeq: ifptSeq
            , process:"getOne"
        },
        success: function (data) {
			console.log(data);
			//console.log(JSON.stringify(data));
            //return JSON.stringify(data);
			result = data;
        },
        error: function (request, status, error) {
            console.log('code: '+request.status+"\n"+'message: '+request.responseText+"\n"+'error: '+error +"\n"+'status: '+status);
        }
    });
	return result;
};