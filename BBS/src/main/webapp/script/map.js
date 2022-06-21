/**
 * 
 */
let isCreate = false;					//옵션이 만들어졌는지 확인하는 flag 변수
let ssd;								// 시/도 select박스
let ssgg;								// 시/군/구 select박스
let map;								 //지도 
let sido;								//시/도 option

/**
 * 문서가 준비되면 실행.
 */
window.onload = function() {	
	if(isCreate) {
		ssd.addEventListener('change', (event) => {
			removeFilled();
			ssgg.innerHTML = "<option value=\"\">시/군/구를 선택하세요</option>";
			let selected = document.querySelector("."+ssd.options[ssd.selectedIndex].value);
	
			if(selected.getAttribute("class")=="세종특별자치시") {
				selected.setAttribute("fill",fillArray[fillLevel]);
				selected.classList.add("filled");
				ssgg.style.display= "none";
				return;
			} else {
				ssgg.style.display= "inline";
			}
			let sigungu = Array.from(selected.children);
			createSigunguOption(sigungu);
		});
	
		ssgg.addEventListener('change', (event) => {
			fill();
		});	
	}
};

/**
 * 색칠된 지역을 지우는 함수
 */
function removeFilled() {
	let filled = document.querySelector(".filled");
	if(filled != null) {
		filled.setAttribute("fill", "#B9B9B9");	
		filled.classList.remove("filled");
	}
}

/**
 * 시/도 SELECT 박스의 옵션을 추가하는 함수
 */
function createSidoOption(){
	ssd = document.querySelector("#ifptSido"); 
	ssgg = document.querySelector("#ifptSigungu"); 
	map = document.querySelector("svg");
	sido = Array.from(map.children);
	// console.log(sido);
	sido.forEach(function(sd) {	
		//console.log(sd);
		if(sd.getAttribute("class")=="레이어_19") return;
		let option = document.createElement("option");
		option.setAttribute("value",sd.getAttribute("class"));
		option.innerText= sd.getAttribute("class");
		ssd.appendChild(option);
	});

	isCreate = true;
}

/**
 * 시/군/구 SELECT 박스의 옵션을 추가하는 함수
 * @param {object} sgg 
 */
function createSigunguOption(sgg) {
	sgg.forEach(function(tempSgg) {	
		let option = document.createElement("option");
		option.setAttribute("value",tempSgg.getAttribute("class"));
		option.innerText= tempSgg.getAttribute("class");
		ssgg.appendChild(option);
	});
}

/**
 * SELECT 박스에서 선택한 지역의 지도를 색칠하는 함수
 * @param {string} sido 	// 색칠하고자 하는 시/도 지역
 * @param {string} sigungu 	//색칠하고자 하는 시/군/구 지역
 * @param {int} flag 		//1: updateForm | 0: insertForm, postView | other : bypass
 * @param {int}removeFill 	//1: true | 0: false
 */
function fill(sido="",sigungu="",flag=0, removeFill=1, count=1) {
	let sidoSelectedValue;
	let sigunguSelectedValue;
	let sdSelected;
	let sggSelected;
	let fillArray = ['#00FF00','#FFFF00','#FFBB00','#FF0000'];
	let fillLevel = (count>fillArray.length)?3:count - 1;
	
	if(removeFill==1)removeFilled();

	if(sido != "") {
		sidoSelectedValue = sido;
		sigunguSelectedValue = sigungu;
	} else {
		sidoSelectedValue = ssd.options[ssd.selectedIndex].value;
		sigunguSelectedValue = ssgg.options[ssgg.selectedIndex].value;
	}

	if(flag == 1) {
		let sd = document.querySelector(`.${sido}`);
		let sggs = Array.from(sd.children);

		createSigunguOption(sggs);

		ssd.querySelector(`option[value="${sido}"]`).setAttribute("selected","");
		if(sido != "세종특별자치시") ssgg.querySelector(`option[value="${sigungu}"]`).setAttribute("selected","");
	} else {
		//by pass
	}
	
	sdSelected = document.querySelector(`.${sidoSelectedValue}`);
	
	if(sdSelected.getAttribute("class") == "세종특별자치시") {
		sggSelected = sdSelected;
	} else {
		sggSelected = sdSelected.querySelector(`.${sigunguSelectedValue}`); 
	} 
	
	if(sggSelected.tagName == "g") {
		sggSelected = sggSelected.childNodes[1];
		//console.log(sggSelected);
	} else {
		//by pass
	}
	sggSelected.setAttribute("fill",fillArray[fillLevel]);
	sggSelected.classList.add("filled");
}

