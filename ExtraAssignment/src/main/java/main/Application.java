package main;

import java.io.IOException;
import java.text.ParseException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Admin;
import model.UserServices;

public class Application {

	public static void main(String[] args) throws IOException, ParseException {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Admin admin = new Admin(sf);
		admin.createProject();
		admin.updateProjectStatus();
		admin.updateProjectTaskStatus();
		UserServices service = new UserServices(sf);
		service.listTaskofProject();
		service.projectInfowithBeneficiaries();
		service.projectwithParticularResource("Developers");

	}

}
