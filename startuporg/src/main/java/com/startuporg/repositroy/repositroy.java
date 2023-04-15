package com.startuporg.repositroy;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Procattr;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.startuporg.helper.factoryProvider;
import com.startuporg.model.AuditQuestionSet;
import com.startuporg.model.QuestionCategory;
import com.startuporg.model.StartupAudit;

public class repositroy {

	public static int savedata(QuestionCategory questionCategory) {

		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(questionCategory);
			tx.commit();
			session.close();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}

	}

	public static int getId(QuestionCategory questionCategory) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Query<AuditQuestionSet> query = session.createQuery(
					"from AuditQuestionSet where processarea=:processarea and questioncategory=:questioncategory");
			query.setParameter("processarea", questionCategory.getQuestionCategoryKey().getProcessarea());
			query.setParameter("questioncategory", questionCategory.getQuestionCategoryKey().getQuestioncategory());
			List<AuditQuestionSet> auditQuestionSet = query.list();
			session.close();
			int count = 1;
			for (AuditQuestionSet obj : auditQuestionSet)
				count++;

			return count;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static void saveaudit(AuditQuestionSet team) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(team);
			tx.commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static int getId() {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Query<Integer> query = session.createQuery("select max(audit_srno) from StartupAudit");
			Integer maxId = query.uniqueResult();
			session.close();
			return maxId != null ? maxId : 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public static void savedatastartup_audit(StartupAudit startupAudit) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(startupAudit);
			tx.commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static List<StartupAudit> getall(String processarea, String questioncategory) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Query<StartupAudit> query = session.createQuery(
					"from StartupAudit Where processarea=:processarea and questioncategory=:questioncategory");
			query.setParameter("processarea", processarea);
			query.setParameter("questioncategory", questioncategory);
			List<StartupAudit> list = query.list();
			session.close();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static int setfield(String processarea, String questioncategory, String auditorTeam, String auditee) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			Query<StartupAudit> query = session.createQuery(
					"Update StartupAudit Set auditorteam=:auditorteam , auditee=:auditee,auditdate=:auditdate Where processarea=:processarea and questioncategory=:questioncategory");
			query.setParameter("auditorteam", auditorTeam);
			query.setParameter("auditee", auditee);
			query.setParameter("auditdate", new Date());
			query.setParameter("processarea", processarea);
			query.setParameter("questioncategory", questioncategory);
			int result = query.executeUpdate();
			tx.commit();
			session.close();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		
	}

	public static int setPath(double actualscore, String remark, String filePath, int srno) {
		try {
			Session session = factoryProvider.getfactory().openSession();
			Transaction tx = session.beginTransaction();
			Query<StartupAudit> query = session.createQuery(
					"Update StartupAudit Set actualscore=:actualscore , remark=:remark,evidenceupload=:evidenceupload Where audit_srno=:audit_srno");
			query.setParameter("actualscore", actualscore);
			query.setParameter("remark", remark);
			query.setParameter("evidenceupload", filePath);
			query.setParameter("audit_srno", srno);
			
			int result = query.executeUpdate();
			tx.commit();
			session.close();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		
	}

}
