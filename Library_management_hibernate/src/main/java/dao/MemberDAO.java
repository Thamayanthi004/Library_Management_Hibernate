package dao;
import entity.Member;
import util.JPAUtil;

import javax.persistence.*;

public class MemberDAO {

    public void addMember(Member m) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
    }

    public Member findMember(int id) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        Member m = em.find(Member.class, id);
        em.close();
        return m;
    }
}