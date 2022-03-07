<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	$(function () {
		$('#memberId').change(function () {
			$('#idCheck').val('unChecked');
		});

		//idCheck 버튼을 클릭했을 때 
		$("#idCheck").click(function () {
			var userid = $("#memberId").val();

			$.ajax({
				type: 'POST',
				data: {
					id: userid
				},
				url: "ajaxMemberIdCheck", //별도 서블릿으로 만들었다. *.do에서 제외(컨트롤러 안탐)
				success: function (data) {
					if (data > 0) {
						alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
						$("#memberId").val("");
						$("#memberId").focus();
					} else {
						alert("사용가능한 아이디입니다.");
						$("#idCheck").val("checked");
						$("#memberPassword").focus();
					}
				},
				error: function (error) {
					alert("error : " + error);
				}
			});
		});
	});
</script>

<script type="text/javascript">
	function formCheck() {
		if (frm.memberId.value == "") {
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
			return false;
		}

		if (frm.idCheck.value == "unChecked") {
			alert("아이디 중복체크를 하세요.");
			return false;
		}

		if (frm.memberPassword.value == "") {
			alert("패스워드를 입력하세요.");
			frm.memberPassword.focus();
			return false;
		}
		if (frm.memberPassword.value != frm.memberPassword2.value) {
			alert("패스워드가 다릅니다.");
			frm.memberPassword.focus();
			return false;
		}
		if (frm.memberName.value == ""){
			alert("이름을 입력하세요.");
			frm.memberName.focus();
			return false;
		}
		if (frm.memberAddress.value == ""){
			alert("주소를 입력하세요.");
			frm.memberAddress.focus();
			return false;
		}
		if (frm.memberCellPhone.value == ""){
			alert("휴대폰번호를 입력하세요.");
			frm.memberCellPhone.focus();
			return false;
		}
		if (frm.memberEmail.value == ""){
			alert("주소를 입력하세요.");
			frm.memberEmail.focus();
			return false;
		}

		frm.submit();
	}

	function idCheckDo() {
		var id = frm.memberId.value;
		window.open("/DbTest/idCheck.do?id=" + id, "childForm", "width=570, height=350, resizable = no, scrollbars = no");

	}
</script>
<div align="center">
	<div>
		<h1>회원가입</h1>
	</div>
	<div>
		<form id="frm" name="frm" action="memberJoin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">회원구분</th>
						<td width="300">
							<input type="radio" id="memberSort" name="memberSort" value="0" checked>개인회원&nbsp;
							<input type="radio" id="memberSort" name="memberSort" value="1" >사업자회원
						</td>
					</tr>
					<tr>
						<th width="150">아이디</th>
						<td width="300"><input type="text" id="memberId" name="memberId">&nbsp;
							<button type="button" id="idCheck" name="idCheck" value="unChecked">중복체크</button>
						</td>
					</tr>
					<tr>
						<th width="150">비밀번호</th>
						<td width="300"><input type="password" id="memberPassword" name="memberPassword"></td>
					</tr>
					<tr>
						<th width="150">비밀번호확인</th>
						<td width="300"><input type="password" id="memberPassword2"
							name="memberPassword2"></td>
					</tr>
					<tr>
						<th width="150">이름</th>
						<td width="300"><input type="text" id="memberName"
							name="memberName"></td>
					</tr>
					<tr>
						<td width="200">우편번호</td>
						<td><input type="text" name="memberPcode" id="memberPcode" size="7"
							readonly> <input type="button" value="우편번호찾기"
							onclick="kakaopost()"></td>
					</tr>
					<tr>
						<th width="150">주소</th>
						
						<td width="300"><input type="text" id="memberAddress"
							name="memberAddress" size="30" placeholder="기본주소">
						<td width="300"><input type="text" id="memberExtraaddress"
							name="memberExtraaddress" placeholder="나머지주소"></td>
					</tr>
					<tr>
						<th width="150">일반전화</th>
						<td width="300"><input type="text" id="memberPhone"
							name="memberPhone"></td>
					</tr>
					<tr>
						<th width="150">휴대전화</th>
						<td width="300"><input type="text" id="memberCellPhone"
							name="memberCellPhone"></td>
					</tr>
					<tr>
						<th width="150">이메일</th>
						<td width="300"><input type="text" id="memberEmail" name="memberEmail"></td>
					</tr>
					
					
					<tr><td><h4>&nbsp;&nbsp;&nbsp;--추가정보--&nbsp;&nbsp;&nbsp;</h4></td></tr>
					<tr>
						<th width="150">평생회원</th>
						<td width="300">
							<input type="radio" id="forever" name="forever" value="0" >동의함&nbsp;
							<input type="radio" id="forever" name="forever" value="1" >동의안함
						</td>
					</tr>
					
					<tr>
						<th width="150">별명</th>
						<td width="300"><input type="text" id="memberNickname" name="memberNickname"></td>
					</tr>
					<tr>
						<th width="150">성별</th>
						<td width="300">
							<input type="radio" id="gender" name="gender" value="0" >남성&nbsp;
							<input type="radio" id="gender" name="gender" value="1" >여성
						</td>
					</tr>
					<tr>
						<th width="150">생년월일</th>
						<td width="300"><input type="date" id="memberBirthday" name="memberBirthday"></td>
					</tr>
					<tr>
						<th width="150">은행명</th>
						<td width="300"><input type="text" id="bank" name="bank"></td>
					</tr>
					<tr>
						<th width="150">예금주</th>
						<td width="300"><input type="text" id="bankName" name="bankName"></td>
					</tr>
					<tr>
						<th width="150">계좌번호</th>
						<td width="300"><input type="text" id="bankNumber" name="bankNumber"></td>
					</tr>
				</table>
			</div><br />
			<div>
				<button type="button" onclick="formCheck()">회원가입</button>&nbsp;&nbsp;&nbsp;
				<button type="reset">취 소</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='main.do'">홈</button>
			</div>
		</form>
	</div>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function kakaopost() {
    new daum.Postcode({
        oncomplete: function(data) {
           document.querySelector("#memberPcode").value = data.zonecode;
           document.querySelector("#memberAddress").value =  data.address
        }
    }).open();
}
</script>
