/**
 * 
 */
let isCreate = false;
let ssd;								// 시/도 select박스
let ssgg;								// 시/군/구 select박스
let map;								 //지도 
let sido;								//시/도 option

window.onload = function() {	
	if(isCreate) {
		ssd.addEventListener('change', (event) => {
			removeFilled();
			ssgg.innerHTML = "<option value=\"\">시/군/구를 선택하세요</option>";
			let selected = document.querySelector("."+ssd.options[ssd.selectedIndex].value);
	
			if(selected.getAttribute("class")=="세종특별자치시") {
				selected.setAttribute("fill","#FF0000");
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
		}
		// (event) => {
		// 	removeFilled();
		// 	let sidoSelectedValue = ssd.options[ssd.selectedIndex].value;
		// 	let sigunguSelectedValue = ssgg.options[ssgg.selectedIndex].value;
		// 	let sdSelected = document.querySelector("."+sidoSelectedValue);
		// 	let sggSelected = sdSelected.querySelector("."+sigunguSelectedValue);
		// 	if(sggSelected.tagName == "g") {
		// 		sggSelected = sggSelected.childNodes[1];
		// 		console.log(sggSelected);
		// 	}
		// 	sggSelected.setAttribute("fill","#FF0000");
		// 	sggSelected.classList.add("filled");
	
		// }
		);	
	}
};

function removeFilled() {
	let filled = document.querySelector(".filled");
	if(filled != null) {
		filled.setAttribute("fill", "#B9B9B9");	
		filled.classList.remove("filled");
	}
}
	
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

function createSigunguOption(sgg) {
	sgg.forEach(function(tempSgg) {	
		let option = document.createElement("option");
		option.setAttribute("value",tempSgg.getAttribute("class"));
		option.innerText= tempSgg.getAttribute("class");
		ssgg.appendChild(option);
	});
}

function fill(sido="",sigungu="",flag=0) {
	let sidoSelectedValue;
	let sigunguSelectedValue;
	let sdSelected;
	let sggSelected;
	
	removeFilled();

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
	sggSelected.setAttribute("fill","#FF0000");
	sggSelected.classList.add("filled");
}

