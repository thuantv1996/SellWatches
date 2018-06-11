package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.DetailPromotionDAO;
import j2ee.spring.sellwatches.models.DetailPromotion;
import j2ee.spring.sellwatches.services.DetailPromotionService;
import j2ee.spring.sellwatches.viewmodel.DetailPromotionViewModel;

@Component
public class DetailPromotionServiceImplement implements DetailPromotionService{

	@Autowired
	private DetailPromotionDAO dao;
	
	@Override
	public List<DetailPromotion> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public boolean insert(DetailPromotion t) {
		// TODO Auto-generated method stub
		return dao.insert(t);
	}

	@Override
	public boolean update(DetailPromotion t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

	@Override
	public boolean delete(Object[] idPara) {
		// TODO Auto-generated method stub
		return dao.delete(idPara);
	}

	@Override
	public DetailPromotion findById(Object[] idPara) {
		// TODO Auto-generated method stub
		return dao.findById(idPara);
	}

	@Override
	public List<DetailPromotionViewModel> getList(String id) {
		// TODO Auto-generated method stub
		return dao.getList(id);
	}

}
