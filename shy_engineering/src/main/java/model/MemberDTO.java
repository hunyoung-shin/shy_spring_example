package model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDTO {
	// dto와 커맨드에 들어가는 값은 다를 수 있음
	// jsp와 커맨드는 같아야 함
	// db의 테이블의 컬럼과 dto는 같아야 함
	
	String membId;
	String membPw;
	String membName;
	String membPhoneNumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date membBirth;
	String membGender;
	String membEmail;
	String membConfirm;
	String postNumber;
	String membAddr;
	String detailAddr;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date membEnterDate;	// 테이블에만 있는 얘가 들어옴
						// 커맨드에만 있는 pwCon은 없음
	public String getMembId() {
		return membId;
	}
	public void setMembId(String membId) {
		this.membId = membId;
	}
	public String getMembPw() {
		return membPw;
	}
	public void setMembPw(String membPw) {
		this.membPw = membPw;
	}
	public String getMembName() {
		return membName;
	}
	public void setMembName(String membName) {
		this.membName = membName;
	}
	public String getMembPhoneNumber() {
		return membPhoneNumber;
	}
	public void setMembPhoneNumber(String membPhoneNumber) {
		this.membPhoneNumber = membPhoneNumber;
	}
	public Date getMembBirth() {
		return membBirth;
	}
	public void setMembBirth(Date membBirth) {
		this.membBirth = membBirth;
	}
	public String getMembGender() {
		return membGender;
	}
	public void setMembGender(String membGender) {
		this.membGender = membGender;
	}
	public String getMembEmail() {
		return membEmail;
	}
	public void setMembEmail(String membEmail) {
		this.membEmail = membEmail;
	}
	public String getMembConfirm() {
		return membConfirm;
	}
	public void setMembConfirm(String membConfirm) {
		this.membConfirm = membConfirm;
	}
	public String getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}
	public String getMembAddr() {
		return membAddr;
	}
	public void setMembAddr(String membAddr) {
		this.membAddr = membAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public Date getMembEnterDate() {
		return membEnterDate;
	}
	public void setMembEnterDate(Date membEnterDate) {
		this.membEnterDate = membEnterDate;
	}
	
}
