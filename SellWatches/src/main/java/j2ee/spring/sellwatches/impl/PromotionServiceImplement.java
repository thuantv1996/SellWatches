package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.PromotionDAO;
import j2ee.spring.sellwatches.models.Promotion;
import j2ee.spring.sellwatches.services.PromotionService;

@Component
public class PromotionServiceImplement implements PromotionService{

	@Autowired
	private PromotionDAO dao;
	@Override
	public List<Promotion> getList() {
		// TODO Auto-generated method stub
		return dao.getListDES();
	}

	@Override
	public List<Promotion> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public boolean insert(Promotion t) {
		// TODO Auto-generated method stub
		return dao.insert(t);
	}

	@Override
	public boolean update(Promotion t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

	@Override
	public boolean delete(Object[] idPara) {
		// TODO Auto-generated method stub
		return dao.delete(idPara);
	}

	@Override
	public Promotion findById(Object[] idPara) {
		// TODO Auto-generated method stub
		return dao.findById(idPara);
	}

	@Override
	public String getMaxId() {
		return dao.getMaxId();
	}

}
