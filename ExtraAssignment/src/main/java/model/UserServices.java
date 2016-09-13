package model;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserServices {
	public SessionFactory sessionFactory;

	public UserServices(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// List of different tasks assigned to different Projects
	public void listTaskofProject() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// retrieve all
		System.out.println("============ TASK INFO =================");
		List<Project> projectList = session.createQuery("Select project from Project project").list();
		for (Project p : projectList) {
			System.out.println("===============PROJECT NAME===============");
			System.out.println("\t\t" + p.getDescription());
			for (Task t : p.getTaskList())
				System.out.println(t);
		}
		tx.commit();
		session.close();
	}

	// See information about projects and their beneficiaries
	public void projectInfowithBeneficiaries() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// retrieve all
		List<Project> projectList = session.createQuery("Select project from Project project").list();
		System.out.println("===============PROJECT INFORMATION WITH EXTRA BENEFITS===========");
		for (Project p : projectList) {
			System.out.println("Product Name=" + p.getDescription());
			System.out.println("Start Date=" + p.getStartDate());
			System.out.println("End Date=" + p.getEndDate());
			System.out.println("End Date=" + p.getListBeneficiaries());
		}
		tx.commit();
		session.close();
	}

	public void projectwithParticularResource(String resourceType) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Project> projectList = session.createQuery("Select project from Project project").list();
		System.out.println("===============PROJECT INFORMATION ON THE BASIC OF RESOURCE SKILL===========");
		for (Project p : projectList) {
			for (Task t : p.getTaskList()) {
				if (t.getResources().contains(resourceType)) {
					System.out.println("Project Name: " + p.getDescription());
					break;
				}
			}
		}
		tx.commit();
		session.close();
	}

}
