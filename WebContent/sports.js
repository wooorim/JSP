function fn_submit(){
	var fn = document.joinForm;
	
	if(fn.regist_month.value == ""){
		alert("수강월을 입력해주세요!");
		fn.regist_month.focus();
		return false;
	}
	if(fn.c_no.value == ""){
		alert("회원명을 선택해주세요!");
		fn.c_name.focus();
		return false;
	}
	if(fn.class_area.value == ""){
		alert("강의장소를 선택해주세요!");
		fn.class_area.focus();
		return false;
	}
	if(fn.tuition.value == ""){
		alert("강의명을 선택해주세요!");
		fn.teacher_code.focus();
		return false;
	}
	
	fn.submit();
	
}
function fn_reset(){
	
	if(confirm("정보를 지우고 처음부터 다시 입력합니다!")){
		location="class_join_view.jsp";
	}
} 