package com.startuporg.service;

import java.util.List;

import com.startuporg.model.AuditQuestionSet;
import com.startuporg.model.QuestionCategory;
import com.startuporg.model.StartupAudit;
import com.startuporg.repositroy.repositroy;

public class service {

	public static int getdata(QuestionCategory questionCategory) {

		return repositroy.savedata(questionCategory);
	}

	public static int getId(QuestionCategory questionCategory) {

		return repositroy.getId(questionCategory);
	}

	public static void getaudit(AuditQuestionSet team) {
		try {
			repositroy.saveaudit(team);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static int getId() {
		
		return repositroy.getId();
	}

	public static void savedatastartup_audit(StartupAudit startupAudit) {
		try {
			repositroy.savedatastartup_audit(startupAudit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public static List<StartupAudit> getall(String processarea, String questioncategory) {
		
		return repositroy.getall(processarea,questioncategory);
	}

	public static int setfield(String processarea, String questioncategory, String auditorTeam, String auditee) {
		
		return repositroy.setfield(processarea,questioncategory,auditorTeam,auditee);
	}

	public static int setPath(double actualscore, String remark, String filePath, int srno) {
		return repositroy.setPath(actualscore,remark,filePath,srno);
	}

	

}
