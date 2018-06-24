package kg.iceknight;

import kg.iceknight.config.HibernateUtil;
import kg.iceknight.model.Skill;
import kg.iceknight.model.Superhero;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Program.class);
        logger.debug("Blyat");
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        addSkill(session);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();
    }

    private static void addSkill(Session session) {
        Skill skill = new Skill();
        skill.setName("Endurance");
        List list = session.createQuery("from Superhero where id = 2").list();
        Superhero superhero = (Superhero) list.get(0);
        skill.setSuperhero(superhero);
        session.save(skill);
    }

    static List<Superhero> listSuperheroes(Session session) {
        Criteria criteria = session.createCriteria(Superhero.class);
        List<Superhero> list = criteria.list();
        return list;
    }

}
