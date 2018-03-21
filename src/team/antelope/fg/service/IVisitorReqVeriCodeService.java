package team.antelope.fg.service;

public interface IVisitorReqVeriCodeService {
	String returnVeriCode(String reqEmail);
	int createVeriCode();
}
