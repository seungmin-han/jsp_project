/**
 * 
 */


/**
 * 팀의 PK를 인자로 받아 게시물 목록을 가져옴.
 * @param {int} iftmSeq 
 * @param {String} category
 * @returns String으로 변환된 Json Object
 */
function getList(iftmSeq, category="", keyword="") {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            iftmSeq: iftmSeq
			, category: category
			, keyword: keyword
			, process: "getSearchList"
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

/**
 * 메인페이지의 최신 게시글 5개를 가져옴(이미지포함)
 * @returns String으로 변환된 Json Object
 */
function getCardList() {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            process:"getCardList"
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


function getRecommendList(ifmbId) {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            process: "getRecommendList"
			, ifmbId: ifmbId
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

/**
 * 게시물의 PK를 인자로 받아 해당 게시물의 내용을 가져옴.
 * @param {int} ifptSeq 
 * @returns String으로 변환된 Json Object
 */
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

/**
 * 팀의 PK를 인자로 받아 이미지 목록을 가져옴.
 * @param {int} iftmSeq 
 * @returns String으로 변환된 Json Object
 */
function getImageList(iftmSeq) {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            iftmSeq: iftmSeq
            , process:"getImageList"
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
}

/**
 * 팀의 PK를 인자로 받아 방문 지역 목록을 가져옴.
 * @param {int} iftmSeq 
 * @returns String으로 변환된 Json Object
 */
function getRegionList(iftmSeq) {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            iftmSeq: iftmSeq
            , process:"getRegionList"
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
}

/**
 * 초대 코드를 갱신하는 메서드
 * @param {int}} iftmSeq 
 * @returns 생성된 해당 팀의 초대코드 String
 */
function updateInviteCode(iftmSeq) {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            iftmSeq: iftmSeq
            , process:"updateInviteCode"
        },
        success: function (data) {
			console.log(data);
			result = data;
        },
        error: function (request, status, error) {
            console.log('code: '+request.status+"\n"+'message: '+request.responseText+"\n"+'error: '+error +"\n"+'status: '+status);
        }
    });
	return result;
}

/**
 * 해당 팀에 속해있는 유저들의 목록을 가져옴
 * @param {int} iftmSeq 
 * @param {String} ifmbId 
 * @returns String으로 변환된 Json Object
 */

function getTeamMemberList(iftmSeq, ifmbId) {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            iftmSeq: iftmSeq
			, ifmbId: ifmbId
            , process:"getTeamMemberList"
        },
        success: function (data) {
			console.log(data);
			result = data;
        },
        error: function (request, status, error) {
            console.log('code: '+request.status+"\n"+'message: '+request.responseText+"\n"+'error: '+error +"\n"+'status: '+status);
        }
    });
	return result;
}

/**
 * 회원 추방 메서드
 * @param {String} ifmbId 
 * @returns String으로 변한된 JSon Object
 */

function kickMember(ifmbId) {
	let result;
    $.ajax({
        type: 'get',
		async: false,
        dataType: 'html',
        url: './execute.jsp',
        data: {
            ifmbId: ifmbId
            , process:"kickMember"
        },
        success: function (data) {
			console.log(data);
			result = data;
        },
        error: function (request, status, error) {
            console.log('code: '+request.status+"\n"+'message: '+request.responseText+"\n"+'error: '+error +"\n"+'status: '+status);
        }
    });
	return result;
}

