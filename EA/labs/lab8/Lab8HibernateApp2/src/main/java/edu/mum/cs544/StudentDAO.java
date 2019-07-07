package edu.mum.cs544;

import javax.persistence.EntityGraph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
	public StudentDAO() {

	}

	public Student load(long studentid) {
		//Student student = EntityManagerHelper.getCurrent().find(Student.class,studentid);

		EntityGraph<Student> entityGraph = EntityManagerHelper.getCurrent().createEntityGraph(Student.class);
		entityGraph.addSubgraph("courselist");
		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.fetchgraph", entityGraph);
		Student student = EntityManagerHelper.getCurrent().find(Student.class,studentid,properties);

		return student;
	}
}
