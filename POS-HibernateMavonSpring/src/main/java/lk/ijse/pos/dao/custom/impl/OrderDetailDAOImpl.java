package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.OrderDetailPK;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDetailDAOImpl implements OrderDetailDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    public void save(OrderDetail orderDetail) throws Exception {
        session.save(orderDetail);
    }

    public void update(OrderDetail orderDetail) throws Exception {
        session.merge(orderDetail);
    }

    public void delete(OrderDetailPK id) throws Exception {
        session.delete(session.load(OrderDetail.class, id));
    }

    public OrderDetail find(OrderDetailPK id) throws Exception {
        return session.find(OrderDetail.class, id);
    }

    public List<OrderDetail> findAll() throws Exception {
        return session.createQuery("FROM OrderDetail", OrderDetail.class).list();
    }

}
