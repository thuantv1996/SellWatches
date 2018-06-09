package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.TrademarkDAO;
import j2ee.spring.sellwatches.models.Trademark;
import j2ee.spring.sellwatches.services.TrademarkService;

@Component
public class TrademarkServiceImplement implements TrademarkService {

	private TrademarkDAO trademarkDAO = new TrademarkDAO();
	
	public List<Trademark> select() {
		// TODO Auto-generated method stub
		return trademarkDAO.select();
	}

	public boolean insert(Trademark t) {
		// TODO Auto-generated method stub
		return trademarkDAO.insert(t);
	}

	public boolean update(Trademark t) {
		// TODO Auto-generated method stub
		return trademarkDAO.update(t);
	}

	public boolean delete(Object[] idPara) {
		// TODO Auto-generated method stub
		return trademarkDAO.delete(idPara);
	}

	public Trademark findById(Object[] idPara) {
		// TODO Auto-generated method stub
		return trademarkDAO.findById(idPara);
	}	
	
}
