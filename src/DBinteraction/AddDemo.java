package DBinteraction;

import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;

import static utils.DateUtils.parseDate;

public class AddDemo {
    public static void main(String[] args) throws ParseException {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating new Instructor object");
           /* Instructor instructor =
                    new Instructor("Chad", "Derby", "chad@luv2code.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("youtube.com/luv", "coding");*/
            Instructor instructor =
                    new Instructor("Banana1", "Bam", "banana@luv2code.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("youtube.com/banana", "banana");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();

            System.out.println("Done!");

        }finally {
            session.close();
            sessionFactory.close();
        }


    }
}
